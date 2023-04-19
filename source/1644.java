import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    static ArrayList<Integer> arrs = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        eratos(n);
        for(int i=0; i<=n; i++){
            if(arr[i] == 0){
                arrs.add(i);
            }
        }
        int count = 0;
        int interval_sum = 0;
        int end = 0;
        for(int i=0; i<arrs.size(); i++){
            while (interval_sum < n  && end < arrs.size()){
                interval_sum += arrs.get(end);
                end += 1;
            }
            if(interval_sum == n){
                count += 1;
            }
            interval_sum -= arrs.get(i);
        }
        System.out.println(count);




    }
    static void eratos(int n){
        arr = new int[n+1];
        arr[0] = 1;
        arr[1] = 1;
        for(int i=2; i*i<=n; i++){
            if(arr[i] == 0){
                for(int j=i*i; j<=n; j+=i){
                    arr[j] = 1;
                }
            }
        }

    }



}