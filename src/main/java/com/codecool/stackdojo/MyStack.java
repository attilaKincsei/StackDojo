package com.codecool.stackdojo;

public class MyStack<E> {

    E[] stackArray;

    public MyStack(int size) {
        stackArray = (E[]) new Object[size];
    }

    public void push(E item) throws StackOverFlowException {
        Integer nullItemsIndex = size();
        if (nullItemsIndex.equals(stackArray.length)) {
            throw new StackOverFlowException("Stack is full. You cannot add any more items");
        } else {
            stackArray[nullItemsIndex] = item;
        }
    }

    public E pop() throws StackUnderFlowException {
        int nullItemsIndex = size();
        if (nullItemsIndex > 0) {
            E itemToPop = stackArray[nullItemsIndex - 1];
            stackArray[nullItemsIndex - 1] = null;
            return itemToPop;
        } else {
            throw new StackUnderFlowException("Stack is empty. Cannot pop last element");
        }

    }


    public E peek() throws StackUnderFlowException {
        int nullItemsIndex = size();
        if (nullItemsIndex > 0) {
            return stackArray[nullItemsIndex - 1];
        } else {
            throw new StackUnderFlowException("Stack is empty. Cannot pop last element");
        }

    }


    public int size() {
        for (int i = 0; i < stackArray.length; i++) {
            if (stackArray[i] == null) {
                return i;
            }
        }
        return stackArray.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for (E item : stackArray) {
            if (item == null) {
                break;
            }
            sb.append(String.valueOf(item)).append(", ");
        }
        System.out.println("Length in toString(): " + size());
        System.out.println(sb.toString());
        if (size() > 0) {
            sb.delete(sb.length() - 2, sb.length());
        }

        sb.append("]");

        return sb.toString();
    }
}
