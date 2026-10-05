import java.util.Stack;

class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // Build the complete number
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }
            // If we find an operator OR reach the last character
            if ((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1) {
                if (sign == '+') {
                    st.push(num);
                }
                else if (sign == '-') {
                    st.push(-num);
                }
                else if (sign == '*') {
                    st.push(st.pop() * num);
                }
                else if (sign == '/') {
                    st.push(st.pop() / num);
                }
                // Update sign
                sign = ch;
                num = 0;
            }
        }
        // Add everything left in stack
        int ans = 0;
        while (!st.isEmpty()) {
            ans += st.pop();
        }
        return ans;
    }
}