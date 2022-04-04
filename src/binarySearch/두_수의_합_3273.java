package binarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class 두_수의_합_3273 {
    static Scanner sc = new Scanner(System.in);
    static int N, sum;
    static int[] num;

    static void input(){
        N = sc. nextInt();
        num = new int[N];

        for(int i=0; i<N; i++) num[i] = sc.nextInt();
        sum = sc.nextInt();
    }
    static int binarySearch(int L, int R, int n){

        while(L <= R){
            int mid = (L + R) / 2;
            if(num[mid] == sum - n) return 1;

            if(num[mid] > sum - n) R = mid -1;
            else L = mid + 1;

        }
        return 0;

    }
    static void proc(){
        int ans = 0;
        Arrays.sort(num);

        for(int n : num){
            ans += binarySearch(0,num.length-1, n);
        }
        System.out.println(ans/2);
    }

    public static void main(String[] args) {
        input();
        proc();
    }

}
