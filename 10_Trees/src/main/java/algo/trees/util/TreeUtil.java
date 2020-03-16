package algo.trees.util;

import algo.trees.AVLNode;

public class TreeUtil {

    public static int getHeight(AVLNode node) {
        if (node == null)
            return 0;

        if (node.getLeft() == null && node.getRight() == null)
            return 0;

        int left = node.getLeft() != null ? node.getHeight() : 0;
        int right = node.getRight() != null ? node.getHeight() : 0;

        return Math.max(left, right) + 1;
    }

    public static int getBalance() {
        return 0;
    }

}
