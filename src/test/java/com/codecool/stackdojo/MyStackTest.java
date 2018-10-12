package com.codecool.stackdojo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collections;
import com.fasterxml.jackson.databind.type.CollectionType;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {

    private MyStack testStack;

    @Test
    void testPush_IfFull_ThrowStackOverflowException() throws InstantiationException, IllegalAccessException {
        initializeAndFillUpMyStack(Integer.class, 3, 3);
        assertThrows(StackOverFlowException.class, () -> testStack.push(1));
    }

    @Test
    void testPop_IfEmpty_ThrowStackUnderflowException() throws InstantiationException, IllegalAccessException {
        initializeAndFillUpMyStack(Integer.class, 1, 0);
        assertThrows(StackUnderFlowException.class, () -> testStack.pop());
    }

    @Test
    void testPeek_IfEmpty_ThrowStackUnderflowException() throws InstantiationException, IllegalAccessException {
        initializeAndFillUpMyStack(Integer.class, 1, 0);
        assertThrows(StackUnderFlowException.class, () -> testStack.peek());
    }

    @ParameterizedTest
    @ValueSource(ints = {111, 112, 113})
    void testPop_IfItemPushed_PopSameAsItemPushed(Integer itemPushed) throws InstantiationException, IllegalAccessException {
        initializeAndFillUpMyStack(Integer.class, 3, 1);
        testStack.push(itemPushed);
        assertSame(itemPushed, testStack.pop());
    }

    @Test
    void testPushAndPop_IfInteger_SameType() throws InstantiationException, IllegalAccessException {
        initializeAndFillUpMyStack(Integer.class, 3, 1);
        testStack.push(1);
        assertSame(Integer.class, testStack.pop().getClass());
    }

    @Test
    void testPushAndPop_IfLong_SameType() throws InstantiationException, IllegalAccessException {
        initializeStack(Long.class, 3);
        testStack.push(1L);
        assertSame(Long.class, testStack.pop().getClass());
    }

    @Test
    void testSize() {
        initializeStack(Double.class, 5);
        testStack.push(1D);
        testStack.push(2D);
        testStack.push(3D);
        assertSame(3, testStack.size());
    }

    @Test
    void testSize_ifPeek_SizeStaysTheSame() {
        initializeStack(Double.class, 5);
        testStack.push(1D);
        testStack.push(2D);
        testStack.push(3D);
        testStack.peek();
        assertSame(3, testStack.size());

    }

    @Test
    void testToString_ifEmpty_ReturnSquareBrackets() {
        initializeStack(Float.class, 2);
        assertEquals("[]", testStack.toString());
    }

    private <E> void initializeAndFillUpMyStack(Class<E> itemsClass, int stackMaxSize, int numberOfItemsInStack) throws IllegalAccessException, InstantiationException {
        initializeStack(itemsClass, stackMaxSize);
        fillUpStack(itemsClass, numberOfItemsInStack);
    }

    private <E> void initializeStack(Class<E> itemsClass, int stackMaxSize) {
        testStack = new MyStack<E>(stackMaxSize);
    }

    private <E> void fillUpStack(Class<E> itemsClass, int numberOfItemsInStack) {
        for (int i = 0; i < numberOfItemsInStack; i++) {
            testStack.push(itemsClass.cast(i));
        }
    }

}