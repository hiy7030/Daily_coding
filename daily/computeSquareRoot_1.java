package daily;

import java.awt.*;
import java.util.Scanner;

public class computeSquareRoot_1 {
    public static String main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        //제곱근 값을 입력할 변수 선언 -> 이 때 0의 값을 주면 제곱근을 구하는 식이 실행될 수 없음을 인지
        double x = 1.0;
        // 결과값을 String 타입으로 출력해야 한다.
        String result = "";

        // 제곱근 구하기 -> 바빌로니아 법 사용
        // 정밀도만큼 반복문을 실행 (정밀도가 높을수록 정확한 값을 구할 수 있다)
        int precision = 100;

        for(int i = 0; i < precision; i++) {
            x = 0.5 * (num / x + x);  // 바빌로니아 식
        }
        // 결과값을 소수점 두자리까지 반환
        result = String.format("%.2f", x);
        return result;
    }
}
