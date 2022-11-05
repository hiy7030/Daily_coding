import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.stream.Collectors;

public class powerSet {
    public static void main(String[] args) {
        String str = "jjump";
        System.out.println(solution(str));
    }
    public static ArrayList<String> solution(String str) {
        // 멱집합, 부분집합 알고리즘
        // n번째 요소가 포함되는 경우와 포함되지 않은경우로 나눠서 생각

        // { a, b, c}의 부분 집합을 구하는 경우
        // a를 포함하는 경우 -> {b,c}의 부분 집합 각 요소에 + "a" -> [" ", "c", "b", "bc", "a", "ac", "ab", "abc"]
        // a를 포함하지 않는 경우 ->  {b,c}의 부분 집합 -> [" ", "c", "b", "bc"]

        // {b,c}의 부분 집합을 구하는 경우
        // b를 포함하는 경우 -> {c}의 부분집합 각 요소에 +"b" -> [" ", "c", "b", "bc"]
        // b를 포함하지 않는 경우 -> {c}의 부분집합 -> [" ", "c"]

        // {c}의 부분집합을 구하는 경우
        // c를 포함하는 경우 ->  [" ", "c"]
        // c를 포함하지 않는 경우 -> [" "]
        String sortStr = sortedString(str);
        Stack<String> stack = new Stack<>();

        ArrayList<String> result = new ArrayList<>();

        result = ex(stack, 0, sortStr, result);

        Collections.sort(result);
        return result;
    }

    public static String sortedString(String str) {
        String result = "";

        for(int i = 0; i < str.length(); i++) {
            if(str.indexOf(str.charAt(i)) == i) {
                result += str.charAt(i);
            }
        }

        String[] arr = result.split("");
        Arrays.sort(arr);
        result = String.join(",", arr).replaceAll(",", "");

        return result;
    }

    public static ArrayList<String> ex(Stack<String> stack, int idx, String subset, ArrayList<String> result){
        if(idx >= subset.length()) {
            result.add(stack.toString()
                    .replaceAll("\\[", "")
                    .replaceAll("]", "")
                    .replaceAll(",", "")
                    .replaceAll(" ", ""));
            return result;
        } else {
            stack.push(Character.toString(subset.charAt(idx)));
            ex(stack, idx +1, subset, result);

            stack.pop();
            ex(stack, idx+1, subset,result);
        }
        return result;
    }

}
