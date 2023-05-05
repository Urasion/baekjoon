import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] map;
    static boolean[][][][] check;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static pos red;
    static pos blue;
    static pos out;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        check = new boolean[N][M][N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j);
                if (map[i][j] == 'R') {
                    red = new pos(j, i);
                    map[i][j] = '.';
                } else if (map[i][j] == 'B') {
                    blue = new pos(j, i);
                    map[i][j] = '.';
                } else if (map[i][j] == 'O') {
                    out = new pos(j, i);
                }
            }
        }
        Queue<state> q = new LinkedList<>();
        check[red.y][red.x][blue.y][blue.x] = true;
        q.add(new state(red, blue, 0));
        while (!q.isEmpty()) {
            state now = q.poll();
            pos now_r = now.red_state;
            pos now_b = now.blue_state;
            int now_count = now.count;
            for (int i = 0; i < 4; i++) {
                int direct_x = dx[i];
                int direct_y = dy[i];
                state next = move(now_r, now_b, direct_x, direct_y, now_count);
                if (map[next.red_state.y][next.red_state.x] == 'O' && map[next.blue_state.y][next.blue_state.x] != 'O') {
                    if (next.count > 10) {
                        System.out.println(-1);
                    } else {
                        System.out.println(next.count);
                    }
                    return;
                }
                else if(map[next.blue_state.y][next.blue_state.x] != 'O') {
                    if (check[next.red_state.y][next.red_state.x][next.blue_state.y][next.blue_state.x] == false) {
                        check[next.red_state.y][next.red_state.x][next.blue_state.y][next.blue_state.x] = true;
                        q.add(next);
                    }
                }
            }
        }
        System.out.println(-1);
    }

    static state move(pos now_r, pos now_b, int direct_x, int direct_y, int count) {
        if (direct_x == 0) {
            int nextr_y = now_r.y;
            int nextb_y = now_b.y;

            while (map[nextr_y + direct_y][now_r.x] != '#') {
                nextr_y += direct_y;
                if (map[nextr_y][now_r.x] == 'O') {
                    break;
                }
            }
            while (map[nextb_y + direct_y][now_b.x] != '#') {
                nextb_y += direct_y;
                if (map[nextb_y][now_b.x] == 'O') {
                    break;
                }
            }
            if(nextr_y == nextb_y && now_b.x == now_r.x){
                if(map[nextr_y][now_r.x] == 'O'){
                    return new state(new pos(now_r.x, nextr_y), new pos(now_b.x, nextb_y), count + 1);
                }
                else{
                    if(direct_y > 0){
                        if(now_b.y > now_r.y){
                            return new state(new pos(now_r.x, nextr_y-1), new pos(now_b.x, nextb_y), count + 1);
                        }else{
                            return new state(new pos(now_r.x, nextr_y), new pos(now_b.x, nextb_y-1), count + 1);
                        }
                    }else{
                        if(now_b.y > now_r.y){
                            return new state(new pos(now_r.x, nextr_y), new pos(now_b.x, nextb_y+1), count + 1);
                        }else{
                            return new state(new pos(now_r.x, nextr_y+1), new pos(now_b.x, nextb_y), count + 1);
                        }
                    }
                }
            }else{
                return new state(new pos(now_r.x, nextr_y), new pos(now_b.x, nextb_y), count + 1);

            }

        } else {
            int nextr_x = now_r.x;
            int nextb_x = now_b.x;
            while (map[now_r.y][nextr_x + direct_x] != '#') {
                nextr_x += direct_x;
                if (map[now_r.y][nextr_x] == 'O') {
                    break;
                }
            }
            while (map[now_b.y][nextb_x + direct_x] != '#') {
                nextb_x += direct_x;
                if (map[now_b.y][nextb_x] == 'O') {
                    break;
                }
            }
            if(nextr_x == nextb_x && now_b.y == now_r.y){
                if(map[now_r.y][nextr_x] == 'O'){
                    return new state(new pos(nextr_x, now_r.y), new pos(nextb_x, now_b.y), count + 1);
                }
                else{
                    if(direct_x > 0){
                        if(now_b.x > now_r.x){
                            return new state(new pos(nextr_x-1, now_r.y), new pos(nextb_x, now_b.y), count + 1);
                        }else{
                            return new state(new pos(nextr_x, now_r.y), new pos(nextb_x-1, now_b.y), count + 1);
                        }
                    }else{
                        if(now_b.x > now_r.x){
                            return new state(new pos(nextr_x, now_r.y), new pos(nextb_x+1, now_b.y), count + 1);
                        }else{
                            return new state(new pos(nextr_x+1, now_r.y), new pos(nextb_x, now_b.y), count + 1);
                        }
                    }
                }
            }else{
                return new state(new pos(nextr_x, now_r.y), new pos(nextb_x, now_b.y), count + 1);
            }


        }
    }
    static class pos{
        int x;
        int y;
        public pos(){}
        public pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static class state{
        pos red_state;
        pos blue_state;

        int count;

        public state(pos red_state, pos blue_state, int count) {
            this.red_state = red_state;
            this.blue_state = blue_state;
            this.count = count;
        }
    }
}
