import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static Stack<Integer> tower = new Stack<>();
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N+1];
        PriorityQueue<pos> q = new PriorityQueue<>(new Comparator<pos>() {
            @Override
            public int compare(pos o1, pos o2) {
                return o1.val - o2.val;
            }
        });
        for(int i=0; i<N ; i++){
            tower.add(Integer.parseInt(st.nextToken()));
        }
        for(int i=N ; i >= 1; i--){
            int next = tower.pop();
            if(!q.isEmpty()){
                while(!q.isEmpty() && q.peek().val < next){
                    pos p = q.poll();
                    arr[p.index-1] = i;

                }
            }
            q.add(new pos(next, i));
        }

        for(int i=0; i<N; i++) {
            bw.write(String.valueOf(arr[i]));
            bw.write(" ");
        }
        bw.flush();


    }
    static class pos{
        int val, index;

        public pos(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }



}