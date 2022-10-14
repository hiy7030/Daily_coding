package daily;

import java.util.Scanner;

public class modulo {
    public static Object main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();

        // num1을 num2로 나눈 나머지 값 구하기 단, '/' 와 '%'연산자 사용 금지
        // num1 == 0 일 경우 나머지는 항상 0
        // num2 == 0 일 경우 return null
        if(num2 == 0) return null;

        // num1 >= num2 가 참일 경우 num1에서 num2를 반복해서 뺀다.
        while(num1 >= num2) {
            num1 -= num2;
        }
        return num1;
    }
}
