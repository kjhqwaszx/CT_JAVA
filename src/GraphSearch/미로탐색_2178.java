package GraphSearch;

import java.awt.image.renderable.ContextualRenderedImageFactory;
import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 미로탐색_2178 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder Sb = new StringBuilder();

    static int N,M;
    static String[] map;
    static int[][] dist;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static void input() {
        N = sc.nextInt();
        M = sc.nextInt();
        map = new String[N];

        sc.nextLine();
        for (int i = 0; i < N; i++) {
            map[i] = sc.nextLine();
        }

        visit = new boolean[N][M];
        dist = new int[N][M];

    }

    static void bfs(int x, int y) {
        //dist배열 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dist[i][j] = -1;
            }
        }

        Queue<Integer> que = new LinkedList<>();
        que.add(x);
        que.add(y);
        dist[x][y] = 1;
        visit[x][y] = true;

        while (!que.isEmpty()) {
            x = que.poll();
            y = que.poll();

            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(map[nx].charAt(ny) == '0')continue;
                if(visit[nx][ny]) continue;
                que.add(nx);
                que.add(ny);
                visit[nx][ny] = true;
                dist[nx][ny] = dist[x][y] +1;
            }
        }

    }
    static void pro() {
        bfs(0,0);
        System.out.println(dist[N-1][M-1]);
    }

    public static void main(String[] args) {
        input();
        pro();
    }

}
