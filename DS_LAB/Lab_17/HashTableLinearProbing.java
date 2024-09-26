import java.util.Random;
public class HashTableLinearProbing {
    public static void main(String[] args) {
        int[] hashTable = new int[20];
        boolean[] occupied = new boolean[20];
        Random random = new Random();

        int count = 0;
        while (count < 15) {
            int value = 100000 + random.nextInt(900000);
            
            if (!isValueAlreadyInTable(hashTable, occupied, value)) {
                insertIntoTable(hashTable, occupied, value);
                count++;
            }
        }

        printHashTable(hashTable, occupied);
    }

    private static boolean isValueAlreadyInTable(int[] hashTable, boolean[] occupied, int value) {
        for (int i = 0; i < hashTable.length; i++) {
            if (occupied[i] && hashTable[i] == value) {
                return true;
            }
        }
        return false;
    }

    private static void insertIntoTable(int[] hashTable, boolean[] occupied, int value) {
        int key = hashFunction(value);
        int index = key;

        while (occupied[index]) {
            index = (index + 1) % 20;
        }

        hashTable[index] = value;
        occupied[index] = true;
    }

    private static void printHashTable(int[] hashTable, boolean[] occupied) {
        System.out.println("Final values in the hash table:");
        for (int i = 0; i < hashTable.length; i++) {
            if (occupied[i]) {
                System.out.println("Index " + i + ": " + hashTable[i]);
            } else {
                System.out.println("Index " + i + ": Empty");
            }
        }
    }

    private static int hashFunction(int x) {
        return (x % 18) + 2;
    }
}