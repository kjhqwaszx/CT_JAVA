package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class N_M_4_15652 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n,m;
    static int selected[];

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        selected = new int[m + 1];
    }

    static void rec(int k) {
        if (k == m + 1) {
            for (int i = 1; i < selected.length; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        }else{
            for (int i = 1; i <= n; i++) {
                if(i >= selected[k-1]){
                    selected[k] = i;
                    rec(k+1);
                }
            }
        }
    }

    static void proc(){
        rec(1);
        System.out.println(sb.toString());
    }
    public static void main(String[] args) throws IOException{
        input();
        proc();
    }


}
