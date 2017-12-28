package chris.HackerRank;

import java.util.ArrayList;
import java.io.*;
import java.math.*;

import java.util.Scanner;

enum Color {
    RED, GREEN
}

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis {
    public abstract int getResult();

    public abstract void visitNode(TreeNode node);

    public abstract void visitLeaf(TreeLeaf leaf);

}

class DebugVisitor extends TreeVis {
    public int getResult() {
        return 0;
    }

    public void visitNode(TreeNode node) {
        System.out.println("Node, value: " + node.getValue() + ", Color: "
                + node.getColor() + ", Depth: " + node.getDepth());
    }

    public void visitLeaf(TreeLeaf leaf) {
        System.out.println("Leaf, value: " + leaf.getValue() + ", Color: "
                + leaf.getColor() + ", Depth: " + leaf.getDepth());
    }
}

class SumInLeavesVisitor extends TreeVis {
    private int sum = 0;

    public int getResult() {
        return sum;
    }

    public void visitNode(TreeNode node) {
        //implement this
    }

    public void visitLeaf(TreeLeaf leaf) {
        sum += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    private BigInteger product = BigInteger.valueOf(1);

    private BigInteger getNewProduct(Tree nodeOrLeaf) {
        if (nodeOrLeaf.getColor() == Color.RED) {
            return product.multiply(BigInteger.valueOf(nodeOrLeaf.getValue())).mod(BigInteger.valueOf(1000000007));
        } else {
            return product;
        }
    }

    public int getResult() {
        return product.intValue();
    }

    public void visitNode(TreeNode node) {
        product = getNewProduct(node);
    }

    public void visitLeaf(TreeLeaf leaf) {
        product = getNewProduct(leaf);
    }
}

class FancyVisitor extends TreeVis {
    private int sumOfValsAtEvenDepthOfNonLeafs = 0;
    private int sumOfValsOfGreenLeafs = 0;

    public int getResult() {
        return Math.abs(sumOfValsAtEvenDepthOfNonLeafs - sumOfValsOfGreenLeafs);
    }

    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 == 0)
            sumOfValsAtEvenDepthOfNonLeafs += node.getValue();
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.GREEN) {
            sumOfValsOfGreenLeafs += leaf.getValue();
        }
    }
}

public class HrTreeVisitor {

    public static Tree solve(Scanner sc) {
        //read the tree from STDIN and return its root as a return value of this function

        //Scanner sc = new Scanner(System.in);
        int numOfNodes = sc.nextInt();

        // hold the tree nodes in an array to easily reference them
        int[] nodeVals = new int[numOfNodes];
        Color[] nodeColors = new Color[numOfNodes];
        int[][] nodeEdges = new int[numOfNodes - 1][2];
        Tree[] nodeArray = new Tree[numOfNodes];
        boolean[] isTreeANode = new boolean[numOfNodes];
        for (int i = 0; i < numOfNodes; i++) {
            nodeVals[i] = sc.nextInt();
        }
        sc.nextLine();
        for (int i = 0; i < numOfNodes; i++) {
            nodeColors[i] = sc.nextInt() == 0 ? Color.RED : Color.GREEN;
        }
        sc.nextLine();

        // read in n-1 pairs of connected nodes
        // the node index values are referenced from 1-n, so decrease to get array index value
        // NOTE: we're not building the tree on this first pass b/c we don't know if the
        // second of a pair is a leaf or a node until we read it all in
        for (int i = 0; i < numOfNodes - 1; i++) {
            // if this is the first of a pair, that means that nodeIndex is a node, not a leaf
            int idxWhichIsANode = sc.nextInt() - 1;
            isTreeANode[idxWhichIsANode] = true;
            nodeEdges[i][0] = idxWhichIsANode;
            nodeEdges[i][1] = sc.nextInt() - 1;
            System.out.println("i: " + i + ", from: " + nodeEdges[i][0] + " to: " + nodeEdges[i][1]);
            if (sc.hasNext())
                sc.nextLine();
            else
                numOfNodes = i + 1;
        }

        System.out.println("numOfNodes: " + numOfNodes);

        // create nodes or leafs.
        // start with root
        nodeArray[0] = new TreeNode(nodeVals[0], nodeColors[0], 0);

        // now, go through and build the tree by walking through the nodeEdges
        // and adding each leaf to the connecting node
        // I am assuming that we're not going to get a node->leaf for a node we haven't already added
        for (int i = 0; i < numOfNodes - 1; i++) {
            int nodeIdx = nodeEdges[i][0];
            int targetNodeIdx = nodeEdges[i][1];
            TreeNode recNode = (TreeNode) nodeArray[nodeIdx];

            System.out.println("nodeIdx: " + nodeIdx + " targetNodeIdx: " + targetNodeIdx + " recNode: " + recNode);

            Tree targetNodeOrLeaf = isTreeANode[targetNodeIdx] ?
                    new TreeNode(nodeVals[targetNodeIdx], nodeColors[targetNodeIdx], recNode.getDepth() + 1) :
                    new TreeLeaf(nodeVals[targetNodeIdx], nodeColors[targetNodeIdx], recNode.getDepth() + 1);
            nodeArray[targetNodeIdx] = targetNodeOrLeaf;
            recNode.addChild(targetNodeOrLeaf);
        }

        return nodeArray[0];
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("hrtreevis1.txt"));
        Tree root = solve(sc);
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}
