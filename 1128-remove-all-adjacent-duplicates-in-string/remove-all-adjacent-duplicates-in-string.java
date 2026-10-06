import java.util.*;

class Solution {
    public String removeDuplicates(String s) {

        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (!st.isEmpty() && st.peek() == ch) {
                st.pop();
            } else {
                st.push(ch);
            }
        }

        char[] ans = new char[st.size()];

        for (int i = 0; i < st.size(); i++) {
            ans[i] = st.get(i);
        }

        return new String(ans);
    }
}