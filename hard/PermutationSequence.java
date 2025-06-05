package hard;

public class PermutationSequence {

    public String getPermutation(int n, int k) {
        StringBuilder result = new StringBuilder();
        boolean[] used = new boolean[n + 1];
        int[] factorial = new int[n + 1];
        factorial[0] = 1;

        // Precompute factorials
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        k--; // Convert to zero-based index

        for (int i = 1; i <= n; i++) {
            int count = factorial[n - i];
            int index = k / count;
            k %= count;

            // Find the index-th unused number
            int num = 1;
            for (int j = 1; j <= n; j++) {
                if (!used[j]) {
                    if (index == 0) {
                        result.append(j);
                        used[j] = true;
                        break;
                    }
                    index--;
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        PermutationSequence solution = new PermutationSequence();
        int n = 3, k = 3;
        System.out.println("The " + k + "th permutation of " + n + " numbers is: " + solution.getPermutation(n, k));
    }

}
