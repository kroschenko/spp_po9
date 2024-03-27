public class ClocksDigital implements DigitalClock{
    int hours;
    int minutes;
    int seconds;
    final private int max_hours = 11;
    final private int max_minutes = 59;
    final private int max_seconds = 59;
    final private int min_time = 0;
    ClocksDigital(){
        hours = 0;
        minutes = 0;
        seconds = 0;
    }
    ClocksDigital(int hours, int minutes, int seconds){
        if((hours > max_hours || hours < min_time)
                || (minutes > max_minutes|| minutes < min_time)
                || (seconds > max_seconds || seconds < min_time)){
            throw new IllegalArgumentException("Wrong time!");
        }
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }
    @Override
    public void showTime() {
        System.out.printf("Time: %d:%d:%d\n", hours, minutes, seconds);
    }

    @Override
    public void setClocks(int hours, int minutes, int seconds) {
        System.out.println("Digital time clock time set");
        if((hours > max_hours || hours < min_time)
                || (minutes > max_minutes || minutes < min_time)
                || (seconds > max_seconds || seconds < min_time)){
            System.out.println("Wrong time!");
            return;
        }
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }
}
