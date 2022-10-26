import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class isSubsetOf {
    public static void main(String[] args) {

    }

    public static boolean solution1 (int[] base, int[] sample) {
        // sample은 base에 포함되어 있어야 한다.

        // List<Integer> baseList = Arrays.asList(base);
        // -> inference variable T has incompatible bounds 에러 발생
        // Reason : Integer는 Wrapper 클래스이고 int와는 다른 타입이다. asList로 배열을 List에 넣으려면 List<int[]> 으로 해야 한다.
        List<Integer> baseList = Arrays.stream(base).boxed().collect(Collectors.toList());
        List<Integer> sampleList = Arrays.stream(sample).boxed().collect(Collectors.toList());

        // boxed()가 하는 일 : 기본형 타입을 래퍼 클래스 타입으로 boxing하여 stream을 형성해준다.

        // A.containsAll(B) : A리스트에 B리스트가 전부 속해있는지를 boolean값으로 리턴하는 메서드
        boolean result = baseList.containsAll(sampleList);

        return result;
    }

    public static boolean solution2 (int[] base, int[] sample) {
        List<Integer> baseList = Arrays.stream(base).boxed().collect(Collectors.toList());

        for(int i : sample) {
            if(!baseList.contains(i)) {
                return false;
            }
        }
        return true;
    }
}
