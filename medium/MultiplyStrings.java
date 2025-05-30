package medium;

public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0"; // If either number is zero, the result is zero
        }

        int m = num1.length();
        int n = num2.length();
        int[] result = new int[m + n]; // Array to hold the intermediate results

        // Multiply each digit of num1 with each digit of num2
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = mul + result[i + j + 1]; // Add to the current position

                result[i + j + 1] = sum % 10; // Store the unit place
                result[i + j] += sum / 10; // Carry over to the next position
            }
        }

        // Build the final result string
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            if (!(sb.length() == 0 && num == 0)) { // Skip leading zeros
                sb.append(num);
            }
        }

        return sb.toString(); // Return the final product as a string
    }

    public static void main(String[] args) {
        MultiplyStrings solution = new MultiplyStrings();
        String num1 = "123";
        String num2 = "456";
        String result = solution.multiply(num1, num2);
        System.out.println("Product: " + result); // Output: Product: 56088
    }

}
