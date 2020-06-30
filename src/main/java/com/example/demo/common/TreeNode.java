package com.example.demo.common;

public class TreeNode<T> extends Node<T> {

    TreeNode<T> leftTreeNode;
    TreeNode<T> rightTreeNode;

    public TreeNode(T data, TreeNode<T> leftTreeNode, TreeNode<T> rightTreeNode) {
        super(data);
        this.leftTreeNode = leftTreeNode;
        this.rightTreeNode = rightTreeNode;
    }

    public TreeNode<T> getLeftTreeNode() {
        return leftTreeNode;
    }

    public void setLeftTreeNode(TreeNode<T> leftTreeNode) {
        this.leftTreeNode = leftTreeNode;
    }

    public TreeNode<T> getRightTreeNode() {
        return rightTreeNode;
    }

    public void setRightTreeNode(TreeNode<T> rightTreeNode) {
        this.rightTreeNode = rightTreeNode;
    }
}

