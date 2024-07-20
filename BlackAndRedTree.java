
import java.util.Scanner;

public class BlackAndRedTree {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {

        int key;
        Node left, right;
        boolean color;

        Node(int key) {
            this.key = key;
            this.color = RED; // Новая нода всегда красная
        }
    }

    private Node root;

    public void insert(int key) {
        root = insert(root, key);
        root.color = BLACK; // Корень всегда чёрный
    }

    private Node insert(Node h, int key) {
        if (h == null) {
            return new Node(key); // Вставляем новую ноду
        }
        if (key < h.key) {
            h.left = insert(h.left, key);
        } else if (key > h.key) {
            h.right = insert(h.right, key);
        } else {
            return h; // Если ключ уже существует, просто возвращаем ноду
        }

        // Балансировка дерева
        if (isRed(h.right) && !isRed(h.left)) {
            h = rotateLeft(h);
        }
        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }
        if (isRed(h.left) && isRed(h.right)) {
            flipColors(h);
        }

        return h;
    }

    private boolean isRed(Node x) {
        if (x == null) {
            return false;
        }
        return x.color == RED;
    }

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    // Метод для печати дерева
    public void printTree() {
        printTree(root, "", true);
    }

    private void printTree(Node node, String indent, boolean last) {
        if (node != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("R----");
                indent += "   ";
            } else {
                System.out.print("L----");
                indent += "|  ";
            }
            String color = node.color == RED ? "RED" : "BLACK";
            System.out.println(node.key + "(" + color + ")");
            printTree(node.left, indent, false);
            printTree(node.right, indent, true);
        }
    }

    public static void main(String[] args) {
        BlackAndRedTree tree = new BlackAndRedTree();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите элементы дерева (введите 'exit' для завершения):");
            while (true) {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("exit")) {
                    break;
                }

                try {
                    int key = Integer.parseInt(input);
                    tree.insert(key);
                    tree.printTree();
                    System.out.println();
                } catch (NumberFormatException e) {
                    System.out.println("Пожалуйста, введите корректное число.");
                }
            }
        }
        System.out.println("Итоговое дерево:");
        tree.printTree(); // Опционально, для проверки структуры дерева
    }
}
