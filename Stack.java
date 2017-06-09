package com.lmig.stack;

public class Stack {
    
    private int[] vals;
    private int size;
    
    public void push(int a) {
        // if necessary, double the size of vals
        // copy the values from the existing array to the new one
    	// First In Last Out
        if (this.size >= this.vals.length) {
            int[] arr = new int[this.vals.length * 2];
            for (int i = 0; i < this.size; i++) {
                arr[i] = this.vals[i];
            }
            this.vals = arr;
        }
        this.vals[this.size] = a;
        this.size++;
        return;
    }
    
    public int pop() {
        if (this.size <= 0) {
            throw new RuntimeException("nothing more to pop");
        }
        this.size--;
        return this.vals[this.size];
    }
    
    public int size() {
        return this.size;
    }
    
    public Stack() {  // Constructor
        this.vals = new int[10];
        this.size = 0;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Stack st;
        st = new Stack();
        System.out.println(st.size());
        st.push(-14);
        st.push(976);
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
    }
}
