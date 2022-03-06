package GraphSearch;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 섬의_개수_4963 {
    static Scanner sc = new Scanner(System.in);
    static int W, H, island_cnt;
    static ArrayList<Integer> ans;
    static int[][] map;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {-1, -1}, {1, -1}, {1, 1}, {-1, 1}};

    static void input() {
        map = new int[H][W];
        visit = new boolean[H][W];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                map[i][j] = sc.nextInt();
            }
        }
    }

    static void bfs(int x, int y){
        Queue<Integer> que = new LinkedList<>();

        que.add(x);
        que.add(y);
        visit[x][y] = true;
        island_cnt ++;

        while (!que.isEmpty()) {
            x = que.poll();
            y = que.poll();

            for (int k = 0; k < 8; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
                if(visit[nx][ny]) continue;
                if(map[nx][ny] == 0) continue;
                que.add(nx);
                que.add(ny);
                visit[nx][ny] = true;
            }
        }

    }

    static void proc() {
        island_cnt = 0;

        for(int i=0; i< H; i++){
            for (int j = 0; j < W; j++) {
                if(map[i][j] == 0) continue;
                if(visit[i][j]) continue;
                bfs(i,j);
            }
        }
        System.out.println(island_cnt);

    }

    public static void main(String[] args) {
        while(true){
            W = sc.nextInt();
            H = sc.nextInt();
            if(W == 0 && H == 0) break;

            input();
            proc();
        }


    }
}
