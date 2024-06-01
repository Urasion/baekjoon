import java.util.*;
import java.io.*;

public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int L,R,C;
    static char[][][] arr;
    static boolean [][][] check;
    static boolean [] robot;
    static int [] dx = {0,0,1,-1,0,0};
    static int [] dy = {1,-1,0,0,0,0};
    static int [] dz = {0,0,0,0,1,-1};
    public static void main(String[] args) throws IOException {
        while(true){
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            if(L == 0 && R == 0 && C == 0){
                break;
            }
            arr = new char[L][R][C];
            check = new boolean[L][R][C];
            pos start = null;
            for(int i=0; i<L; i++){
                for(int j=0; j<R; j++){
                    String s = br.readLine();
                    for(int k=0; k<C; k++){
                        arr[i][j][k] = s.charAt(k);
                        if(arr[i][j][k] == 'S'){
                            start = new pos(k,j,i,0);
                        }
                    }
                }
                br.readLine();
            }
            Queue<pos> q = new LinkedList<>();
            q.add(start);
            boolean flag = false;
            while(!q.isEmpty()){
                pos now = q.poll();
                if(arr[now.z][now.y][now.x] == 'E'){
                    flag = true;
                    System.out.println("Escaped in "+now.count+" minute(s).");
                    break;
                }
                for(int i=0; i<6; i++){
                    int next_x = now.x + dx[i];
                    int next_y = now.y + dy[i];
                    int next_z = now.z + dz[i];
                    if(next_x >= 0 && next_x< C && next_y >= 0 && next_y < R && next_z >=0 && next_z < L && arr[next_z][next_y][next_x] != '#'){
                        if(!check[next_z][next_y][next_x]){
                            check[next_z][next_y][next_x] = true;
                            q.add(new pos(next_x, next_y, next_z, now.count + 1));
                        }
                    }
                }
            }
            if(!flag){
                System.out.println("Trapped!");
            }
        }






    }
    static class pos{
        int x,y,z;
        int count;

        public pos(int x, int y, int z, int count) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.count = count;
        }
    }


}