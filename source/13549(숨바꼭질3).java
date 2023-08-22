import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int [] check;
    static int INF = 1000000;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        check = new int[100001];
        Arrays.fill(check, INF);
        check[N] = 0;
        PriorityQueue<pos> q = new PriorityQueue<>(new Comparator<pos>() {
            @Override
            public int compare(pos o1, pos o2) {
                return o1.count - o2.count;
            }
        });
        q.add(new pos(N, 0));
        while(!q.isEmpty()){
            pos now = q.poll();
            if(now.val == K){
                System.out.println(now.count);
                return;
            }
            if(check[now.val] < now.count){
                continue;
            }else{
                check[now.val] = now.count;
            }
            int next1 = now.val - 1;
            if(next1 >= 0 && next1 < 100001 && check[next1] > now.count + 1){
                q.add(new pos(next1, now.count + 1));
            }
            int next2 = now.val + 1;
            if(next2 >= 0 && next2 < 100001 && check[next2] > now.count + 1){
                q.add(new pos(next2, now.count + 1));
            }
            int next3 = now.val* 2;
            if(next3 >= 0 && next3 < 100001 && check[next3] > now.count){
                q.add(new pos(next3, now.count));
            }
        }
    }
    static class pos{
        int val, count;

        public pos(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }




}