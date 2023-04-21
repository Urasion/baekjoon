import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int [] arr;
    static int [] count_arr;
    static int [] result;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<Integer>();
        arr = new int[N+1];
        result = new int[N+1];
        count_arr = new int[1000001];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            count_arr[arr[i]] += 1;

        }
        stack.push(0);
        for(int i=1; i<N; i++){
            while(!stack.isEmpty() && count_arr[arr[stack.peek()]] < count_arr[arr[i]]) {
                result[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            result[stack.pop()] = -1;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0; i<N; i++){
            bw.write(result[i] + " ");
        }
        bw.flush();

    }




}