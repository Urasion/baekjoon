import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int l,c;
    static LinkedList<Integer>[]arr = new LinkedList[4];
    static int [] turnInfo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<4; i++){
            arr[i] = new LinkedList<>();
            String str = br.readLine();
            for(int j=0; j<str.length(); j++){
                arr[i].addLast((int)str.charAt(j)-48);
            }
        }
        int k = Integer.parseInt(br.readLine());
        for(int i=0; i<k; i++){
            turnInfo = new int[4];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int turnGear = Integer.parseInt(st.nextToken());
            turnInfo[turnGear-1] = Integer.parseInt(st.nextToken());
            turnCheck(turnGear);
            roll();
        }
        int sum = 0;
        sum += arr[0].get(0)*(1);
        sum += arr[1].get(0)*(2);
        sum += arr[2].get(0)*(4);
        sum += arr[3].get(0)*(8);
        System.out.println(sum);




    }
    static void turnCheck(int gearNum){
        for(int i=gearNum; i<4; i++){

            if(arr[i-1].get(2) != arr[i].get(6)){
                turnInfo[i] = turnInfo[i-1]*(-1);
            }
            else{
                turnInfo[i] = 0;
            }

        }
        for(int i=gearNum-1; i>0; i--){
            if(arr[i].get(6) != arr[i-1].get(2)){
                turnInfo[i-1] = turnInfo[i]*(-1);
            }
            else{
                turnInfo[i-1] = 0;
            }

        }
    }
    public static void roll(){
        for(int i=0; i<4; i++){
            if(turnInfo[i] != 0){
                if(turnInfo[i] == 1){
                    arr[i].addFirst(arr[i].pollLast());
                }
                else{
                    arr[i].addLast(arr[i].pollFirst());
                }
            }

        }
    }


}
