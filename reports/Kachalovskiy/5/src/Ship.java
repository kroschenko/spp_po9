package Lab5_1;

public interface Ship {

    String getName();

    String getType();

    void move(int x, int y);

    void attack(Ship target);

}