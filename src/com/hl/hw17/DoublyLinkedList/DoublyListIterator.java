package com.hl.hw17.DoublyLinkedList;

import java.util.Iterator;

public interface DoublyListIterator <E> extends Iterator<E> {
    boolean hasNext();
    E next();
}
