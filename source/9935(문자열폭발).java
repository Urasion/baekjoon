import java.util.*;
import java.io.*;

public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static String str;
    static String boom;
    static String temp = "";


    public static void main(String[] args) throws IOException {
        str = br.readLine();
        boom = br.readLine();
        Stack<Character> s = new Stack<>();
        for(int i=0; i<str.length(); i++){
            char n = str.charAt(i);
            s.add(n);
            boolean check = false;
            if(s.size() >= boom.length()){
                for(int j=0; j<boom.length(); j++){
                    if (s.get(s.size() - boom.length() + j) != boom.charAt(j)) {
                        check = true;
                        break;
                    }
                }
                if(!check){
                    for(int j=0; j<boom.length(); j++){
                        s.pop();
                    }
                }
            }

        }
        if(s.isEmpty()){
            bw.write("FRULA");
        }
        else{
            for(int i=0; i<s.size(); i++){
                bw.write(s.get(i));
            }
        }
        bw.flush();
        bw.close();


    }

}