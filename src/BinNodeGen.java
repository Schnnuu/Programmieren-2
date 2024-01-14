public class BinNodeGen<E extends Comparable<E>> {
    E data; // Data stored in the node
    BinNodeGen<E> left, right; // References to left and right children

    // Constructors for BinNode

    // Default constructor initializes left and right children as null
    BinNodeGen() {
        left = right = null;
    }

    // Constructor to create a node with given data and both children as null
    BinNodeGen(E data) {
        this.data = data;
        left = right = null;
    }

    // Constructor to create a node with given data, left child, and right child
    BinNodeGen(E d, BinNodeGen l, BinNodeGen r) {
        data = d;
        left = l;
        right = r;
    }
}
