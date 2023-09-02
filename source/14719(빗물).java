import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int h,w, ans;

    static int[] arr;



    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        arr= new int[w];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<w; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<w; i++){
            int left = 0;
            int right =0;
            for(int j=0; j<i; j++){
                left = Math.max(arr[j], left);
            }
            for(int j=i+1; j<w; j++){
                right = Math.max(arr[j], right);
            }
            if(arr[i] < left && arr[i] < right) {
                ans += Math.min(left,right) - arr[i];
            }

        }
        System.out.println(ans);

    }

}
