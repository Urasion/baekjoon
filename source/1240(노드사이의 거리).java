import java.util.*;
import java.io.*;

public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M;
    static ArrayList<node>[] arr;




    public static void main(String[] args) throws IOException {
      st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      arr = new ArrayList[N+1];
      for(int i=0; i<N+1; i++){
          arr[i] = new ArrayList<>();
      }
      for(int i=0; i<N-1; i++){
          st = new StringTokenizer(br.readLine());
          int a = Integer.parseInt(st.nextToken());
          int b = Integer.parseInt(st.nextToken());
          int c = Integer.parseInt(st.nextToken());
          arr[a].add(new node(b,c));
          arr[b].add(new node(a,c));
      }
      for(int i=0; i<M; i++){
          st = new StringTokenizer(br.readLine());
          int a = Integer.parseInt(st.nextToken());
          int b = Integer.parseInt(st.nextToken());
          System.out.println(bfs(a,b));
      }
    }
    static int bfs(int x, int y){
        Queue<node> q = new LinkedList<>();
        boolean [] check = new boolean[N+1];
        check[x] = true;
        q.add(new node(x,0));
        while(!q.isEmpty()){
            node now = q.poll();
            if(now.num == y){
                return now.len;
            }
            for(int i=0; i<arr[now.num].size(); i++){
                if(!check[arr[now.num].get(i).num]){
                    check[arr[now.num].get(i).num] = true;
                    q.add(new node(arr[now.num].get(i).num, now.len + arr[now.num].get(i).len));
                }
            }
        }
        return 0;
    }
    static class node{
        int num, len;

        public node(int num, int len) {
            this.num = num;
            this.len = len;
        }
    }
}