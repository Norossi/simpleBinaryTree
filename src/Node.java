
public class Node {

    public int value;
    private Node left, right, parent;

    public Node(int value, Node parent) {
        this.value = value;
        this.parent = parent;
        this.left = null;
        this.right = null;
    }

    public void addNode (int value) {
        Node currentNode = this;
        while (true) {
            if (value < currentNode.value && currentNode.left != null) {
                currentNode = currentNode.left;
                continue;
            }
            if (value > currentNode.value && currentNode.right != null) {
                currentNode = currentNode.right;
                continue;
            }
            if (value < currentNode.value && currentNode.left == null) {
                currentNode.left = new Node(value, currentNode);
                return;
            }
            if (value > currentNode.value && currentNode.right == null) {
                currentNode.right = new Node(value, currentNode);
                return;
            }
        }
    }

    public void depthNode() {
        if (this.left != null) this.left.depthNode();
        System.out.print(this.value + " ");
        if (this.right != null) this.right.depthNode();
    }

    public Node prev() {
        if (this.left != null) return this.left.max();
        else {
            Node currentNode = this, predecessor = this.parent;
            while(predecessor != null && currentNode == predecessor.left) {
                currentNode = predecessor;
                predecessor = currentNode.parent;
            }
            return predecessor;
        }
    }

    public Node next() {
        if (this.right != null) return this.right.min();
        else {
            Node currentNode = this, successor = this.parent;
            while (successor != null && currentNode == successor.left) {
                currentNode = successor;
                successor = successor.parent;
            }
            return successor;
        }
    }

    public Node min() {
        Node node = this;
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public Node max() {
        Node node = this;
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    public Node searchNode(int value) {
        Node node = this;
        while(true) {
            if (value < node.value && node.left != null) {
                node = node.left;
                continue;
            }
            if (value > node.value && node.right != null) {
                node = node.right;
                continue;
            }
            if (value == node.value) return node;
            else return null;
        }
    }

    public void deleteNode() {
        if (this.left == null && this.right == null) {
            if (this == this.parent.right) {
                this.parent.right = null;
                this.parent = null;
                return;
            }
            if (this == this.parent.left) {
                this.parent.left = null;
                this.parent = null;
                return;
            }
        }
        if (this.left == null && this.right != null) {
            this.right.parent = this.parent;
            this.parent.right = this.right;
            this.parent = null;
            this.right = null;
            return;
        }
        if (this.left != null && this.right == null) {
            this.left.parent = this.parent;
            this.parent.left = this.left;
            this.parent = null;
            this.left = null;
        }
        else {
            Node successor = this.next();
            this.value = successor.value;
            successor.deleteNode();
        }
    }
}
