package com.codecool.stackdojo;

public class MainStack {

    public static void main(String[] args) {
        MyStack<Long> stack = new MyStack<>(6);

        stack.push(1L);
        stack.push(2L);
        stack.push(444L);
        stack.push(22L);
        stack.push(223L);
        stack.push(522L);
        System.out.println(stack.size());
        System.out.println(stack);


        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.size());
    }

}
