package app;

import Connection.ConnectionDAO;

public class Main {
    public static void main(String[] args) {
        new ConnectionDAO().inserir("Ana", "ana@email.com");
    }
}