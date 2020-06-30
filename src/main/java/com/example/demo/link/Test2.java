package com.example.demo.link;

import com.example.demo.common.LinkNode;


public class Test2 {

    public static void main(String[] args) {

        LinkNode linkNode = LinkUtil.createLink();
        LinkUtil.printLinkInfo(linkNode);
        LinkNode linkNode2 = reverse(linkNode, 3);
        LinkUtil.printLinkInfo(linkNode2);
    }


    public static LinkNode reverse(LinkNode linkNode, int k) {

        LinkNode prev = new LinkNode("Y");
        prev.setNextLinkNode(linkNode);
        LinkNode hair = prev;
        LinkNode next;

        LinkNode tail = prev;

        while (tail.next() != null) {

            LinkNode head = prev.next();

            int i = k;
            while (tail != null && tail.next() != null && i-- > 0) {
                tail = tail.next();
            }

            next = tail.next();
            tail.setNextLinkNode(null);

            LinkNode childLinkNode = reverseChild(head);

            prev.setNextLinkNode(childLinkNode);
            head.setNextLinkNode(next);

            prev = head;
            tail = prev;
        }

        return hair.next();
    }


    public static LinkNode reverseChild(LinkNode linkNode) {

        LinkNode prev = null;
        while (linkNode != null) {
            LinkNode tmp = linkNode;
            linkNode = linkNode.next();
            tmp.setNextLinkNode(prev);
            prev = tmp;
        }
        return prev;
    }

}
