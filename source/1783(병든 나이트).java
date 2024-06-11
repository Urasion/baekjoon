import java.util.*;
import java.io.*;

public class Main {


    static int N,M;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;


    public static void main(String[] args) throws IOException {
        int ans = 0;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        if(N==1){
            ans = 1;
        }
        else if(N==2){
            ans = Math.min(4, (M+1)/2);
        }
        else if(M >= 7){
            ans = M-2;
        }else{
            ans = Math.min(4,M);
        }
        System.out.println(ans);



    }




}