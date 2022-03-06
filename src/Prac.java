import java.util.*;

public class Prac {
    static Scanner sc = new Scanner(System.in);
    static int N, M;
    static int[][] rel;
    static int[] dist;

    static void input() {
        N = sc.nextInt();
        M = sc.nextInt();

        rel = new int[N+1][N+1];

        for (int i = 0; i < M; i++) {
            int p1 = sc.nextInt();
            int p2 = sc.nextInt();

            rel[p1][p2] = 1;
            rel[p2][p1] = 1;
        }
    }

    static void bfs(int p1) {
        Queue<Integer> que = new LinkedList<>();

        que.add(1);

        dist[1] = 0;

        while (!que.isEmpty()) {
            p1 = que.poll();

            for(int i =1; i<=N; i++){
                if(rel[p1][i] == 1){
                    if(dist[i] != -1) continue;
                    que.add(i);
                    dist[i] = dist[p1] + 1;
                }
            }
        }



    }
    static void proc() {
        int ans=0;
        dist = new int[N + 1];

        for(int i=1; i<=N; i++){
            dist[i] = -1;
        }

        bfs(1);
        for (int i : dist) {
            if(i == 1 || i == 2) ans++;
        }
        System.out.println(ans);
    }
    public static void main(String[] args) {
        input();
        proc();
    }

}
