import java.util.LinkedList;

public class Dictionary<K, V> {
    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry<K, V>>[] table;
    private int capacity;
    private int size;

    @SuppressWarnings("unchecked")
    public Dictionary(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        table = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(K key) {
        return Math.abs(key.hashCode() % capacity);
    }

    public void put(K key, V value) {
        int index = hash(key);
        LinkedList<Entry<K, V>> entries = table[index];

        for (Entry<K, V> entry : entries) {
            if (entry.key.equals(key)) {
                entry.value = value; 
                return;
            }
        }

        entries.add(new Entry<>(key, value));
        size++;
    }

    public V get(K key) {
        int index = hash(key);
        LinkedList<Entry<K, V>> entries = table[index];

        for (Entry<K, V> entry : entries) {
            if (entry.key.equals(key)) {
                return entry.value; 
            }
        }
        return null; 
    }

    public void remove(K key) {
        int index = hash(key);
        LinkedList<Entry<K, V>> entries = table[index];

        entries.removeIf(entry -> entry.key.equals(key));
        size--;
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public int size() {
        return size; 
    }

    public void display() {
        for (int i = 0; i < capacity; i++) {
            LinkedList<Entry<K, V>> entries = table[i];
            if (!entries.isEmpty()) {
                System.out.print("Index " + i + ": ");
                for (Entry<K, V> entry : entries) {
                    System.out.print("[" + entry.key + "=" + entry.value + "] ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Dictionary<String, Integer> dictionary = new Dictionary<>(10);
        
        dictionary.put("apple", 1);
        dictionary.put("banana", 2);
        dictionary.put("orange", 3);
        
        System.out.println("Dictionary contents:");
        dictionary.display();

        System.out.println("Value for 'banana': " + dictionary.get("banana"));

        dictionary.remove("apple");
        System.out.println("Dictionary after removing 'apple':");
        dictionary.display();
        
        System.out.println("Size of dictionary: " + dictionary.size());
    }
}
