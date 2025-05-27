import java.util.BitSet;
import java.util.Random;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class task3 {
    private BitSet bitSet;
    private int bitSetSize;
    private int numHashFunctions;
    private MessageDigest md5Digest;

    public task3(int expectedNumItems, double falsePositiveProbability) {
        this.bitSetSize = (int) Math.ceil(-(expectedNumItems * Math.log(falsePositiveProbability)) / (Math.log(2) * Math.log(2)));
        this.numHashFunctions = (int) Math.ceil((bitSetSize / expectedNumItems) * Math.log(2));
        
        this.bitSet = new BitSet(bitSetSize);
        
        try {
            this.md5Digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 algorithm not found", e);
        }
    }

    public void add(String item) {
        byte[] bytes = item.getBytes();
        
        for (int i = 0; i < numHashFunctions; i++) {
            byte[] salt = new byte[]{(byte) i};
            byte[] input = new byte[bytes.length + salt.length];
            System.arraycopy(bytes, 0, input, 0, bytes.length);
            System.arraycopy(salt, 0, input, bytes.length, salt.length);
            
            byte[] hash = md5Digest.digest(input);
            
            int index = Math.abs(new Random(new String(hash).hashCode()).nextInt()) % bitSetSize;
            bitSet.set(index, true);
        }
    }

    public boolean mightContain(String item) {
        byte[] bytes = item.getBytes();
        
        for (int i = 0; i < numHashFunctions; i++) {
            byte[] salt = new byte[]{(byte) i};
            byte[] input = new byte[bytes.length + salt.length];
            System.arraycopy(bytes, 0, input, 0, bytes.length);
            System.arraycopy(salt, 0, input, bytes.length, salt.length);
            
            byte[] hash = md5Digest.digest(input);
            int index = Math.abs(new Random(new String(hash).hashCode()).nextInt()) % bitSetSize;
            
            if (!bitSet.get(index)) {
                return false;
            }
        }
        
        return true;
    }

    public static void main(String[] args) {
        task3 filter = new task3(1000, 0.01);
        
        filter.add("apple");
        filter.add("banana");
        filter.add("orange");
        
        System.out.println("Contains 'apple': " + filter.mightContain("apple")); // true
        System.out.println("Contains 'grape': " + filter.mightContain("grape")); // false (возможно true из-за ложного срабатывания)
    }
}
