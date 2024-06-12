import java.util.*;
import java.io.*;

public class Main {


    static int N;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static char[] arr;
    static boolean [] check;
    static boolean flag;
    static ArrayList<String> temp;



    public static void main(String[] args) throws IOException {
        int ans = 0;
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new char[N];
        check = new boolean[10];
        for(int i=0; i<N; i++){
            arr[i] = st.nextToken().charAt(0);
        }
        for(int i=9; i>=0; i--){
            flag = false;
            check = new boolean[10];
            check[i] = true;
            temp = new ArrayList<>();
            dfs(i,0);
            if(flag){
                for(int j=temp.size()-1; j>=0; j--){
                    System.out.print(temp.get(j));
                }
                break;
            }

            
        }
        System.out.println();
        for(int i=0; i<=9; i++){
            flag = false;
            check = new boolean[10];
            check[i] = true;
            temp = new ArrayList<>();
            dfs_m(i,0);
            if(flag){
                for(int j=temp.size()-1; j>=0; j--){
                    System.out.print(temp.get(j));
                }
                break;
            }
        }
    }
    static void dfs(int n, int count){
        if(count == N){
            flag = true;
            temp.add(String.valueOf(n));
            return;
        }
        if(arr[count] == '>'){
            for(int i = n-1; i>=0; i--){
                if(!check[i]){
                    check[i] = true;
                    dfs(i,count+1);
                    if(flag){
                        temp.add(String.valueOf(n));
                        return;
                    }
                    check[i] = false;
                }

            }
        }else{
            for(int i=9; i>n; i--){
                if(!check[i]){
                    check[i] = true;
                    dfs(i,count+1);
                    if(flag){
                        temp.add(String.valueOf(n));
                        return ;
                    }
                    check[i] = false;
                }
            }
        }
    }
    static void dfs_m(int n, int count){
        if(count == N){
            flag = true;
            temp.add(String.valueOf(n));
            return;
        }
        if(arr[count] == '>'){
            for(int i = 0; i<n; i++){
                if(!check[i]){
                    check[i] = true;
                    dfs_m(i,count+1);
                    if(flag){
                        temp.add(String.valueOf(n));
                        return ;
                    }
                    check[i] = false;
                }

            }
        }else{
            for(int i=n+1; i<=9; i++){
                if(!check[i]){
                    check[i] = true;
                    dfs_m(i,count+1);
                    if(flag){
                        temp.add(String.valueOf(n));
                        return ;
                    }
                    check[i] = false;
                }
            }
        }
    }




}