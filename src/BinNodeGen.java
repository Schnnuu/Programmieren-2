/**
 * Generic Binary Tree Node.
 *
 * @param <E> Type of data stored in the node, must be Comparable.
 */
public class BinNodeGen<E extends Comparable<E>> {
    E data; // Daten im Knoten
    BinNodeGen<E> left, right; // Verweise auf linke und rechte Kinder

    // Konstruktoren für BinNode

    /**
     * Standardkonstruktor initialisiert linke und rechte Kinder als null.
     */
    BinNodeGen() {
        left = right = null;
    }

    /**
     * Konstruktor, um einen Knoten mit gegebenen Daten zu erstellen, beide Kinder sind null.
     *
     * @param data Die Daten für den Knoten.
     */
    BinNodeGen(E data) {
        this.data = data;
        left = right = null;
    }

    /**
     * Konstruktor, um einen Knoten mit gegebenen Daten, linkem Kind und rechtem Kind zu erstellen.
     *
     * @param d Die Daten für den Knoten.
     * @param l Das linke Kind des Knotens.
     * @param r Das rechte Kind des Knotens.
     */
    BinNodeGen(E d, BinNodeGen<E> l, BinNodeGen<E> r) {
        data = d;
        left = l;
        right = r;
    }
}
