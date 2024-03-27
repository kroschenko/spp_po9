package Lab5_2;

public class CherryTree extends GardenTree {

    public CherryTree() {
        super();
    }

    @Override
    public void grow() {
        setAge(getAge() + 1);
        if (getAge() >= 4) {
            setFruiting(true);
        }
    }

    @Override
    public boolean needsReplanting() {
        return getAge() >= 20;
    }

    @Override
    public String toString() {
        return super.toString() + " - Вишня";
    }

}
