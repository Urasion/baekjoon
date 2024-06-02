import java.util.*;
import java.io.*;

public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static long N;
    public static void main(String[] args) throws IOException {
        N = Long.parseLong(br.readLine());
        int daldidalgo = 8;
        int daldidan = 2;
        int count = 0;
        while(N>1){
           N/=2;
           count++;
        }
        System.out.println(daldidalgo + count + daldidan);





    }



}