import javafx.scene.paint.Color;

class Point {
    private int x;
    private int y;
    private int red, green, blue;
    private double size;
    private boolean right;

    public Point(boolean right) {
        if(right){
            x = (int) (Math.random() * Main.WIDTH);
            y = (int) (Math.random() * Main.HEIGHT);
            while (isPointAboveLine(Line.getX(), Line.getY(), Line.getRotation(), x, y)){
                x = (int) (Math.random() * Main.WIDTH);
                y = (int) (Math.random() * Main.HEIGHT);
            }
        }else {
            x = (int) (Math.random() * Main.WIDTH);
            y = (int) (Math.random() * Main.HEIGHT);
            while (!isPointAboveLine(Line.getX(), Line.getY(), Line.getRotation(), x, y)){
                x = (int) (Math.random() * Main.WIDTH);
                y = (int) (Math.random() * Main.HEIGHT);
            }
        }
        red = (int) (Math.random() * 256);
        green = (int) (Math.random() * 256);
        blue = (int) (Math.random() * 256);
        size = Math.random() * 5 + 2;
        this.right = right;
    }
    public static boolean isPointAboveLine(double centerX, double centerY, double rotationDegrees, double pointX, double pointY) {
        double rotationRadians = Math.toRadians(rotationDegrees);

        double diffX = pointX - centerX;
        double diffY = pointY - centerY;

        double rotatedDiffX = diffX * Math.cos(-rotationRadians) - diffY * Math.sin(-rotationRadians);
        double rotatedDiffY = diffX * Math.sin(-rotationRadians) + diffY * Math.cos(-rotationRadians);

        return rotatedDiffY > 0;
    }
    public double getSize(){
        return size;
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    public boolean getPos(){
        return right;
    }

    public Color getColor() {
        return Color.rgb(red, green, blue);
    }
}
