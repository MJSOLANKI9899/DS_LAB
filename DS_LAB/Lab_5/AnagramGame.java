// B 32. Design anagram game using array
import java.util.Arrays;
import java.util.Scanner;

public class AnagramGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of words: ");
        int n = sc.nextInt();
         

        String[] words = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter word " + (i + 1) + ": ");
            words[i] = sc.nextLine().toLowerCase();
        }

        int randomIndex = (int) (Math.random() * n);
        String randomWord = words[randomIndex];

        System.out.println("Random word chosen: " + randomWord);

        System.out.print("Enter  a word : ");
        String inputWord = sc.nextLine().toLowerCase(); 

        boolean isAnagram = checkAnagram(randomWord, inputWord);

        if (isAnagram) {
            System.out.println(inputWord + " is an anagram of " + randomWord);
        } else {
            System.out.println(inputWord + " is not an anagram of " + randomWord);
        }

        sc.close();
    }

    public static boolean checkAnagram(String str1, String str2) {
        str1 = str1.replaceAll("\\s", "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();

        if (str1.length() != str2.length()) {
            return false;
        }

        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        return Arrays.equals(charArray1, charArray2);
    }
}
