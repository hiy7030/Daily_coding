import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class rotatedArraySearch {
    public static void main(String[] args) {

    }
    public int solution(int[] rotated, int target) { //NullPointerException
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < rotated.length; i++) {
            map.put(rotated[i], i);
        }

        List<Integer> key = new ArrayList<>(map.keySet());
        key.stream().sorted().collect(Collectors.toList());

        int low = 0;
        int high = rotated.length - 1;

        int index = ex(rotated, target, low, high);

        int result = map.get(index);

        return result;


    }
    public int ex (int[] rotated, int target, int low, int high) {
        if(low > high) return -1;

        int mid = (low + high) /2;

        if(rotated[mid] == target) {
            return mid;
        } else if(rotated[mid] > target) {
            return ex(rotated, target, low, mid-1);
        } else {
            return ex(rotated, target, mid+1, high);
        }
    }

    public int reference(int[] rotated, int target) {
        int low = 0; //왼쪽
        int high = rotated.length -1; //오른쪽

        while (low <= high) {
            int mid = (low + high) / 2;

            if(rotated[mid] == target) {
                return mid;
            }

            //왼쪽이 정렬된 상태인 경우
            if(rotated[low] < rotated[mid]) {// 1234567  mid = 4 low = 1 target = 3
                // target이 low보다 크고 mid보다 작으면 return mid -1
                if(target >= rotated[low] && target < rotated[mid]) {
                    high = mid - 1;
                } else {
                // 그외는 mid + 1
                    low = mid + 1;
                }
            } else { // mid 4 high 7 target 5
                // target이 mid보다 크고 high보다 작으면 mid + 1
                if(target > rotated[mid] && target <= rotated[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
