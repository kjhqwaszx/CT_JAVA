import java.util.*;

public class Prac {
    static Scanner sc = new Scanner(System.in);
    static int N, M;
    static int[] map = new int[100001];
    static boolean[] visit = new boolean[100001];
    static int[] dist = new int[100001];

    static void input() {
        N = sc.nextInt();
        M = sc.nextInt();
    }

    static void bfs(int x) {
        Queue<Integer> que = new LinkedList<>();
        visit[x] = true;
        dist[x] = 0;
        que.add(x);

        while (!que.isEmpty()) {
            x = que.poll();
            if(x == M) break;

            int nx = x + 1;
            if(nx >= 0 && nx <= 100000 && !visit[nx]){
                visit[nx] = true;
                dist[nx] = dist[x] + 1;
                que.add(nx);
            }

            nx = x - 1;
            if(nx >= 0 && nx <= 100000 && !visit[nx]){
                visit[nx] = true;
                dist[nx] = dist[x] + 1;
                que.add(nx);
            }

            nx = x * 2;
            if(nx >= 0 && nx <= 100000 && !visit[nx]){
                visit[nx] = true;
                dist[nx] = dist[x] + 1;
                que.add(nx);
            }
        }
    }
    static void proc() {
        bfs(N);
        System.out.println(dist[M]);
    }
    public static void main(String[] args) {
        input();
        proc();
    }

}
