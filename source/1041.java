import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;



public class Main {

    public static long N, face_1,face_2,face_3,max=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[7];
        int sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<6; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(arr[i],max);
            sum += arr[i];
        }
        if(N == 1){
            System.out.println(sum - max);
            return;
        }
        long AF = Math.min(arr[0],arr[5]);
        long BE = Math.min(arr[1],arr[4]);
        long CD = Math.min(arr[2],arr[3]);
        face_3 = AF+BE+CD;
        face_2 = Math.min(AF+BE,Math.min(BE+CD, AF+CD));
        face_1 = Math.min(AF,Math.min(BE,CD));
        System.out.println(calc());

    }
    public static long calc(){
        long face_one = 4*(N-1)*(N-2) + (N-2)*(N-2);
        long face_two = 4*(N-2) + 4*(N-1);
        long face_three = 4;

        long sum = 0;
        sum = face_one*face_1 + face_two*face_2 + face_three*face_3;
        return sum;

    }
}
