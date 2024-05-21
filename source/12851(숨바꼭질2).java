import java.util.*;
import java.io.*;

public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static long M;
    static boolean[] visited;
    static int total = 0;
    static int time = 0;


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());
        visited = new boolean[1000001];
        Queue<point> q = new LinkedList<>();
        q.add(new point(N,0));
        while(!q.isEmpty()){
            point now = q.poll();
            if(now.x == M){
                if(time == 0){
                    time = now.count;
                    total += 1;
                }else if(time == now.count){
                    total += 1;
                }
                continue;
            }
            else{
                visited[now.x] = true;
            }
            for(int i=0; i<3; i++){
                int next;
                if(i == 0){
                    next = now.x - 1;
                }else if(i == 1){
                    next = now.x + 1;
                }else{
                    next = now.x * 2;
                }
                if(next >=0 && next <= 100000 && !visited[next]){
                    q.add(new point(next, now.count + 1));
                }
            }
        }
        bw.write(time+"\n");
        bw.write(total+"\n");
        bw.flush();
        bw.close();

    }
    static class point{
        int x;
        int count;

        public point(int x, int count) {
            this.x = x;
            this.count = count;
        }
    }



}