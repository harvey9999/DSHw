package pracmas;

import java.util.TreeMap;

public class binarySerach {
    public int firstKey(Node t) {
        if (t.left == null) {
            return t.key;
        } else return firstKey(t.left);
    }

    public int secondKey(Node t) {
        int keyFirst = firstKey(t);
        return secondKeyHelper(t, keyFirst);
    }

    private int secondKeyHelper(Node t, int keyFirst) {
        if (t.left != null) {
            if (t.left.left == null && t.left.key == keyFirst && t.left.right == null) return t.key;
            else return secondKeyHelper(t.left, keyFirst);
        } else {
            return firstKey(t.right);
        }
    }

    public class Node<K> {
        int key;
        Node<K> left;
        Node<K> right;
    }
}
