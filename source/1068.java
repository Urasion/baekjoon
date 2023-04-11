import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;



public class Main {
    static int ans=0, n, deleteindex;
    static int []parent;
    static Node[] nodes;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nodes = new Node[n+1];
        for(int i=0; i<n; i++){
            nodes[i] = new Node(i);
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int rootindex = 0;
        for(int i=0; i<n; i++){
            int parent = Integer.parseInt(st.nextToken());
            if(parent == -1){
                rootindex = i;
                continue;
            }
            nodes[parent].child.add(nodes[i]);
        }
        deleteindex = Integer.parseInt(br.readLine());
        if(deleteindex != rootindex){
            deleteNode(rootindex);
            dfs(rootindex);

        }
        System.out.println(ans);
    }
    static void deleteNode(int idx){
        for(Node child : nodes[idx].child){
            if(child.idx == deleteindex){
                nodes[idx].child.remove(child);
                return;
            }
            deleteNode(child.idx);
        }
    }
    static void dfs(int idx){
        if(nodes[idx].child.size() == 0){
            ans += 1;
            return;
        }
        for(Node child: nodes[idx].child){
            dfs(child.idx);
        }
    }
    static class Node{
        int idx;
        ArrayList<Node> child = new ArrayList<>();
        public Node(int idx){
            this.idx = idx;
        }
    }
}
