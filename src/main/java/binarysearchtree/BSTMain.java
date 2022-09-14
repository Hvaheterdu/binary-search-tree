package binarysearchtree;

import java.util.ArrayList;

public class BSTMain extends BSTree<Integer> {

    public static void main(String[] args) {
        BSTree<Integer> b = new BSTree<>();

        // Create nodes
        BSTree<Integer>.Node n8 = b.new Node(8);
        BSTree<Integer>.Node n3 = b.new Node(3);
        BSTree<Integer>.Node n1 = b.new Node(1);
        BSTree<Integer>.Node n4 = b.new Node(4);
        BSTree<Integer>.Node n6 = b.new Node(6);
        BSTree<Integer>.Node n2 = b.new Node(2);
        BSTree<Integer>.Node n10 = b.new Node(10);
        BSTree<Integer>.Node n9 = b.new Node(9);
        BSTree<Integer>.Node n20 = b.new Node(20);
        BSTree<Integer>.Node n25 = b.new Node(25);
        BSTree<Integer>.Node n15 = b.new Node(15);
        BSTree<Integer>.Node n16 = b.new Node(16);

        // add
        System.out.println("\n--- ADD NODES TO BST ---\n");
        b.add(n8.data);
        b.add(n3.data);
        b.add(n1.data);
        b.add(n4.data);
        b.add(n6.data);
        b.add(n2.data);
        b.add(n10.data);
        b.add(n9.data);
        b.add(n20.data);
        b.add(n25.data);
        b.add(n15.data);
        b.add(n16.data);

        // printBST on add
        System.out.println("\n--- PRINT BST AFTER ADD ---\n");
        System.out.println("Original Tree for add function:");
        b.printBST(b.root);
        System.out.println();

        // size
        System.out.println("\n--- BST SIZE ---\n");
        System.out.println("BST height: " + b.size());
        System.out.println();

        // sortedArray in inorder
        System.out.println("--- SORTED BST IN INORDER ORDER ---\n");
        System.out.println("Sorted BST in inorder order:");
        ArrayList<Integer> sortedArr = b.sortedArray();
        for (Integer e : sortedArr) {
            System.out.print(e + " ");
        }
        System.out.println();

        // addAll
        System.out.println("\n--- ADD ALL NODES TO BST ---\n");
        BSTree<Integer> bst = new BSTree<>();
        ArrayList<Integer> nodes = new ArrayList<>();
        int[] node = { 8, 3, 1, 4, 6, 2, 10, 9, 20, 25, 15, 16 };
        for (int e : node) {
            nodes.add(e);
        }
        bst.addAll(nodes);

        // printBST on addAll
        System.out.println("\n--- PRINT BST AFTER ADDALL ---\n");
        System.out.println("Original Tree for addAll function:");
        bst.printBST(bst.root);
        System.out.println();

        // existsInTree
        System.out.println("\n--- CHECK NODE EXISTENCE IN BST ---\n");
        System.out.println("Check whether Node with value 4 exists: " + b.existsInTree(4));

        // find
        System.out.println("\n--- CHECK IF NODE IS IN BST ---\n");
        if (b.find(4) != null) {
            System.out.printf("Node with value %d was found in tree\n", b.find(4).data);
        } else {
            System.out.printf("Node with value %d was not found in tree\n", b.find(4).data);
        }

        // findParent
        System.out.println("\n--- FIND PARENT ---\n");
        System.out.println("Find parent for node with value 8");
        System.out.println("Value of parent node: " + b.findParent(n8));
        System.out.println("\nFind parent for node with value 3");
        System.out.println("Value of parent node: " + b.findParent(n2).data);
        System.out.println("\nFind parent for node with value 16");
        System.out.println("Value of parent node: " + b.findParent(n16).data);
        System.out.println("\nFind parent for node with value 25");
        System.out.println("Value of parent node: " + b.findParent(n25).data);

        // findGrandparent
        System.out.println("\n--- FIND GRANDPARENT ---\n");
        System.out.println("Find grandparent for node with value 8");
        System.out.println("Value of grandparent node: " + b.findGrandparent(n8));
        System.out.println("\nFind grandparent for node with value 2");
        System.out.println("Value of grandparent node: " + b.findGrandparent(n2).data);
        System.out.println("\nFind grandparent for node with value 16");
        System.out.println("Value of grandparent node: " + b.findGrandparent(n16).data);
        System.out.println("\nFind grandparent for node with value 25");
        System.out.println("Value of grandparent node: " + b.findGrandparent(n25).data);

        // findNearestSmallerThan
        System.out.println("\n--- FIND NEAREST SMALLER THAN ---\n");
        System.out.println("Find nearest node smaller than 2: " + b.findNearestSmallerThan(2));
        System.out.println("Find nearest node smaller than 3: " + b.findNearestSmallerThan(3));
        System.out.println("Find nearest node smaller than 25: " + b.findNearestSmallerThan(25));
        System.out.println("Find nearest node smaller than 15: " + b.findNearestSmallerThan(15));
        System.out.println("Find nearest node smaller than 9: " + b.findNearestSmallerThan(9));

        // findInRange
        System.out.println("\n--- FIND NODES IN GIVEN RANGE ---\n");
        System.out.println("Find nodes between 0 and 8:");
        ArrayList<Integer> nodesInRange = b.findInRange(0, 8);
        for (Integer e : nodesInRange) {
            System.out.print(e + " ");
        }
        System.out.println();

        System.out.println("\nFind nodes between 8 and 15");
        ArrayList<Integer> nodesInRange2 = b.findInRange(8, 15);
        for (Integer e : nodesInRange2) {
            System.out.print(e + " ");
        }
        System.out.println();

        System.out.println("\nFind nodes between 15 and 25");
        ArrayList<Integer> nodesInRange3 = b.findInRange(15, 25);
        for (Integer e : nodesInRange3) {
            System.out.print(e + " ");
        }
        System.out.println();

        // remove and print remaining BST
        System.out.println("\n--- REMOVE NODE WITH NO CHILDREN ---\n");
        System.out.println("Remove Node with no children: " + b.remove(2));
        System.out.println("BST after deleting Node with value 2");
        b.printBST(b.root);
        System.out.println();

        // remove and print remaining BST
        System.out.println("\n--- REMOVE NODE WITH ONE CHILDREN ---\n");
        System.out.println("Remove Node with one child: " + b.remove(4));
        System.out.println("BST after deleting Node with value 4");
        b.printBST(b.root);
        System.out.println();

        // remove and print remaining BST
        System.out.println("\n--- REMOVE NODE WITH TWO CHILDREN ---\n");
        System.out.println("Remove Node with two children: " + b.remove(10));
        System.out.println("BST after deleting Node with value 10:");
        b.printBST(b.root);
        System.out.println();
    }
}
