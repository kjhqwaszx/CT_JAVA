package GraphSearch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//44분
public class 양_3184 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int R,C;
    static int o_cnt, v_cnt; // 같은 공간 내 양, 늑대 수
    static int ans_o, ans_v; // 최종 양, 늑대 수
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static boolean[][] visit;
    static String[] map;


    static void input(){
        R = sc.nextInt();
        C = sc.nextInt();

        map = new String[R];
        visit = new boolean[R][C];
        sc.nextLine();

        for (int i = 0; i < R; i++) {
            map[i] = sc.nextLine();
        }
    }
    static void bfs(int x, int y){
        Queue<Integer> que = new LinkedList<>();

        o_cnt = 0;
        v_cnt = 0;
        if(map[x].charAt(y) == 'o') o_cnt++;
        else if(map[x].charAt(y) == 'v') v_cnt++;

        que.add(x);
        que.add(y);
        visit[x][y] = true;

        while (!que.isEmpty()) {
            x = que.poll();
            y = que.poll();
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if (visit[nx][ny]) continue;
                if(map[nx].charAt(ny) == '#') continue;
                if(map[nx].charAt(ny) == 'o') o_cnt++;
                else if(map[nx].charAt(ny) == 'v') v_cnt++;
                que.add(nx);
                que.add(ny);
                visit[nx][ny] = true;
            }
        }

        if(o_cnt > v_cnt) ans_o += o_cnt;
        else ans_v += v_cnt;
    }

    static void proc(){
        ans_o = 0;
        ans_v = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(visit[i][j]) continue;
                if(map[i].charAt(j) == '#') continue;
                bfs(i, j);
            }
        }
        sb.append(ans_o).append(' ').append(ans_v);
        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        proc();
    }



}
