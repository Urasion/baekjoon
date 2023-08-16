import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int distance = y-x;
            if(distance < 4){
                System.out.println(distance);
                continue;
            }
            int num = (int)Math.sqrt(distance);
            int count = 2*num-1;
            int sum = (num)*(num+1);
            if(distance > sum){
                System.out.println(count + 2);
            }else if(distance > num*num){
                System.out.println(count + 1);
            }else{
                System.out.println(count);
            }
        }
    }


}