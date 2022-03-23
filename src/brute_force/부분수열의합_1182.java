package brute_force;

import java.util.Arrays;
import java.util.Scanner;

public class 부분수열의합_1182 {
    static Scanner sc = new Scanner(System.in);
    static int N,S,ans;
    static int[] nums;

    static void input() {
        N = sc.nextInt();
        S = sc.nextInt();

        nums = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            nums[i] = sc.nextInt();
        }
    }

    static void rec(int k, int value){
        if(k == N+1){
            if(value == S) ans++;
        }else{
            //k번째 변수 포함
            rec(k + 1, value + nums[k]);

            // 비포함
            rec(k + 1, value);

        }
    }

    static void proc(){
        rec(1, 0);
        if(S == 0) --ans ;

        System.out.println(ans);

    }

    public static void main(String[] args) {
        input();
        proc();
    }

}
