class Node {
    int val;
    Node left, right;
}

class Scenario4 {
    int height(Node node) {
        if (node == null) return -1;
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    boolean isTooDeep(Node root, int threshold) {
        return height(root) > threshold;
    }
}
