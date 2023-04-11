import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int l,c;
    static String[] arr;
    static String[] arr2 = {"a","e","i","o","u"};
    static List<String> arrList = new ArrayList<>(Arrays.asList(arr2));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new String[c];
        for(int i=0; i<c; i++){
            arr[i] = st.nextToken();
        }
        Arrays.sort(arr, Comparator.naturalOrder());
        for(int i =0; i<=c-l; i++){
            dfs(i,0,0, "");
        }

    }
    public static void dfs(int index, int count1, int count2, String str){
        if(arrList.contains(arr[index])){
            count1 += 1;
        }
        else{
            count2 += 1;
        }
        str = str+arr[index];
        if(str.length() == l && count1 >= 1 && count2 >= 2){
            System.out.println(str);
            return;
        }
        for(int i=index+1; i<c; i++){
            dfs(i, count1, count2 , str);
        }
    }

}

