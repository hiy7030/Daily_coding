import java.util.Scanner;

public class readVertically {
    public static void main(String[] args) {
    }
    public static String readVertically2 (String[] arr) {
        // 기존 배열 중 가장 길이가 긴 요소를 찾아 길이를 저장한다.
        int maxLength = 0;

        for(int i = 0; i < arr.length; i++) {
            if(maxLength < arr[i].length()) {
                maxLength = arr[i].length();
            }
        }
        // 저장된 길이만큼의 String 배열을 하나 선언한다.  -> 반복문을 돌면서 요소 저장할
        String[] result = new String[maxLength];
        // 1번 반복문 : arr배열의 요소를 하나 빼온다.
        for(int i = 0; i < arr.length; i++) {
            String str = arr[i];
            for(int j = 0; j < str.length(); j++) {
                // 만약 result[j]의 값이 없다면
                if(result[j] == null) {
                    // str.charAt(j)의 값을 String으로 변환하여 저장
                    result[j] = Character.toString(str.charAt(j));
                } else {
                    // str.charAt(j)의 값을 result[j]와 더하기
                    result[j] += str.charAt(j);
                }
            }
        }
        // 반복문이 종료되면 result의 값을 반복문을 돌며 String에 저장한다.
        String strResult = "";
        for(int i = 0; i < result.length; i++) {
            strResult += result[i];
        }
        return strResult;
    }
}
