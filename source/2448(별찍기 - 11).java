import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static char[][] arr;
    static StringTokenizer st;


    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N*2-1];
        for(int i=0; i<N; i++){
            Arrays.fill(arr[i], ' ');
        }
        star(N-1, 0, N);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N*2-1; j++) {
                sb.append(arr[i][j]);
            }
            sb.append('\n');
        }

        System.out.print(sb);

    }

    static void star(int x, int y, int n) {
        if (n == 3) {
            arr[y][x] = '*';
            arr[y+1][x-1] = '*';
            arr[y+1][x+1] = '*';
            arr[y+2][x-2] = '*';
            arr[y+2][x-1] = '*';
            arr[y+2][x] = '*';
            arr[y+2][x+1] = '*';
            arr[y+2][x+2] = '*';
            return;
        } else{
            int size = n / 2;
            star(x, y, size);
            star(x-size, y + size, size);
            star(x+size, y+size, size);
        }

    }
}