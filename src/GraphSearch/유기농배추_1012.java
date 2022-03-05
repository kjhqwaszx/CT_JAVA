package GraphSearch;
//27분
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 유기농배추_1012 {
    static Scanner sc = new Scanner(System.in);
    static int T,W,H,N;
    static boolean[][] visit;
    static int[][] map;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int ans;

    static void input(){

        W = sc.nextInt();
        H = sc.nextInt();
        N = sc.nextInt();

        map = new int[W][H];
        visit = new boolean[W][H];
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            map[x][y] = 1;
        }
    }

    static void bfs(int x, int y){
        Queue<Integer> que = new LinkedList<>();
        visit[x][y] = true;
        que.add(x);
        que.add(y);

        while (!que.isEmpty()) {
            x = que.poll();
            y = que.poll();

            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];

                if (nx < 0 || ny < 0 || nx >= W || ny >= H) continue;
                if(map[nx][ny] == 0) continue;
                if (visit[nx][ny]) continue;
                que.add(nx);
                que.add(ny);
                visit[nx][ny] = true;
            }

        }
        ans ++;
    }

    static void proc(){
        ans = 0;
        for (int i = 0; i < W; i++) {
            for (int j = 0; j < H; j++) {
                if(visit[i][j]) continue;
                if(map[i][j]==0) continue;
                bfs(i, j);
            }
        }
        System.out.println(ans);

    }

    public static void main(String[] args) {
        T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            input();
            proc();
        }

    }
}
