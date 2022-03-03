package GraphSearch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 나이트이동_7562 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int N,M,X,Y,DX,DY;
    static int[][] map;
    static boolean[][] visit;
    static int[][] dist;
    static int[][] dir = {{-2, -1}, {-1, -2}, {2, -1}, {1, -2}, {2, 1}, {1, 2}, {-2, 1}, {-1, 2}};

    static void input(){
        N = sc.nextInt();

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

                if(nx < 0 || ny < 0 || nx >= M || ny >= M ) continue;
                if(visit[nx][ny]) continue;
                dist[nx][ny] = dist[x][y] + 1;

                visit[nx][ny]= true;

                que.add(nx);
                que.add(ny);
            }
        }
    }

    static void proc(){
        for (int i = 0; i < N; i++) {
            M = sc.nextInt();
            map = new int [M][M];
            dist = new int[M][M];
            visit = new boolean[M][M];

            X = sc.nextInt();
            Y = sc.nextInt();
            DX = sc.nextInt();
            DY = sc.nextInt();

            bfs(X,Y);

            sb.append(dist[DX][DY]).append('\n');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        proc();


    }
}

