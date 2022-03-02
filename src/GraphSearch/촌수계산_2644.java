package GraphSearch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 촌수계산_2644 {
    static Scanner sc = new Scanner(System.in);
    static int N, P1, P2, I;
    static int[][] pMap;
    static int[] chonNum; // P1기준 Index 사람 별 촌수.

    static void input() {
        N = sc.nextInt();
        P1 = sc.nextInt();
        P2 = sc.nextInt();
        I = sc.nextInt();
        pMap = new int[N+1][N+1];

        for (int i = 0; i < I; i++) {
            int x= sc.nextInt();
            int y = sc.nextInt();
            pMap[x][y] = 1;
            pMap[y][x] = 1;
        }
    }

    static void bfs() {
        Queue<Integer> que = new LinkedList<>();

        for(int i=1; i<=N; i++) chonNum[i] = -1;

        que.add(P1);
        chonNum[P1] = 0;

        while (!que.isEmpty()) {
            int x = que.poll();
            for (int i = 1; i <= N; i++) {
                if(pMap[x][i] == 1){
                    if(chonNum[i] != -1) continue;
                    que.add(i);
                    chonNum[i] = chonNum[x] + 1;
                }
            }

        }
        System.out.println(chonNum[P2]);
    }
    static void proc() {
        chonNum = new int[N+1];
        bfs();
    }
    public static void main(String[] args) {
        input();
        proc();
    }
}
