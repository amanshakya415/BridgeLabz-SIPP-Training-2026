class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
    }
}

public class EmployeeDirectoryInsertion {
    public Node insert(Node node, int id) {
        if (node == null) {
            return new Node(id);
        }
        if (id < node.val) {
            node.left = insert(node.left, id);
        } else if (id > node.val) {
            node.right = insert(node.right, id);
        }
        return node;
    }
}