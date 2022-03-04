package GraphSearch;

import java.time.Year;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 현명한_나이트_18404 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static int N,M, sx,sy;
    static int[][] dist;
    static int[][] dir = {{-1, -2}, {-2, -1}, {-1, 2}, {-2, 1}, {1, -2}, {2, -1}, {1, 2}, {2, 1}};
    static boolean[][] visit;
    static int[][] EP;

    static void input() {
        N = sc.nextInt();
        M = sc.nextInt();

        dist = new int[N + 1][N + 1];
        visit = new boolean[N+1][N+1];

        sx = sc.nextInt();
        sy = sc.nextInt();

        EP = new int[M][2];
        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            EP[i][0] = x;
            EP[i][1] = y;
        }
    }

    static void bfs(int x, int y) {
        Queue<Integer> que = new LinkedList<>();

        visit[x][y] = true;
        dist[x][y] = 0;

        que.add(x);
        que.add(y);

        while (!que.isEmpty()) {
            x = que.poll();
            y = que.poll();

            for (int k = 0; k < 8; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];

                if(nx < 1 || ny < 1 || nx > N || ny > N) continue;
                if(visit[nx][ny]) continue;

                visit[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + 1;
                que.add(nx);
                que.add(ny);
            }
        }
    }

    static void proc() {
        bfs(sx, sy);
        for(int[] ep : EP){
            sb.append(dist[ep[0]][ep[1]]).append(' ');
        }
        sb.deleteCharAt(sb.length()-1);

        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        proc();
    }

}
