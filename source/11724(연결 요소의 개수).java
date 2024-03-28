import java.util.*;
import java.io.*;

public class Main{

    static int [][] arr;
    static int n;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean [] visit;
    static ArrayList<Integer>[] edges;
    static int N, M;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visit = new boolean[N+1];
        edges = new ArrayList[N+1];
        for(int i=0; i<=N; i++){
            edges[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            edges[start].add(end);
            edges[end].add(start);
        }
        int count = 0;
        for(int i=1; i<=N; i++){
            if(!visit[i]){
                visit[i] = true;
                dfs(i);
                count ++;
            }
        }
        System.out.println(count);

    }
    static void dfs(int start){
        for (int end : edges[start]) {
            if(!visit[end]){
                visit[end] = true;
                dfs(end);
            }
        }
    }
}