import java.util.*;
import java.io.*;

public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, K;
    static int[] arr;
    static boolean [] robot;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        robot = new boolean[N+1];
        arr = new int[2*N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=2*N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int count = 0;
        while(true){
            circle();
            move();
            robotOn();
            count += 1;
            if(!check()){
                break;
            }


        }
        System.out.println(count);




    }
    static void circle(){
        arr[0] = arr[2*N];
        for(int i=2*N; i>=1; i--){
            arr[i] = arr[i-1];
        }
        for(int i=N; i>=1; i--){
            robot[i] = robot[i-1];
        }
        robot[N] = false;

    }
    static void move(){
        for(int i=N-1; i>=1; i--){
            if(arr[i+1] >= 1 && !robot[i+1] && robot[i]){
                robot[i+1] = true;
                robot[i] = false;
                arr[i+1] -= 1;
                if (robot[N]){
                    robot[N] = false;
                }
            }
        }
    }
    static void robotOn(){
        if(arr[1] >= 1 && !robot[1]){
            robot[1] = true;
            arr[1] -= 1;
        }
    }
    static boolean check(){
        int count = 0;
        for(int i=1; i<arr.length; i++){
            if(arr[i] == 0){
                count += 1;
                if(count >= K){
                    return false;
                }
            }
        }
        return true;
    }

}