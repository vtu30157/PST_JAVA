import java.io.*;
import java.util.*;

abstract class Tree {
    private int value;
    private int depth;
    private int color;

    public Tree(int value, int depth, int color) {
        this.value = value;
        this.depth = depth;
        this.color = color;
    }

    public abstract void accept(TreeVis visitor);

    public int getValue() { return value; }
    public int getDepth() { return depth; }
    public int getColor() { return color; }
}

class TreeNode extends Tree {
    private ArrayList<Tree> children = new ArrayList<Tree>();

    public TreeNode(int value, int depth, int color) {
        super(value, depth, color);
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
    public TreeLeaf(int value, int depth, int color) {
        super(value, depth, color);
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

class SumInLeavesVisitor extends TreeVis {
    private int sum = 0;

    public int getResult() {
        return sum;
    }

    public void visitNode(TreeNode node) {
    }

    public void visitLeaf(TreeLeaf leaf) {
        sum += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    private static final int MOD = 1_000_000_007;
    private long product = 1;

    public int getResult() {
        return (int) (product % MOD);
    }

    public void visitNode(TreeNode node) {
        if (node.getColor() == 0) {
            product = (product * node.getValue()) % MOD;
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == 0) {
            product = (product * leaf.getValue()) % MOD;
        }
    }
}

class FancyVisitor extends TreeVis {
    private int nonLeafEvenDepthSum = 0;
    private int greenLeafSum = 0;

    public int getResult() {
        return Math.abs(nonLeafEvenDepthSum - greenLeafSum);
    }

    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 == 0) {
            nonLeafEvenDepthSum += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == 1) {
            greenLeafSum += leaf.getValue();
        }
    }
}

public class Solution {

    public static Tree solve() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[] values = new int[n + 1];
        int[] colors = new int[n + 1];
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for (int i = 1; i <= n; i++) {
            values[i] = scan.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            colors[i] = scan.nextInt();
        }

        for (int i = 0; i < n - 1; i++) {
            int u = scan.nextInt();
            int v = scan.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        Tree[] builtNodes = new Tree[n + 1];
        int[] depth = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Map<Integer, Integer> parent = new HashMap<>();

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        depth[1] = 0;

        List<Integer> order = new ArrayList<>();

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            order.add(cur);
            for (int next : adj.get(cur)) {
                if (!visited[next]) {
                    visited[next] = true;
                    depth[next] = depth[cur] + 1;
                    parent.put(next, cur);
                    queue.add(next);
                }
            }
        }

        for (int node : order) {
            boolean isLeaf = adj.get(node).size() == 1 && node != 1
                    || (node == 1 && adj.get(node).isEmpty());
            if (isLeaf) {
                builtNodes[node] = new TreeLeaf(values[node], depth[node], colors[node]);
            } else {
                builtNodes[node] = new TreeNode(values[node], depth[node], colors[node]);
            }
        }

        for (int node : order) {
            if (builtNodes[node] instanceof TreeNode) {
                TreeNode tn = (TreeNode) builtNodes[node];
                for (int next : adj.get(node)) {
                    if (parent.containsKey(next) && parent.get(next) == node) {
                        tn.addChild(builtNodes[next]);
                    }
                }
            }
        }

        return builtNodes[1];
    }

    public static void main(String[] args) {
        Tree root = solve();

        SumInLeavesVisitor sumInLeavesVisitor = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor productOfRedNodesVisitor = new ProductOfRedNodesVisitor();
        FancyVisitor fancyVisitor = new FancyVisitor();

        root.accept(sumInLeavesVisitor);
        root.accept(productOfRedNodesVisitor);
        root.accept(fancyVisitor);

        int sum = sumInLeavesVisitor.getResult();
        int product = productOfRedNodesVisitor.getResult();
        int fancy = fancyVisitor.getResult();

        System.out.println(sum);
        System.out.println(product);
        System.out.println(fancy);
    }
}