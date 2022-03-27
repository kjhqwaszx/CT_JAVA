import java.util.*;

public class Prac {
    static Scanner sc = new Scanner(System.in);
    static int T, N, M, l, r, mid ;
    static int[] A, B, ans;

    static void input(){
        T = sc.nextInt();
        ans = new int[T + 1];
        for(int i =1; i<=T ; i++){
            N = sc.nextInt();
            M = sc.nextInt();
            A = new int[N + 1];
            B = new int[M + 1];
            for(int j = 1; j<=N; j++) A[j] = sc.nextInt();
            for(int k = 1; k<=M; k++) B[k] = sc.nextInt();

            Arrays.sort(B, 1, M+1);

            proc(i);
        }

        for (int i = 1; i <= T; i++) {
            System.out.println(ans[i]);
        }
    }
    static void proc(int t) {
        int ans = 0;
        for (int s : A) {
            l = 1;
            r = B.length - 1;
            mid = (l + r) / 2;
            int idx = 0; // 찾으려는 값 바로 직전의 idx ( 작은 수의 개수 )

            while (r >= l) {
                if (B[mid] < s) {
                    l = mid + 1;
                    idx = mid;
                } else if (B[mid] >= s) {
                    r = mid - 1;
                }
                mid = (l + r) / 2;

            }

            ans+= idx;
        }
        System.out.println(ans);
    }
    public static void main(String[] args) {
        input();

    }

}