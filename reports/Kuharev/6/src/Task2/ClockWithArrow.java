import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ClockWithArrow implements ArrowClock{
    final private int degreeAmount = 360;
    final private int nextCircleTransition = -1;
    final private int hoursToDegrees = 30;
    final private int minutesSecondsToDegrees = 6;
    final private int rotationsPerHour = 6;
    final private int minutesPerRotation = 10;
    final private int secondsPerRotation = 600;
    private int hourArrDegree;
    private int minuteArrDegree;
    private int secondArrDegree;
    ClockWithArrow(){
        hourArrDegree = 0;
        minuteArrDegree = 0;
        secondArrDegree = 0;
    }
    ClockWithArrow(double rotationAmount){
        hourArrDegree = (int)(rotationAmount/rotationsPerHour*hoursToDegrees);
        while (hourArrDegree > degreeAmount+nextCircleTransition){
            hourArrDegree -= degreeAmount;
        }
        minuteArrDegree = (int)(rotationAmount*minutesPerRotation*minutesSecondsToDegrees);
        while (minuteArrDegree > degreeAmount+nextCircleTransition){
            minuteArrDegree -= degreeAmount;
        }
        secondArrDegree = (int)(rotationAmount*secondsPerRotation*minutesSecondsToDegrees);
        while (secondArrDegree > degreeAmount+nextCircleTransition){
            secondArrDegree -= degreeAmount;
        }
    }
    @Override
    public void showTime() {
        System.out.printf("*Часы показывают*\nЧасы: %d\nМинуты: %d\nМинуты: %d\n\n", hourArrDegree/hoursToDegrees, minuteArrDegree/minutesSecondsToDegrees, secondArrDegree/minutesSecondsToDegrees);
    }
    @Override
    public void setClocks(double rotationAmount){
        System.out.println("Крутим-вертим устанавливаем время");
        hourArrDegree = (int)(rotationAmount/rotationsPerHour*hoursToDegrees);
        while (hourArrDegree > degreeAmount+nextCircleTransition){
            hourArrDegree -= degreeAmount;
        }
        minuteArrDegree = (int)(rotationAmount*minutesPerRotation*minutesSecondsToDegrees);
        while (minuteArrDegree > degreeAmount+nextCircleTransition){
            minuteArrDegree -= degreeAmount;
        }
        secondArrDegree = (int)(rotationAmount*secondsPerRotation*minutesSecondsToDegrees);
        while (secondArrDegree > degreeAmount+nextCircleTransition){
            secondArrDegree -= degreeAmount;
        }
    }

    public void drawBeautifulClock() {
        System.out.println("  . .. .  . .. .  . .. .  . .. .  . .. .  . .. .  . .. .  . .. .  . .. .  . .. .\n" +
                ".. .  . .. .  . .. .  . .. .  . .. #@@@@@@@@% . .. .  . .. .  . .. .  . .. .  . \n" +
                ".. .  . .. .  . .. .  . . @@@@@@@@@@@@@@@@@@@@@@@@@@@@, .. .  . .. .  . .. .  . \n" +
                ".. .  . .. .  . .. . @@@@@@   . .. .  . .. .  . .. . @@@@@@,  . .. .  . .. .  . \n" +
                ".. .  . .. .  . .@@@@@@ .. .  . .. .  . .. .  . .. .  .@@@@@@@@ .. .  . .. .  . \n" +
                ".. .  . .. .  @@@@(.  . .. .  . .. .  .@@. .  . .. .  . .. .  @@@@ .  . .. .  . \n" +
                ".. .  . ..  @@@@.. .  . .. .  . .. .   @@% .  . .. .  . .. .  . ,@@@( . .. .  . \n" +
                ".. .  . . @@@ . .. .  . .. .  . .. .   @@% .  . .. .  . .. .  . .. @@@% .. .  . \n" +
                ".. .  . @@@   . .. .  . .. .  . .. .   @@% .  . .. .  . .. .  . .. . @@@.. .  . \n" +
                "  . ..(@@@@ .. .  . .. .  . .. .  . .. @@%. .. .  . .. .  . .. .  . @@@@@@. .. .\n" +
                "  . .@@@  . .. .  . .. .  . .. .  . .. @@%. .. .  . .. .  . .. .  . .. .@@@ .. .\n" +
                "  . @@@   . .. .  . .. .  . .. .  . .. @@%. .. .  . .. .  . .. .  . .. . @@@.. .\n" +
                "  .(@@*.  . .. .  . .. .  . .. .  . .. @@%. .. .  . .. .  . .. .  . .. .  @@@. .\n" +
                "  .@@@ .  . .. .  . .. .  . .. .  . .. @@%. .. .  . .. .  . .. .  . .. .  @@@. .\n" +
                "  %@@  .  . .. .  . .. .  . .. .  . .. @@%. .. .  . .. .  . .. .  . .. .  .@@@ .\n" +
                "  @@@. .  . .. .  . .. .  . .. .  . .. @@%. .. .  . .. .  . .. .  . .. .  .@@@ .\n" +
                "  @@@@@.  . .. .  . .. .  . .. .  . .. @@@@@@@@@@@@@@@ .  . .. .  . .. . @@@@@ .\n" +
                "..@@@ . .. .  . .. .  . .. .  . .. . @* .. .  . .. .  . .. .  . .. .  . .. @@@. \n" +
                "..@@@ . .. .  . .. .  . .. .  . .. @  . .. .  . .. .  . .. .  . .. .  . .. @@@. \n" +
                ".. @@@. .. .  . .. .  . .. .  . @, .  . .. .  . .. .  . .. .  . .. .  . ..%@@ . \n" +
                ".. @@@  .. .  . .. .  . .. . .@ .. .  . .. .  . .. .  . .. .  . .. .  . ..@@@ . \n" +
                ".. .@@@ .. .  . .. .  . .. @  . .. .  . .. .  . .. .  . .. .  . .. .  . .@@@  . \n" +
                ".. . @@@.. .  . .. .  . *@ .  . .. .  . .. .  . .. .  . .. .  . .. .  . @@@.  . \n" +
                ".. .  @@@%@&  . .. .  @ .. .  . .. .  . .. .  . .. .  . .. .  . .. . @@@@@ .  . \n" +
                ".. .  . @@@.  . .. .  . .. .  . .. .  . .. .  . .. .  . .. .  . .. . @@@(. .  . \n" +
                "  . .. . @@@@. .  . .. .  . .. .  . .. .  . .. .  . .. .  . .. .  .@@@@.  . .. .\n" +
                "  . .. .  .@@@@   . .. .  . .. .  . .. .  . .. .  . .. .  . .. . @@@@. .  . .. .\n" +
                "  . .. .  . . @@@@. .. .  . .. .  . .. .  . .. .  . .. .  . ..@@@@( .. .  . .. .\n" +
                "  . .. .  . .. ..@@@@(@@@ . .. .  . .. .  . .. .  . .. . @@@@@@@  . .. .  . .. .\n" +
                "  . .. .  . .. .  . @@@@@@. .. .  . .. .  . .. .  . . @@@@@@.. .  . .. .  . .. .\n" +
                "  . .. .  . .. .  . .. . @@@@@@@@@@* . @@%. .@@@@@@@@@@.  . .. .  . .. .  . .. .\n" +
                "  . .. .  . .. .  . .. .  . .. . @@@@@@@@@@@@@@,  . .. .  . .. .  . .. .  . .. .");
    }

}
