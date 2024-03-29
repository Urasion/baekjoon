import java.util.*;
import java.io.*;

public class Main{

    static int T, N;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String[] list;
    static int min;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        while(T-- > 0){

            N = Integer.parseInt(br.readLine());
            min = Integer.MAX_VALUE;
            list = new String[N];
            check = new boolean[N];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                list[i] = st.nextToken();
            }
            for(int i=0; i<N; i++){
                for(int j=i+1; j<N; j++){
                    for(int k=j+1; k<N; k++) {
                        calc(i,j,k);
                        if(min == 0){
                            break;
                        }
                    }
                    if(min == 0){
                        break;
                    }
                }
                if(min == 0){
                    break;
                }
            }
            System.out.println(min);
        }

    }
    static class temp{
        int idx, count;

        public temp(int idx, int count) {
            this.idx = idx;
            this.count = count;
        }
    }
    static void calc(int a, int b, int c){
        int total = 0;
        for(int i=0; i<4; i++){
            if(list[a].charAt(i) != list[b].charAt(i)){
                total += 1;
            }
            if(list[a].charAt(i) != list[c].charAt(i)){
                total += 1;
            }
            if(list[b].charAt(i) != list[c].charAt(i)){
                total += 1;
            }
        }
        if(total < min){
            min = total;
        }
    }


}