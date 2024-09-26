public class DilDup {
    public static void main(String[] args) {
        int[] array = { 1, 1, 1, 2, 2, 3, 4, 4, 5, 5 };
        int uniqueIndex = 0;

        for (int i = 1; i < array.length; i++) {
            boolean isDuplicate = false;

            for (int j = 0; j <= uniqueIndex; j++) {
                if (array[i] == array[j]) {
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) {
                uniqueIndex++;
                array[uniqueIndex] = array[i];
            }
        }
       for (int i = 0; i < uniqueIndex+1; i++) {
            System.out.print(array[i] + " ");
        }

    }

}
