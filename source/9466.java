import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int t,n;
    static int[] arr;
    static boolean[] check;
    static boolean[] visited;
    static int count;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for(int c=0; c<t; c++){
            n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            check = new boolean[n+1];
            visited = new boolean[n+1];
            arr = new int[n+1];
            count = 0;
            for(int i=1; i<=n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for(int i=1; i<=n; i++){
                if(check[i] == false){
                    dfs(i);
                }

            }
            System.out.println(n-count);

        }




    }

    private static void dfs(int now) {
        if(visited[now]){
            check[now] = true;
            count++;
        }else{
            visited[now] = true;
        }
        int next = arr[now];
        if(!check[next]){
            dfs(next);
        }
        visited[now] = false;
        check[now] = true;

    }


}