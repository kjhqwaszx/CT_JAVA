import java.util.*;

public class DFS_BFS {
    static Scanner s = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static int N, M, V; // N: 정점의 수, M: 간선의 수, V: 시작정점
    static ArrayList<Integer>[] adj;
    static boolean[] visit;

    static void input(){
        N = s.nextInt();
        M = s.nextInt();
        V = s.nextInt();

        adj = new ArrayList[N+1];

        //인접 리스트 초기화
        for(int i=1; i<=N; i++){
            adj[i] = new ArrayList<Integer>();
        }

        // 인접행렬 입력
        for(int i=1; i<=M; i++){
            int x = s.nextInt(), y = s.nextInt(); // x에서 y를 갈 수 있다.
            adj[x].add(y);
            adj[y].add(x);
        }

        // 단, 방문할 수 있는 정점중 작은 숫자먼저 방문 조건이 있기 때문에 정렬하고 시작
        for(int i=1; i <= N; i++){
            Collections.sort(adj[i]);
        }
    }
    // x 를 갈 수 있다는 걸 알고 방문한 상태
    static void dfs(int x){
        visit[x] = true;
        sb.append(x).append(' ');

        for(int y: adj[x]){
            if(visit[y]) continue;
            visit[y] = true;
            dfs(y);
        }
    }

    static void bfs(int x){
        Queue<Integer> que = new LinkedList<>();
        que.add(x);
        visit[x] = true;

        while(!que.isEmpty()){
            x = que.poll();
            sb.append(x).append(' ');
            for(int y : adj[x]){
                if(visit[y]) continue;
                que.add(y);
                visit[y] = true; // 방문 가능하다는 것을 체크
            }
        }
    }
    static void pro(){
        visit = new boolean[N+1];
        dfs(V);
        sb.append('\n');
        for(int i=1; i<=N; i++) visit[i] = false;
        bfs(V);
        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
