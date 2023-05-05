import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<source> arr = new ArrayList<>();


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            arr.add(new source(p,d));
        }
        arr.sort(new Comparator<source>() {
            @Override
            public int compare(source o1, source o2) {
                if(o1.d < o2.d){
                    return -1;
                }else if(o1.d == o2.d){
                    return 0;
                }
                else{
                    return 1;
                }
            }
        });
        PriorityQueue<source> q = new PriorityQueue<>(new Comparator<source>() {
            @Override
            public int compare(source o1, source o2) {
                if(o1.p < o2.p){
                    return -1;
                }else if(o1.p == o2.p){
                    return 0;
                }
                else{
                    return 1;
                }
            }
        });
        int max_d = 0;
        for(int i=0; i<N; i++){
            if(max_d < arr.get(i).d){
                max_d = arr.get(i).d;
            }
            if(q.isEmpty()){
                q.add(arr.get(i));
            }
            else if(max_d == q.size()){
                if(q.peek().p < arr.get(i).p){
                    q.poll();
                    q.add(arr.get(i));
                }
            }else{
                q.add(arr.get(i));
            }
        }
        int sum = 0;
        while(!q.isEmpty()){
            sum += q.poll().p;
        }
        System.out.println(sum);





    }
    static class source{
        int p;
        int d;

        public source(int p, int d) {
            this.p = p;
            this.d = d;
        }
    }



}