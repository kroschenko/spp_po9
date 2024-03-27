package Lab5_1;

public class Destroyer extends WarShip {

    private String name;

    public Destroyer(String name) {
        super(name, "Destroyer");
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return "Destroyer";
    }

    @Override
    public void move(int x, int y) {
        System.out.println("Уничтожитель " + getName() + " перемещается в  (" + x + "," + y + ")");
    }

    @Override
    public void attack(Ship target) {
        System.out.println("Уничтожитель " + getName() + " атакует " + target.getName());
    }

}
