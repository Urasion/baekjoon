import java.sql.SQLOutput;
import java.util.*;
import java.io.*;

public class Main{

    static int N;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static HashMap<String, String> map = new HashMap<>();
    static int [] arr;
    static int [] count;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        count = new int[N];
        Set<Integer> s = new HashSet<>();
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<N; i++){
            s.add(arr[i]);
        }
        ArrayList<Integer> arr_sort = new ArrayList<>(s);
        Collections.sort(arr_sort);
        int size = 0;
        HashMap<Integer, Integer> h = new HashMap<>();
        for (Integer integer : arr_sort) {
            h.put(integer, size);
            size++;
        }
        for(int i=0; i<N; i++){
            int count = h.get(arr[i]);
            bw.write(count + " ");
        }
        bw.flush();
        bw.close();
    }




}