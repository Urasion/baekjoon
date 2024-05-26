import java.util.*;
import java.io.*;

public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M;
    static String[] arr;
    static int result = -1;


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();

        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int mi = -N; mi < N; mi++) {
                    for (int mj = -M; mj < M; mj++) {
                        if (mi == 0 && mj == 0) {
                            continue;
                        }
                        int temp_i = i;
                        int temp_j = j;
                        StringBuilder sb = new StringBuilder();
                        while (temp_i >= 0 && temp_i < N && temp_j >= 0 && temp_j < M) {
                            sb.append(arr[temp_i].charAt(temp_j));
                            int num = Integer.parseInt(sb.toString());
                            if (Math.sqrt(num) % 1 == 0) {
                                result = Math.max(result, num);
                            }
                            temp_i += mi;
                            temp_j += mj;
                        }
                    }
                }
            }


        }
        System.out.println(result);
    }
}