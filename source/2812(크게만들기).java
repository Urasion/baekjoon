import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static String str;
    static char[] arr;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        str = br.readLine();
        arr = str.toCharArray();
        int count = 0;
        Deque<Integer> q = new LinkedList<>();
        q.addLast(0);
        for (int i = 1; i < N; i++) {
            while (count < K && !q.isEmpty() && arr[q.peekLast()] < arr[i]) {
                count += 1;
                q.pollLast();
            }
            q.addLast(i);
        }
        StringBuilder ans = new StringBuilder();
        while(q.size() > K-count){
            ans.append(arr[q.pollFirst()]);
        }
        bw.write(ans.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();



    }
}