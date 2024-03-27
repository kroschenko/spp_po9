import javafx.scene.paint.Color;

public class Line {
    static int x, y, rotation;
    static int rightPercentage;
    static Color color;
    public Line(int x, int y, int rotation, Color color, int rightPercentage){
        this.x = x;
        this.y = y;
        this.rotation = rotation;
        this.color = color;
        this.rightPercentage = rightPercentage;
    }
    static public int getX(){
        return x;
    }
    static public void setX(int newx){
        x = newx;
    }
    static public int getY(){
        return y;
    }
    static public void setY(int newy){
        y = newy;
    }
    static public int getRotation(){
        return rotation;
    }
    static public void setRotation(int newrotation){
        rotation = newrotation;
    }
    static public Color getColor(){
        return color;
    }
    static public void setColor(Color newcolor){
        color = newcolor;
    }
    static public int getRightPercentage(){
        return rightPercentage;
    }
    static public void setRightPercentage(int newrightPercentage){
        rightPercentage = newrightPercentage;
    }
}
