import java.time.temporal.Temporal;
import java.util.*;
import java.io.*;

public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int A,B,C;
    static int[] arr;
    static boolean[][][] check;
    static Set<Integer> s = new TreeSet<>();
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        check = new boolean[A+1][B+1][C+1];
        Queue<bottle> q = new LinkedList<>();
        q.add(new bottle(0,0,C));
        check[0][0][C] = true;
        while(!q.isEmpty()){
            bottle now = q.poll();
            if(now.A == 0){
                s.add(now.C);

            }
            for(int i=0; i<6; i++){
                int sum = 0;
                switch (i){
                    case 0:
                        sum = now.A + now.B;
                        if(sum < B){
                            if(!check[0][sum][now.C]){
                                check[0][sum][now.C] = true;
                                q.add(new bottle(0,sum,now.C));
                            }

                        }else{
                            if(!check[sum-B][B][now.C]){
                                check[sum-B][B][now.C] = true;
                                q.add(new bottle(sum-B, B, now.C));
                            }

                        }
                    case 1:
                        sum = now.A + now.C;
                        if(sum < C){
                            if(!check[0][now.B][sum]){
                                check[0][now.B][sum] = true;
                                q.add(new bottle(0,now.B,sum));
                            }
                        }else{
                            if(!check[sum-C][now.B][C]){
                                check[sum-C][now.B][C] = true;
                                q.add(new bottle(sum-C, now.B, C));
                            }
                        }
                    case 2:
                        sum = now.A + now.B;
                        if(sum < A){
                            if(!check[sum][0][now.C]){
                                check[sum][0][now.C] = true;
                                q.add(new bottle(sum,0,now.C));
                            }
                        }else{
                            if(!check[A][sum-A][now.C]){
                                check[A][sum-A][now.C] = true;
                                q.add(new bottle(A,sum-A,now.C));
                            }
                        }
                    case 3:
                        sum = now.B + now.C;
                        if(sum < C){
                            if(!check[now.A][0][sum]){
                                check[now.A][0][sum] = true;
                                q.add(new bottle(now.A,0,sum));
                            }
                        }else{
                            if(!check[now.A][sum-C][C]){
                                check[now.A][sum-C][C] = true;
                                q.add(new bottle(now.A, sum-C, C));
                            }
                        }
                    case 4:
                        sum = now.A + now.C;
                        if(sum < A){
                            if(!check[sum][now.B][0]){
                                check[sum][now.B][0] = true;
                                q.add(new bottle(sum,now.B, 0));
                            }
                        }else{
                            if(!check[A][now.B][sum-A]){
                                check[A][now.B][sum-A] = true;
                                q.add(new bottle(A,now.B,sum-A));
                            }
                        }
                    case 5:
                        sum = now.B + now.C;
                        if(sum < B){
                            if(!check[now.A][sum][0]){
                                check[now.A][sum][0] = true;
                                q.add(new bottle(now.A, sum, 0));
                            }
                        }else{
                            if(!check[now.A][B][sum-B]){
                                check[now.A][B][sum-B] = true;
                                q.add(new bottle(now.A, B, sum-B));
                            }
                        }
                }
            }
        }
        for(int i : s){
            bw.write(i + " ");
        }
        bw.flush();
        bw.close();
        
    }
    static class bottle{
        int A,B,C;

        public bottle(int a, int b, int c) {
            A = a;
            B = b;
            C = c;
        }
    }


}