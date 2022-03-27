package binarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class 먹먹_7795 {
    static Scanner sc = new Scanner(System.in);
    static int N, M;
    static int[] A, B;

    static void input(){

        N = sc.nextInt();
        M = sc.nextInt();
        A = new int[N + 1];
        B = new int[M + 1];

        for(int j = 1; j<=N; j++) A[j] = sc.nextInt();
        for(int k = 1; k<=M; k++) B[k] = sc.nextInt();

    }

    static int lower_bound(int[] B, int L, int R, int X) {
        // B배열에서 X보다 작은 수 중 제일 오른쪽 index 를 return, 없다면 return 0
        int result = 0;

        while (L <= R) {
            int mid = (L + R) / 2;
            if(B[mid] < X ){
                L = mid + 1;
                result = mid;
            }else if( B[mid] >= X){
                R = mid -1;
            }
        }
        return result;
    }
    static void proc(){
        //이분탐색 대상 배열 정렬
        Arrays.sort(B, 1, M+1);
        int ans = 0;

        //A[i]보다 작은 수가 몇개인지 count
        for( int i=1; i<=N; i++){
            ans += lower_bound(B, 1, M, A[i]);
        }
        System.out.println(ans);

    }
    public static void main(String[] args) {
        int TT;
        TT = sc.nextInt();
        for (int tt = 1; tt <= TT; tt++) {
            input();
            proc();
        }
    }
}
