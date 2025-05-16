package easy;

public class ValidParenthis {

    public boolean isValid(String s) {

        if (s == null || s.length() == 0) {
            return true;
        }

        char[] stack = new char[s.length()];
        int top = -1;

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack[++top] = c;
            } else {
                if (top < 0) {
                    return false;
                }
                char last = stack[top--];
                if ((c == ')' && last != '(') ||
                        (c == '}' && last != '{') ||
                        (c == ']' && last != '[')) {
                    return false;
                }
            }
        }

        return top == -1;

    }

    public static void main(String[] args) {
        ValidParenthis solution = new ValidParenthis();
        String s = "()[]{}";
        boolean result = solution.isValid(s);
        System.out.println("Is valid: " + result);
    }

}
