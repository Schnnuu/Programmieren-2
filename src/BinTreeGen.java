public class BinTreeGen<E extends Comparable<E>> implements BinTreeGenInterface<E> {

    private BinNodeGen<E> root;

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

    public int countNodes(BinNodeGen<E> nodeGen){
        if (nodeGen == null) {
            return 0;
        }

        int leftCount = countNodes(nodeGen.left);
        int rightCount = countNodes(nodeGen.right);

        // Count the current node
        return leftCount + rightCount + 1;
    }



    @Override
    public boolean insertNode(E item) {
        if ( item == null) {
            return false;
        }
        BinNodeGen<E> newNode = new BinNodeGen<>(item);
        if(root == null) {
            root = newNode;
            return true;
        }

        return insertNode(item, root);
    }

    private boolean insertNode(E item, BinNodeGen<E> node) {
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
    public BinNodeGen<E> find(E item) throws NullPointerException {
        if (root == null) {
            return null;
        }
        if (item == null) throw new NullPointerException("Item cannot be null.");
        return find(item, root);
    }

    private BinNodeGen<E> find(E item, BinNodeGen<E> nodeGen) {
        if (nodeGen == null){
            return null;
        }
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

        System.out.print(nodeGen.data);
        toString(result,nodeGen.left);
        toString(result,nodeGen.right);
    }
}