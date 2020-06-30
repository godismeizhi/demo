package com.example.demo.link;

import com.example.demo.common.Collect;
import com.example.demo.common.LinkNode;

import java.util.ArrayList;

public class LinkCollect<T> implements Collect<T> {


    LinkNode<T> rootNode;

    LinkNode<T> lastNode;

    @Override

    public void add(T data) {

        if (data == null) {
            throw new NullPointerException();
        }

        if (rootNode == null) {
            rootNode = new LinkNode<>(data);
            lastNode = rootNode;
        } else {
            LinkNode<T> newLinkNode = new LinkNode<>(data);
            lastNode.setNextLinkNode(newLinkNode);
            lastNode = newLinkNode;
        }
    }


    @Override
    public void remove(T data) {

        if (data == null) {
            throw new NullPointerException();
        }
    }


    @Override
    public boolean hasNext() {
        return false;
    }


    @Override
    public T next() {
        return null;
    }
}
