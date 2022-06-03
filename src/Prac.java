import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Prac {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[][] v = {{1, 1}, {2, 2}, {1, 2}};
    //        v =
    static ArrayList<Integer> ans = new ArrayList<Integer>();
    static Map<Integer, Integer> map1 = new HashMap<Integer,Integer>();
    static Map<Integer, Integer> map2 = new HashMap<Integer,Integer>();
    static void input() throws IOException{

    }

    static void proc() throws IOException{
        for(int i=0; i<3; i++){
            if(map1.get(v[i][0]) == null){
                map1.put(v[i][0],1);
            }else{
                map1.put(v[i][0], map1.get(v[i][0])+1);
            }

            if(map2.get(v[i][1]) == null){
                map2.put(v[i][1],1);
            }else{
                map2.put(v[i][1], map2.get(v[i][1])+1);
            }
        }

        for(int i=0; i<3; i++){
            if(map1.get(v[i][0]) == 1){
                ans.add(v[i][0]);
            }

        }
    for(int i=0; i<3; i++) {
        if (map2.get(v[i][1]) == 1) {
            ans.add(v[i][1]);
        }
    }
        for(int i : ans){
            sb.append(i).append(' ');
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
//        input();
//        proc();
        Map<String,String> m = new HashMap<String,String>();
        m.put("k","0");
        m.put("l","1");
        m.get("k");
        ArrayList<String> arr = new ArrayList<>(m.values());
        for(String s3 : arr){
            System.out.println(s3);
        }
//        System.out.println(m.keySet());
//        System.out.println(m.values());
//        System.out.println(m.containsKey("k"));
    }




}

