import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

import java.util.Optional;

public class Main extends Application {
    private static final int WIDTH = 900;
    private static final int HEIGHT = 600;
    private static final int SIDE_SIZE = 300;

    private Pane root;
    private double startX, startY;
    private double startTranslateX, startTranslateY;
    static public int generations_amount;

    @Override
    public void start(Stage stage) throws Exception {

        TextInputDialog gDialog = new TextInputDialog();
        gDialog.setHeaderText("Enter amount of generations:");
        String gResult = gDialog.showAndWait().orElse("2");
        generations_amount = Integer.parseInt(gResult);

        TextInputDialog colorDialog = new TextInputDialog();
        colorDialog.setHeaderText("Enter line color (r,g,b):");
        String colorResult = colorDialog.showAndWait().orElse("0,0,0");
        String[] colors = colorResult.split(",");
        Color lineColor = Color.rgb(Integer.parseInt(colors[0]), Integer.parseInt(colors[1]), Integer.parseInt(colors[2]));

        root = new Pane();
        Group group = new Group(root);
        Scale scale = new Scale(1, 1);

        root.getTransforms().add(scale);

        Scene scene = new Scene(group, WIDTH, HEIGHT);

        double squareSize = SIDE_SIZE;
        startX = (WIDTH - squareSize) / 2;
        startY = (HEIGHT - squareSize) / 2;
        double endX = startX + squareSize;
        double endY = startY + squareSize;

        drawMinkowskiSquare(startX, startY, endX, endY, generations_amount, lineColor);

        scene.setOnScroll(event -> {
            double scaleFactor = event.getDeltaY() > 0 ? 1.1 : 0.9;
            scale.setX(scale.getX() * scaleFactor);
            scale.setY(scale.getY() * scaleFactor);
            event.consume();
        });

        scene.setOnMousePressed(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                startTranslateX = event.getSceneX() - root.getTranslateX();
                startTranslateY = event.getSceneY() - root.getTranslateY();
            }
        });

        scene.setOnMouseDragged(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                double offsetX = event.getSceneX() - startTranslateX;
                double offsetY = event.getSceneY() - startTranslateY;
                root.setTranslateX(offsetX);
                root.setTranslateY(offsetY);
            }
        });

        stage.setScene(scene);
        stage.show();
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.Q) {
                if(generations_amount < 4){
                    generations_amount++;
                    root.getChildren().clear();
                    drawMinkowskiSquare(startX, startY, endX, endY, generations_amount, lineColor);
                }else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setHeaderText("Warning");
                    alert.setContentText("Application will crush");
                    alert.showAndWait();
                }
            } else if (event.getCode() == KeyCode.A) {
                if (generations_amount > 0) {
                    generations_amount--;
                    root.getChildren().clear();
                    drawMinkowskiSquare(startX, startY, endX, endY, generations_amount, lineColor);
                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setHeaderText("Warning");
                    alert.setContentText("Cannot decrease generations amount below 0.");
                    alert.showAndWait();
                }
            }
        });
    }

    /**
     * Draws a square made of Minkowski curves.
     */
    private void drawMinkowskiSquare(double startX, double startY, double endX, double endY, int generations, Color color) {
        double width = endX - startX;
        double height = endY - startY;

        drawMinkowski(startX, startY, startX + width, startY, generations, color); // Top side
        drawMinkowski(startX + width, startY, startX + width, startY + height, generations, color); // Right side
        drawMinkowski(startX + width, startY + height, startX, startY + height, generations, color); // Bottom side
        drawMinkowski(startX, startY + height, startX, startY, generations, color); // Left side
    }

    /**
     * Draws a Minkowski curve between two points.
     */
    private void drawMinkowski(double xa, double ya, double xi, double yi, int i, Color color) {
        if (i == 0) {
            Line line = new Line(xa, ya, xi, yi);
            line.setStroke(color);
            root.getChildren().add(line);
        } else {
            double xb = xa + (xi - xa) * 1 / 4;
            double yb = ya + (yi - ya) * 1 / 4;

            double xe = xa + (xi - xa) * 2 / 4;
            double ye = ya + (yi - ya) * 2 / 4;

            double xh = xa + (xi - xa) * 3 / 4;
            double yh = ya + (yi - ya) * 3 / 4;

            double cos90 = 0;
            double sin90 = -1;
            double xc = xb + (xe - xb) * cos90 - sin90 * (ye - yb);
            double yc = yb + (xe - xb) * sin90 + cos90 * (ye - yb);

            double xd = xc + (xe - xb);
            double yd = yc + (ye - yb);

            sin90 = 1;
            double xf = xe + (xh - xe) * cos90 - sin90 * (yh - ye);
            double yf = ye + (xh - xe) * sin90 + cos90 * (yh - ye);

            double xg = xf + (xh - xe);
            double yg = yf + (yh - ye);

            drawMinkowski(xa, ya, xb, yb, i - 1, color);
            drawMinkowski(xb, yb, xc, yc, i - 1, color);
            drawMinkowski(xc, yc, xd, yd, i - 1, color);
            drawMinkowski(xd, yd, xe, ye, i - 1, color);
            drawMinkowski(xe, ye, xf, yf, i - 1, color);
            drawMinkowski(xf, yf, xg, yg, i - 1, color);
            drawMinkowski(xg, yg, xh, yh, i - 1, color);
            drawMinkowski(xh, yh, xi, yi, i - 1, color);
        }
    }
}