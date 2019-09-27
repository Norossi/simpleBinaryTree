public class Main {

    public static void main(String[] args) {

        Tree test = new Tree(45, 23, 44, 88, 1, 100);
        System.out.println("kek");
        System.out.println("Обходим в глубину");
        test.depthTree();
        System.out.println("Delete 23");
        test.delete(23);
        test.depthTree();

    }
}
