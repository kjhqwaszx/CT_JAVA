package GraphSearch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 숨바꼭질_1697 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static int N, K;
    static int[] dist;
    static boolean[] visit;

    static void input() {
        N = sc.nextInt();
        K = sc.nextInt();
        visit = new boolean[100005];
        dist = new int[100005];
    }

    static void bfs() {
        Queue<Integer> que = new LinkedList<>();
        que.add(N);
        visit[N] = true;
        dist[N] = 0;

        while (!que.isEmpty()) {
            int s = que.poll();
            int x1 = s-1;
            if(x1 >= 0 && x1<=100000 && !visit[x1]){
                visit[x1] = true;
                dist[x1] = dist[s] +1;
                que.add(x1);
            }

            int x2 = s+1;
            if(x2 >= 0 && x2 <= 100000 && !visit[x2]){
                visit[x2] = true;
                dist[x2] = dist[s] +1;
                que.add(x2);
            }

            int x3 = s*2;
            if(x3 >= 0 && x3 <= 100000 && !visit[x3]){
                visit[x3] = true;
                dist[x3] = dist[s] +1;
                que.add(x3);
            }
        }

    }

    static void pro(){
        bfs();
        System.out.println(dist[K]);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
