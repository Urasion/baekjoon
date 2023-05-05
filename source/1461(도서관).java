import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static ArrayList<Integer> arr_p = new ArrayList<>();
    static ArrayList<Integer> arr_n = new ArrayList<>();
    static int sum;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(num > 0){
                arr_p.add(num);
            }else{
                arr_n.add(Math.abs(num));
            }
        }
        int p_idx = 0;
        int n_idx = 0;
        arr_p.sort(Comparator.reverseOrder());
        arr_n.sort(Comparator.reverseOrder());
        if(arr_p.size() == 0){
            arr_p.add(0);
        }
        if(arr_n.size() == 0){
            arr_n.add(0);
        }
        if(arr_p.get(0) > arr_n.get(0)){
            sum += arr_p.get(0);
            p_idx += M;
        }else{
            sum += arr_n.get(0);
            n_idx += M;
        }

        while(p_idx < arr_p.size()){
            sum += arr_p.get(p_idx)*2;
            if(arr_p.size() - p_idx+M > M){
                p_idx += M;
            }else{
                p_idx += 1;
            }
        }

        while(n_idx < arr_n.size()){
            sum += arr_n.get(n_idx)*2;
            if(arr_n.size() - n_idx+M > M){
                n_idx += M;
            }else{
                n_idx += 1;
            }
        }
        System.out.println(sum);


    }



}