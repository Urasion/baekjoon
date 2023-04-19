import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int [][]map;
    static boolean [][] visited;
    static int landNum = 2;
    static int min = 10001;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == 1){
                    makeLand(i,j);

                }
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] >= 2){
                    visited = new boolean[n][n];
                    bfs(i,j);

                }
            }
        }
        System.out.println(min);
    }

    private static void bfs(int r, int c) {
       Queue<Pos> q = new LinkedList<>();
       q.add(new Pos(c,r,0));
       int current = map[r][c];
       visited[r][c] = true;
       while(!q.isEmpty()){
           Pos now = q.poll();
           for(int i=0; i<4; i++){
               int nextx = now.x + dx[i];
               int nexty = now.y + dy[i];
               int count = now.count;


               if(nextx>=0 && nextx<n && nexty>=0 && nexty<n && !visited[nexty][nextx]){
                   if(map[nexty][nextx] == 0){
                       visited[nexty][nextx] = true;
                       q.add(new Pos(nextx, nexty, count+1));
                   }
                   else if(map[nexty][nextx] != current){
                       min = Math.min(min, count);
                   }
               }
           }
       }
    }
    private static void makeLand(int r, int c){
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(c,r,0));
        visited[r][c] = true;
        while(!q.isEmpty()){
            Pos now = q.poll();
            map[now.y][now.x] = landNum;
            for(int i=0; i<4; i++){
                int nextx = now.x + dx[i];
                int nexty = now.y + dy[i];
                if(nextx>=0 && nextx<n && nexty>=0 && nexty<n && !visited[nexty][nextx]){
                    if(map[nexty][nextx] == 1){
                        visited[nexty][nextx] = true;
                        q.add(new Pos(nextx,nexty,0));
                    }
                }
            }
        }
        landNum++;
    }
    static class Pos{
        int x,y;
        int count;

        public Pos(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}