package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DfsAndBfs {
    static int n, m, v;
    static ArrayList<Integer>[] graph;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        n = Integer.parseInt(info[0]);
        m = Integer.parseInt(info[1]);
        v = Integer.parseInt(info[2]);
        graph = new ArrayList[n+1];
        for (int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i<m; i++){
            String[] edge = br.readLine().split(" ");
            int x = Integer.parseInt(edge[0]);
            int y = Integer.parseInt(edge[1]);
            graph[x].add(y);
            graph[y].add(x);
        }
        for (int i=1; i<=n; i++){
            Collections.sort(graph[i]);
        }
        visit = new boolean[n+1];
        DFS(v);
        visit = new boolean[n+1];
        BFS(v);
    }
    static void DFS(int node) {
        visit[node] = true;
        System.out.println(node);
        for(int i=0; i<graph[node].size(); i++){
            int next = graph[node].get(i);
            if(!visit[next]) DFS(next);
        }
    }
    static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visit[start] = true;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            System.out.println(cur);
            for(int i=0; i<graph[cur].size(); i++){
                int next = graph[cur].get(i);
                if(!visit[next]){
                    visit[next] = true;
                    queue.add(next);
                }
            }
        }
    }
}
