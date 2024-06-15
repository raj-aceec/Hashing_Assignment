import java.util.LinkedList;

class HashMap {
    private class Entry {
        int key;
        int value;

        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry>[] table;
    private int size;

    public HashMap(int size) {
        this.size = size;
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hashFunction(int key) {
        return key % size;
    }

    public void insert(int key, int value) {
        int hash = hashFunction(key);
        for (Entry entry : table[hash]) {
            if (entry.key == key) {
                entry.value = value;
                return;
            }
        }
        table[hash].add(new Entry(key, value));
    }

    public void remove(int key) {
        int hash = hashFunction(key);
        table[hash].removeIf(entry -> entry.key == key);
    }

    public int get(int key) {
        int hash = hashFunction(key);
        for (Entry entry : table[hash]) {
            if (entry.key == key) {
                return entry.value;
            }
        }
        return -1; // Return -1 if the key does not exist
    }
}
