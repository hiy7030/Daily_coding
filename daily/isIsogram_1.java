package daily;

import java.util.Locale;
import java.util.Scanner;

public class isIsogram_1 {
    public static boolean main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        // str의 문자 중복여부 확인, 중복이면 false 중복이 아니면 true
        // 이중 반복문 사용

        // 입력받은 문자열을 전부 소문자로 변환
        String str2 = str.toLowerCase();

        // 문자열을 char 타입의 배열로 변환
        char[] ch = str2.toCharArray();

        for(int i = 0; i > ch.length; i++) {
            for(int j = 0; j < ch.length; j++) {
                if(i == j) {
                    continue;
                } else {
                    if(ch[i] == ch[j]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
