import java.util.*;

public class Prac {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] selected;

    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();

        selected = new int[M];
    }

    static void rec(int k){
        if(k == M){
            for (int i = 0; i < M; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        }else{
            for (int i = 1; i <= N; i++) {
                selected[k] = i;
                rec(k+1);
            }
        }

    }

    public static void main(String[] args) {
        input();
        rec(0);
        System.out.println(sb.toString());
    }

}
