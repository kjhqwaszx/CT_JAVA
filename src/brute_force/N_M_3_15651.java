package brute_force;

import java.util.Scanner;

public class N_M_3_15651 {
    static StringBuilder sb = new StringBuilder();
    static Scanner sc = new Scanner(System.in);
    static int N,M;
    static int[] selected;


    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        selected = new int[M + 1];

    }
    static void rec(int k){
        if(k == M + 1){ // 다 골랐다

            for(int i=1; i<=M; i++){
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');

        }else{
            for (int n = 1; n <= N; n++) {
                selected[k] = n;
                rec(k + 1);
            }
        }

    }
    public static void main(String[] args) {
        input();

        rec(1);
        System.out.println(sb.toString());
    }
}
