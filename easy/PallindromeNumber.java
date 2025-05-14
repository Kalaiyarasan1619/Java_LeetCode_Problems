package easy;

public class PallindromeNumber {

    public boolean isPalindrome(int x) {

        // Negative numbers and numbers ending with 0 (except 0 itself) are not
        // palindromes
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversed = 0;
        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }

        // Check if the number is a palindrome
        return x == reversed || x == reversed / 10;

    }

    public static void main(String[] args) {
        PallindromeNumber solution = new PallindromeNumber();
        int x = 121;
        boolean result = solution.isPalindrome(x);
        System.out.println("Is palindrome: " + result);
    }

}
