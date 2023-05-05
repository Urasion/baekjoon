import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int []dx_x = {1, 1, 0, 0, 0, 0, -1, -1, -2};
    static int[]dx_y = {-1, 1, -2, -1, 1, 2, -1, 1, 0};
    static int[]per_x = {1, 1, 2, 7, 7, 2, 10, 10, 5};

    static int []dy_x = {-1, 1, -2, -1, 1, 2, -1, 1, 0};
    static int []dy_y = {-1, -1, 0, 0, 0, 0, 1, 1,  2};
    static int[]per_y = {1, 1, 2, 7, 7, 2, 10, 10, 5};
    static int[][] map;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int direction = -1;
        int x = N/2;
        int y = N/2;
        int num = 1;
        map = new int[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int sum = 0;
        while (true) {
            for (int i = 0; i < num; i++) {
                if(i == N-1){
                    break;
                }
                x += direction;
                sum += calc_x(x,y,direction);
            }
            if(direction == -1 && num == N){
                break;
            }
            for(int i=0; i<num; i++){
                y += direction*(-1);
                sum += calc_y(x,y,direction*(-1));
            }
            num++;
            direction *= -1;

        }
        System.out.println(sum);

    }
    static int calc_y(int x, int y , int direction){
        int sum = 0;
        int sand = map[y][x];
        map[y][x] = 0;
        int spread = 0;
        for(int i=0; i<9; i++){
            int next_x = x + (dy_x[i] * direction);
            int next_y = y + (dy_y[i]* direction);
            int sandAmount = (sand * per_y[i]) /100;
            if(next_y >= N || next_y < 0 || next_x >= N || next_x < 0){
                sum += sandAmount;
            }else{
                map[next_y][next_x] += sandAmount;
            }
            spread += sandAmount;
        }
        int alpha = sand - spread;
        if(y+direction <0 || y+direction >= N){
            sum += alpha;
        }else{
            map[y+direction][x] += alpha;
        }


        return sum;

    }
    static int calc_x(int x, int y , int direction){
        int sum = 0;
        int sand = map[y][x];
        map[y][x] = 0;
        int spread = 0;
        for(int i=0; i<9; i++){
            int next_x = x + (dx_x[i]* direction * (-1));
            int next_y = y + (dx_y[i]* direction * (-1));
            int sandAmount = (sand * per_x[i]) /100;
            if(next_y >= N || next_y < 0 || next_x >= N || next_x < 0){
                sum += sandAmount;
            }else{
                map[next_y][next_x] += sandAmount;
            }
            spread += sandAmount;
        }
        int alpha = sand - spread;

        if(x+direction < 0 || x+direction >= N){
            sum += alpha;
        }else{
            map[y][x+direction] += alpha;
        }
        return sum;
    }
}
