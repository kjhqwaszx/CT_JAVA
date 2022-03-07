package GraphSearch;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 케빈_베이컨_1389 {
    static Scanner sc = new Scanner(System.in);
    static int N,M;
    static int[][] rel;
    static int[][] dist;
    static int[] ans;

    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();

        rel = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            int p1 = sc.nextInt();
            int p2 = sc.nextInt();

            rel[p1][p2] = 1;
            rel[p2][p1] = 1;
        }
    }

    static void bfs(){
        Queue<Integer> que = new LinkedList<>();

        for (int i = 1; i <= N; i++) { // 모든 사람마다 친구 관계 탐색
            que.add(i);
            dist[i][i] = 0;

            while (!que.isEmpty()) {
                int p1 = que.poll();

                for (int j = 1; j <= N; j++) {
                    if(rel[p1][j] == 1 ){ // 친구관계가 있는 경우에만 탐색
                        if(dist[i][j] != -1) continue;
                        dist[i][j] = dist[i][p1] + 1;
                        que.add(j);
                    }
                }
            }
        }

    }

    static void proc() {
        dist = new int[N + 1][N + 1];
        ans = new int[N+1];
        int[] tmp;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dist[i][j] = -1;
            }
        }
        bfs();

        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for(int j=1; j<=N; j++){
                sum += dist[i][j];
            }
            ans[i] = sum;
        }
        tmp = Arrays.copyOf(ans,ans.length);

        Arrays.sort(tmp);
        for (int i = 1; i <= N; i++) {
            if(ans[i] == tmp[1]){
                System.out.print(i);
                break;
            }
        }
    }

    public static void main(String[] args) {
        input();
        proc();

    }
}
