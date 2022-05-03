package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class snake {
    static int n, d=0;
    static int[][] board;
    static Map<Integer, String> moveInfo;
    static int[] dirx = {0, 1, 0, -1}; //우 하 좌 상
    static int[] diry = {1, 0, -1, 0};
    static List<int[]> snake;
    public static void main(String[] args) throws IOException {
        // 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n+1][n+1];
        int k = Integer.parseInt(br.readLine());
        for(int i = 0; i< k; i++){
            String[] apple = br.readLine().split(" ");
            // 사과의 경우 1로 저장
            board[Integer.parseInt(apple[0])][Integer.parseInt(apple[1])] = 1;
        }
        int l = Integer.parseInt(br.readLine());
        moveInfo = new HashMap<>();
        for(int i = 0; i<l; i++){
            String[] move = br.readLine().split(" ");
            moveInfo.put(Integer.parseInt(move[0]), move[1]);
        }

        solve();
    }

    static void solve() {
        snake = new LinkedList<>();
        int cx = 1;
        int cy = 1;
        snake.add(new int[] {cx, cy});
        int nx, ny;
        int time = 0;
        while(!snake.isEmpty()){
            nx = cx + dirx[d];
            ny = cy + diry[d];
            time++;

            if (isFinished(nx, ny)) break;

            snake.add(new int[] {nx, ny});
            // 사과가 있으면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않는다.
            if (board[nx][ny] == 1){
                board[nx][ny] = 0;
            }
            // 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다. 즉, 몸길이는 변하지 않는다.
            else {
                snake.remove(0);
            }

            //방향 전환
            if (moveInfo.containsKey(time)){
                String dir = moveInfo.get(time);
                if (dir.equals("L")){
                    d -= 1;
                    if (d < 0) d = 3;
                }
                else {
                    d += 1;
                    if (d > 3) d = 0;
                }
            }
            cx = nx;
            cy = ny;
        }
        System.out.println(time);
    }

    static boolean isFinished(int nx, int ny) {
        //벽에 부딪힘
        if (nx < 1 || ny < 1 || nx > n || ny > n) {
            return true;
        }
        //자기자신과 부딪힘
        for(int i=0; i<snake.size(); i++){
            if(nx == snake.get(i)[0] && ny == snake.get(i)[1])
                return true;
        }
        return false;
    }
}
