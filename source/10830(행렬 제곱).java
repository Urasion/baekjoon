import java.util.*;
import java.io.*;

public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static long M;
    static int [][] arr;


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());
        arr = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }
        int[][] result = div_con(arr, M);
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                bw.write(result[i][j] + " ");
            }
            bw.write('\n');
        }
        bw.flush();
        bw.close();
    }
    static int[][] div_con(int[][]a, Long M){
        if(M == 1L){
            return a;
        }
        int [][] result = div_con(a, M/2);
        result = calc(result, result);
        if(M % 2 == 1){
            result = calc(result, arr);
        }
        return result;
    }
    static int[][] calc(int [][] arr1, int [][] arr2){
        int[][] temp = new int[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<N; k++){
                    temp[i][j] += arr1[i][k]*arr2[k][j];
                    temp[i][j] %= 1000;
                }

            }
        }
        return temp;
    }


}