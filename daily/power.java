public class power {
    public static void main(String[] args) {
        // 왜 나누는 값이 굳이 94906249인지? -> 모듈러 곱셈 역원과 관련
        // 오버플로어가 발생하지 않게 하기 위해 저 값으로 나누는 것까지는 이해 완.. 근데 왜 하필 저 숫자?
        // 알고리즘 문제로 94,906,249와 1,000,000,007로 나눈 나머지를 구하라는 문제가 많다고..
        // 그 이유는 두 수가 소수이기 때문 -> 소수는 풀이의 정확도를 가질 수 있는 장점을 가진다.
    }

    public static long solution (int base, int exponent) {
        // power(2^13) = power(2^6) * power(2^6) * 2 -> exponent가 1이라 재귀 종료
        if(exponent == 0) return 1;

        // 재귀 생성
        long result = solution(base, exponent/2);

        long num = 94906249; //연산할 때마다 결과값에 이 값으로 나눈 나머지를 구해서 연산을 진행
        long ex = 0; // 연산값 저장

        // exponent 짝수일 경우
        if(exponent % 2 == 0) {
            // result * result
           ex = result * result;
        } else {
        // exponent 홀수일 경우
            // result * result * base
            ex = result * result * base;
        }

        // 연산값을 num으로 나눈 값을 result에 저장하여 반환한다.
        result = ex % num;

        return result;

    }

    public static long solution2 (int base, int exponent) {
        if(exponent == 0) return 1;

        int half = exponent / 2;
        long temp = solution2(base, half);
        long result = (temp * temp) % 94906249;

        if(exponent % 2 == 1) return (base * result) % 94906249;
        else  return result;
    }
}
