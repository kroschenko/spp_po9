public class Main {
    public static void main(String[] args) {
        String[] specs = {"256 GB", "12 GB", "6.7'", "128 MP", "Black abundance", "Good phone for everyday usage. Logical evolution of 25B Pro"};
        Mobile Xiaomi = new Mobile("Xiaomi");
        Xiaomi.addPhone("26B Pro", specs, 2030);
        Xiaomi.addPhone("26B", specs, 2029);
        Xiaomi.addPhone("26B Pro Max", specs, 2031);
        Xiaomi.addPhone("26B Pro X", specs, 2032);
        Xiaomi.addPhone("26A Ultra", specs, 2032);
        Xiaomi.addPhone("27T Super Pro Max X Ultra", specs, 2035);
        Xiaomi.ShowList();
        Xiaomi.AddDescription(3);
        Xiaomi.ShowPhone(3);
    }
}