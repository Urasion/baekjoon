import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


// 아마 사이클찾는 문제 같음
// 사이클 찾으면 나가면 될듯
public class Main {
    static int N,M;
    static boolean[] check;
    static boolean result;
    static ArrayList<Integer>[] friend;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        friend = new ArrayList[N];
        for(int i=0; i<N; i++){
            friend[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friend[a].add(b);
            friend[b].add(a);
        }
        for(int i=0; i<N; i++){
            check = new boolean[N];
            dfs(i,0);
        }
        if(result == true){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
    static void dfs(int now, int count){
        check[now] = true;
        if(count == 4){
            result = true;
            return;
        }
        for(int i=0; i<friend[now].size(); i++){
            int next = friend[now].get(i);
            if(check[next] == false){;
                dfs(next, count + 1);
            }
        }
        check[now] = false;

    }

}