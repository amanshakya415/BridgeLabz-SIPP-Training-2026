class Node {
    int val;
    Node left, right;
}

class Scenario6 {
    void deleteNode(Node node) {
    }

    void deleteTree(Node root) {
        if (root == null) return;

        deleteTree(root.left);
        deleteTree(root.right);
        deleteNode(root);
    }
}
