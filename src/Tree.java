
public class Tree {

    public Node root;

    public Tree(int value) {
        this.root = new Node(value, null);
    }

    public Tree() {
        this.root = null;
    }

    public Tree(int ... values) {
        this.root = new Node(values[0], null);
        for (int i = 1; i < values.length; i++) {
            this.root.addNode(values[i]);
        }
    }



    public void add(int value) {

        if (this.root == null) {
            root = new Node(value, null);
            return;
        }
        this.root.addNode(value);
    }

    public void depthTree () {
        this.root.depthNode();
    }

    public Node search(int value) {
        return this.root.searchNode(value);
    }

    public void delete(int value) {
        this.root.searchNode(value).deleteNode();
    }
}
