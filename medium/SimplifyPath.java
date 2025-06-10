package medium;

import java.util.Stack;

public class SimplifyPath {

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] parts = path.split("/");
        for (String part : parts) {
            if (part.equals("") || part.equals(".")) {
                continue;
            } else if (part.equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            } else {
                stack.push(part);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String dir : stack) {
            sb.append("/").append(dir);
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }

    public static void main(String[] args) {
        SimplifyPath sp = new SimplifyPath();
        System.out.println(sp.simplifyPath("/home/")); // Output: /home
        System.out.println(sp.simplifyPath("/../")); // Output: /
        System.out.println(sp.simplifyPath("/home//foo/")); // Output: /home/foo
        System.out.println(sp.simplifyPath("/a/./b/../../c/")); // Output: /c
    }

}