package Lab5_2;

public class Lab5_2 {
    public static void main(String[] args) {
        GardenTree[] trees = new GardenTree[3];
        trees[0] = new AppleTree("Антоновка");
        trees[1] = new CherryTree();
        trees[2] = new PearTree("Дюшес");

        for (int i = 1; i < 5; i++) {
            for (GardenTree tree : trees) {
                tree.grow();
                System.out.println(tree);
            }
        }

        System.out.println("Деревья, которые нужно пересадить:");
        for (GardenTree tree : trees) {
            if (tree.needsReplanting()) {
                System.out.println(tree);
            }
        }

    }
}
