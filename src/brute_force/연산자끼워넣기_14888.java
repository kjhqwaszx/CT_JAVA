package brute_force;

import java.util.Scanner;

public class 연산자끼워넣기_14888 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int N, min, max;
    static int[] nums;
    static int[] operators; // 연산자의 개수
    static int[] order; // 연산 순서

    static void input() {
        N = sc.nextInt();
        nums = new int[N + 1];
        operators = new int[5];
        order = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            nums[i] = sc.nextInt();
        }
        for (int i = 1; i <= 4; i++) {
            operators[i] = sc.nextInt();
        }

        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

    }
    static int calculator() {
        int value = nums[1];
        for (int i = 1; i <= N - 1; i++) {
            if (order[i] == 1) {
                value = value + nums[i + 1];
            }else if (order[i] == 2) {
                value = value - nums[i + 1];
            }else if (order[i] == 3) {
                value = value * nums[i + 1];
            }else if (order[i] == 4) {
                value = value / nums[i + 1];
            }
        }
        return value;
    }
    static void rec(int k) {
        if (k == N) { // 모든 연산자가 나열됐을경우 계산 (연산자는 N-1개 이므로)
           // 배열된 연산자에 따라 계산
            int value = calculator();
            min = Math.min(min, value);
            max = Math.max(max, value);
        }else{
            //k번째 연산자 선택하기
            for (int i = 1; i <= 4; i++) {
                if (operators[i] >= 1) {
                    operators[i] --;
                    order[k] = i;
                    rec(k+1);
                    operators[i] ++;
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        rec(1);
        sb.append(max).append('\n').append(min);
        System.out.println(sb.toString());

    }

}
