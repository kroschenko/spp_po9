public class ArrowToDigitalAdapter implements DigitalClock{
    final private int minutesInHour= 60;
    final private int crownRatioToMinutes = 10;
    final private int crownRatioToSeconds = 600;
    ClockWithArrow arrowClock;
    ArrowToDigitalAdapter(ClockWithArrow arrowClock){
        this.arrowClock = arrowClock;
    }
    @Override
    public void showTime() {
        arrowClock.showTime();
    }

    @Override
    public void setClocks(int hours, int minutes, int seconds) {
        arrowClock.setClocks((((double) hours*minutesInHour/crownRatioToMinutes)
                +((double) minutes/crownRatioToMinutes)//1 crown rotation equals 10 minutes
                +((double) seconds/crownRatioToSeconds)));
    }
}
