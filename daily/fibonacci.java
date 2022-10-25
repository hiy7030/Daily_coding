import java.util.ArrayList;

public class fibonacci {
    public static void main(String[] args) {

    }

    public static int o2n(int num) { //시간복잡도가 O(2^n)
        if(num <= 2) return num;
        return o2n(num-1) + o2n(num -2);
    }

    public static int on (int num) { //시간복잡도가 O(n)
        //이미 한번 연산을 한 숫자는 기록해둬서 중복 연산을 하지 않게 한다.
        // 이미 연산을 완료한 숫자를 넣는 리스트 선언
        ArrayList<Integer> memo = new ArrayList<>();
        // 피보나치 수열에서 0번째는 0, 1번째는 1이므로 미리 넣어둔다.
        memo.add(0);
        memo.add(1);

        return function(memo, num);

    }
    public static int function(ArrayList<Integer> memo, int num) {
        // 만약 memo의 사이즈가 num보다 같거나 작다면 -> 아직 연산 안끝남 연산 재귀
        if(memo.size() <= num) {
            memo.add(function(memo, num-1) + function(memo, num-2));
        }
        // 그렇지 않다면, memo의 num번째 숫자를 리턴
        return memo.get(num);
    }
}
