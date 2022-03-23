import java.util.Arrays;
import java.util.Scanner;

public class Prac {
    static Scanner sc = new Scanner(System.in);
    static int n, m, ans;
    static int[] nums;

    static void input(){
        n = sc.nextInt();
        m = sc.nextInt();

        nums = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            nums[i] = sc.nextInt();
        }
    }

    static void rec(int k, int s) {
        if (k == n + 1) {
            if(s == m) ans++;
        }else{
            rec(k + 1, s + nums[k]);
            rec(k + 1, s);
        }
    }

    static void proc(){
        rec(1, 0);
        if(m == 0) --ans ;

        System.out.println(ans);

    }

    public static void main(String[] args) {
        input();
        proc();
    }
}