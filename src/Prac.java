import java.util.*;

public class Prac {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static int N,M;
    static String[] map;
    static boolean[][] visit;
    static int[][] dist;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static void input() {
        N = sc.nextInt();
        M = sc.nextInt();
        map = new String[N];

        sc.nextLine();
        for (int i = 0; i < N; i++) {
            map[i] = sc.nextLine();
        }
    }

    static void bfs(int x, int y) {
        Queue<Integer> que = new LinkedList<>();
        que.add(x);
        que.add(y);
        visit[x][y] = true;
        dist[x][y] = 1;

        while (!que.isEmpty()) {
            x = que.poll();
            y = que.poll();

            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(visit[nx][ny]) continue;
                if(map[nx].charAt(ny) == '0') continue;

                visit[nx][ny] = true;
                dist[nx][ny] = dist[x][y] +1;
                que.add(nx);
                que.add(ny);
            }
        }
    }

    static void proc() {
        visit = new boolean[N][M];
        dist = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dist[i][j] = -1;
            }
        }
        bfs(0,0);

        System.out.println(dist[N-1][M-1]);
    }
    public static void main(String[] args) {
        input();
        proc();
    }

}
