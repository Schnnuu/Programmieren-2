public class BinTreeGen<E extends Comparable<E>> implements BinTreeGenInterface {

    private BinNodeGen root = null;

    BinTreeGen() {
        root = null;
    }

    BinTreeGen(BinNodeGen r) {
        root = r;
    }



    @Override
    public int countNodes() {
        return countNodes(root);
    }

    public int countNodes(BinNodeGen nodeGen){
        if (nodeGen == null) {
            return 0;
        }

        int leftCount = countNodes(nodeGen.left);
        int rightCount = countNodes(nodeGen.right);

        // Count the current node
        return leftCount + rightCount + 1;
    }



    @Override
    public boolean insertNode(Comparable item) {
        if (item == null) {
            return false;
        }

        if (root.data == null) {
            // This node is empty, insert the item here
            root.data = item;
            return true;
        }

        BinNodeGen<E> existingNode = find(item);

        if (existingNode != null) {
            // Item already exists in the tree
            return false;
        }

        // The item does not exist in the tree, proceed with insertion
        return insertNode(item, root);
    }

    private boolean insertNode(Comparable item, BinNodeGen<E> node) {
        int comparison = item.compareTo(node.data);

        if (comparison < 0) {
            // Insert into the left subtree
            if (node.left == null) {
                node.left = new BinNodeGen<>(item);
                return true;
            } else {
                return insertNode(item, node.left);
            }
        } else {
            // Insert into the right subtree
            if (node.right == null) {
                node.right = new BinNodeGen<>(item);
                return true;
            } else {
                return insertNode(item, node.right);
            }
        }
    }



    @Override
    public BinNodeGen<E> find(Comparable item) throws NullPointerException {
        if (item == null) throw new NullPointerException("Item cannot be null.");
        return find(item, root);
    }

    private BinNodeGen<E> find(Comparable item, BinNodeGen nodeGen) {
        int compareResult = item.compareTo(nodeGen.data);
        if (compareResult == 0) {
            return nodeGen;
        } else if (compareResult < 0 && nodeGen.left != null) {
            // Search in the left subtree
            return find(item, nodeGen.left);
        } else if (compareResult > 0 && nodeGen.right != null) {
            // Search in the right subtree
            return find(item, nodeGen.right);
        } else {
            // Item not found
            return null;
        }
    }
    @Override
    public String toString() throws IllegalStateException{
        if (root == null) throw new IllegalStateException("Empty Tree");
    String result = new String();
    toString(result,root);
    return result.toString();
    }

    public void toString(String result, BinNodeGen nodeGen) {
        if (nodeGen == null){
            return;
        }

        System.out.print(nodeGen.data + " ");
        toString(result,nodeGen.left);
        toString(result,nodeGen.right);

    }
}