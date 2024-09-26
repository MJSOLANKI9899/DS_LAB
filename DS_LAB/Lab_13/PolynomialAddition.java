import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PolynomialAddition {

    // Method to add a term to a polynomial represented as a HashMap
    private static void addTerm(Map<Integer, Integer> polynomial, int coefficient, int exponent) {
        polynomial.put(exponent, polynomial.getOrDefault(exponent, 0) + coefficient);
    }

    // Method to add two polynomials
    private static Map<Integer, Integer> addPolynomials(Map<Integer, Integer> poly1, Map<Integer, Integer> poly2) {
        Map<Integer, Integer> result = new HashMap<>(poly1);

        for (Map.Entry<Integer, Integer> entry : poly2.entrySet()) {
            addTerm(result, entry.getValue(), entry.getKey());
        }

        return result;
    }

    // Method to print a polynomial
    private static void printPolynomial(Map<Integer, Integer> polynomial) {
        StringBuilder sb = new StringBuilder();
        boolean first = true;

        for (Map.Entry<Integer, Integer> entry : polynomial.entrySet()) {
            int coefficient = entry.getValue();
            int exponent = entry.getKey();

            if (coefficient != 0) {
                if (!first) {
                    sb.append(coefficient > 0 ? " + " : " - ");
                } else {
                    if (coefficient < 0) {
                        sb.append("-");
                    }
                    first = false;
                }

                sb.append(Math.abs(coefficient));
                if (exponent > 0) {
                    sb.append("x");
                    if (exponent > 1) {
                        sb.append("^").append(exponent);
                    }
                }
            }
        }

        if (sb.length() == 0) {
            sb.append("0");
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Polynomial 1
        Map<Integer, Integer> poly1 = new HashMap<>();
        System.out.println("Enter the number of terms for the first polynomial:");
        int numTerms1 = scanner.nextInt();
        for (int i = 0; i < numTerms1; i++) {
            System.out.print("Enter coefficient and exponent (e.g., 3 2 for 3x^2): ");
            int coefficient = scanner.nextInt();
            int exponent = scanner.nextInt();
            addTerm(poly1, coefficient, exponent);
        }

        // Polynomial 2
        Map<Integer, Integer> poly2 = new HashMap<>();
        System.out.println("Enter the number of terms for the second polynomial:");
        int numTerms2 = scanner.nextInt();
        for (int i = 0; i < numTerms2; i++) {
            System.out.print("Enter coefficient and exponent (e.g., 4 3 for 4x^3): ");
            int coefficient = scanner.nextInt();
            int exponent = scanner.nextInt();
            addTerm(poly2, coefficient, exponent);
        }

        // Add the polynomials
        Map<Integer, Integer> result = addPolynomials(poly1, poly2);

        // Print the result
        System.out.println("Sum of the polynomials:");
        printPolynomial(result);

        scanner.close();
    }
}
