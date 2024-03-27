package Lab5_2;

public class PearTree extends GardenTree {

    private String variety;

    public PearTree(String variety) {
        super();
        this.variety = variety;
    }

    @Override
    public void grow() {
        setAge(getAge() + 1);
        if (getAge() >= 6) {
            setFruiting(true);
        }
    }

    @Override
    public boolean needsReplanting() {
        return getAge() >= 30;
    }

    @Override
    public String toString() {
        return super.toString() + " - Груша (" + variety + ")";
    }

}
