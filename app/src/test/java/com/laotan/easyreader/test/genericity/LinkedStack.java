package com.laotan.easyreader.test.genericity;

import org.junit.Test;

/**
 * Created by quantan.liu on 2017/11/19 0019 17:47.
 */

public class LinkedStack<T> {
    private static class Node<U> {
        U item;
        Node<U> next;

        Node() {
            item = null;
            next = null;
        }

        Node(U item, Node<U> next) {
            this.item = item;
            this.next = next;
        }

        boolean end() {
            return item == null && next == null;
        }
    }

    private Node<T> top = new Node();

    public void push(T item) {
        top = new Node(item, top);
    }

    public T pop() {
        T result = top.item;
        if (!top.end()) {
            top = top.next;
            return result;
        }
        return result;
    }

    @Test
    public void main() {
        LinkedStack<String> mLinkedStack = new LinkedStack<>();
        for (String s : "Phasers on stun!".split(" ")) {
            mLinkedStack.push(s);
        }
        String s;
        while ((s = mLinkedStack.pop()) != null) {
            System.out.println(s);
        }

    }

}
