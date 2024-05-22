import java.util.*;
import java.io.*;

public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int[] parent;
    static boolean[] check;
    static ArrayList<Integer>[] arr;



    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new ArrayList[N+1];
        check = new boolean[N+1];
        for(int i=0; i<N+1; i++){
            arr[i] = new ArrayList<>();
        }

        parent = new int[N+1];
        check[1] = true;
        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while(!q.isEmpty()){
            int now = q.poll();
            for(int i=0; i<arr[now].size(); i++){
                int next = arr[now].get(i);
                if(!check[next]){
                    check[next] = true;
                    parent[next] = now;
                    q.add(next);
                }
            }
        }
        for(int i=2; i<=N; i++){
            System.out.println(parent[i]);
        }





    }
}