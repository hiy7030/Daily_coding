import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class tiling {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        System.out.println(solution2(num));
    }
    public static int mySolution(int num) {
        // 피보나치 수열
        int[] result = new int[num];
        result[0] = 1;
        if(result.length > 1) {
            result[1] =2;
        }

        for(int i = 2; i < num; i++) {
            result[i] = result[i-1] + result[i-2];
        }
        return result[num-1];
    }

    public static int solution2(int num) { // 해당 방법은 실행시간을 초과한다. -> 비효율적인 알고리즘(O(2^N)
        if(num <= 2) return num;

        int result = solution2(num-1) + solution2(num-2);

        return result;
    }

    public int reference1(int num) { // 시간복잡도 : O(N)
        // 이미 한번 계산한 값을 ArrayList의 저장한다.
        ArrayList<Integer> memo = new ArrayList<>(Arrays.asList(0, 1, 2)); // 우리는 memo의 num번째 값을 반환하면 됨
        return sub(num, memo);
    }
    public int sub(int num, ArrayList<Integer> memo) {
        if(memo.size() > num) return memo.get(num);
        memo.add(sub(num-1, memo) + sub(num-2, memo));
        return memo.get(num);
    }
}
