import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Prac {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String str;
    static String word;
    static int ans, idx;

    static void input() throws IOException{
        str = br.readLine();
        word = br.readLine();
    }

    static void rec(String s){
        idx = s.indexOf(word);

        if(idx < 0){

        }else{
            ans++;
            rec(s.substring(idx+word.length()));
        }

    }
    static void proc() throws IOException{
        rec(str);
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        String str = "s!@s";
        ArrayList<String> tmp = new ArrayList<String>(Arrays.asList(str.split("")));
        System.out.println(str.contains("6"));
//        input();
//        proc();

    }



}

