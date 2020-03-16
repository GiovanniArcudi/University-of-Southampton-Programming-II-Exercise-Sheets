/** EXERCISE:
   Secondly, write a similar method to work for a Tree data structure (uk.ac.soton.ecs.comp1206.labtestlibrary.datastructure.Tree).
   Create a class MinTree that implements MinimumInTree (package uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.recursion).

   Implement the method int findMin(Tree tree) to recursively find the minimum in a tree.
   The method should return the minimal number in the tree.*/

import uk.ac.soton.ecs.comp1206.labtestlibrary.datastructure.Tree;
import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.recursion.MinimumInTree;

public class MinTree implements MinimumInTree {

    public static void main(String[] args) {
        Tree tree = new Tree(24,
                new Tree(45,
                        null,
                        new Tree(8, null, null)),
                new Tree(17,
                        new Tree(74, null, null),
                        null));
        MinTree minTree = new MinTree();
        System.out.println("Minimum is: " + minTree.findMin(tree));
    }

    public int findMin(Tree tree) {
        return findMinTree(tree).getVal();
    }

    public Tree findMinTree (Tree tree) {
        if (tree.right() == null && tree.left() == null) {
            return tree;
        } else if (tree.left() != null && tree.right() == null) {
            return findMinAux(tree, findMinTree(tree.left()));
        } else if (tree.left() == null && tree.right() != null) {
            return findMinAux(tree, findMinTree(tree.right()));
        } else {
            return findMinAux(tree, findMinAux(findMinTree(tree.left()), findMinTree(tree.right())));
        }
    }

    public Tree findMinAux(Tree tree1, Tree tree2) {
        if (tree1.getVal() < tree2.getVal()) {
            return tree1;
        } else {
            return tree2;
        }
    }

}
