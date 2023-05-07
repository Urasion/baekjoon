import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<road> [] arr ;
    static boolean [] check;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N+1];
        for(int i=0; i<=N; i++){
            arr[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++){
           st =  new StringTokenizer(br.readLine());
           int start = Integer.parseInt(st.nextToken());
           int end = Integer.parseInt(st.nextToken());
           int weight = Integer.parseInt(st.nextToken());
           arr[start].add(new road(end,weight));
           arr[end].add(new road(start, weight));
        }
        st = new StringTokenizer(br.readLine());
        int dest_s = Integer.parseInt(st.nextToken());
        int dest_e = Integer.parseInt(st.nextToken());
        int start = 0;
        int end = Integer.MAX_VALUE;
        int result = 0;
        while(start + 1 < end){
            int mid = (start + end) / 2;
            if(bfs(dest_s, dest_e, mid)){
                start = mid;
                result = mid;

            }else{
                end = mid;
            }
        }
        System.out.println(result);

    }
    static boolean bfs(int start, int end, int weight){
        Queue<Integer> q = new LinkedList<>();
        check = new boolean[N+1];
        q.add(start);
        check[start] = true;
        while (!q.isEmpty()){
            int now = q.poll();
            if(now == end){
                return true;
            }
            for(int i=0; i<arr[now].size(); i++){
                if(arr[now].get(i).weight >= weight && check[arr[now].get(i).next] == false){

                    q.add(arr[now].get(i).next);
                    check[arr[now].get(i).next] = true;
                }
            }
        }
        return false;
    }
    static class road{
        int next;
        int weight;

        public road(int next, int weight) {
            this.next = next;
            this.weight = weight;
        }
    }
}
