package StackQueue;

public class QueueUsingArray {
    int start = -1, end = -1, curr_size = 0;
    int length;
    int[] arr;

    QueueUsingArray(){
        this.length = 10;
        this.arr = new int[length];
    }
    QueueUsingArray(int length){
        this.length = length;
        this.arr = new int[length];
    }

    void push(int x){
        if(curr_size == length) System.out.println("\"Overflow\"");
        else{
            if(curr_size == 0){
                start = end = 0;
            }
            else end = (end + 1) % length;

            arr[end] = x;
            curr_size += 1;
        }
    }

    int pop(){
        if(curr_size == 0) System.out.println("\"Underflow\"");
        else{
            int val = arr[start];

            if(curr_size == 1) start = end = -1;
            else start = (start + 1) % length;

            curr_size -= 1;
            return val;
        }
        return -1;
    }

    void top(){
        if(curr_size == 0) System.out.println("\"Underflow\"");
        else{
            System.out.println(arr[start]);
        }
    }

    void size(){
        System.out.println(curr_size);
    }
}
