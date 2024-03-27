package Lab5_1;

public abstract class WarShip implements Ship {

    private String name;
    private String type;

    public WarShip(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public abstract void move(int x, int y);

    @Override
    public abstract void attack(Ship target);

}
