package com.company;

public class Main {

    public static void main(String[] args) {
        Tree root =
                new Tree(20,
                        new Tree(7,
                                new Tree(4, null, new Tree(6)), new Tree(9)),
                        new Tree(35,
                                new Tree(31, new Tree(28), null),
                                new Tree(40, new Tree(38), new Tree(52))));
        System.out.println(root.sumInChild());
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

        public int sumInChild(){
            int sum = value;

            if(left != null){
                sum += left.sumInChild();
            }
            if(right != null) {
                sum += right.sumInChild();
            }
            return  sum;
        }
    }

}
