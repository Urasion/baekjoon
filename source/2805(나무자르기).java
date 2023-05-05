import java.io.*;
import java.util.*;

public class Main {
    static long N;
    static long M;
    static long [] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        M = Long.parseLong(st.nextToken());
        arr = new long[(int)N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long start = 0;
        long end = 2000000000;
        while(start + 1 < end){
            long mid = (start+end)/2;
            if(check(mid)){
                start = mid;
            }else{
                end = mid;
            }
        }
        System.out.println(start);
    }
    static boolean check(long mid){
        long sum =0;
        for(int i=0; i<N; i++){
            if(arr[i] > mid){
                sum += arr[i] - mid;
            }
        }
        return sum >= M;
    }
}
