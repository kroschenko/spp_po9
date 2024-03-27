import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.util.ArrayList;

public class Main extends Application {
    final static public int WIDTH = 800;
    final static public int HEIGHT = 600;
    static ArrayList<Point> points = new ArrayList<>();
    static Pane root;
    static Canvas canvas;
    static GraphicsContext gc;
    @Override
    public void start(Stage primaryStage) throws InterruptedException {
        TextInputDialog xDialog = new TextInputDialog();
        xDialog.setHeaderText("Enter x coordinate:");
        String xResult = xDialog.showAndWait().orElse(WIDTH/2+"");
        int x = Integer.parseInt(xResult);

        TextInputDialog yDialog = new TextInputDialog();
        yDialog.setHeaderText("Enter y coordinate:");
        String yResult = yDialog.showAndWait().orElse(HEIGHT/2+"");
        int y = Integer.parseInt(yResult);

        TextInputDialog rotationDialog = new TextInputDialog();
        rotationDialog.setHeaderText("Enter rotation angle:");
        String rotationResult = rotationDialog.showAndWait().orElse("0");
        int rotation = Integer.parseInt(rotationResult);

        TextInputDialog colorDialog = new TextInputDialog();
        colorDialog.setHeaderText("Enter line color (r,g,b):");
        String colorResult = colorDialog.showAndWait().orElse("0,0,0");
        String[] colors = colorResult.split(",");

        TextInputDialog percentageDialog = new TextInputDialog();
        percentageDialog.setHeaderText("Enter right side dots percentage (0-100):");
        String percentageResult = percentageDialog.showAndWait().orElse("50");
        int percentage = Integer.parseInt(percentageResult);

        Color color = Color.rgb(Integer.parseInt(colors[0]), Integer.parseInt(colors[1]), Integer.parseInt(colors[2]));
        Line.setX(x);
        Line.setY(y);
        Line.setRotation(rotation);
        Line.setColor(color);
        Line.setRightPercentage(percentage);

        canvas = new Canvas(800, 600);
        gc = canvas.getGraphicsContext2D();

        root = new Pane();
        Button button = new Button("Drow points");
        button.setOnAction(event -> {
            int amount = (int) (Math.random() * 40 + 10);
            for (int i = 0; i < amount; ++i) {
                if(i < Math.round((double) amount * (double) Line.getRightPercentage() / 100)){
                    points.add(new Point(true));
                }
                else {
                    points.add(new Point(false));
                }
            }
            drawPoints();
        });

        drawLine();

        root.getChildren().add(canvas);
        root.getChildren().add(button);
        primaryStage.setScene(new Scene(root, WIDTH, HEIGHT));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    public static void drawLine(){
        gc.save();

        gc.setStroke(Line.getColor());
        gc.setLineWidth(2.0);

        gc.translate(Line.getX(), Line.getY());
        gc.rotate(Line.getRotation());

        gc.strokeLine(-5000, 0, 5000, 0);

        gc.restore();
    }
    public static void drawPoints(){
        for (int i = 0; i < points.size(); ++i) {

            Circle circle = new Circle(points.get(i).getX(), points.get(i).getY(), points.get(i).getSize());
            circle.setFill(points.get(i).getColor());
            root.getChildren().add(circle);
        }
    }

}
