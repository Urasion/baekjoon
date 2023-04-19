import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static long[] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new long[1000001];
        arr[0] = 0;
        arr[1] = 0;
        arr[2] = 1;
        for(int i=3; i<=n; i++){
            arr[i] = (i-1)*(arr[i-1] + arr[i-2])%1000000000;
        }
        System.out.println(arr[n]);



    }



}