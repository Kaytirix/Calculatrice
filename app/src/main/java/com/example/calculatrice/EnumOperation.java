package com.example.calculatrice;

public enum EnumOperation {
    ADD("+"),
    SUBSTRACT("-"),
    MULTIPLY("*"),
    DIVISE("/");

    private String symbol;

    EnumOperation(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}

