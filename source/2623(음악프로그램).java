import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M;
    static int[] arr;
    static boolean[] visited;
    static ArrayList<Integer>[] nodes;
    static ArrayList<Integer> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        visited = new boolean[N+1];
        nodes = new ArrayList[N+1];
        for(int i=0; i<=N; i++){
            nodes[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int parent = Integer.parseInt(st.nextToken());
            for(int j=1; j<num; j++){
                int child = Integer.parseInt(st.nextToken());
                arr[child] += 1;
                nodes[parent].add(child);
                parent = child;
            }
        }
        bfs();
        if(result.size() != N){
            System.out.println(0);
        }
        else{
            for(Integer ans : result){
                System.out.println(ans);
            }
        }

    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=N; i++){
            if(arr[i] == 0){
                q.add(i);
                visited[i] = true;
            }
        }
        while(!q.isEmpty()){
            int now = q.poll();
            result.add(now);
            for (Integer num : nodes[now]) {
                arr[num] -= 1;
                if(arr[num] == 0 && !visited[num]){
                    q.add(num);
                    visited[num] = true;
                }
            }
        }


    }


}