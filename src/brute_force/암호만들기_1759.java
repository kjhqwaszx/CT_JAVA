package brute_force;

import java.util.Arrays;
import java.util.Scanner;

public class 암호만들기_1759 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static int L,C;
    static boolean[] ch;
    static char[] chars;


    static void input(){
        L = sc.nextInt();
        C = sc.nextInt();
        chars = new char[C];
        ch = new boolean[C];
        sc.nextLine();
        String[] tokens = sc.nextLine().split(" ");

        for (int i = 0; i < C; i++) {
            chars[i] = tokens[i].charAt(0);
        }

        Arrays.sort(chars);

    }
    static boolean isPossible(){
        int vowelCnt = 0;
        int consonantCnt = 0;
        for (int i = 0; i < C; i++) {
            if(ch[i]){
                char ch = chars[i];
                if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') vowelCnt ++;
                else consonantCnt ++;
            }
        }
        if(vowelCnt >=1 && consonantCnt >=2) return true;
        else return false;
    }

    static void rec(int start, int cnt){
        if (cnt == L) {
            boolean pos = false;
            pos = isPossible();
            if (pos) {
                for (int i = 0; i < C; i++) {
                    if(ch[i]) sb.append(chars[i]);
                }
                sb.append('\n');
            }
        }else{
            for (int i = start; i < C; i++) {

                ch[i]= true;
                rec(i + 1, cnt + 1);
                ch[i]= false;

            }
        }
    }

    static void proc(){
        rec(0,0);

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        input();
        proc();
    }
}
