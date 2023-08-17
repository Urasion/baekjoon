import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M;
    static int robot_y, robot_x, direct;
    static int count = 0;
    static int [][] map;
    static boolean[][] trash;
    static boolean phase_end = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        trash = new boolean[N][M];
        st = new StringTokenizer(br.readLine());
        robot_y = Integer.parseInt(st.nextToken());
        robot_x = Integer.parseInt(st.nextToken());
        direct = Integer.parseInt(st.nextToken());
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while(!phase_end){
            if(trash[robot_y][robot_x] == false){
                count += 1;
                trash[robot_y][robot_x] = true;
            }
            if(check(robot_y, robot_x)){
                direct -= 1;
                if(direct == -1){
                    direct = 3;
                }
                switch (direct){
                    case 0:
                        if(map[robot_y-1][robot_x] == 0 && trash[robot_y-1][robot_x] == false){
                            robot_y -= 1;
                        }
                        break;
                    case 1:
                        if(map[robot_y][robot_x + 1] == 0 && trash[robot_y][robot_x+1] == false){
                            robot_x += 1;
                        }
                        break;
                    case 2:
                        if(map[robot_y+1][robot_x] == 0 && trash[robot_y+1][robot_x] == false){
                            robot_y += 1;
                        }
                        break;
                    case 3:
                        if(map[robot_y][robot_x - 1] == 0 && trash[robot_y][robot_x-1] == false){
                            robot_x -= 1;
                        }
                        break;
                }
            }else{
                switch (direct){
                    case 0:
                        if(map[robot_y+1][robot_x] == 0){
                            robot_y += 1;
                        }else{
                            phase_end = true;
                            break;
                        }
                        break;
                    case 1:
                        if(map[robot_y][robot_x -1] == 0){
                            robot_x -= 1;
                        }else{
                            phase_end = true;
                        }
                        break;
                    case 2:
                        if(map[robot_y-1][robot_x] == 0){
                            robot_y -= 1;
                        }else{
                            phase_end = true;
                        }
                        break;
                    case 3:
                        if(map[robot_y][robot_x + 1] == 0){
                            robot_x += 1;
                        }else{
                            phase_end = true;
                        }
                        break;
                }
            }
        }
        System.out.println(count);


    }
    static class pos{
        int y, x, direct;

        public pos(int y, int x, int direct) {
            this.y = y;
            this.x = x;
            this.direct = direct;
        }
    }
    static boolean check(int y, int x){
        if((trash[y+1][x] == false && map[y+1][x] == 0) || (trash[y-1][x] == false&& map[y-1][x] == 0) ||  (trash[y][x+1] == false&& map[y][x+1] == 0) || (trash[y][x-1] == false&& map[y][x-1] == 0)){
            return true;
        }else{
            return false;
        }
    }


}