package GraphSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 탈출_3055 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static String[] map;

    //해당 위치가 물에 잠길 예상 시간
    static int[][] dist_water;
    //해당 위치에 두더지가 도착할 시간
    static int[][] dist_hedgehog;

    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static void input() {
        N = sc.nextInt();
        M = sc.nextInt();
        map = new String[N];

        sc.nextLine();
        for (int i = 0; i < N; i++)
            map[i] = sc.nextLine();

        visit = new boolean[N][M];
        dist_water = new int[N][M];
        dist_hedgehog = new int[N][M];
    }

    // 모든 물들을 시작으로 동시에 BFS 시작!
    static void bfs_water() {
        Queue<Integer> que = new LinkedList<>();
        // 모든 물의 위치를 Q에 전부 넣어주기!
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // dist_water 와 visit 배열 초기화
                dist_water[i][j] = -1;
                visit[i][j] = false;

                if (map[i].charAt(j) == '*') {
                    que.add(i);
                    que.add(j);
                    dist_water[i][j] = 0;
                    visit[i][j] = true;
                }
            }
        }

        // BFS 과정 시작
        while (!que.isEmpty()) {
            int x = que.poll();
            int y = que.poll();

            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(visit[nx][ny]) continue;
                if(map[nx].charAt(ny) != '.') continue;

                visit[nx][ny] = true;
                dist_water[nx][ny] = dist_water[x][y] + 1;
                que.add(nx);
                que.add(ny);
            }
        }
    }

    // 고슴도치를 시작으로 동시에 BFS 시작!
    static void bfs_hedgehog() {
        Queue<Integer> que = new LinkedList<>();
        // 고슴도치 위치를 que에 넣어주기!
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // dist_hedgehog 와 visit 배열 초기화
                dist_hedgehog[i][j] = -1;
                visit[i][j] = false;

                if (map[i].charAt(j) == 'S') {
                    visit[i][j] = true;
                    dist_hedgehog[i][j] = 0;
                    que.add(i);
                    que.add(j);
                }
            }
        }

        // BFS 과정 시작
        while (!que.isEmpty()) {
            int x = que.poll();
            int y = que.poll();

            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue; // 지도를 벗어나는 곳인지 확인
                if(visit[nx][ny]) continue; // 이미 방문한 곳인지 확인
                if(map[nx].charAt(ny) != '.' && map[nx].charAt(ny) != 'D') continue; // 갈 수 있는 칸인지 확인
                if(dist_water[nx][ny] != -1 && dist_water[nx][ny] <= dist_hedgehog[x][y] + 1) continue; //물에 잠기지 않는 곳인지
                visit[nx][ny] = true;
                dist_hedgehog[nx][ny] = dist_hedgehog[x][y] + 1;

                que.add(nx);
                que.add(ny);
            }
        }
    }

    static void proc(){
        //각 칸마다 물에 닿는 시간 계싼하기
        bfs_water();

        //고슴도치가 물을 피해 탐색할 수 있는 공간 찾기
        bfs_hedgehog();

        //탈출구 'D' 에 대한 결과를 통해 정답 출력하기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i].charAt(j) == 'D') {
                    if(dist_hedgehog[i][j] == -1){
                        System.out.println("KAKTUS");
                    }else{
                        System.out.println(dist_hedgehog[i][j]);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        proc();
    }

}
