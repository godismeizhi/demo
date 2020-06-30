package com.example.demo.common;

public class LinkNode<T> extends Node<T> {

    LinkNode<T> preLinkNode;
    LinkNode<T> nextLinkNode;

    public LinkNode(T data) {
        super(data);
    }


    public LinkNode(T data, LinkNode<T> nextLinkNode) {
        super(data);
        this.nextLinkNode = nextLinkNode;
    }


    public LinkNode(T data, LinkNode<T> preLinkNode, LinkNode<T> nextLinkNode) {
        super(data);
        this.preLinkNode = nextLinkNode;
        this.nextLinkNode = nextLinkNode;
    }

    public LinkNode<T> getPreLinkNode() {
        return preLinkNode;
    }

    public void setPreLinkNode(LinkNode<T> preLinkNode) {
        this.preLinkNode = preLinkNode;
    }

    public LinkNode<T> getNextLinkNode() {
        return nextLinkNode;
    }

    public void setNextLinkNode(LinkNode<T> nextLinkNode) {
        this.nextLinkNode = nextLinkNode;
    }

    public LinkNode<T> next() {
        return this.nextLinkNode;
    }
}
