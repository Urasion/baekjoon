import java.sql.SQLOutput;
import java.util.*;
import java.io.*;

public class Main{

    static int N,M;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static HashMap<String, String> map = new HashMap<>();
    static String [] arr;
    static boolean[][] check;
    static int count = 0;
    static int []dx = {1,0,-1,0};
    static int []dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
       st = new StringTokenizer(br.readLine());
       N = Integer.parseInt(st.nextToken());
       M = Integer.parseInt(st.nextToken());
       arr = new String[N];
       for(int i=0; i<N; i++){
           arr[i] = br.readLine();
       }
       check = new boolean[N][M];
       Queue<point> q = new LinkedList<>();
        for (int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[i].length(); j++){
                if(arr[i].charAt(j) == 'I'){
                    q.add(new point(j,i));
                    check[i][j] = true;
                }
            }
        }
        while(!q.isEmpty()){
            point now = q.poll();
            if(arr[now.y].charAt(now.x) == 'P'){
                count ++;
            }
            for(int i=0; i<4; i++){
                int next_x = now.x + dx[i];
                int next_y = now.y + dy[i];
                if(next_y >=0 && next_y < N && next_x >= 0 && next_x < M){
                    if(!check[next_y][next_x] && arr[next_y].charAt(next_x) != 'X'){
                        check[next_y][next_x] = true;
                        q.add(new point(next_x, next_y));
                    }
                }
            }
        }
        if(count != 0){
            System.out.println(count);
        }
        else{
            System.out.println("TT");
        }


    }
    static class point{
        int x, y;

        public point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }




}