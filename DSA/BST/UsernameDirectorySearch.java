class node {
    int val;
    node left;
    node right;

    node(int val) {
        this.val = val;
    }
}

public class UsernameDirectorySearch {
    public boolean search(node root, int target) {
        node current = root;
        while (current != null) {
            if (target == current.val) {
                return true;
            }
            current = (target < current.val) ? current.left : current.right;
        }
        return false;
    }
}