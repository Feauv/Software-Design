import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Server extends JFrame {
    private JTextArea outputTerminal;

    public Server() {
        super("Checkers Server");


        outputTerminal = new JTextArea(); // create JTextArea for output
        add(outputTerminal, BorderLayout.CENTER);
        outputTerminal.setText("Server awaiting connections\n");

        setSize(300, 300);
        setVisible(true);
    }

}