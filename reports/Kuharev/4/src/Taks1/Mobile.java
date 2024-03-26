import java.util.ArrayList;
import java.util.Scanner;

public class Mobile {
    String brand;
    ArrayList<Phone> phones = new ArrayList<Phone>();
    public class Phone{
        String model;
        String[] specs;
        int release_year;
        public Phone(String model, String[] specs, int release_year){
            this.model = model;
            this.specs = specs;
            this.release_year = release_year;
        }
        public void Show(){
            System.out.print(brand + " " + model + ", (" + release_year + ").");
            System.out.println("\n\tStorage: " + specs[Const.ROM] +
                    "\n\tRAM: " + specs[Const.RAM] + "\n\tScreen size: " + specs[Const.SCREEN_SIZE] +
                    "\n\tColor: " + specs[Const.COLOR] + "\n\tMain camera: " + specs[Const.MAIN_CAM_RESOLUTION] +
                    "\n\tDescription: \n\t" + specs[Const.ADV_DESCRIPTION]);
            System.out.println();
        }
        public void setSpecs(String[] specs){
            this.specs = specs;
        }
        public String[] MakeDescription(){
            String[] specs = new String[Const.ADV_DESCRIPTION+1];
            Scanner in = new Scanner(System.in);
            System.out.println("Add description for the " + model + ":");
            System.out.print("Storage: "); specs[Const.ROM] = in.nextLine();
            System.out.print("ROM: "); specs[Const.RAM] = in.nextLine();
            System.out.print("Screen size: "); specs[Const.SCREEN_SIZE] = in.nextLine();
            System.out.print("Main camera: "); specs[Const.MAIN_CAM_RESOLUTION] = in.nextLine();
            System.out.print("Color: "); specs[Const.COLOR] = in.nextLine();
            System.out.print("Description: "); specs[Const.ADV_DESCRIPTION] = in.nextLine();
            return specs;
        }
    }
    public Mobile(String brand){
        this.brand = brand;
    }
    public void AddDescription(int index){
        phones.get(index).setSpecs(phones.get(index).MakeDescription());
    }
    public void addPhone(String model, String[] specs, int release_date){
        Phone new_phone = new Phone(model, specs, release_date);
        phones.add(new_phone);
    }
    public void ShowList(){
        System.out.println("Phones list:");
        for(int i = 0; i < phones.size(); ++i){
            System.out.print(i + "."); phones.get(i).Show();
        }
        System.out.println();
    }
    public void ShowPhone(int index){
        if(index < 0 || index > phones.size()){
            System.out.println("Incorrect index");
            return;
        }
        System.out.print("Model № " + index + " ");
        phones.get(index).Show();
    }
}
