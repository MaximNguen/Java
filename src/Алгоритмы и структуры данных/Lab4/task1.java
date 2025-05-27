public class task1<K, V>{
    private static final int DEFAULT_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;

    private Entry<K, V>[] table;
    private int size;

    private static class Entry<K, V>{
        K key;
        V value;
        boolean isDeleted;

        Entry(K key, V value){
            this.key = key;
            this.value = value;
            this.isDeleted = false;
        }
    }

    public task1(){
        table = new Entry[DEFAULT_CAPACITY];
        size = 0;
    }

    private int hash(K key){
        if (key == null){
            return 0;
        }
        return Math.abs(key.hashCode()) % table.length;
 
    }

    public void put(K key, V value){
        if (size >= table.length * LOAD_FACTOR){
            resize();
        }

        int index = hash(key);
        int i = 1;

        while (table[index] != null){
            if (!table[index].isDeleted && table[index].key.equals(key)){
                table[index].value = value;
                return;

            }
            index = (index + i * i) % table.length;
            i++;
        }
        table[index] = new Entry<>(key, value);
        size++;
    }

    public V get(K key) {
        int index = hash(key);
        int i = 1;
        
        while (table[index] != null) {
            if (!table[index].isDeleted && table[index].key.equals(key)) {
                return table[index].value;
            }
            index = (index + i * i) % table.length;
            i++;
        }

        return null;
    }

    public void remove(K key){
        int index = hash(key);
        int i = 1;
        
        while (table[index] != null) {
            if (!table[index].isDeleted && table[index].key.equals(key)) {
                table[index].isDeleted = true;
                size--;
                return;
            }
            index = (index + i * i) % table.length;
            i++;
        }
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    private void resize() {
        Entry<K, V>[] oldTable = table;
        table = new Entry[oldTable.length * 2];
        size = 0;

        for (Entry<K, V> entry : oldTable) {
            if (entry != null && !entry.isDeleted) {
                put(entry.key, entry.value);
            }
        }
    }

    public static void main(String[] args) {
        task1<String, Integer> map = new task1<>();
        map.put("one", 234);
        map.put("one", 275);
        map.put("two", 2345);
        map.put("three", 524);

        System.out.println(map.get("one")); // 2
        System.out.println(map.containsKey("three")); // true

        map.remove("two");
        System.out.println(map.get("two")); // null
    }
}
