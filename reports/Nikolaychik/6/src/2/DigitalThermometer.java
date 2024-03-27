public class DigitalThermometer{
    AnalogThermometer analogThermometer;

    DigitalThermometer(){
        this.analogThermometer=new AnalogThermometer();
    }
    DigitalThermometer(AnalogThermometer analogThermometer){
        this.analogThermometer=analogThermometer;
    }
    DigitalThermometer(double top,double bottom,double height,double length){
        this.analogThermometer=new AnalogThermometer( top, bottom, height, length);
    }

    public void setAnalogThermometer(AnalogThermometer analogThermometer) {
        this.analogThermometer = analogThermometer;
    }
    public double indication(){
        return analogThermometer.indications()/analogThermometer.getLength()*
                (analogThermometer.getTop()-analogThermometer.getBottom())+
                analogThermometer.getBottom();
    }
}
