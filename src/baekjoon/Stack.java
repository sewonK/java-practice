package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class arrayStack{
    private int top;
    private int[] stack;

    arrayStack(int stackSize){
        top = -1;
        stack = new int[stackSize];
    }
    void push(int x){
        stack[++top] = x;
    }
    void pop(){
        if(top == -1){
            System.out.println(-1);
        } else{
            System.out.println(stack[top]);
            stack[top--] = 0;
        }
    }
    void size(){
        System.out.println(top+1);
    }
    void empty(){
        if(top == -1){
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    void top(){
        if(top == -1){
            System.out.println(-1);
        } else{
            System.out.println(stack[top]);
        }
    }
}

public class Stack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arrayStack stack = new arrayStack(N+1);
        for(int i=0; i<N; i++){
            String[] order = br.readLine().split(" ");
            switch (order[0]) {
                case "push":
                    stack.push(Integer.parseInt(order[1]));
                    break;
                case "pop":
                    stack.pop();
                    break;
                case "size":
                    stack.size();
                    break;
                case "empty":
                    stack.empty();
                    break;
                case "top":
                    stack.top();
                    break;
            }
        }
    }
}
