public class BinarySearchTreeTest {

    public static void main(String[] args){

        System.out.println("-- Add Tests --");
        BinarySearchTree<Integer> intBST = new BinarySearchTree<>();
        intBST.add(1);
        intBST.add(4);
        intBST.add(12);
        intBST.add(3);
        intBST.add(55);
        intBST.add(45);
        intBST.add(32);
        intBST.add(89);
        intBST.add(2);
        intBST.add(95);
        intBST.add(62);
        System.out.println((intBST.getSize()));
        intBST.traversePreOrder();
        intBST.traversePostOrder();
        intBST.traverseInOrder();

        System.out.println("\n-- Search Tests --");
        System.out.println("Result of searching for four: " + intBST.search(4));
        System.out.println("Result of searching for 100: " + intBST.search(100));


        System.out.println("\n-- Minimum Tests --");
        System.out.println("Minimum node: " + intBST.findMinNode());

        System.out.println("\n-- Remove Tests --");
        intBST.remove(4);
        intBST.remove(95);
        System.out.println((intBST.getSize()));
        intBST.traversePreOrder();
        intBST.traversePostOrder();
        intBST.traverseInOrder();

        System.out.println("\n-- Add Tests (Strings) --");
        BinarySearchTree<String> strBST = new BinarySearchTree<>();
        strBST.add("juliett");
        strBST.add("golf");
        strBST.add("bravo");
        strBST.add("echo");
        strBST.add("alpha");
        strBST.add("sierra");
        strBST.add("zulu");
        strBST.add("india");
        strBST.add("lima");
        strBST.add("november");
        strBST.add("mike");
        strBST.traversePreOrder();
        strBST.traversePostOrder();
        strBST.traverseInOrder();

    }
}
