/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texts;

/**
 *
 * @author ruang
 */
public class Tree {

    public static void main(String[] args) {
        TreeShape ts = new TreeShape();
        ts.setHeight(14);
        ts.drawTree();
    }

    public static class TreeShape {

        public int height;

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public void drawTree() {
            int inc = 0;

            for (int i = 0; i < height; i++) {
                if (i % 2 == 0) {
                    for (int j = (height / 2); j > (inc / 2); j--) {
                        System.out.print(" ");
                    }
                    for (int j = 0; j < inc; j++) {
                        if (j % 2 == 0) {
                            System.out.print("/");
                        } else {
                            System.out.print("/");
                        }
                    }
                    System.out.println("");
                } else {
                    for (int j = (height / 2); j > (inc / 2); j--) {
                        System.out.print(" ");
                    }
                    for (int j = 0; j < inc; j++) {
                        if (j % 2 == 0) {
                            System.out.print("/");
                        } else {
                            System.out.print("/");
                        }
                    }
                    System.out.println("");
                }

                inc++;
            }

            for (int j = (height / 2); j > ((height / 2) / 2); j--) {
                System.out.print(" ");
            }

            for (int i = (height / 2); i < height; i++) {
                System.out.print("|");
            }
            System.out.println("");
        }
    }

}
