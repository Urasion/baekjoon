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
        for(int i=0; i<M; i++){
            arr[i] = Integer.parseInt(br.readLine());
            end = Math.max(end, arr[i]);
        }
        while(start <= end){
            int mid = (start+end)/2;
            if(check(mid) > N){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        System.out.println(start);





    }
    static int check(int mid){
        int sum = 0;
       for(int i=0; i<M; i++){
           sum += arr[i]/mid;
           if(arr[i] % mid != 0){
               sum += 1;
           }
       }
       return sum;
    }








}