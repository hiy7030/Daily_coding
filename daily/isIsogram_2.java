package daily;

import java.util.HashMap;
import java.util.Scanner;

public class isIsogram_2 {
    public static boolean main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        // 해쉬맵을 사용하며 순회하기

        // 빈문자열 -> true 리턴
        if(str.length() == 0) return true;

        String str2 = str.toLowerCase();

        HashMap<Character, Integer> hashMap = new HashMap<>();

        for(int i = 0; i < str2.length(); i++) {
            char c = str2.charAt(i);
            if(hashMap.containsKey(c)) {
                return false;
            }
            hashMap.put(c, i);
        }
        return true;
    }
}
