package daily;

import java.util.Scanner;

public class computeSquareRoot_2 {
    public static String main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        // 정밀도를 위해 double타입의 배열을 선언 소수점 3번째 자리에서 반올림하기
        double[] precision = new double[]{1, 0.1, 0.01, 0.001};
        // 초기값 선언
        double base = 1;

        // 반복문을 precision 배열의 길이만큼 실행한다.
        for(int i = 0; i < precision.length; i++) {
            // base의 제곱근 < num -> num과 같거나 커질때까지 반복
            while(base * base < num) {
                base += precision[i];
            }
            // base의 제곱근이 num과 같다면 바로 base 리턴
            if(base * base == num) {
                return String.format("%.2f", base);
            } else {
                // base의 제곱근 > num -> 1빼고 반복문 돌리기
                base -= precision[i];
            }
        }
        return String.format("%.2f", base);
    }
}
