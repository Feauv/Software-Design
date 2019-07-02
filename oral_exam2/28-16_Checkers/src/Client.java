import javafx.geometry.Pos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client extends JFrame implements Runnable {
    private JTextField playerField;
    private JTextArea outputTerminal;
    private JPanel boardPanel;
    private JPanel panel2;
    private Square[][] board;
    private Socket connection;
    private Scanner input;
    private Formatter output;
    private String host;
    private boolean myTurn;

    public Client(String host) {
        this.host = host;
        outputTerminal = new JTextArea(4, 30);
        outputTerminal.setEditable(false);
        add(new JScrollPane(outputTerminal), BorderLayout.SOUTH);

        boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(8, 8, 0, 0));

        board = new Square[8][8];

        for (int row = 0; row < board.length; row++) {
            // loop over the columns in the board
            for (int column = 0; column < board[row].length; column++) {
                // create square

                if ((row+column)%2 == 0) {
                    if (row < 3) {
                        board[row][column] = new Square(Color.black, new Position(row,column), new Piece(Color.red));
                    } else if (row > 4) {
                        board[row][column] = new Square(Color.black, new Position(row,column), new Piece(Color.white));
                    } else {
                        board[row][column] = new Square(Color.black, new Position(row,column), new Piece(Color.black));
                    }
                } else {
                    board[row][column] = new Square(Color.white, new Position(row,column), new Piece(Color.white));
                }
                boardPanel.add(board[row][column]);
            }
        }

        playerField = new JTextField();
        playerField.setEditable(false);
        add(playerField, BorderLayout.NORTH);

        panel2 = new JPanel();
        panel2.add(boardPanel, BorderLayout.CENTER);
        add(panel2, BorderLayout.CENTER);

        setSize(300, 400);
        setVisible(true);

    }


    public void run() {

    }


    private class Square extends JPanel {
        private Position position;
        private Color color;
        private Piece piece;

        public Square(Color color, Position position, Piece piece) {
            this.color = color;
            this.piece = piece;
            this.position = position;

            addMouseListener(
                    new MouseAdapter() {
                        public void mouseReleased(MouseEvent e) {

                        }
                    }
            );
        }

        public Dimension getPreferredSize() {
            return new Dimension(30, 30);
        }

        public Dimension getMinimumSize() {
            return getPreferredSize();
        }

        public Position getPosition() {
            return position;
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(color);
            g.fillRect(0, 0, 29, 29);

            g.setColor(piece.color);
            g.fillOval(5, 5, 19, 19);

        }
    }

    public class Piece {

        private Color color;

        Piece(Color color) {

            this.color = color;

        }

        public Color getColor() { return color; }

        public void setColor(Color c) { color = c; }

    }

    public class Position {

        public Integer vertical;

        public Integer horizontal;

        public Position(Integer vertical, Integer horizontal) {
            this.vertical = vertical;
            this.horizontal = horizontal;
        }

    }
}