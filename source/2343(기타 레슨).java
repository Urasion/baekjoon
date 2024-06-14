import java.util.*;
import java.io.*;

public class Main {


    static int N,M;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] arr, arr_sum;


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        arr_sum = new int[N+1];
        st = new StringTokenizer(br.readLine());
        int start = 0;
        int end = 0;
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            end += arr[i];
            start = Math.max(arr[i],start);
        }

        while(start <= end){
            int mid = (start + end) / 2;
            int count = blueCount(mid);
            if(count > M){
                start = mid + 1;
            }else{
                end = mid -1;
            }

        }
        System.out.println(start);
    }
    static int blueCount(int mid){
        int sum = 0;
        int count = 0;
        for(int i=0; i<N; i++){
            if(sum + arr[i] > mid){
                sum = 0;
                count ++;
            }
            sum += arr[i];
        }
        if(sum != 0){
            count ++;
        }
        return count;
    }






}