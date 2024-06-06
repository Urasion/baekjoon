import java.util.*;
import java.io.*;

public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int [][] arr;
    static int N, K;
    static int S,X,Y;
    static Queue<Pos> q = new LinkedList<>();
    static int[] dx = {0,0,-1,1};
    static int[] dy= {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        ArrayList<Pos> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] != 0){
                    list.add(new Pos(j,i,arr[i][j],0));
                }
            }
        }
        Collections.sort(list, new Comparator<Pos>() {
            @Override
            public int compare(Pos o1, Pos o2) {
                return o1.virus - o2.virus;
            }
        });

        for(Pos pos : list){
            q.add(pos);
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        bfs();

        System.out.println(arr[X-1][Y-1]);

        
    }
    static void bfs(){
        while(!q.isEmpty()){
            Pos now = q.poll();
            int x = now.x;
            int y = now.y;
            if(now.time == S){
                return;
            }
            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                    if (arr[ny][nx] == 0) {
                        arr[ny][nx] = now.virus;
                        q.add(new Pos(nx, ny, now.virus, now.time + 1));
                    }
                }
            }
        }
    }
    static class Pos{
        int x,y,virus,time;

        public Pos(int x, int y, int virus, int time) {
            this.x = x;
            this.y = y;
            this.virus = virus;
            this.time = time;
        }
    }



}