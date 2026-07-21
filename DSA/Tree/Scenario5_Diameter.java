class Node {
    int val;
    Node left, right;
}

class Scenario5 {
    int diameter = 0;

    int longestPath(Node root) {
        diameter = 0;
        height(root);
        return diameter;
    }

    int height(Node node) {
        if (node == null) return -1;

        int left = height(node.left);
        int right = height(node.right);

        diameter = Math.max(diameter, left + right + 2);
        return Math.max(left, right) + 1;
    }
}
