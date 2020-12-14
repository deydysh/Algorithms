package Tree.RedBlack;

public class RedBlackTree {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private static class Node {

        int value;
        Node left, right;
        boolean color;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
            this.color = RED;
        }
    }

    private Node root;
    private int size;

    public RedBlackTree() {
        root = null;
        size = 0;
    }

    private boolean isRed(Node node) {
        if (node == null) return BLACK;
        return node.color;
    }

    /**
     * //      node                                        x
     * //     /    \                                    /    \
     * //    T1     x           --------->            node    T3
     * //         /   \                              /    \
     * //       T2     T3                           T1    T2
     */

    private Node leftRotate(Node node) {
        Node x = node.right;
        node.right = x.left;
        x.left = node;
        x.color = node.color;
        node.color = RED;
        return x;
    }

    /**
     * //      node                                         x
     * //     /    \                                      /   \
     * //    x     T2           --------->               y   node
     * //  /  \                                             /    \
     * // y   T1                                           T1    T2
     */

    private Node rightRotate (Node node) {
        Node x = node.left;
        node.left = x.right;
        x.right = node;
        x.color = node.color;
        node.color = RED;
        return x;
    }

    private void flipColors(Node node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    private Node addRecursive(Node node, int value) {
        if (node == null) {
            size++;
            return new Node(value);
        }
        if (value <= node.value) node.left = addRecursive(node.left, value);
        if (value > node.value) node.right = addRecursive(node.right, value);

        if (isRed(node.right) && !isRed(node.left)) node = leftRotate(node);
        if (isRed(node.left) && isRed(node.left.left)) node = rightRotate(node);
        if (isRed(node.left) && isRed(node.right)) flipColors(node);

        return node;
    }

    public void add(int value) {
        root = addRecursive(root, value);
        root.color = BLACK;
    }

    private Node getNode (Node node, int value) {
        if (node == null) return null;
        if (value == node.value) return node;
        return value < node.value ? getNode(node.left, value) : getNode(node.right, value);
    }

    private Node minimum (Node node) {
        if (node.left == null) return node;
        return minimum(node.left);
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    private Node removeRecursive(Node node, int value) {
        if (node == null) return null;
        if (value < node.value) {
            node.left = removeRecursive(node.left, value);
            return node;
        }
        if (value > node.value) {
        node.right = removeRecursive(node.right, value);
        return node;
        }
        //value == node.value
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        Node successor = minimum(node.right);
        successor.right = removeMin(node.right);
        successor.left = node.left;
        node.left = node.right = null;

        return successor;
    }

    public Integer remove (int value) {
        Node node = getNode(root, value);
        if (node != null) {
            root = removeRecursive(root, value);
            return node.value;
        }
        return null;
    }

    public boolean contains(int value) {
        return getNode(root, value) != null;
    }

    public Integer get(int value) {
        Node node = getNode(root, value);
        return node == null ? null : node.value;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
