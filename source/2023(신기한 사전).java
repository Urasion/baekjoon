import java.util.*;
import java.io.*;

public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;

    static int number;
    static int number_l;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        number = (int) Math.pow(10, N-1);
        number_l = (int) Math.pow(10,N)-1;
        for(int i=number; i<=number_l; i++){
            if(check(i)){
                bw.write(i + "\n");
            }
        }
        bw.flush();
        bw.close();


    }
    static boolean check(int N){
        if(N < 10){
            return isPrime(N);
        }else{
            return check(N / 10) && isPrime(N);
        }
    }
    static boolean isPrime(int N){
        if(N < 2) return false;
        for(int i=2; i*i<= N; i++){
            if(N % i == 0){
                return false;
            }
        }
        return true;
    }
}