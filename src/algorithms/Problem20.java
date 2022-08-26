package algorithms;

import org.junit.Test;

import java.util.*;

public class Problem20 {

    @Test
    public void test() {
        String s = "()[]{}((([[{}]])))";
        System.out.println(isValid(s));
    }

    private boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<>(){
            {put(')', '(');}
            {put(']', '[');}
            {put('}', '{');}
        };

        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (pairs.containsKey(c)) {
                if (stack.peek() != pairs.get(c)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

}
