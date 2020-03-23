package edu.ti.collections.list.linked;

public class LinkedList {
    private java.lang.Object Object;

    private class Node {
        Object payload;
        Node next = null;

        public Node(Object payload) {
            this.payload = payload;
        }

        public Object getPayload() {
            return payload;
        }

        public void setPayload(Object payload) {
            this.payload = payload;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node head = null;

    public LinkedList() {
        // nothing
    }

    public LinkedList(Object payload) {
        head = new Node(payload);
    }

    public boolean isEmpty() {
        return (head == null);
    }

    private Node end() {
        Node end = head;
        while(end.getNext() != null) {
            end = end.getNext();
        }
        return null;
    }

    public int size() {
        int size = 1;
        Node current = head;
        while (current.getNext() != null) {
            current = current.getNext();
            size++;
        }
        return size;
    }

    public void insert(Object object) {
        Node newNode = new Node(object);
        newNode.setNext(head);
        head = newNode;
    }

    public void append(Object object) {
        Node newNode = new Node(object);
        newNode.next = null;
        if(isEmpty()) {
            head = newNode;
        }
        else {
            Node lastNode = head;
            while (lastNode.next != null){
                lastNode = lastNode.next;
            }
            lastNode.next = newNode;
        }
    }


    public Object get(int n) {
        Node node = head;
        if(n > this.size() - 1) {
            return n; //retune n
        }
        else
        {
            for (int count = 0; count < n; count++)
            {
                node = node.getNext();
            }
        }
        return node.getPayload();
    }


    public Object remove(int n) {
        Node current = head;
        Node previous = null;
        Object removeObject = null;
        if ( head != null){
            if(n == 0) {
                head = current.getNext();
                removeObject = current.getPayload();
            }
            else {
                for (int count = 0; count < n; count++)
                {
                    previous = current;
                    current = current.getNext();
                }
                previous.setNext(current.getNext());
                removeObject = current.getPayload();
            }
        }

        return removeObject;
    }

    //TODO -- implement remove to remove given object from list,
    //        return Object if object is in the list, null otherwise
    public Object remove(Object object) {
        Node current = head;
        Node previous = null;
        if(current != null && current == object){
            head = current.next;
            return Object;
        }
        previous = current;
        current = current.next;
        if (current != null){
            previous.next = current.next;
        }

        return null;
    }
}
