/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texts;

import java.awt.event.*;
import java.applet.Applet;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Label;

/**
 *
 * @author ruang
 */
public class Blobs extends Applet implements ActionListener, MouseListener {

    final static int SQUARE_SIZE = 8;
    Label message;
    Choice percentFill;
    int rows;
    int columns;
    boolean[][] filled;
    boolean[][] visited;

    @Override
    public void init() {
        setLayout(null);
        setBackground(new Color(220, 220, 255));
        addMouseListener(this);

        int width = getSize().width;
        int height = getSize().height;

        rows = (height - 100) / SQUARE_SIZE;
        columns = (width - 20) / SQUARE_SIZE;

        filled = new boolean[rows][columns];
        visited = new boolean[rows][columns];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                filled[r][c] = (Math.random() < 0.3);
            }
        }

        message = new Label("Click a square to get the blob size", Label.CENTER);
        message.setForeground(Color.blue);
        message.setFont(new Font("Helvetica", Font.PLAIN, 14));

        percentFill = new Choice();
        percentFill.add("10% fill");
        percentFill.add("20% fill");
        percentFill.add("30% fill");
        percentFill.add("40% fill");
        percentFill.add("50% fill");
        percentFill.add("60% fill");
        percentFill.add("70% fill");
        percentFill.add("80% fill");
        percentFill.add("90% fill");
        percentFill.setBackground(Color.white);
        percentFill.select(2);

        Button newButton = new Button("New Blobs");
        newButton.addActionListener(this);
        newButton.setBackground(Color.lightGray);

        Button countButton = new Button("Count the Blobs");
        countButton.addActionListener(this);
        countButton.setBackground(Color.lightGray);

        add(message);
        add(newButton);
        add(percentFill);
        add(countButton);

        message.setBounds(15, height - 75, width - 30, 18);
        countButton.setBounds(15, height - 50, width - 30, 18);
        newButton.setBounds(15, height - 25, (width - 40) / 2, 18);
        percentFill.setBounds(width / 2 + 5, height - 25, (width - 40) / 2, 18);
    }

    @Override
    public void paint(Graphics g) {
        int width = getSize().width;
        int height = getSize().height;

        g.setColor(Color.blue);
        g.drawRect(0, 0, width - 1, height - 1);
        g.drawRect(1, 1, width - 3, height - 3);
        g.setColor(Color.white);
        g.fillRect(10, 10, columns * SQUARE_SIZE, rows * SQUARE_SIZE);
        g.setColor(Color.black);

        for (int i = 0; i <= rows; i++) {
            g.drawLine(10, 10 + i * SQUARE_SIZE, columns * SQUARE_SIZE + 10, 10 + i * SQUARE_SIZE);
        }
        for (int i = 0; i <= columns; i++) {
            g.drawLine(10 + i * SQUARE_SIZE, 10, 10 + i * SQUARE_SIZE, rows * SQUARE_SIZE + 10);
        }
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                if (visited[r][c]) {
                    g.setColor(Color.red);
                    g.fillRect(11 + c * SQUARE_SIZE, 11 + r * SQUARE_SIZE, SQUARE_SIZE - 1, SQUARE_SIZE - 1);
                } else {
                    if (filled[r][c]) {
                        g.setColor(Color.gray);
                        g.fillRect(11 + c * SQUARE_SIZE, 11 + r * SQUARE_SIZE, SQUARE_SIZE - 1, SQUARE_SIZE - 1);
                    }
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        String cmd = evt.getActionCommand();
        if (cmd.equals("New Blobs")) {
            fillGrid();
        } else {
            if (cmd.equals("Count the Blobs")) {
                countBlobs();
            }
        }
    }

    void fillGrid() {
        double probability = (percentFill.getSelectedIndex() + 1) / 10.0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                filled[r][c] = (Math.random() < probability);
                visited[r][c] = false;
            }
        }
        message.setText("Click a square to get the blob size");
        repaint();
    }

    void countBlobs() {
        int count = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                visited[r][c] = false;
            }
        }
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                if (getBlobSize(r, c) > 0) {
                    count++;
                }
            }
        }

        repaint();
        message.setText("The number of blobs is " + count);
    }

    int getBlobSize(int r, int c) {
        if (r < 0 || r >= rows || c < 0 || c >= columns) {
            return 0;
        }
        if (filled[r][c] == false || visited[r][c] == true) {
            return 0;
        }

        visited[r][c] = true;
        int size = 1;

        size += getBlobSize(r - 1, c);
        size += getBlobSize(r + 1, c);
        size += getBlobSize(r, c - 1);
        size += getBlobSize(r, c + 1);

        return size;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent evt) {
        int row = (evt.getY() - 10) / SQUARE_SIZE;
        int col = (evt.getX() - 10) / SQUARE_SIZE;

        if (row < 0 || row >= rows || col < 0 || col >= columns) {
            message.setText("please click on a square");
            return;
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                visited[r][c] = false;
            }
        }

        int size = getBlobSize(row, col);

        if (size == 0) {
            message.setText("There is no blob at (" + row + ", " + col + ")");
        } else {
            if (size == 1) {
                message.setText("The blob at (" + row + ", " + col + ") contains 1 square");
            } else {
                message.setText("The blob at (" + row + ", " + col + ") contains " + size + " squares");
            }
        }

        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
