import java.util.*;

public class Prac {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int a,b,c;
    static boolean[][][] visit;
    static ArrayList<Integer> ans = new ArrayList<>();

    public static void main(String[] args) {
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        Queue<int[]> que = new LinkedList<>();

        visit = new boolean[a + 1][b + 1][c + 1];

        que.add(new int[]{0, 0, c});

        while (!que.isEmpty()) {
            int[] tmp = que.poll();

            //이미 확인한 물의 용량
            if(visit[tmp[0]][tmp[1]][tmp[2]]) continue;
            visit[tmp[0]][tmp[1]][tmp[2]] = true;

            //A의 물의양이 0 일경우 C의 양 저장
            if(tmp[0] == 0) ans.add(tmp[2]);

            //A와 B 물통 붓기
            if(tmp[0] + tmp[1] > b){
                que.add(new int[]{tmp[0] - (b - tmp[1]), b, tmp[2]});
            }else{
                que.add(new int[]{0, tmp[0] + tmp[1], tmp[2]});
            }

            if (tmp[0] + tmp[1] > a) {
                que.add(new int[]{a, tmp[1] - (a - tmp[0]), tmp[2]});
            }else{
                que.add(new int[]{tmp[0] + tmp[1], 0, tmp[2]});
            }

            //B와 C 물통 붓기
            if (tmp[1] + tmp[2] > c) {
                que.add(new int[]{tmp[0], tmp[1] - (c - tmp[2]), c});
            }else{
                que.add(new int[]{tmp[0], 0, tmp[1] + tmp[2]});
            }

            if (tmp[1] + tmp[2] > b) {
                que.add(new int[]{tmp[0], b, tmp[2] - (b - tmp[1])});
            }else{
                que.add(new int[]{tmp[0], tmp[1] + tmp[2], 0});
            }

            //A와 C 물통 붓기
            if (tmp[0] + tmp[2] > c) {
                que.add(new int[]{tmp[0] - (c - tmp[2]), tmp[1], c});
            }else{
                que.add(new int[]{0, tmp[1], tmp[0] + tmp[2]});
            }

            if (tmp[0] + tmp[2] > a) {
                que.add(new int[]{a, tmp[1], tmp[2] - (a - tmp[0])});
            }else{
                que.add(new int[]{tmp[0] + tmp[2], tmp[1], 0});
            }
        }
        Collections.sort(ans);
        for (int cnt : ans) {
            sb.append(cnt).append(' ');
        }
        System.out.println(sb);

    }



}
