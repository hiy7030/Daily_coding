package daily;

import java.util.Scanner;

public class numberSearch {
    public static int main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();

        if(str.length() == 0) return 0;

        //indexOf() -> 해당 문자를 가진다면 해당 문자의 인덱스를 가지지않았다면 -1 리턴하는 메서드
        // str의 문자형이 숫자라면 인덱스를 아니라면 -1를 리턴
        String number = "0123456789";

        // str에서 숫자를 제외한 문자를 담을 문자 선언
        String strResult = "";
        // 숫자의 합
        double sum = 0;

        // str.charAt(i)가 숫자인 경우 indexOf의 결과는 인덱스를 반환
        // str.charAt(i)가 숫자가 아닌 경우 -1를 반환
        // str.charAt(i)가 공백인 경우
        String str2 = str.replaceAll(" ", "");

        for(int i = 0; i < str2.length(); i++) {
            // str.charAt(i)가 숫자인 경우 indexOf의 결과는 인덱스를 반환
            if(number.indexOf(str2.charAt(i)) != -1) {
                sum += Character.getNumericValue(str2.charAt(i));
            } else {
                // 문자인 경우
                strResult += str2.charAt(i);
            }
        }
        double result = sum / strResult.length();
        return (int) Math.round((result*10)/10);
    }
}

