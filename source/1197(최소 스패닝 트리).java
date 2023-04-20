import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,E;
    static edge[] edges;
    static ArrayList<edge> mst = new ArrayList<>();
    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        edges = new edge[E];
        parent = new int[N+1];
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            edges[i] = new edge(start, end, value);
        }
        for(int i=1; i<=N; i++){
            parent[i] = i;
        }
        Arrays.sort(edges, new Comparator<edge>() {
            @Override
            public int compare(edge o1, edge o2) {
                return o1.value - o2.value;
            }
        });
        func();
        int sum = 0;
        for(int i=0; i<mst.size(); i++){
            sum += mst.get(i).value;
        }
        System.out.println(sum);


    }
    static void func(){
        for(int i=0; i<E; i++){
            edge current = edges[i];
            int start = current.start;
            int end = current.end;
            if(find_root(start) == find_root(end)){
                continue;
            }
            mst.add(current);
            union_root(start, end);
            if(mst.size() == N){
                return;
            }


        }

    }
    static void union_root(int x, int y){
        int a = find_root(x);
        int b = find_root(y);
        if(a == b){
            return;
        }
        if(a > b){
            parent[b] = a;
            return;
        }
        parent[a] = b;
    }
    static int find_root(int x){
        if(parent[x] == x){
            return x;
        }
        return parent[x] = find_root(parent[x]);
    }
    static class edge{
        int start,end,value;

        public edge(int front, int end, int value) {
            this.start = front;
            this.end = end;
            this.value = value;
        }
    }




}