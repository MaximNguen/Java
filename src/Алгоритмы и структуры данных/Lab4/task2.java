import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class task2<K extends Comparable<K>, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;

    private BST<K, V>[] table;
    private int size;

    private static class Node<K, V> {
        K key;
        List<V> values;
        Node<K, V> left, right;

        Node(K key, V value) {
            this.key = key;
            this.values = new LinkedList<>();
            this.values.add(value);
        }
    }

    private static class BST<K extends Comparable<K>, V> {
        Node<K, V> root;

        void put(K key, V value) {
            root = put(root, key, value);
        }

        private Node<K, V> put(Node<K, V> node, K key, V value) {
            if (node == null) return new Node<>(key, value);

            int cmp = key.compareTo(node.key);
            if (cmp < 0) node.left = put(node.left, key, value);
            else if (cmp > 0) node.right = put(node.right, key, value);
            else node.values.add(value); // Добавляем значение в список

            return node;
        }

        List<V> get(K key) {
            return get(root, key);
        }

        private List<V> get(Node<K, V> node, K key) {
            if (node == null) return null;

            int cmp = key.compareTo(node.key);
            if (cmp < 0) return get(node.left, key);
            else if (cmp > 0) return get(node.right, key);
            else return node.values;
        }

        void delete(K key) {
            root = delete(root, key);
        }

        private Node<K, V> delete(Node<K, V> node, K key) {
            if (node == null) return null;

            int cmp = key.compareTo(node.key);
            if (cmp < 0) node.left = delete(node.left, key);
            else if (cmp > 0) node.right = delete(node.right, key);
            else {
                if (node.right == null) return node.left;
                if (node.left == null) return node.right;

                Node<K, V> temp = node;
                node = min(temp.right);
                node.right = deleteMin(temp.right);
                node.left = temp.left;
            }
            return node;
        }

        private Node<K, V> min(Node<K, V> node) {
            if (node.left == null) return node;
            return min(node.left);
        }

        private Node<K, V> deleteMin(Node<K, V> node) {
            if (node.left == null) return node.right;
            node.left = deleteMin(node.left);
            return node;
        }
    }

    public task2() {
        @SuppressWarnings("unchecked")
        BST<K, V>[] temp = (BST<K, V>[]) new BST[DEFAULT_CAPACITY];
        table = temp;
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            table[i] = new BST<>();
        }
        size = 0;
    }

    private int hash(K key) {
        if (key == null) return 0;
        return Math.abs(key.hashCode()) % table.length;
    }

    public void put(K key, V value) {
        if (size >= table.length * LOAD_FACTOR) {
            resize();
        }

        int index = hash(key);
        if (table[index].get(key) == null) {
            size++;
        }
        table[index].put(key, value);
    }

    public List<V> get(K key) {
        int index = hash(key);
        return table[index].get(key);
    }

    public void remove(K key) {
        int index = hash(key);
        if (table[index].get(key) != null) {
            table[index].delete(key);
            size--;
        }
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    private void resize() {
        BST<K, V>[] oldTable = table;
        @SuppressWarnings("unchecked")
        BST<K, V>[] temp = (BST<K, V>[]) new BST[oldTable.length * 2];
        table = temp;
        for (int i = 0; i < table.length; i++) {
            table[i] = new BST<>();
        }
        size = 0;

        for (BST<K, V> bst : oldTable) {
            Queue<Node<K, V>> queue = new LinkedList<>();
            if (bst.root != null) queue.add(bst.root);

            while (!queue.isEmpty()) {
                Node<K, V> node = queue.poll();
                for (V value : node.values) {
                    put(node.key, value);
                }
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
    }

    public static void main(String[] args) {
        task2<String, Integer> map = new task2<>();
        map.put("one", 1);
        map.put("one", 23);
        map.put("one", 111);

        map.put("two", 2);
        map.put("two", 2245);

        map.put("three", 3);

        System.out.println("one: " + map.get("one"));   // [1, 11, 111]
        System.out.println("two: " + map.get("two"));   // [2, 22]
        System.out.println("three: " + map.get("three"));// [3]

        map.remove("two");
        System.out.println("two after remove: " + map.get("two")); // null
    }
}
