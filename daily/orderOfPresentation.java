import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class orderOfPresentation {
    public static void main(String[] args) {

    }
    public static int solution(int N, int[] K) { // N = 3, K = [2,3,1]
        // 발표 순서
        int order = 0;
        // 사용된 조 배열
        boolean[] isUsed = new boolean[N + 1]; // [false, false, false, false]

        for (int i = 0; i < K.length; i++) { //1
            int num = K[i]; // 2 //3
            isUsed[num] = true; // [false, false, true, false] //[false, false, true, true]
            boolean[] candidates = Arrays.copyOfRange(isUsed, 1, num); // [false] // [false, true]
            int validCat = 0;
            for (boolean candidate : candidates) {
                if (!candidate) validCat++; // 1
            }
            int formerCnt = validCat * factorial(N - i - 1); // 1*(3-0-1) -> 1*2! // 1*(3-1-1) -> 1
            order = order + formerCnt; // 0+2 => 2 // 3
        }
        return order;
    }
    public static int factorial(int n) { //팩토리얼 재귀함수
        if(n <= 1) return 1;
        return n * factorial(n-1);
    }
}

