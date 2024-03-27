package Lab5_2;

public class AppleTree extends GardenTree {

    private String variety;

    public AppleTree(String variety) {
        super();
        this.variety = variety;
    }

    @Override
    public void grow() {
        setAge(getAge() + 1);
        if (getAge() >= 5) {
            setFruiting(true);
        }
    }

    @Override
    public boolean needsReplanting() {
        return getAge() >= 25;
    }

    @Override
    public String toString() {
        return super.toString() + " - Яблоня (" + variety + ")";
    }

}

