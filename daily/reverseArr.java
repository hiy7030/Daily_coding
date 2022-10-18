import java.lang.reflect.Array;
import java.util.Arrays;

public class reverseArr {
    public static void main(String[] args) {

    }
    public static int[] reverseArr2 (int[] arr ) {
        // 빈 배열 -> 빈 배열 리턴
        if(arr.length == 0) return new int[]{};

        //arr의 마지막 요소를 저장한 배열
        int[] head = Arrays.copyOfRange(arr, arr.length-1, arr.length);
        // arr의 마지막 요소를 제외한 배열을 길이가 0이 될때까지 재귀를 돌린다.
        int[] tail = reverseArr2(Arrays.copyOfRange(arr, 0, arr.length-1));
        // 위 두 배열의 요소 합만큼의 길이를 가진 배열
        int[] result = new int[head.length + tail.length];

        //head의 요소와 tail의 요소를 result에 복사한다.
        System.arraycopy(head, 0, result, 0, head.length);
        System.arraycopy(tail, 0, result, head.length, tail.length);

        return result;
    }
}
