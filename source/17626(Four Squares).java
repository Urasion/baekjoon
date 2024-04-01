import java.util.*;
import java.io.*;

public class Main{

    static int N, count;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int [] arr;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[1] = 1;
        for(int i=2; i<=N; i++){
            for(int j=1; j<=i; j++){
                if(j*j > N){
                    break;
                }
                if(j*j == i){
                    arr[i] = 1;
                 }else if(i > j*j){
                    arr[i] = Math.min(arr[i],arr[i-j*j] + arr[j*j]);
                }
            }
        }
        System.out.println(arr[N]);

    }




}