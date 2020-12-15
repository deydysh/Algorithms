package Hash;

import java.util.LinkedList;

public class HashMap {

    public HashMap() {
        for (int i = 0; i < 6; i++) {
            array[i] = new LinkedList<>();
        }
    }

    private static class Set {
        private final int key;
        private final String name;

        public Set(int key, String name) {
            this.key = key;
            this.name = name;
        }

        @Override
        public String toString() {
            return "(" + key + "; " + name + ")";
        }

    }

    @Override
    public String toString() {
        String tmp = "";
        for (int i = 0; i < 6; i++) {
            tmp += "Hash value: " + i + "\t" + array[i].toString() + "\n";
        }
        return tmp;
    }

    LinkedList<Set>[] array = new LinkedList[6];

    private int hashFunction(int key) {
        int hashValue = 0;
        while (key != 0) {
            hashValue += key % 10;
            key /= 10;
        }
        return hashValue % 6;
    }

    public void insert(int key, String name) {
        int hashValue = hashFunction(key);
        Set new_set = new Set(key, name);
        array[hashValue].addLast(new_set);
    }

    public boolean find(int key, String name) {
        int hashValue = hashFunction(key);
        Set new_set = new Set(key, name);
        return array[hashValue].contains(new_set);
    }
    public boolean remove(int key, String name) {
        int hashValue = hashFunction(key);
        Set new_set = new Set(key, name);
        return array[hashValue].remove(new_set);
    }

}