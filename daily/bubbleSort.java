import java.util.Arrays;

public class bubbleSort {
    public static void main(String[] args) {

        int[] arr = new int[]{5,4,3,2,1};
        System.out.println(Arrays.toString(bubbleSort2(arr)));

    }
    public static int[] bubbleSort2(int[] arr) {

        // 전체 반복문은 arr의 길이보다 하나 작은 수 만큼 돌린다 -> 어차피 그 전수로 비교를 하기 때문에
        for(int i = 1; i < arr.length; i++) {
            // 현재 상태를 표현해준다. 반복문이 돌지 않는 시점은 false
            boolean status = false;
            // 정렬을 위한 반복문 실행
            for(int j = 0; j < arr.length-1; j++ ) {
                // arr[j] > arr[j+1] -> arr[j] = arr[j+1] , arr[j+1] = arr[j]
                if(arr[j] > arr[j+1]) {
                    int num = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = num;
                    //반복문이 정상실행 되었으므로 상태를 변경해준다.
                    status = true;
                }
            }
            if(!status) {
                break;
            }
        }
        return arr;
    }

}
