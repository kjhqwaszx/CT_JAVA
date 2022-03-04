package GraphSearch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 결혼식_5567 {
    static Scanner sc = new Scanner(System.in);
    static int N, M;
    static int[] inviteList;
    static int[][] friendLst;

    static void input() {
        N = sc.nextInt();
        M = sc.nextInt();

        inviteList = new int[N+1];
        friendLst = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            int f1 = sc.nextInt();
            int f2 = sc.nextInt();

            friendLst[f1][f2] = 1;
            friendLst[f2][f1] = 1;
        }
    }
    static void bfs() {
        Queue<Integer> que = new LinkedList<>();
        que.add(1);
        inviteList[1] = 0;

        while (!que.isEmpty()) {
            int f = que.poll();
            for (int i = 2; i <= N; i++) {
                if(i == f) continue;

                if(friendLst[f][i] == 0)continue; // 친구관계가 아닐경우
                if(inviteList[i] != -1) continue; // 이미 초대하기로 한 친구인 경우
                inviteList[i] = inviteList[f]+1;
                que.add(i);
            }
        }
    }

    static void proc() {
        int ans = 0;

        for (int i = 0; i < inviteList.length; i++) {
            inviteList[i] = -1;
        }
        bfs();
        for (int i = 2; i < inviteList.length; i++) {
            if(inviteList[i] == 1 || inviteList[i] == 2 ){
                ans ++;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        proc();
    }

}
