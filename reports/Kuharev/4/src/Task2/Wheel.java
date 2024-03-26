public class Wheel {
    final static int OK = 0;
    final static int UNTORN = 1;
    final static int LOWERED = 2;
    private String brand;
    private String mark;
    private String type;
    private int diameter;
    private double pressure;
    private double resource;
    private boolean isUntorn;
    private boolean isLowered;
    Wheel(){
        this.brand = "БелШина";
        this.mark = "195/65 R15 91 T RSC";
        this.type = "until";
        this.diameter = 15;
        this.pressure = 2.0;
        this.resource = 100;
        isUntorn = false;
        isLowered = false;
    }
    Wheel(String brand, int diameter, String type, double pressure, double resource){
        this.brand = brand;
        if(type.equals("until")){
            this.mark = "195/65 R"+diameter+" 91 T RSC";
        }else{
            this.mark = "195/65 R"+diameter+" 91 T XL";
        }
        this.type = type;
        this.diameter = diameter;
        this.pressure = pressure;
        this.resource = resource;
        isUntorn = false;
        isLowered = false;
    }
    public String getType(){
        return type;
    }
    public int getDiameter(){
        return diameter;
    }
    public int getState(){
        if(isUntorn){
            return UNTORN;
        }else if(isLowered){
            return LOWERED;
        }else {
            return OK;
        }
    }
    public int Wear(double distance){//изнашивание в пути
        resource -= distance/100;
        if(resource < 0){
            isUntorn = true;
            return 1;
        }
        return 0;
    }
    public int PressureDown(int distance){
        pressure -= distance/1000;
        if(pressure < 1.0){
            isLowered = true;
            return 1;
        }
        return 0;
    }
    public void PumpUp(){
        if(pressure < 2.0){
            pressure = 2.0;
            System.out.println("Текущее давление 2.0 атмосфер");
        }else if (pressure < 2.3){
            pressure = 2.3;
            System.out.println("Текущее давление 2.3 атмосферы");
        }else if(pressure < 3.0){
            pressure = 3.0;
            System.out.println("Текущее давление 3.0 атмосфер, шина перекачана");
        }else {
            System.out.println("Шина лопнула");
            isUntorn = true;
        }
        isLowered = false;
    }
}
