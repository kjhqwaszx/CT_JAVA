package binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 듣보잡_1774 {
    static Scanner sc = new Scanner(System.in);
    static int N,M;
    static String[] A,B;
    static ArrayList<String> ans;

    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();

        A = new String[N];
        B = new String[M];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextLine();
        }
        for (int i = 0; i < M; i++) {
            B[i] = sc.nextLine();
        }
    }
    static void binarySearch(int L, int R, String name){
        while(L <= R) {
            int mid = (L + R) / 2;
            if (B[mid].equals(name)) {
                ans.add(name);
                break;
            }

            if (B[mid].compareTo(name) >= 0) R = mid - 1;
            else L = mid + 1;
        }
    }
    static void proc(){
        ans = new ArrayList<String>();
        Arrays.sort(B);
        Arrays.sort(A);

        for(String s : A){
            binarySearch(0,B.length-1, s);
        }
        System.out.println(ans.size());
        for(String s : ans) System.out.println(s);
    }

    public static void main(String[] args) {
        input();
        proc();
    }
}
