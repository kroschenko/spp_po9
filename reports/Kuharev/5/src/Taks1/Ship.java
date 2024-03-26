public interface Ship {
    public void call();
    public void load(Cargo cargo);
    public void transportTo(String destination);
    public void goToStorage();
}
