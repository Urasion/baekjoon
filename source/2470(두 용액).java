import java.io.*;
import java.util.*;

public class Main {
    static long N;
    static long [] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        arr = new long[(int)N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        int start=0;
        int end = (int)N-1;
        int max_s = 0;
        int max_e = 0;
        long max = 2000000000;
        while(start < end){
            long total = arr[start] + arr[end];
            if(Math.abs(total) < max){
                max = Math.abs(total);
                max_s = start;
                max_e = end;
            }
            if(total < 0){
                start += 1;
            }else{
                end -= 1;
            }

        }
        System.out.println(arr[max_s] + " " + arr[max_e]);
    }
}
