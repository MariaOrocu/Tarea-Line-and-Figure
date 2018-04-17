package secondPart;

import static java.lang.System.exit;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Marco y Maria
 */
public class PaintFx extends Application implements Runnable {
    // atributos

    private int WIDTH = 600;
    private final int HEIGHT = 600;
    private Pane pane;
    private Scene scene;
    private Canvas canvas;
    private Thread thread;

    //llama al metodo init para inicializarlo
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Graphics");
        initComponents(primaryStage);
        primaryStage.show();
    }//start

    // se crea una ventana donde se puedan dibujar graficos
    private void initComponents(Stage primaryStage) {
        this.pane = new Pane();
        this.scene = new Scene(this.pane, WIDTH, HEIGHT);
        this.canvas = new Canvas(WIDTH, HEIGHT);

        this.thread = new Thread(this);
        this.thread.start();

        this.pane.getChildren().add(this.canvas);
        primaryStage.setScene(this.scene);
        primaryStage.setOnCloseRequest(exit);

    }//init

    /*se crean dos numeros aleatorios que seran las coordenas necesarias para 
    que se pinten las figuras en la ventana,se crean la variables sumX y sumY 
    para sumarlas a las coordenadas y controlar el movimiento de la figura por 
    la ventana, para que rebote se suma 10 o se resta para que no llegue al 
    limite de la ventana y simule el rebote.*/
    @SuppressWarnings("empty-statement")
    private void myDraw(GraphicsContext gc) {

        Random rand = new Random();
        int y = rand.nextInt(HEIGHT - 500) + 20;
        int x = rand.nextInt(WIDTH - 500) + 20;
        int sumX = 30;
        int sumY = 30;
        while (true) {

            
            try {
                gc.clearRect(0, 0, WIDTH, WIDTH);
                gc.setFill(Color.AQUAMARINE);
                x = x + sumX;
                y = y + sumY;
                gc.fillRect(x, y, 80, 80);
                if (x <= 0) {

                    sumX = 10;
                } else if (x >= 500) {

                    sumX = -30;
                } else if (y <= 0) {

                    sumY = 30;
                } else if (y >= 500) {

                    sumY = -10;

                }

                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(PaintFx.class.getName()).log(Level.SEVERE, null, ex);
            }
             
                
            }
        
    }//myDraw

    // se llama al metodo myDraw para ejecutarlo
    @Override
    public void run() {
        GraphicsContext gc = this.canvas.getGraphicsContext2D();
        myDraw(gc);
    }//run

    //metodo controlador de los eventos que ocurren en la ventana
    EventHandler<WindowEvent> exit = new EventHandler<WindowEvent>() {
        @Override
        public void handle(WindowEvent event) {
            System.exit(0);
        }
    };//eventHandler

}//fin clase
