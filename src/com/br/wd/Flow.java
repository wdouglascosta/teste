package com.br.wd;

import javax.swing.*;

public class Flow {

    private Node root = createRoot();

    private static Node createRoot() {
        Node root = new Node("massa");
        root.setLeft(new Leaf("Lasanha"));
        root.setRight(new Leaf("Bolo de Chocolate"));
        return root;
    }

    public void start() {

        lookFor(root);
    }

    private void lookFor(Node node) {
        int answer = showMessage(node);
        if (answer == JOptionPane.YES_OPTION) {
            if (node.leftLastLayer()) {
                int i = showMessage(node.getLeft());
                if (i == JOptionPane.YES_OPTION) {
                    successMessage();
                } else {
                    node.setLeft(createNew(node.getLeft()));
                }
            } else {
                lookFor(node.getLeft());
            }

        } else {
            if (node.rightLastLayer()) {
                int j = showMessage(node.getRight());
                if (j == JOptionPane.YES_OPTION) {
                    successMessage();
                } else {
                    node.setRight(createNew(node.getRight()));
                }
            } else {
                lookFor(node.getRight());
            }

        }
    }

    private void successMessage() {
        JOptionPane.showMessageDialog (null,
                "Parece que acertei de novo",
                "Fim",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private int showMessage(Node node) {

        return JOptionPane.showConfirmDialog(null,
                "O prato que você pensou é " + node.getValue() + "?",
                null,
                JOptionPane.YES_NO_OPTION);
    }

    private Node createNew(Node node) {
        String newFood = JOptionPane.showInputDialog(null,
                "Qual prato você pensou?",
                "Desisto",
                JOptionPane.QUESTION_MESSAGE);


        String newNode = JOptionPane.showInputDialog(null,
                newFood + " é " + "_______" + " e " + node.getValue() + " não é",
                "Novo",
                JOptionPane.QUESTION_MESSAGE);

        Leaf leaf = new Leaf(newFood);
        Node subs = new Node(newNode);
        subs.setLeft(leaf);
        subs.setRight(node);
        return subs;
    }


}
