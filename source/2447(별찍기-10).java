import java.io.*;
import java.util.*;



public class Main {
    static int N,M;
    static StringBuffer star = new StringBuffer();
    static ArrayList<Integer>[] friend;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                func(i, j, N);
            }
            star.append('\n');
        }
        System.out.println(star.toString());
    }
    static void func(int x, int y, int num){


        if((x/num)%3 == 1 && (y/num)%3 ==1){
            star.append(' ');
        }else{
            if(num==1){
                star.append('*');
            }else{
                func(x,y,num/3);
            }
        }
    }



}