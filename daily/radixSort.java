package daily;

public class radixSort {
    public static void main(String[] args) {
        // 코드 개선 필요함
    }
    public int[] solution(int[] arr) {
        // TODO: 계수 정렬 -> 각각의 요소에서 가장 큰값만큼의 길이를 가진 배열을 선언해 각 개수를 세는 방법?
        if(arr.length == 0) return arr;
        // 1. arr의 요소 중 가장 큰 값을 구한다.
        int max = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i]>max) max = arr[i];
        }
        // 2.가장 작은 자리수(1의자리)부터 가장 큰 자리수까지 범위를 나눠 계수 정렬을 진핸한다.
        // 1의 자리 ~ 10^n 자리 -> 곱하기 10하면됨
        for(int i = 1; i < max; i *= 10) {
            //계수정렬 식
            arr = countingSort(arr, i);
        }
        return arr;
    }

    // 자리수마다 계수 정렬하기
    public int[] countingSort(int[] arr, int digit) {
        // 카운팅(0~9) 10개의 길이를 가진 배열
        int[] count = new int[10];
        // arr의 정렬된 요소를 가지는 임시배열
        int[] temp = new int[arr.length];

        // 각 자리수의 값 구하는 법 (해당값 / 자리수)%10
        for(int i = 0; i < arr.length; i++ ) {
            count[(arr[i]/digit)%10]++;
        }

        // 누적합(1의 자리수는 10자리 연산에서 카운팅이 안되니까)
        for(int i = 1; i<10; i++) {
            count[i] += count[i-1];
        }

        for(int i = 0; i < arr.length; i++) {
            int num = (arr[i] / digit) % 10;
            int index = count[num];
            temp[index-1] = arr[i];
            count[num]--;
        }

        for(int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }

        return temp;
    }
}
