public class removeExtremes {
    public static void main(String[] args) {

    }
    public static String[] removeExtremes2 (String[] arr) {
        // 반복문을 사용하여 요소의 length가 가장 짧은 것을 찾고 긴것을 찾는다?
        // 리스트에 해당 요소를 제외한 것들을 넣고 리스트를 배열로 변환해야 하나??
        // 배열이 공백일 경우 null 반환
        if(arr.length == 0) return null;

        // 가장 짧은 문자열 찾기 가장 큰 숫자부터 줄여나가기??
        int shorter = 20;
        int shorterIndex = 0;
        // 가장 큰 문자열 찾기
        int longer = 0;
        int longerIndex = 0;

        for(int i = 0; i < arr.length; i++) {
            //만약 arr[i].length가 short보다 작으면 short에 arr[i].length 값 저장하기
            if(arr[i].length() <= shorter) {
                shorter = arr[i].length();
                // arr[i]를 삭제해야 함 인덱스 값을 저장해야함
                shorterIndex = i;
            }
            // 만약 arr[i].length가 longer보다 크다면 longer에 arr[i].length 값 저장하기.
            if(arr[i].length() >= longer) {
                longer = arr[i].length();
                longerIndex = i;
            }
        }

        String[] result = new String[arr.length - 2];
        int resultIndex = 0;

        for(int i = 0; i < arr.length; i++) {
            // i != shorterIndex 가 아니고 i != longerIndex 가 아니면
            if(i != shorterIndex && i != longerIndex){
                // result[resultIndex] = arr[i]
                result[resultIndex] = arr[i];
                resultIndex++;
            }
        }
        return result;
    }
}
