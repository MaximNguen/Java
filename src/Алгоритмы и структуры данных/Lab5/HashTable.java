
public class HashTable {
    static class Entry {
        final int key;
        int value;
        Entry next;

        Entry(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    private Entry[] buckets;
    private static final int DEFAULT_SIZE = 16;
    public HashTable() {
        buckets = new Entry[DEFAULT_SIZE];
    }
    private int hash(int key) {
        return Math.abs(key % buckets.length);
    }
    public void put(int key, int value) {
        int index = hash(key);
        Entry node = buckets[index];

        if (node == null) {
            buckets[index] = new Entry(key, value);
        } else {
            Entry prev = null;
            while (node != null) {
                if (node.key == key) {
                    node.value = value;
                    return;
                }
                prev = node;
                node = node.next;
            }
            prev.next = new Entry(key, value);
        }
    }
    public Integer get(int key) {
        int index = hash(key);
        Entry node = buckets[index];

        while (node != null) {
            if (node.key == key) return node.value;
            node = node.next;
        }
        return null;
    }
    public boolean remove(int key) {
        int index = hash(key);
        Entry node = buckets[index];
        Entry prev = null;

        while (node != null) {
            if (node.key == key) {
                if (prev == null) {
                    buckets[index] = node.next;
                } else {
                    prev.next = node.next;
                }
                return true;
            }
            prev = node;
            node = node.next;
        }
        return false;
    }
    public boolean containsValue(int value) {
        for (Entry bucket : buckets) {
            Entry node = bucket;
            while (node != null) {
                if (node.value == value) {
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }
}