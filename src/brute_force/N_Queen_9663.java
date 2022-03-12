package brute_force;

import java.util.Scanner;

//퀸은 행, 열, 대각선으로 이동 가능하다.
//하나의 행, 열 에는 하나의 퀸만 위치할 수 있다.

public class N_Queen_9663 {
    static Scanner sc = new Scanner(System.in);
    static int N, ans;
    static int[] col; // i번재 행의 col[i]번 열에 놓았다.

    static void input(){
        N = sc.nextInt();
        col = new int[N + 1];
    }



    static boolean attakable(int r1,int c1,int r2,int c2){
        if(c1 == c2) return true; // 같은 열이면 공격가능
        if(r1+c1 == r2+c2) return true; // 오른쪽 위(왼쪽 아래) 대각선에 위치해있다
        if(r1-c1 == r2-c2) return true; // 왼쪽 위(오른쪽 아래) 대각선에 위치해있다.
        return false;
    }

    static void rec(int row) {
        if( row == N +1){
                ans ++;
        }else{
            for (int c = 1; c <= N; c++) {
                boolean possible= true;
                for (int i = 1; i <= row - 1; i++) {
                    //(i,col[i])
                    if(attakable(row,c, i, col[i])){
                        possible= false;
                        break;
                    }
                }
                if(possible){
                    col[row] = c;
                    rec(row + 1);
                    col[row] = 0;
                }

            }
        }
    }

    public static void main(String[] args) {
        input();
        rec(1);
        System.out.println(ans);
    }
}
