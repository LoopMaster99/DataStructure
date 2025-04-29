package StackQueue;

public class StackUsingArray {

    int top;
    int length;
    int[] arr; 

    StackUsingArray(){
        this.length = 10;
        this.top = -1;
        this.arr = new int [length];
    }

    StackUsingArray(int length){
        this.length = length;
        this.top = -1;
        this.arr = new int [length];
    }

    void push(int x){
        top = top + 1;
        arr[top] = x;
    }

    int pop(){
        if(top == -1) System.out.println("\"UnderFlow\", please push element first");
        else{
            int val = arr[top];
            top = top - 1;
            return val;
        }
    }

    void peek(){
        if(top == -1) System.out.println("\"UnderFlow\", stack is empty");    
        else System.out.println(arr[top]);
    }

    void size(){
        System.out.println(top + 1); 
    }
}

class Main{
    public static void main(String[] args) {
        StackUsingArray st = new StackUsingArray();
        st.push(9);
        st.peek();
        st.size();
    }
}
