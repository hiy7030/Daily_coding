package daily;

public class quickSort {
    public static void main(String[] args) {

    }
    public int[] solution(int[] arr) {
        if(arr.length == 0) return arr;

        return sort(arr, 0, arr.length -1); // 실행초과 오류
    }

    private int[] sort(int[] arr, int low, int high) { // 왼쪽 기준 정렬은 효율이 안좋은가?
        if(low >= high) return arr;

        int pivot = low; // 0
        int left = low + 1; // 1
        int right = high; // 5
        int temp = 0; // 임시저장소

        while(left <= right) { // 1<=5
            while(arr[low] >= arr[pivot]) {
                low++;
            }
            while(arr[high] <= arr[pivot]){
                high--;
            }

            if(left > right) {
                temp = arr[right];
                arr[right] = arr[low];
                arr[low] = temp;
            } else {
                temp = arr[right];
                arr[right] = arr[low];
                arr[left] = temp;
            }
        }
        sort(arr, low, right-1);
        sort(arr, right+1, high);

        return arr;
    }

    // 레퍼런스 코드

    public int[] reference(int[] arr) {
        if(arr.length == 0) return arr;

        return sort2(arr, 0, arr.length-1);
    }

    public int[] sort2(int[] arr, int left, int right) {
        // 퀵 정렬 메서드
        int part = partition(arr, left, right);
        if(left < part-1) arr = sort2(arr, left, part - 1);
        if(right > part) arr = sort2(arr, part, right);

        return arr;
    }

    private int partition(int[] arr, int left, int right) {
        int pivot = arr[(left + right)/2];

        while (left<=right) {
            while (arr[left] < pivot) left++;
                while (arr[right]>pivot) right--;
                    if(left<= right) {
                        int temp = arr[left];
                        arr[left] = arr[right];
                        arr[right] = temp;
                        left++;
                        right--;
                    }
        }
        return left;
    }
}
