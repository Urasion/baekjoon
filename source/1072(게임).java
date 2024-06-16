import java.util.*;
import java.io.*;

public class Main {


    static long N,M,Z;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] arr, arr_sum;


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Z = M*100/N;
        long start = 1;
        long end = N;
        long ans = -1;
        while(start <= end){
            long mid = (start+end)/2;
            if(winRate(N+mid,M+mid) > Z){
                ans = mid;
                end = mid-1;
            }else{
                start = mid +1;
            }
        }
        System.out.println(ans);




    }
    static long winRate(long n, long m){
        return m*100/n;
    }







}