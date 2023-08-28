import java.io.*;
import java.util.*;

public class Main {
    static int px1,py1;
    static int px2,py2;
    static int px3,py3;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        px1 = Integer.parseInt(st.nextToken());
        py1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        px2 = Integer.parseInt(st.nextToken());
        py2 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        px3 = Integer.parseInt(st.nextToken());
        py3 = Integer.parseInt(st.nextToken());
        int a = (py2 - py1)*(px3 - px1) + py1*(px2 - px1);
        int b = (px2- px1) * py3;
        if(a < b){
            System.out.println(1);
        }else if(a == b){
            System.out.println(0);
        }else{
            System.out.println(-1);
        }


    }




}