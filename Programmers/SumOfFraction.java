package Programmers;

public class SumOfFraction {
    public static void main(String[] args) {

    }

    public static int[] solution(int denum1, int num1, int denum2, int num2) {
        // denum : 분자 num : 분모
        // 두 분수를 일단 더한다.
        // 분자
        int baby = (denum1 * num2) + (denum2 * num1);
        // 분모
        int mom = num1 * num2;

        // baby와 mom의 최대 공약수를 구해 나눠 줘야 함
        int min = Math.min(baby, mom);

        int gcd = 0;
        for(int i = 1; i <= min; i++) {
            if(baby % i == 0 && mom % i == 0) {
                gcd = i;
            }
        }

        baby /= gcd;
        mom /= gcd;

        int[] answer = new int[]{baby, mom};
        return answer;
    }

    // 최대 공약수 구하는 다른 방법
    public int gcd2 (int num1, int num2) {
        if(num1 % num2 == 0) return num2;
        return gcd2(num2, num1 % num2);
    }
}
