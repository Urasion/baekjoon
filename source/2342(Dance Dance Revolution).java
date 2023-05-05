import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<Integer> arr =new ArrayList<>();
    static int[][][]dp;
    static final int INF = 987654321;



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr.add(0);
        while(true){
            int k = Integer.parseInt(st.nextToken());
            if(k == 0){
                break;
            }
            arr.add(k);
        }
        int size = arr.size();
        dp = new int [size][5][5];
        for(int i=0; i<arr.size(); i++){
            for(int j=0; j<5; j++){
                for(int k=0; k<5; k++){
                    dp[i][j][k] = INF;
                }
            }
        }
        dp[0][0][0] = 0;
        for(int i=0; i<size-1; i++){
            int next = arr.get(i+1);
            for(int left=0; left<5; left++){
                for(int right =0; right<5; right++){
                    int now = dp[i][left][right];
                    if(left != right){
                        dp[i+1][next][right] = Math.min(dp[i+1][next][right], now + calc(left, next));
                    }
                    if(next != left){
                        dp[i+1][left][next] = Math.min(dp[i+1][left][next], now + calc(right, next));
                    }
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for(int i=0; i<5 ;i++){
            for(int j=0; j<5; j++){
                result = Math.min(result, dp[size-1][i][j]);
            }
        }
        System.out.println(result);
        br.close();


    }

    static int calc(int pos, int des){
        int num = Math.abs(pos-des);
        if(pos == 0){
            return 2;
        }else if(num == 0){
            return 1;
        }else if (num ==1 | num == 3){
            return 3;
        }else{
            return 4;
        }
    }
}