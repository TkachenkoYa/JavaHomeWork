package com.hl.hw17;

import java.util.Objects;

public class SinglyLinkedList <E> implements CustomList<E>{
    private int size;
    private Node<E> first;

    public int size() {
        return size;
    }

    public void add(E element) {
        if (first == null) {
            first = new Node<>(element);
            size++;
            return;
        }
        add(first, element);
    }

    private void add(Node<E> current, E value) {
        if (current.next == null) {
            current.next = new Node<>(value);
            size++;
            return;
        }
        add(current.next, value);
    }

    public E get(int index) {
        Objects.checkIndex(index, size);

        Node<E> current = first;
        for (int i = 1; i <= index; i++) {
            current = current.next;
        }

        return current.value;
    }

    public boolean remove(int index) {
        Objects.checkIndex(index, size);

        Node<E> prev = null;
        Node<E> current = first;
        for (int i = 1; i <= index; i++) {
            prev = current;
            current = current.next;
        }

        if (prev == null) {
            if (current.next == null) {
                first = null;
                size--;
                return true;
            }
            first = current.next;
            size--;
            return true;
        }

        prev.next = current.next;
        size--;
        return true;
    }
    private static class Node<E> {
        E value;
        Node<E>  next;

        Node(E value) {
            this.value = value;
        }
        Node(E value, Node<E>  next){
            this.value = value;
            this.next = next;
        }
    }
    public SinglyListIterator<E> singlyListIterator(){
        return new SinglyIterator();
    }
    public class SinglyIterator implements SinglyListIterator<E>{
        private Node<E> lastReturned = first.next;
        private  Node<E> beforeElement  = first;
        private  Node<E> previousElement = beforeElement ;

        public boolean hasNext(){
            return lastReturned != null;
        }

        public E next(){
            previousElement = beforeElement;
            beforeElement = lastReturned;
            E e = lastReturned.value;
            lastReturned = lastReturned.next;
            return e;
        }
    }
}
