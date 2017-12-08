package com.ccd.test.design.Composite;

/**
 * Created by ccd on 2017/12/6.
 * 组合模式（Composite）
 * 组合模式有时又叫部分-整体模式在处理类似树形结构的问题时比较方便，看看关系图：
 *
 *
 * Tree                 TreeNode
 *                Vector<TreeNode>children ________|
 *                [add()                          |
 *                remove()/                      |
 *                  |                            |
 *                  |                            |
 *                  1,n_________________________|
 *
 *  使用场景：将多个对象组合在一起进行操作，常用于表示树形结构中，例如二叉树，数等
 *
 */
public class Tree {
    TreeNode root  = null;
    public Tree(String name){
        root = new TreeNode(name);
    }

    public static void main(String[] args) {
        Tree tree = new Tree("A");

        TreeNode nodeB = new TreeNode("B");
        TreeNode nodeC = new TreeNode("C");

        nodeB.add(nodeC);
        tree.root.add(nodeB);

        System.out.println("build the three finished!");
    }

}
