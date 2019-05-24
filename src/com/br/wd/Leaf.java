package com.br.wd;

public class Leaf extends Node {

    public Leaf(String value) {
        super(value);
    }

    @Override
    public Node getLeft() {
        return null;
    }

    @Override
    public Node getRight() {
        return null;
    }
}
