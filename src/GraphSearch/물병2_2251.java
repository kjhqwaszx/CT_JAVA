package GraphSearch;

import java.util.*;

public class 물병2_2251 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int a,b,c;
    static boolean visit[][][];

    public static void main(String[] args) {
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();

        visit = new boolean[a + 1][b + 1][c + 1];

        ArrayList<int[]> list = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] {0,0,c});

        while (!que.isEmpty()) {
            int[] tmp = que.poll();

            //확인했던 용량이면 패스
            if(visit[tmp[0]][tmp[1]][tmp[2]]) continue;

            //확인했던 용량이 아니면 체크하고
            visit[tmp[0]][tmp[1]][tmp[2]] = true;

            //만약 a 물통이 비어있으면 ans에 c의 물의양 추가
            if(tmp[0]==0) ans.add(tmp[2]);

            //a물통 b에 붓기
            if(tmp[0]+tmp[1] > b){
                // a+b의 양이 b의 최대양 보다 클경우
                que.add(new int[] {tmp[0]+tmp[1]-b, b, tmp[2]});
            }else{
                que.add(new int[] {0,tmp[0]+tmp[1],tmp[2]});
            }
            //b물통 a에 붓기
            if(tmp[0] + tmp[1] > a){
                //a+b의 양이 a의 최대양보다 클경우
                que.add(new int[]{a,tmp[0]+tmp[1]-a,tmp[2]});
            }else {
                que.add(new int[]{tmp[0]+tmp[1],0,tmp[2]});
            }

            //a물통 c에 붓기
            if (tmp[0] + tmp[2] > c) { // 합이 c보다 크면, c 다 채우고 나머지 a
                que.add(new int[] { tmp[0] + tmp[2] - c, tmp[1], c });
            } else { // 합이 c보다 작으면, 전부 c로 옮기기
                que.add(new int[] { 0, tmp[1], tmp[0] + tmp[2] });
            }
            //c물통 a에 붓기
            if (tmp[0] + tmp[2] > a) { // 합이 a보다 크면, a 다 채우고 나머지 c
                que.add(new int[] { a, tmp[1], tmp[0] + tmp[2] - a });
            } else { // 합이 a보다 작으면, 전부 a로 옮기기
                que.add(new int[] { tmp[0] + tmp[2], tmp[1], 0 });
            }

            //b물통 c에 붓기
            if (tmp[1] + tmp[2] > c) { // 합이 c보다 크면, c 다 채우고 나머지 b
                que.add(new int[] { tmp[0], tmp[1] + tmp[2] - c, c });
            } else { // 합이 c보다 작으면, 전부 c로 옮기기
                que.add(new int[] { tmp[0], 0, tmp[1] + tmp[2] });
            }
            //c물통 b에 붓기
            if (tmp[1] + tmp[2] > b) { // 합이 b보다 크면, b 다 채우고 나머지 c
                que.add(new int[] { tmp[0], b, tmp[1] + tmp[2] - b });
            } else { // 합이 b보다 작으면, 전부 b로 옮기기
                que.add(new int[] { tmp[0], tmp[1] + tmp[2], 0 });
            }

        }
        Collections.sort(ans);
        for (int i = 0; i < ans.size(); i++) {
            sb.append(ans.get(i)).append(' ');
        }
        System.out.println(sb);
    }
}
