import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<pos> chicken = new ArrayList<>();
    static ArrayList<pos> currentList = new ArrayList<>();
    static int sum = -99;
    static int n,m;
    static ArrayList<pos> home = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i=0; i<n; i++) {

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int check = Integer.parseInt(st.nextToken());
                if (check == 2) {
                    chicken.add(new pos(i, j));
                } else if (check == 1) {
                    home.add(new pos(i, j));
                }
            }
        }
        for(int i=0; i<=chicken.size()-m; i++){

            currentList.add(chicken.get(i));
            dfs(i,1);
            currentList.remove(currentList.size()-1);
        }
        System.out.println(sum);


    }

    static void dfs(int index, int count){
        if(count == m){
            if(sum == -99){
                sum = chickenSum();
            }else{
                sum = Math.min(sum, chickenSum());
            }
            return;
        }
        for(int i = index+1; i<chicken.size(); i++){
            currentList.add(chicken.get(i));
            dfs(i, count+1);
            currentList.remove(currentList.size()-1);
        }
    }

    private static int chickenSum() {
        int sum = 0;
        for(int i=0; i<home.size(); i++){
            int min = Math.abs(home.get(i).x - currentList.get(0).x) + Math.abs(home.get(i).y - currentList.get(0).y);
            for(int j=1; j<currentList.size(); j++){
                min = Math.min(min,Math.abs(home.get(i).x - currentList.get(j).x) + Math.abs(home.get(i).y - currentList.get(j).y));
            }
            sum += min;
        }
        return sum;
    }

    static class pos{
        int x,y;
        pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

}