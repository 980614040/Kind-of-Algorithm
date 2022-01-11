package demo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int data) {
        this.value = data;
    }

    public static boolean isCBT(Node head) {
        if (head == null) {
            return true;
        }
        Queue<Node> queue = new LinkedList<Node>();
        boolean leaf = false;
        Node l = null;
        Node r = null;
        queue.offer(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            l = head.left;
            r = head.right;
            if ((leaf && (l != null || r != null)) || (l == null && r != null)) {
                return false;//当前结点不是叶子结点且之前结点有叶子结点 || 当前结点有右孩子无左孩子
            }
            if (l != null) {
                queue.offer(l);
            }
            if (r != null) {
                queue.offer(r);
            } else {
                leaf = true;//无孩子即为叶子结点
            }
        }
        return true;
    }


    public static void main(String[] args) {

        Scanner scan=new Scanner(System.in);
        System.out.println("请输入二叉树一行:");
        Node node=new Node(scan.nextInt());
        System.out.println("请输入二叉树二行:");
        Node left1=new Node(scan.nextInt());
        Node right1=new Node(scan.nextInt());
        node.left=left1;
        node.right=right1;
        System.out.println("请输入二叉树三行:");
        Node left2=new Node(scan.nextInt());
        Node right2=new Node(scan.nextInt());
        left1.left=left2;
        left1.right=right2;

        Node left3=new Node(scan.nextInt());
        Node right3=new Node(scan.nextInt());
        right1.left=left3;
        right1.right=right3;

        System.out.println("此二叉树为"+(isCBT(node)?"完全":"不完全")+"二叉树");
    }


}

