package Programmers;

import java.util.Arrays;

public class OddArrays {
    public static void main(String[] args) {
        // 정수 n이 매개변수로 주어질 때, n 이하의 홀수가 오름차순으로 담긴 배열을 return하도록 solution 함수를 완성해주세요.
    }
    public static int[] solution(int n) {
        // 입력받은 n 만큼의 길이를 가진 배열을 선언한 후 1부터 n까지의 값을 오름차순으로 저장한다.
        int[] num = new int[n];
        int number = 1;
        for(int i = 0; i < num.length; i++) {
            num[i] = number;
            number++;
        }

        // 가변 배열을 선언한 후, num배열의 홀수값이 나오면 배열의 길이를 늘리고 저장
        // 배열의 길이를 늘리는 법 배열을 복사
        int[] result = new int[]{};

        for(int i = 0; i < num.length; i++) {
            if(num[i] % 2 != 0) {
                result = Arrays.copyOf(result, result.length + 1);
                result[result.length -1] = num[i];
            }
        }
        return result;
    }
}
