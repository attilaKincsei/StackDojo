package com.codecool.stackdojo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {

    MyStack testStack;

    @Test
    void testPush_IfFull_ThrowStackOverflowException() {
        initializeAndFillUpMyStack(Integer.class, 3, 3);
        assertThrows(StackOverFlowException.class, () -> testStack.push(1));
    }

    @Test
    void testPop_IfEmpty_ThrowStackUnderflowException() {
        initializeAndFillUpMyStack(Integer.class, 1, 0);
        assertThrows(StackUnderFlowException.class, () -> testStack.pop());
    }

    @Test
    void testPeek_IfEmpty_ThrowStackUnderflowException() {
        initializeAndFillUpMyStack(Integer.class, 1, 0);
        assertThrows(StackUnderFlowException.class, () -> testStack.peek());
    }


    @Test
    void pop() {
    }

    @Test
    void peek() {
    }

    @Test
    void size() {
    }

    @Test
    public String toString() {
        return "";
    }

    private <E> void initializeAndFillUpMyStack(Class<E> itemsClass, int stackMaxSize, int numberOfItemsInStack) {
        testStack = new MyStack<E>(stackMaxSize);
        for (int i = 0; i < numberOfItemsInStack; i++) {
            testStack.push(itemsClass.cast(i));
        }
    }

}