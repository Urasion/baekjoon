import java.io.*;
import java.util.*;

public class Main {
    static int root;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        root = Integer.parseInt(br.readLine());
        node root_node = new node(root);
        while(true){
            String input = br.readLine();
            if(input == null || input.equals("")){
                break;
            }
            root_node.insert(Integer.parseInt(input));
        }
        postOrder(root_node);
        



    }
    public static void postOrder(node n){
        if(n == null){
            return;
        }else{
            postOrder(n.left);
            postOrder(n.right);
            System.out.println(n.num);
        }
    }
    static class node{
        int num;
        node left, right;

        public node(int num) {
            this.num = num;
        }

        void insert(int num){
            if(num < this.num){
                if(this.left == null){
                    this.left = new node(num);
                }else{
                    this.left.insert(num);
                }
            }else{
                if(this.right == null){
                    this.right = new node(num);
                }else{
                    this.right.insert(num);
                }
            }
        }

    }



}