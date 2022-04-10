import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prac {
    static int T, N, sx,sy,ex, ey;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            sx = Integer.parseInt(st.nextToken());
            sy = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            ex = Integer.parseInt(st.nextToken());
            ey = Integer.parseInt(st.nextToken());
            sb.append(N).append('\n').append(sx).append(' ').append(sy).append('\n').append(ex).append(' ').append(ey).append('\n');

        }
        proc();
    }

    static void proc() {
        System.out.println(sb.toString());
    }
    public static void main(String[] args) throws IOException {
        input();
    }

}