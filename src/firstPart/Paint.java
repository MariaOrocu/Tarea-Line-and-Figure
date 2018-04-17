package firstPart;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Marco y Maria
 */
public class Paint extends JFrame {

    JButton boton;

    public Paint() {
        super("HomeWork Three");
        this.setLayout(null);
        this.setSize(900, 900);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        init();
    } // constructor

    public void init() {
    }

    public void paint(Graphics g) {

        for (int i = 0; i < 500; i++) {
            /* el for va pintar 500 lineas en dos lados de la vetana, para así formal mil,
            la primer parte es en la parte diagonal izquierda y luego la parte diagonal derecha
            */
            
            int x = (int) (Math.random() * (800 - 0) + 0);
            int y = (int) (Math.random() * (800 - 0) + 0);
            // se crean dos números aleatorios para la posicion de las lineas
            
            int one = (int) (Math.random() * (250 - 0) + 0);
            int two = (int) (Math.random() * (250 - 0) + 0);
            int three = (int) (Math.random() * (250 - 0) + 0);
            // se crean tres números aleatorios para que cada linea tenga un color diferente
            
            Color c = new Color(one, two, three);
            
            g.drawLine(y, y, x, 5);
            g.drawLine(5, y, x, x);
            g.setColor(c);
            // Se pintan las lineas
        }
    }//paint

    public static void main(String[] args) {
        Paint paint = new Paint();
        paint.setVisible(true);
    }//main

} // fin clase