public class Main {
    public static void main(String[] args) {
        AnalogThermometer analogThermometer=new AnalogThermometer();
        DigitalThermometer digitalThermometer=new DigitalThermometer(analogThermometer);
        System.out.println(digitalThermometer.indication());
    }
}