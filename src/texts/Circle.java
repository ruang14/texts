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
public class Circle {

    public static void main(String[] args) {
        new DrawMeACircle().DrawACircle(3, 10, 3);
    }

    private static class DrawMeACircle {

        public DrawMeACircle() {
        }

        void DrawACircle(int posX, int posY, int radius) {
            for (int i = 0; i <= posX + radius; i++) {
                for (int j = 1; j <= posY + radius; j++) {
                    int xSquared = (i - posX) * (i - posX);
                    int ySquared = (j - posY) * (j - posY);
                    if (Math.abs(xSquared + ySquared - radius * radius) < radius) {
                        System.out.print("0");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }
}
