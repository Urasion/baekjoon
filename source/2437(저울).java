import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;




    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int sum = 0;
        for(int i=0; i<N; i++){
            if(sum + 1 < arr[i]){
                break;
            }
            sum += arr[i];
        }
        System.out.println(sum+1);



    }

}