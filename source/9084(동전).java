import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            int N = Integer.parseInt(br.readLine());
            int[] coin = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                coin[i] = Integer.parseInt(st.nextToken());
            }
            int K = Integer.parseInt(br.readLine());
            int[] dp = new int[K+1];
            for(int i=0; i<N; i++){
                for(int j=coin[i]; j<=K; j++){
                    if(j-coin[i] == 0){
                        dp[j] = dp[j] + 1;
                    }else{
                        dp[j] = dp[j] + dp[j-coin[i]];
                    }

                }
            }
            System.out.println(dp[K]);
        }

    }
}