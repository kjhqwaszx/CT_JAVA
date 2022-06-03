package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 연산자끼워넣기_14888_2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, min, max;
    static int[] nums;
    static int[] selected;
    static int[] calc;

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());

        nums = new int[n];
        selected = new int[n-1];// 선택한 연산자
        calc = new int[4];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            calc[i] = Integer.parseInt(st.nextToken());
        }
    }
    static void calculator(){
        int val = nums[0];
        for(int i=0; i<selected.length; i++){
            int idx = selected[i];

            if(idx == 0) val += nums[i + 1];
            else if(idx == 1) val -= nums[i + 1];
            else if(idx == 2) val *= nums[i + 1];
            else val /= nums[i + 1];
        }
        if(val > max) max = val;
        if(val < min) min = val;
    }
    static void rec(int k) {
        if(k == n){
            //연산자를 모두 선택했을 때
            calculator();
        }else{
            for(int i=0; i<4; i++){
                if(calc[i] >0){
                    calc[i] --;
                    selected[k-1] = i;
                    rec(k+1);
                    calc[i] ++;
                }
            }
        }
    }

    static void proc(){
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        rec(1);

        System.out.println(max);
        System.out.println(min);
    }
    public static void main(String[] args) throws IOException{
        input();
        proc();
    }

}
