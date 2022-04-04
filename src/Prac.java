import java.util.*;

public class Prac {
    static Scanner sc = new Scanner(System.in);
    static int n, m;
    static int[] A, B;

    static void input(){
        n = sc.nextInt();
        m = sc.nextInt();

        A = new int[n];
        B = new int[m];

        for(int i=0; i<n; i++){
            A[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            B[i] = sc.nextInt();
        }

    }
    static int binarySearch(int l, int r, int num){
        int result = 0; // num보다 작으면서 가장 큰 수의 갯수

        while(l <= r){
            int m = (l+r) / 2;
            if(B[m] >= num){
                r = m-1;
            }else{
                l = m+1;
                result = m+1;
            }
        }
        return result;
    }
    static void proc() {
        int ans = 0;

        Arrays.sort(B);
        int l = 0, r= B.length -1;
        for (int i = 0; i < n; i++) {
            ans += binarySearch(l,r,A[i]);
        }
        System.out.println(ans);
    }
    public static void main(String[] args) {
        int T;
        T = sc.nextInt();
        for(int i=0; i<T; i++) {
            input();
            proc();
        }

    }

}