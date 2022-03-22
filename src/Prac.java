import java.util.*;

public class Prac {
    static Scanner sc = new Scanner(System.in);
    static int min, max, N;
    static int[] calc, nums;

    static void input(){
        N = sc.nextInt();

        nums = new int[N + 1];
        calc = new int[5];

        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        for (int i = 1; i <= N; i++) {
            nums[i] = sc.nextInt();
        }
        for (int i = 1; i <= 4; i++) {
            calc[i] = sc.nextInt();
        }
    }

    static int calculator(int s, int num, int i) {
        int sum = s;
        if(i == 1) sum += num;
        else if(i == 2) sum -= num;
        else if(i ==3 ) sum *= num;
        else sum /= num;
        return sum;
    }
    static void rec(int k, int sum) {
        if (k == N ) {
            min = Math.min(sum, min);
            max = Math.max(sum, max);
        }else{
            for(int i=1; i<=4; i++){
                int s = sum;
                if(calc[i] > 0){
                    calc[i] --;
                    s = calculator(sum, nums[k+1], i);
                    rec(k + 1, s);
                    calc[i]++;
                }
            }
        }
    }
    static void proc(){
        rec(1,nums[1]);

        System.out.println(max);
        System.out.println(min);
    }

    public static void main(String[] args) {
        input();
        proc();

    }

}
