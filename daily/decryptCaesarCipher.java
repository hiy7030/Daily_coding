import java.util.Scanner;

public class decryptCaesarCipher {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        int secret = s.nextInt();

        System.out.println(method("khoor", 3));
    }

    public static String method(String str, int secret) {

        if (str.length() == 0) return "";

        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        // 원래 인덱스에서 -secret한 인덱스의 문자를 반환해야 함
        // 복호화한 문자열
        String result = "";

        for(int i = 0; i < str.length(); i++) {
            //str.charAt(i)가 공백이라면
            if(str.charAt(i) == ' ') {
                result += str.charAt(i);
            } else { //str.char(i) 가 문자인 경우
                // indexOf() : 해당 인덱스를 반환
                int alpha = alphabet.indexOf(str.charAt(i));
                int index = (alpha - secret + alphabet.length()) % alphabet.length();
                result += alphabet.charAt(index);
            }
        }
        return result;
    }

}
