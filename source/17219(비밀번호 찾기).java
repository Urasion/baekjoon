import java.util.*;
import java.io.*;

public class Main{

    static int N, M;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static HashMap<String, String> map = new HashMap<>();
    static int [] arr;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String site = st.nextToken();
            String pass = st.nextToken();
            map.put(site, pass);
        }
        for(int i=0; i<M; i++){
            String site = br.readLine();
            String pass = map.get(site);
            bw.write(pass + "\n");
        }
        bw.flush();
        bw.close();
    }




}