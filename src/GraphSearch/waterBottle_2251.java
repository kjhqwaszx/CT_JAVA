package GraphSearch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class waterBottle_2251 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static int[] Limit;
    static boolean[] possible;
    static boolean[][][] visit;

    //물통의 현재 상태와 물을 붓는 행위를 관리하는 구조체
    static class State{
        int[] bottle;

        State(int[] _bottle){
            bottle = new int[3];

            for(int i=0; i<3; i++) bottle[i] = _bottle[i];
        }

        State move(int from, int to, int[] Limit){
            // from 물통에서 to 물통으로 물을 옮긴다.
            int[] tmpBottle = new int[]{bottle[0], bottle[1], bottle[2]};

            if(bottle[from] + bottle[to] > Limit[to] ){
                tmpBottle[from] -= Limit[to] - bottle[to];
                tmpBottle[to] = Limit[to];
            }else{
                tmpBottle[from] = 0;
                tmpBottle[to] += bottle[from];
            }

            // 옮긴 후 물통의 상태 return
            return new State(tmpBottle);
        }
    }

    static void input(){
        Limit = new int[3];
        for (int i = 0; i < 3; i++) {
            Limit[i] = sc.nextInt();
        }

        visit = new boolean [205][205][205];
        // C의 물의양 중 가능한 곳, index = 물의 양
        possible = new boolean[205];
    }

    //물통 탐색 시작
    static void bfs(int b1, int b2, int b3) {
        Queue<State> que = new LinkedList<>();
        visit[b1][b2][b3] = true;
        que.add(new State(new int[]{b1,b2,b3}));

        while (!que.isEmpty()) {
            State st = que.poll();
            if(st.bottle[0] == 0) possible[st.bottle[2]] = true;
            for (int from = 0; from < 3; from++) {
                for (int to = 0; to < 3; to++) {
                    //같은 컵에는 물을 부울 수 없기 떄문에
                    if(from == to) continue;
                    State nxt = st.move(from,to,Limit);
                    if(!visit[nxt.bottle[0]][nxt.bottle[1]][nxt.bottle[2]]){
                        visit[nxt.bottle[0]][nxt.bottle[1]][nxt.bottle[2]] = true;
                        que.add(nxt);
                    }
                }
            }
        }
    }

    static void pro() {
        bfs(0, 0, Limit[2]);

        for (int i = 0; i <= Limit[2]; i++) {
            if(possible[i]) sb.append(i).append(' ');
        }

        System.out.println(sb);
    }

    public static void main(String[] args) {

        input();
        pro();
    }
}
