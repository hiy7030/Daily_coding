package daily;

import java.util.Scanner;

public class superIncreasing2 {
    public static boolean main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];

    // n==0 return false
    if (n == 0) return false;
    // 합의 값을 arr의 첫요소로 초기화한다.
    int sum = arr[0];

    // arr의 요소를 돌며 sum보다 작거나 같을 경우 false를 반환하고
    for(int i = 0; i < n; i++) {
     // sum보다 클 경우 sum에 해당 요소를 더해준다.
        if(arr[i] <= sum) {
            return false;
        }
        sum += arr[i];
    }
    // 반복문이 끝나면 true를 반환한다.
    return true;
    }


}
