// 20. Valid Parentheses
// BRUTE FORCE
class Solution {
    public boolean isValid(String s) {
        while(s.contains("{}")||s.contains("()")||s.contains("[]")){
            s.replace("{}","");
            s.replace("[]","");
            s.replace("()","");
        }
        return s.isEmpty();        
    }
}

// STACK APPROACH

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        HashMap<Character,Character> closeToOpen=new HashMap<>();
        closeToOpen.put(')','(');
        closeToOpen.put('}','{');
        closeToOpen.put(']','[');

        for(char c:s.toCharArray()){
            if(closeToOpen.containsKey(c)){
                if(!stack.isEmpty()&&stack.peek()==closeToOpen.get(c)){
                    stack.pop();
                }
                else{
                    return false;
                }
            } 
            else{
                stack.push(c);
            }
        }
        return stack.isEmpty();        
    }
}

//Approach 2

import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;

                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}