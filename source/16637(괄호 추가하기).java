import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long max = -999999999;
    static int [] nums;
    static char[] opr;



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N/2+1];
        opr = new char[N/2];
        int stridx = 0;
        int numidx = 0;
        String temp = br.readLine();
        for(int i=0; i<N; i++){
            if(i%2 == 0){
                nums[i/2] = temp.charAt(i)-48;
            }else {
                opr[i/2] = temp.charAt(i);
            }
        }
       bfs();
        System.out.println(max);



    }
    static void bfs(){
        Queue<pos> q = new LinkedList<>();
        q.add(new pos(0, nums[0]));
        while(!q.isEmpty()){
            pos now = q.poll();
            if(now.idx == N/2){
                max = Math.max(now.value, max);
            }
            else{
                if(now.idx < N/2){
                    if(opr[now.idx] == '+'){
                        q.add(new pos(now.idx+1, now.value + nums[now.idx+1]));

                    } else if (opr[now.idx] == '-') {
                        q.add(new pos(now.idx+1, now.value - nums[now.idx+1]));
                    }else {
                        q.add(new pos(now.idx+1, now.value * nums[now.idx+1]));
                    }
                }
                if(now.idx < N/2-1){
                    if(opr[now.idx] == '+'){
                        if(opr[now.idx+1] == '+'){
                            q.add(new pos(now.idx+2, now.value + (nums[now.idx+1] + nums[now.idx+2])));
                        } else if (opr[now.idx+1] == '-') {
                            q.add(new pos(now.idx+2, now.value + (nums[now.idx+1] - nums[now.idx+2])));

                        }else{
                            q.add(new pos(now.idx+2, now.value + (nums[now.idx+1] * nums[now.idx+2])));

                        }


                    } else if (opr[now.idx] == '-') {
                        if(opr[now.idx+1] == '+'){
                            q.add(new pos(now.idx+2, now.value - (nums[now.idx+1] + nums[now.idx+2])));
                        } else if (opr[now.idx+1] == '-') {
                            q.add(new pos(now.idx+2, now.value - (nums[now.idx+1] - nums[now.idx+2])));

                        }else{
                            q.add(new pos(now.idx+2, now.value - (nums[now.idx+1] * nums[now.idx+2])));

                        }
                    }else {
                        if(opr[now.idx+1] == '+'){
                            q.add(new pos(now.idx+2, now.value * (nums[now.idx+1] + nums[now.idx+2])));
                        } else if (opr[now.idx+1] == '-') {
                            q.add(new pos(now.idx+2, now.value * (nums[now.idx+1] - nums[now.idx+2])));

                        }else{
                            q.add(new pos(now.idx+2, now.value * (nums[now.idx+1] * nums[now.idx+2])));

                        }
                    }
                }

            }
        }
    }
    static class pos{
        int idx;
        int value;

        public pos(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }






}