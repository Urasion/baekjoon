import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


public class Main {
    static int N, ans;
    static int[][] arr;
    static int [][]map;




    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr= new int[N][N];
        map = new int[N][N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ans = 0;
        dfs(1,0,0);
        System.out.println(ans);



    }
    public static void dfs(int x, int y, int direction){
        if(x == N-1&& y ==N-1){
            ans++;
            return;
        }
        switch (direction){
            case 0:
                if (x + 1 < N && map[y][x + 1] == 0) {
                    dfs(x + 1, y, 0);
                }
                break;
            case 1:
                if (y + 1 < N && map[y + 1][x] == 0) {
                    dfs(x, y + 1, 1);
                }
                break;
            case 2:
                if (x + 1 < N && map[y][x + 1] == 0) {
                    dfs(x + 1, y, 0);
                }
                if (y + 1 < N && map[y + 1][x] == 0) {
                    dfs(x, y + 1, 1);
                }
                break;
        }
        if(y+1 < N && x+1 < N && map[y][x + 1] == 0 && map[y + 1][x] == 0 && map[y + 1][x + 1] == 0){
            dfs(x+1, y+1 ,2);
        }
    }



}