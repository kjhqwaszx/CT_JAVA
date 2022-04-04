package binarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class 수찾기_1920 {
    static Scanner sc = new Scanner(System.in);
    static int N,M;
    static int[] A,B;

    static void input(){
        N = sc.nextInt();
        A = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = sc.nextInt();
        }

        M = sc.nextInt();
        B = new int[M + 1];

        for (int i = 1; i <= M; i++) {
            B[i] = sc.nextInt();
        }

    }
    static void binarySearch(int L, int R, int num){
        boolean isNum = false;
        while(L <= R){
            int mid = (L + R) / 2;

            if(A[mid] >= num ){
                R = mid -1;
                if(A[mid] == num){
                    isNum = true;
                }
            }else{
                L = mid + 1;
            }
        }

        if(isNum){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }

    static void proc(){
        //이진 탐색은 정렬된 배열에서 사용.
        Arrays.sort(A,1, A.length);

        for (int i = 1; i <= M; i++) {
            binarySearch(1,A.length-1, B[i]);
        }
    }

    public static void main(String[] args) {
        input();
        proc();
    }
}
