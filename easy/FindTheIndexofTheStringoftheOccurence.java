package easy;

public class FindTheIndexofTheStringoftheOccurence {

    public int strStr(String haystack, String needle) {

        if (needle.isEmpty()) {
            return 0;
        }

        int haystackLength = haystack.length();
        int needleLength = needle.length();

        for (int i = 0; i <= haystackLength - needleLength; i++) {
            if (haystack.substring(i, i + needleLength).equals(needle)) {
                return i;
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        FindTheIndexofTheStringoftheOccurence solution = new FindTheIndexofTheStringoftheOccurence();
        String haystack = "hello";
        String needle = "ll";
        int index = solution.strStr(haystack, needle);
        System.out.println("Index of the first occurrence: " + index);
    }

}
