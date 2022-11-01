import java.util.HashMap;
import java.util.Stack;

public class balancedBrackets {
    // 스택과 연관되어 있는 문제
    public static void main(String[] args) {

    }
    public static boolean solution(String str) {
        // 스택 선언
        Stack<Character> stack = new Stack<>();
        // 해시맵을 선언해 괄호 쌍으로 이룬 key value 할당
        HashMap<Character, Character> opener = new HashMap<>();
        opener.put('{', '}');
        opener.put('[', ']');
        opener.put('(', ')');

        //괄호 뒷부분만 따로 String으로 선언
        String closer = "}])";

        for(int i = 0; i < str.length(); i++) {
            // str.charAt(i)가 열린 괄호일 경우 ==> opener의 key값과 같은 경우
            if(opener.containsKey(str.charAt(i))) {
                // 스택에 해당 문자를 삽입
                stack.push(str.charAt(i));
            } else if (closer.indexOf(str.charAt(i)) != -1 && stack.size() > 0) { // str.charAt(i)가 닫힌 괄호일 경우 -> closer에 존재
                // 스택에 저장된 열린 괄호를 빼와 opener의 키값과 비교
                char top = stack.pop();
                char pair = opener.get(top);
                if(pair != str.charAt(i)) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return stack.empty();
    }
    public static boolean failSolution(String str) { // str 값이 "[(]{)}" 들어갔을 때, 통과하지 못함.
        if(str.isEmpty()) return true;
        Stack stack = new Stack();

        for(int i = 0; i<str.length(); i++) {
            char c = str.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if(stack.empty()){
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.empty();
    }
}
