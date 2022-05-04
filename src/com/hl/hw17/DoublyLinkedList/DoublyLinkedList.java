package com.hl.hw17.DoublyLinkedList;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;

    private static class Node<E> {
        Node<E> prev;
        Node<E> next;
        E data;

        public Node(Node<E> prev, Node<E> next, E data) {
            this.prev = prev;
            this.next = next;
            this.data = data;
        }
    }

    public E get(int i) {
        Node<E> x = getNode(i);
        return x == null ? null : x.data;
    }

    private Node<E> getNode(int i) {
        if (i >= size)
            return null;

        if (i < (size >> 1)) {
            Node<E> current = first;
            for (int j = 0; j < i; j++) {
                current = current.next;
            }
            return current;
        } else {
            Node<E> current = last;
            for (int j = size - 1; j > i; j--) {
                current = current.prev;
            }
            return current;
        }
    }
    public boolean addFirst(E element) {
        Node<E> newNode = new Node<>(null, first, element);
        if (first != null)
            first.prev = newNode;

        last = newNode;
        first = newNode;
        size++;
        return true;
    }
    public void add(E element) {
        Node<E> l = last;
        Node<E> newNode = new Node<E>(l,null, element);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    public boolean add(E element, int i) {
        if (i < 0)
            throw new IndexOutOfBoundsException("index = " + i);
        if (size == 0 || i == 0)
            return addFirst(element);
        Node<E> current = first;
        for (int j = 1; j < i && j < size; j++) {
            current = current.next;
        }
        return addAfter(current, element);
    }

    private boolean addAfter(Node<E> current, E element) {
        Node<E> newNode = new Node<>(current, current.next, element);
        if (current.next == null)
            last = newNode;

        else current.next.prev = newNode;

        current.next = newNode;
        size++;
        return true;
    }

    public Iterator<E> doublyIteratorByFirst() {
        return new ListItr(0);
    }

    public ListIterator<E> doublyListIteratorForIndex(int index) {
        return new ListItr(index);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    private class ListItr implements ListIterator<E>,DoublyListIterator<E> {
        private Node<E> lastReturned = null;
        private Node<E> next;
        private int nextIndex;

        ListItr(int index) {
            next = (index == size) ? null : getNode(index);
            nextIndex = index;
        }

        public boolean hasNext() {
            return nextIndex < size;
        }

        public E next() {
            if (!hasNext())
                throw new NoSuchElementException();

            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.data;
        }

        public boolean hasPrevious() {
            return nextIndex > 0;
        }

        public E previous() {

            if (!hasPrevious())
                throw new NoSuchElementException();

            lastReturned = next = (next == null) ? last : next.prev;

            nextIndex--;
            return lastReturned.data;
        }

        public int nextIndex() {
            return nextIndex;
        }

        public int previousIndex() {
            return nextIndex - 1;
        }

        public void remove() {

            if (lastReturned == null)
                throw new IllegalStateException();

            Node<E> lastNext = lastReturned.next;

            DoublyLinkedList.this.remove(lastReturned);

            if (next == lastReturned)
                next = lastNext;

            nextIndex--;
            lastReturned = null;
        }

        public void set(E e) {
            if (lastReturned == null)
                throw new IllegalStateException();
            lastReturned.data = e;
        }

        public void add(E e) {
            lastReturned = null;
            DoublyLinkedList.this.add(e, nextIndex);
            nextIndex++;
        }
    }

        public E remove(int i) {
            Node<E> current = getNode(i);
            if (current == null) {
                return null;
            }
            return remove(current);
        }
    private E remove(Node<E> current) {
        E oldData = current.data;
        Node<E> prev = current.prev;
        Node<E> next = current.next;

        if (prev == null)
            first = current.next;
        else {
           prev.next = next;
            current.prev = null;
        }
        if (next == null)
            last = current.prev;
        else {
            next.prev = prev;
            current.next = null;
        }
        current.data = null;
        size--;
        return oldData;
    }
}

