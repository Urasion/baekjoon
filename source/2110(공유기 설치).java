import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int [] arr;
    static int [] range;




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        range = new int [N-1];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int start = 1;
        int result = 0;
        int end = arr[N-1] - arr[0] + 1;
        while(start + 1 < end){
            int mid = (start + end) / 2;
            if(check(mid) < M){
                end = mid;
            }else{
                start = mid;
            }
        }
        System.out.println(start);


    }
    static int check(int mid){
        int count = 1;
        int start = arr[0];
        for(int i=1; i<N; i++){
            if(arr[i] - start >= mid){
                start = arr[i];
                count += 1;
            }
        }
        return count;
    }
}
