import java.io.*;
import java.util.*;

public class Main {
    static int N;

    static temp[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new temp[N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr[i] = new temp(d,w);
        }
        Arrays.sort(arr, new Comparator<temp>() {
            @Override
            public int compare(temp o1, temp o2) {
                if(o1.d < o2.d){
                    return -1;
                }else{
                    return 1;
                }
            }
        });
        PriorityQueue<temp> q = new PriorityQueue<>(new Comparator<temp>() {
            @Override
            public int compare(temp o1, temp o2) {
                if(o1.w < o2.w){
                    return -1;
                }
                else if(o1.w == o2.w){
                    if(o1.d < o2.d){
                        return 1;
                    }else{
                        return -1;
                    }
                }
                else{
                    return 1;
                }
            }
        });
        int max = 0;
        for(int i=0; i<N; i++){
            temp t = arr[i];
            max = Math.max(t.d, max);
            if(!q.isEmpty() && q.size() ==  max){
                temp front = q.poll();
                if(front.w < t.w){
                    q.add(t);
                }else{
                    q.add(front);
                }
            }else{
                q.add(t);
            }
        }
        int sum = 0;
        while(!q.isEmpty()){
            temp result = q.poll();
            sum += result.w;
        }
        System.out.println(sum);



    }
    static class temp{
        int d;
        int w;

        public temp(int d, int w) {
            this.d = d;
            this.w = w;
        }
    }
}