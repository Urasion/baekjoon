import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int[] time = new int[N+1];
        int[] point = new int[N+1];
        int[][] dp = new int[N+1][T+1];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            time[i] = k;
            point[i] = s;
        }
        for(int i = 1; i<=N; i++){
            for(int j=0; j<=T; j++){
                if(time[i] > j){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-time[i]]+point[i]);
                }
            }
        }

        System.out.println(dp[N][T]);
    }

}