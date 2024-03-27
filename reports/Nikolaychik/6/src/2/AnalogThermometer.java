public class AnalogThermometer {
    protected double top;
    protected double bottom;
    protected double height;
    protected double length;
    double indications(){
        return height;
    }
    AnalogThermometer(){
        this.top=42;
        this.bottom=35;
        this.length=10;
        this.height=5;
    }
    AnalogThermometer(double top,double bottom,double length,double height){
        this.top=top;
        this.bottom=bottom;
        this.length=length;
        this.height=height;
    }

    public double getTop() {
        return top;
    }

    public double getBottom() {
        return bottom;
    }

    public double getHeight() {
        return height;
    }

    public double getLength() {
        return length;
    }
}
