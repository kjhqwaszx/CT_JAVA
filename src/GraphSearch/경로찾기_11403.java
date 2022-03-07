package GraphSearch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 경로찾기_11403 {
    static Scanner sc = new Scanner(System.in);
    static int N;
    static int[][] adjList;
    static boolean[][] visit;
    static int[][] ans;

    static void input() {
        N = sc.nextInt();
        adjList = new int[N][N];
        ans = new int[N][N];
        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                adjList[i][j] = sc.nextInt();
            }
        }
    }

    static void bfs(int s1) {
        Queue<Integer> que = new LinkedList<>();
        que.add(s1);

        while (!que.isEmpty()) {
            int s2 = que.poll();

            for (int i = 0; i < N; i++) {
                if(visit[s1][i])continue;
                if(adjList[s2][i] == 0) continue;

                visit[s1][i] = true;
                ans[s1][i] = 1;
                que.add(i);
            }
        }
    }
    static void proc() {
        for (int i = 0; i < N; i++) {
            bfs(i);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(ans[i][j]);
                System.out.print(' ');
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        input();
        proc();
    }
}
