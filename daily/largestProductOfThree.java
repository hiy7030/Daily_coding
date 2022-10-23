import java.util.Arrays;

public class largestProductOfThree {
    public static void main(String[] args) {

        int[] arr = new int[]{-5, -4, -3, -1, 999, 10000};

        System.out.println(largestProductOfThree2(arr));

    }

    public static int largestProductOfThree2 (int[] arr) {
        Arrays.sort(arr);

        // 만약 다 양수라면 제일 큰 수끼리 곱해야 하고 다 음수거나 섞여있다면...?
        // 가장 큰 수끼리 곱한 것과, 가장 작은 수 2개와 가장 큰 수끼리 곱한 것을 비교해서 더 큰 값을 리턴
        int max = arr[arr.length-1] * arr[arr.length-2] * arr[arr.length-3];
        int min = arr[arr.length-1] * arr[1] * arr[0];

        return Math.max(max, min);
    }
}
