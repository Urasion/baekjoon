import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<Long> arr = new ArrayList<>();
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if(N <= 10){
            System.out.println(N);
        }else if (N <= 1022){
            for(int i=0; i<10; i++){
                dfs(i, 1);
            }
            Collections.sort(arr);
            System.out.println(arr.get(N));

        }else{
            System.out.println(-1);
        }




    }
    static void dfs(long N, int phase){
        if(phase > 11){
            return;
        }
        arr.add(N);
       for(int i=0; i<N%10; i++){
           dfs(N*10 + i, phase + 1);
       }
    }

}