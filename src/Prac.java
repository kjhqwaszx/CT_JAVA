import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Prac {

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static int[] Limit;
    static boolean[] possible;
    static boolean[][][] visit;

    static class State{
        int[] bottle = new int[3];

        State(int[] bottle){
            for (int i = 0; i < 3; i++) this.bottle[i] = bottle[i];
        }

        State move(int from, int to, int[] Limit){
            int[] tmpBottle = new int[]{this.bottle[0], this.bottle[1], this.bottle[2]};

            if (this.bottle[from] + this.bottle[to] > Limit[to]) {
                tmpBottle[from] -= Limit[to] - this.bottle[to];
                tmpBottle[to] = Limit[to];
            }else{
                tmpBottle[from] = 0;
                tmpBottle[to] += this.bottle[from];
            }

            return new State(tmpBottle);
        }
    }

    static void input(){
        Limit = new int[3];

        for (int i = 0; i < 3; i++) {
            Limit[i] = sc.nextInt();
        }
        possible = new boolean[201];
        visit = new boolean[201][201][201];
    }

    static void bfs(int b1, int b2, int b3){
        Queue<State> que = new LinkedList<>();
        visit[b1][b2][b3] = true;
        que.add(new State(new int[] {b1,b2,b3}));

        while (!que.isEmpty()) {
            State st = que.poll();

            if(st.bottle[0] == 0) possible[st.bottle[2]] = true;
            for (int from = 0; from < 3; from++) {
                for (int to = 0; to < 3; to++) {
                    if(from == to) continue;
                    State nSt = st.move(from,to,Limit);
                    if(!visit[nSt.bottle[0]][nSt.bottle[1]][nSt.bottle[2]]){
                        visit[nSt.bottle[0]][nSt.bottle[1]][nSt.bottle[2]] = true;
                        que.add(nSt);
                    }
                }
            }
        }
    }

    static void proc() {
        bfs(0,0,Limit[2]);

        for (int i = 0; i <= Limit[2]; i++) {
            if(possible[i]) sb.append(i).append(' ');
        }

        System.out.println(sb);

    }

    public static void main(String[] args) {
        input();
        proc();
    }

}
