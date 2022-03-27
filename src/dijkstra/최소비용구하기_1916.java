package dijkstra;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 최소비용구하기_1916 {
    static Scanner sc = new Scanner(System.in);

    static class Edge{
        public int to, weight;

        public Edge(int _to, int _weigth){
            this.to = _to;
            this.weight = _weigth;
        }
    }

    static class Info{
        public int idx, dist;
        public Info(){
        }

        public Info(int _idx, int _dist) {
            this.idx = _idx;
            this.dist = _dist;
        }
    }

    static int N, M, start, end;
    static int[] dist;
    static ArrayList<Edge>[] edges;

    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        dist = new int[N + 1];
        edges = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) edges[i] = new ArrayList<Edge>();
        for (int i = 1; i <= M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();
            edges[from].add(new Edge(to, weight));
        }
        start = sc.nextInt();
        end = sc.nextInt();
    }

    static void dijkstra(int start) {
        // 모든 정점까지에 대한 거리를 최대값으로 초기화 해주기
        for (int i = 1; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        //우선순위 큐 생성
        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));

        pq.add(new Info(start, 0));
        dist[start] = 0;

        // 거리 정보들이 모두 소진될때까지 거리 갱신을 반복한다.
        while (!pq.isEmpty()) {
            Info info = pq.poll(); // 거리 정보에서 최소 거리를 선택한다.

            //꺼낸 정보가 최신 정보랑 다르면, 의미없가 없으므로 폐기
            if(dist[info.idx] < info.dist) continue;

            // 연결된 모든 간선들을 통해서 다른 정점들에 대한 정보를 갱신해준다.
            for (Edge e : edges[info.idx]) {
                if(dist[info.idx] + e.weight >= dist[e.to]) continue;

                // e.to 까지 갈 수 있는 더 짧은 거리를 찾았다면 이에 대한 정보를 갱신하고 PQ에 기록해준다.
                dist[e.to] = dist[info.idx] + e.weight;
                pq.add(new Info(e.to, dist[e.to]));
            }
        }

    }
    static void proc(){
        dijkstra(start);
        System.out.println(dist[end]);
    }

    public static void main(String[] args) {
        input();
        proc();
    }
}
