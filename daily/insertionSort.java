package daily;

public class insertionSort {
    public static void main(String[] args) {
        // 삽입 정렬

    }
    public int[] solution(int[] arr) { // 배열의 길이가 1000일 때는 통과를 하지 못함
        // 1. arr[i]가 그 앞에 있는 요소들과 비교하면서 자리를 바꾸는 ?
        // 만약 arr[i]가 arr[0]~arr[i-1] 까지의 요소 중 가장 크면 i++
        //  만약 arr[i]가 arr[0]~arr[i-1] 까지의 요소와 비교하여 값들을 정렬
        if(arr.length == 0) return arr;

        return sort(arr, 1);
    }
    public int[] sort(int[] arr, int k) { // k =1 {5}
        // arr의 마지막 요소는 arr[arr.length-1]
        if(k == arr.length) return arr;

        for(int i = 0; i < k; i++){
            if(arr[i] > arr[k]) { // 8 > 5
                int temp = arr[i]; // 8
                arr[i] = arr[k]; // 5
                arr[k] = temp;  // 8  arr = {5, 8, 2, 3, 1}
            }
        }
        return sort(arr, ++k); // arr = {5, 8, 2, 3, 1} k =2
    }
    //레퍼런스 코드
    public int[] reference(int[] arr) {
        for(int index = 1; index < arr.length; index++) {
            int target = index;
            while (target > 0 && arr[target-1] > arr[target]) {
                int temp = arr[target - 1];
                arr[target-1] = arr[target];
                arr[target] = temp;
                target--;
            }
        }
        return arr;
    }
}
