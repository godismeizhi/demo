package com.example.demo.link;

import com.example.demo.common.LinkNode;

public class Test1 {

    /**
     * 反转链表
     *
     * @param args
     */
    public static void main(String[] args) {

        LinkUtil.printLinkInfo(LinkUtil.createLink());

        LinkNode reverse1 = reverse1(LinkUtil.createLink());
        LinkUtil.printLinkInfo(reverse1);

        LinkNode reverse2 = reverse2(reverse1);
        LinkUtil.printLinkInfo(reverse2);

    }


    //递归翻转链表
    public static LinkNode reverse1(LinkNode node) {


        if (node == null || node.getNextLinkNode() == null) {
            return node;
        } else {
            LinkNode temp = reverse1(node.getNextLinkNode());
            node.getNextLinkNode().setNextLinkNode(node);
            node.setNextLinkNode(null);
            return temp;
        }
    }


    //循环
    public static LinkNode reverse2(LinkNode node) {

        LinkNode prev = null;
        while (node != null) {
            LinkNode temp = node;
            node = node.next();
            temp.setNextLinkNode(prev);
            prev = temp;
        }
        return prev;
    }


}
