package Lab5_2;

public abstract class GardenTree {

    private static int nextId = 1;
    private int id;
    private int age;
    private boolean isFruiting;

    public GardenTree() {
        this.id = nextId++;
        this.age = 0;
        this.isFruiting = false;
    }


    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isFruiting() {
        return isFruiting;
    }

    public void setFruiting(boolean isFruiting) {
        this.isFruiting = isFruiting;
    }

    public abstract void grow();

    public abstract boolean needsReplanting();

    @Override
    public String toString() {
        return "Садовое дерево #" + id + " (" + getAge() + " лет, " + (isFruiting ? "плодоносит" : "не плодоносит") + ")";
    }

}
