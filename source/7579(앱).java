import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[] dp = new int[10001], memory = new int[N], cost = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            memory[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 10000; j >= cost[i]; j--) {
                dp[j] = Math.max(dp[j-cost[i]] + memory[i], dp[j]);
            }
            //System.out.println(Arrays.toString(dp)); -> 디버깅 위한 코드
        }

        for (int i = 0; i < 10001; i++) {
            if (dp[i] >= M) {
                System.out.println(i);
                return;
            }
        }


    }

}