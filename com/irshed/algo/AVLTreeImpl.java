package Algorithm.com.irshed.algo;

public class AVLTreeImpl {

    public Node root;

    public class Node {
        public int val;
        public int balancingFactor;
        public int height;
        public Node left, right;

        public Node(int val) {
            this.val = val;
            this.balancingFactor = 0;
            this.height = 0;
            left = null;
            right = null;
        }
    }

    public void insert(int val) {
        Node newNode = new Node(val);
        if (root == null) {
            root = newNode;
        } else {
            root = insertUtil(root, newNode);
        }
        balance(root);
    }

    public Node insertUtil(Node root, Node newNode) {
        if (root == null)
            return newNode;

        if (root.val < newNode.val) {
            root.right = insertUtil(root.right, newNode);
        } else if (root.val > newNode.val) {
            root.left = insertUtil(root.left, newNode);
        }
        return balance(root);
    }

    public void remove(int val) {
        removeUtil(root, val);
        balance(root);
    }

    public Node removeUtil(Node root, int val) {
        if (root == null)
            return null;
        if (root.val > val) {
            root.left = removeUtil(root.left, val);
        } else if (root.val < val) {
            root.right = removeUtil(root.right, val);
        } else {

            if(root.left == null && root.right==null)
                return null;
            else if (root.left == null)
                root = root.right;
            else if (root.right == null)
                root = root.left;
            else {
                int minVal = minimum(root.right);
                root.val = minVal;
                root.right = removeUtil(root.right, minVal);
            }
        }
        return balance(root);
    }

    public int minimum(Node root) {
        int value = root.val;
        while (root.left != null) {
            value = root.left.val;
            root = root.left;
        }
        return value;
    }

    public Node balance(Node root) {
        if (root == null)
            return null;

        update(root);
        int bf = root.balancingFactor;
        if (bf == -2) {
            if (root.left.balancingFactor > 0) {
                root.left = leftRotation(root.left);
            }
            root = rightRotation(root);
        } else if (bf == 2) {
            if (root.right.balancingFactor < 0)
                root.right = leftRotation(root.right);
            root = rightRotation(root);
        }
        update(root);
        return root;
    }

    public void update(Node node) {
        if (node == null)
            return;

        int left = (node.left != null) ? node.left.height : -1;
        int right = (node.right != null) ? node.right.height : -1;

        node.height = 1 + Math.max(left, right);
        node.balancingFactor = right - left;
    }

    public Node leftRotation(Node root) {
        Node nextRoot = root.left;
        root.left = nextRoot.right;
        nextRoot.right = root;

        update(nextRoot);
        update(root);
        return nextRoot;
    }

    public Node rightRotation(Node root) {
        Node nextRoot = root.right;
        root.right = nextRoot.left;
        nextRoot.left = root;

        update(nextRoot);
        update(root);
        return nextRoot;
    }

}