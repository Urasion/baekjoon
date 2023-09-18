import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] time, price;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        time = new int[N+2];
        price = new int[N+2];
        dp = new int[N+2];
        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<2; j++){
                if(j==0){
                    time[i] = Integer.parseInt(st.nextToken());
                }else{
                    price[i] = Integer.parseInt(st.nextToken());
                }
            }
        }
        for(int i=1; i<=N; i++){
            if(i + time[i] <= N+1){
                dp[i + time[i]] = Math.max(dp[i + time[i]], dp[i] + price[i]);
            }
            dp[i+1] = Math.max(dp[i], dp[i+1]);
        }
        System.out.println(dp[N+1]);

    }
}