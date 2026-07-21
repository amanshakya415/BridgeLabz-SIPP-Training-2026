import java.util.*;

class Node {
    int val;
    Node left, right;

    Node(int v) {
        val = v;
    }
}

class Scenario1 {
    void inorder(Node node, List<Integer> result) {
        if (node == null) return;
        inorder(node.left, result);
        result.add(node.val);
        inorder(node.right, result);
    }

    List<Integer> getSortedLeaderboard(Node root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }
}
