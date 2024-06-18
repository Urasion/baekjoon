import java.util.*;
import java.io.*;

public class Main {


    static int N,M;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int [] arr;


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int start = 1;
        int end = 0;
        arr = new int[M];
        st = new StringTokenizer(br.readLine());
        Arrays.sort(arr);
        for(int i=0; i<M; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            end = Math.max(end, arr[i]);
        }
        int result = 0;
        while(start <= end){
            int mid = (start+end)/2;
            if(check(mid) >= N){
                if(result < mid){
                    result = mid;
                }
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        System.out.println(result);





    }
    static int check(int mid){
        int sum = 0;
       for(int i=0; i<M; i++){
           sum += arr[i]/mid;
       }
       return sum;
    }








}