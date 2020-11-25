package com.company;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Tree root =
                new Tree(20,
                        new Tree(7,
                                new Tree(4, null, new Tree(6)), new Tree(9)),
                        new Tree(35,
                                new Tree(31, new Tree(28), null),
                                new Tree(40, new Tree(38), new Tree(52))));
        System.out.println(root.sumWidth(root));
    }

    static class Tree{
        int value;
        Tree left;
        Tree right;

        public Tree(int value, Tree left, Tree right){
            this.left = left;
            this.right = right;
            this.value = value;
        }
        public Tree(int value){
            this.value = value;
            this.right = null;
            this.left = null;
        }

        public int sumDepthRecursive(){
            int sum = value;
            if(left != null){
                sum += left.sumDepthRecursive();
            }
            if(right != null) {
                sum += right.sumDepthRecursive();
            }
            return  sum;
        }

        public static int sumDepth(Tree root){
            Stack<Tree> stack = new Stack<Tree>();
            stack.push(root);
            int sum = 0;
            while (!stack.empty()){
                Tree node = stack.pop();
                sum += node.value;

                if(node.left != null){ stack.push(node.left);}
                if(node.right != null){ stack.push(node.right); }
            }
            return sum;
        }

        public static int sumWidth(Tree root){
            ArrayDeque<Tree> queue = new ArrayDeque<>();
            queue.add(root);
            int sum = 0;
            while (!queue.isEmpty()){
                Tree node = queue.pop();
                sum += node.value;
                System.out.println(node.value);

                if(node.left != null){ queue.add(node.left);}
                if(node.right != null){ queue.add(node.right); }
            }
            return sum;
        }

    }

}
