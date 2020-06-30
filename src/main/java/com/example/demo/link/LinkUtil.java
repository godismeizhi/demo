package com.example.demo.link;

import com.example.demo.common.LinkNode;
import sun.awt.image.ImageWatched;

public class LinkUtil {

    public static LinkNode createLink() {
        LinkNode<String> node1 = new LinkNode("A");
        LinkNode<String> node2 = new LinkNode("B");
        LinkNode<String> node3 = new LinkNode("C");
        LinkNode<String> node4 = new LinkNode("D");
//        LinkNode<String> node5 = new LinkNode("E");
//        LinkNode<String> node6 = new LinkNode("F");

        node1.setNextLinkNode(node2);
        node2.setNextLinkNode(node3);
        node3.setNextLinkNode(node4);
//        node4.setNextLinkNode(node5);
//        node5.setNextLinkNode(node6);

        return node1;
    }

    public static void printLinkInfo(LinkNode node) {
        if (node == null) {
            System.out.println("");
            return;
        }
        System.out.print(node.getData() + "-");
        printLinkInfo(node.getNextLinkNode());
    }
}
