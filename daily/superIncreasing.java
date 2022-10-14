package daily;

import java.util.Arrays;
import java.util.Scanner;

public class superIncreasing {
    public static boolean main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N];

        // arr[i] > arr[0]~arr[i-1]의 합
        for(int i = 1; i < arr.length; i++) {
            // i 전까지의 요소들로만 이루어진 배열을 copy해서 메서드 호출
            int[] arrcopy = Arrays.copyOfRange(arr, 0, i);
            int arrsum = sum(arrcopy);
            if (arr[i] <= arrsum) {
                return false;
            }
        }
        return true;
    }
    // 이전 요소들의 합
    public static int sum(int[] arr) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
