import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int t, n;
    static pos[] store;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] check;
    public static void main(String args[]) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        while(t > 0){
            n = Integer.parseInt(br.readLine());
            store = new pos[n+2];
            graph = new ArrayList<>();
            for(int i=0; i<n+2; i++){
                graph.add(new ArrayList<>());
            }
            for(int i=0; i<n+2; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                store[i] = new pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            for(int i=0; i<n+2; i++){
                for(int j=i+1; j<n+2; j++){
                    if(Manhattan(store[i], store[j]) <= 1000){
                        graph.get(i).add(j);
                        graph.get(j).add(i);
                    }
                }
            }
            Queue<Integer> q = new LinkedList<>();
            q.add(0);
            check = new boolean[n+2];
            check[0] = true;
            boolean flag = false;
            while(!q.isEmpty()){
                int now = q.poll();
                if(now == n+1){
                    System.out.println("happy");
                    flag = true;
                }
                for(int i=0; i<graph.get(now).size(); i++){

                    if(check[graph.get(now).get(i)] == false){
                        q.add(graph.get(now).get(i));
                        check[graph.get(now).get(i)] = true;
                    }
                }
            }
            if(!flag){
                System.out.println("sad");
            }
            t -= 1;

        }

    }
    static class pos{
        int x, y;

        public pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static int Manhattan(pos p1, pos p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }
}