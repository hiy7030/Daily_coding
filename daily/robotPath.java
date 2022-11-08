package daily;

public class robotPath {
    public static void main(String[] args) {

    }
    public int solution(int[][] room, int[] src, int[] dst) {
        // 최소시간 == 최단 거리 BFS 이용하기
        // 지나온 자리는 +1 해줄 것.
        // 현재 위치에서 상하좌우로 이동하는 4가지 사항 -> 범위를 벗어나거나, 1을 만나면 방향 바꾸기 => 재귀
        int n = room.length;
        int m = room[0].length;

        room = path(n, m, room, src, 1);

        return room[dst[0]][dst[1]] -1;


    }
    public static int[][] path(int n, int m, int[][] room, int[] src, int path) {
        // 현재 위치
        int i = src[0];
        int j = src[1];

        // 범위에 벗어나는 경우
        if(i < 0 || i >= n || j < 0 || j >= m) return room;

        if(room[i][j] == 0 || room[i][j] > path) {
            room[i][j] = path;
        } else {
            return room;
        }

        path(n, m, room, new int[]{i+1, j}, path+1);
        path(n, m, room, new int[]{i-1, j}, path+1);
        path(n, m, room, new int[]{i, j+1}, path+1);
        path(n, m, room, new int[]{i, j-1}, path+1);

        return room;
    }
}
