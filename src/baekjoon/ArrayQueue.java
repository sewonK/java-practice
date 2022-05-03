package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class intQueue {
    private int front;
    private int back;
    private int[] queue;
    intQueue(int queueSize){
        front=0;
        back=0;
        queue = new int[queueSize];
    }
    void push(int x){
        queue[back++] = x;
    }
    void pop(){
        if(back == front){
            System.out.println(-1);
        } else{
            System.out.println(queue[front++]);
        }
    }
    void size(){
        System.out.println(back-front);
    }
    void empty(){
        if(back == front){
            System.out.println(1);
        } else{
            System.out.println(0);
        }
    }
    void front(){
        if(back == front){
            System.out.println(-1);
        } else {
            System.out.println(queue[front]);
        }
    }
    void back(){
        if(back == front){
            System.out.println(-1);
        } else {
            System.out.println(queue[back-1]);
        }
    }
}

public class ArrayQueue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        intQueue queue = new intQueue(N+1);
        for(int i=0; i<N; i++){
            String[] order = br.readLine().split(" ");
            switch (order[0]) {
                case "push":
                    queue.push(Integer.parseInt(order[1]));
                    break;
                case "pop":
                    queue.pop();
                    break;
                case "size":
                    queue.size();
                    break;
                case "empty":
                    queue.empty();
                    break;
                case "front":
                    queue.front();
                    break;
                case "back":
                    queue.back();
                    break;
            }
        }
    }
}
