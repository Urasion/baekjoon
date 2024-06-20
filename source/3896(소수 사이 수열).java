import java.util.*;
import java.io.*;

public class Main {


    static int T;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int [] arr;
    static int max = 1299709;
    static int [] temp;


    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        arr = new int[max+1];
        for(int i=2; i<=max; i++ ){
            arr[i] = i;
        }
        for(int i=2; i<=max; i++){
            if(arr[i] == 0){
                continue;
            }
            for(int j=2*i; j<=max; j+=i){
                arr[j] = 0;
            }
        }
        int index = 0;
        temp = new int[100000];
        for(int i=2; i<=max; i++){
            if(arr[i] != 0){
                temp[index++] = arr[i];
            }
        }
        for(int i=0; i<T; i++){
            int num = Integer.parseInt(br.readLine());
            int ans = func(num);
            System.out.println(ans);
        }


    }
    static int func(int N){
        int start = 0;
        int end = 99999;
        int ans = 0;

        while(start + 1 < end){
            int mid = (start+end)/2;
            if(temp[mid] < N){
                start = mid;
            }else{
                end = mid;
            }
        }
        if(temp[start] < N && temp[start+1] > N){
            ans = temp[start+1] - temp[start];
        }

        return ans;
    }










}