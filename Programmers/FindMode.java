package Programmers;

public class FindMode {
    //최빈값은 주어진 값 중에서 가장 자주 나오는 값을 의미합니다.
    //정수 배열 array가 매개변수로 주어질 때, 최빈값을 return 하도록 solution 함수를 완성해보세요.
    // 최빈값이 여러 개면 -1을 return 합니다.
    public static void main(String[] args) {

    }
    public static int solution(int[] arr) {
        // 결과값 저장
        int result = 0;
        // arr은 1,2,3 오름차순으로 값을 가진다. 따라서 배열 내 카운팅 배열의 길이는 arr요소의 가장 큰 값에 +1 하면됨
        int arrMax = 0;

        for(int i = 0; i<arr.length; i++) {
            if(arr[i]>arrMax) {
                arrMax = arr[i];
            }
        }

        int[] cnt = new int[arrMax + 1];
        int max = 0; // cnt 배열의 최대값을 저장

        for(int i = 0; i<arr.length; i++) {
            cnt[arr[i]]++;
        }
        for(int i = 0; i < cnt.length; i++) {
            if(cnt[i]>max) {
                max = cnt[i];
                result = i;
            }
        }
        // 중복 최빈값 찾기
        int n = 0; // 중복여부 카운팅

        for(int i = 0; i<cnt.length; i++) {
            if(cnt[i] == max) n++;
        }
        if(n>1) result = -1;

        return result;
    }
}
