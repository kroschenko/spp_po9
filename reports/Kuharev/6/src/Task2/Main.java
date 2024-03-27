public class Main {

    public static void main(String[] args) {
        ClockWithArrow n = new ClockWithArrow();
        DigitalClock adapted = new ArrowToDigitalAdapter(n);
        adapted.showTime();
        adapted.setClocks(10, 20, 44);
        adapted.showTime();

        DigitalClock digital = new ClocksDigital(10, 12, 21);
        digital.showTime();
    }


}