import java.util.Scanner;

public class CompressString {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = "dsafdasfffffsgaaaaabbbscccdd";

        System.out.println(compressString2(str));
    }
    public static String compressString2(String str) {
        if(str.length() == 0) return "";

        // 연속된 문자가 3개 나오면 3, 그 미만은 문자만, 그 이상은 숫자 문자
        String result = "";
        int count = 1;
        char ch = str.charAt(0);

        // 마지막 요소가 누락되는 일이 발생하므로 임의의 공백을 문자열 뒤에 넣어준다.
        str = str + ' ';

        for(int i = 1; i < str.length(); i++) {
            // ch와 str.charAt(i)와 같다면 count++
            if(ch == str.charAt(i)) {
                count++;
            } else {  // 같지 않다면
                // count >= 3일때, result는 count + ch
                if(count >= 3) {
                    result = result + count + ch;
                } else {
                // count < 3일때, result는 ch * count
                    for(int j = 0; j < count;  j++) {
                        result += ch;
                    }
                }
                // 해당 반복문의 과정이 끝나면 다음 반복문으로 넘어가고 ch의 값을 변경한다.
                ch = str.charAt(i);
                // count도 다시 리셋
                count = 1;
            }
        }
        return result;
    }
}
