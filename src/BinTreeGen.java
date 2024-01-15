/**
 * Binary Tree Implementation.
 *
 * @param <E> Type of elements stored in the tree, must be Comparable.
 */
public class BinTreeGen<E extends Comparable<E>> implements BinTreeGenInterface<E> {

    private BinNodeGen<E> root; // Wurzel des Binärbaums

    /**
     * Konstruktor für einen leeren Binärbaum.
     */
    BinTreeGen() {
        root = null;
    }

    /**
     * Konstruktor für einen Binärbaum mit gegebener Wurzel.
     *
     * @param r Die Wurzel des Binärbaums.
     */
    BinTreeGen(BinNodeGen<E> r) {
        root = r;
    }

    /**
     * Zählt die Anzahl der Knoten im Baum.
     *
     * @return Anzahl der Knoten im Baum.
     */
    @Override
    public int countNodes() {
        return countNodes(root);
    }

    /**
     * Hilfsmethode, die rekursiv die Anzahl der Knoten im Unterbaum mit gegebener Wurzel zählt.
     *
     * @param nodeGen Die Wurzel des Unterbaums.
     * @return Anzahl der Knoten im Unterbaum.
     */
    public int countNodes(BinNodeGen<E> nodeGen) {
        if (nodeGen == null) {
            return 0;
        }

        int leftCount = countNodes(nodeGen.left);
        int rightCount = countNodes(nodeGen.right);

        // Zähle den aktuellen Knoten
        return leftCount + rightCount + 1;
    }

    /**
     * Fügt einen Knoten mit gegebenem Element in den Baum ein.
     *
     * @param item Das einzufügende Element.
     * @return True, wenn das Einfügen erfolgreich war, sonst False.
     */
    @Override
    public boolean insertNode(E item) {
        if (item == null) {
            return false;
        }
        BinNodeGen<E> newNode = new BinNodeGen<>(item);
        if (root == null) {
            root = newNode;
            return true;
        }

        return insertNode(item, root);
    }

    /**
     * Hilfsmethode, die rekursiv ein Element in den Unterbaum mit gegebener Wurzel einfügt.
     *
     * @param item Das einzufügende Element.
     * @param node Die Wurzel des Unterbaums.
     * @return True, wenn das Einfügen erfolgreich war, sonst False.
     */
    private boolean insertNode(E item, BinNodeGen<E> node) {
        int comparison = item.compareTo(node.data);

        if (comparison < 0) {
            // Einfügen in den linken Unterbaum
            if (node.left == null) {
                node.left = new BinNodeGen<>(item);
                return true;
            } else {
                return insertNode(item, node.left);
            }
        } else {
            // Einfügen in den rechten Unterbaum
            if (node.right == null) {
                node.right = new BinNodeGen<>(item);
                return true;
            } else {
                return insertNode(item, node.right);
            }
        }
    }

    /**
     * Sucht nach einem Element im Baum und gibt den zugehörigen Knoten zurück.
     *
     * @param item Das zu suchende Element.
     * @return Der Binärbaumknoten, der das gesuchte Element enthält, oder null, wenn nicht gefunden.
     * @throws NullPointerException wenn das gesuchte Element null ist.
     */
    @Override
    public BinNodeGen<E> find(E item) throws NullPointerException {
        if (root == null) {
            return null;
        }
        if (item == null) throw new NullPointerException("Item cannot be null.");
        return find(item, root);
    }

    /**
     * Hilfsmethode, die rekursiv nach einem Element im Unterbaum mit gegebener Wurzel sucht.
     *
     * @param item Das zu suchende Element.
     * @param nodeGen Die Wurzel des Unterbaums.
     * @return Der Binärbaumknoten, der das gesuchte Element enthält, oder null, wenn nicht gefunden.
     */
    private BinNodeGen<E> find(E item, BinNodeGen<E> nodeGen) {
        if (nodeGen == null) {
            return null;
        }
        int compareResult = item.compareTo(nodeGen.data);
        if (compareResult == 0) {
            return nodeGen;
        } else if (compareResult < 0 && nodeGen.left != null) {
            // Suche im linken Unterbaum
            return find(item, nodeGen.left);
        } else if (compareResult > 0 && nodeGen.right != null) {
            // Suche im rechten Unterbaum
            return find(item, nodeGen.right);
        } else {
            // Element nicht gefunden
            return null;
        }
    }

    /**
     * Gibt eine String-Repräsentation des Baums zurück.
     *
     * @return String-Repräsentation des Baums.
     * @throws IllegalStateException wenn der Baum leer ist.
     */
    @Override
    public String toString() throws IllegalStateException {
        if (root == null) throw new IllegalStateException("Empty Tree");
        StringBuilder result = new StringBuilder();
        toString(result, root);
        return result.toString();
    }

    /**
     * Hilfsmethode, die rekursiv eine String-Repräsentation des Unterbaums mit gegebener Wurzel erstellt.
     *
     * @param result Der StringBuilder für die resultierende String-Repräsentation.
     * @param nodeGen Die Wurzel des Unterbaums.
     */
    public void toString(StringBuilder result, BinNodeGen<E> nodeGen) {
        if (nodeGen == null) {
            return;
        }

        result.append(nodeGen.data);
        toString(result, nodeGen.left);
        toString(result, nodeGen.right);
    }
}
