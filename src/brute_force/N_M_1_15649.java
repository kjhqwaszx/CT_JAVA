package brute_force;

import java.util.Scanner;

public class N_M_1_15649 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static int N,M;
    static int[] selected;
    static boolean[] visit;

    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();

        selected = new int[M + 1];
        visit = new boolean[N + 1];
    }
    static void rec(int k) {
        if (k == M + 1) {
            for (int i = 1; i <= M; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        }else{
            for (int n = 1; n <= N; n++) {
                if(!visit[n]){
                    selected[k] = n;
                    visit[n] = true;
                    rec(k + 1);
                    visit[n] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        rec(1);
        System.out.println(sb.toString());
    }

}
