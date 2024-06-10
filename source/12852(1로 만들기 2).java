import java.util.*;
import java.io.*;

public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int X;
    static int[] dp, stock;

    public static void main(String[] args) throws IOException {
        X = Integer.parseInt(br.readLine());
        dp = new int[X+1];
        stock = new int[X+1];
        dp[0] = dp[1] = 0;
        for(int i=2; i<=X; i++){
            dp[i] = dp[i-1]+1;
            stock[i] = i-1;
            if(i%2==0 && dp[i]>dp[i/2]+1){
                dp[i] = dp[i/2]+1;
                stock[i] = i/2;
            }
            if(i%3==0 && dp[i]>dp[i/3]+1){
                dp[i] = dp[i/3]+1;
                stock[i] = i/3;
            }
        }
        System.out.println(dp[X]);
        while (X>0){
            bw.write(X + " ");
            X = stock[X];
        }
        bw.flush();
        bw.close();
      }



}