package daily;

import java.util.LinkedList;
import java.util.Queue;

public class rotateMatrix {
    public static void main(String[] args) {

    }

    public int[][] solution (int[][] matrix, int K) {
        // TODO: k가 홀수면 int[matrix.length][matrix[0].length] 짝수면 int[matrix[i].length][matrix.length]
        // k는 4의 배수일 때 배열은 제자리로 돌아감 -> 4로 나눈 나머지 값으로 회전
        // [matrix.length-1][0] 차례대로 저장 -> [matrix.length-1][1] => Queue
        // 재귀의 파라미터로 사용할 것 -> 배열, k
        if(matrix == null) return null;
        // 1. K를 4로 나눈 값에 따라 재귀 횟수를 줄인다.
        if(K >= 4) {
            K = K % 4;
        }

        return aux(matrix, K);
    }

    // 3. 한번 그 과정을 거치면 k의 값을 하나 줄이고 k가 0이 될 때까지 반복한다.
    public int[][] aux(int[][] matrix, int k) {
        // 재귀 종료 조건은 K가 0일 때 matrix 배열을 반환한다.
        if(k == 0) return matrix;

        // 2. 배열의 값을 큐에 넣고 순서에 따라 새로운 배열에 저장한다. -> 새로운 함수를 작성해 재귀
        Queue<Integer> que = new LinkedList<>();

        int[][] result = new int[matrix[0].length][matrix.length];

        for(int i = 0; i < matrix[0].length; i++){
            for(int j = matrix.length-1; j >= 0; j--){
                que.add(matrix[j][i]);
            }
        }

        // 큐의 순서대로 새로운 배열에 값 채워넣기
        for(int i = 0; i < result.length; i++) {
            for(int j = 0; j < result[0].length; j++) {
                result[i][j] = que.poll();
            }
        }


        return aux(result, --k);

    }

    public int[][] reference (int[][] matrix, int K) {
        if(matrix == null || matrix.length == 0) return matrix;

        int N = matrix.length;
        int M = matrix[0].length;

        int rotateNum = K % 4;

        if(rotateNum == 0) return matrix;

        // 홀수번 회전 시 M x N 짝수번 회전 시 N x M
        int[][] rotated = rotateNum % 2 == 1 ? new int[M][N] : new int[N][M];

        for(int row = 0; row <rotated.length; row++) {
            for(int col = 0; col < rotated[row].length; col++) {
                if(rotateNum == 1) {
                    rotated[row][col] = matrix[N -col-1][row];
                } else if (rotateNum == 2) {
                    rotated[row][col] = matrix[N-row-1][M-col-1];
                } else {
                    rotated[row][col] = matrix[col][M -row-1];
                }
            }
        }
        return rotated;
    }
}
