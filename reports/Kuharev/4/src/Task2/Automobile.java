public class Automobile {
    private String name;
    private String car_type;
    private Wheel[] wheels;
    private boolean isUntil; //докатка
    Automobile(String name, Wheel wheel1, Wheel wheel2, Wheel wheel3, Wheel wheel4){
        if(!compareWheels(wheel1, wheel2) || !compareWheels(wheel2, wheel3) || !compareWheels(wheel3, wheel4)){
            throw new IllegalArgumentException("Разные диаметры колес "+name+" недопустимы!\n");
        }
        this.name = name;
        this.car_type = "passenger";
        wheels = new Wheel[4];
        wheels[0] = wheel1; wheels[1] = wheel2; wheels[2] = wheel3; wheels[3] = wheel4;
        if(wheel1.getType().equals("until") || wheel2.getType().equals("until") ||
                wheel3.getType().equals("until") || wheel4.getType().equals("until")){
            isUntil = true;
        }else{
            isUntil = false;
        }
        System.out.println(name + " готов к поездке!\n");
    }
    Automobile(String name, Wheel wheel1, Wheel wheel2, Wheel wheel3, Wheel wheel4, Wheel wheel5, Wheel wheel6){
        if(!compareWheels(wheel1, wheel2) || !compareWheels(wheel2, wheel3) || !compareWheels(wheel3, wheel4) || !compareWheels(wheel4, wheel5) || !compareWheels(wheel5, wheel6)){
            throw new IllegalArgumentException("Разные диаметры колес недопустимы!");
        }
        this.name = name;
        this.car_type = "cargo";
        wheels = new Wheel[6];
        wheels[0] = wheel1; wheels[1] = wheel2; wheels[2] = wheel3; wheels[3] = wheel4; wheels[4] = wheel5; wheels[5] = wheel6;
        if(wheel1.getType().equals("until") || wheel2.getType().equals("until") ||
                wheel3.getType().equals("until") || wheel4.getType().equals("until") ||
                wheel5.getType().equals("until") || wheel6.getType().equals("until")){
            isUntil = true;
        }else{
            isUntil = false;
        }
    }
    public void drive(int distance){
        System.out.println("В путь");
        for(int i = 0; i < wheels.length; ++i){
            if(wheels[i].getState() == Wheel.UNTORN){
                System.out.println("Шина изношена, машина не может ехать\n");
                return;
            }else if(wheels[i].getState() == Wheel.LOWERED){
                System.out.println("Шина спущена, машина не может ехать\n");
                return;
            }
        }
        System.out.println("Едем!");
        for(int i = 0; i < wheels.length; ++i){
            if(wheels[i].Wear(distance) == 1){
                System.out.println("Шина "+(i+1)+" износилась");
            }
            if(wheels[i].PressureDown(distance) == 1){
                System.out.println("Шина "+(i+1)+" спущена");
            }
        }
        System.out.println();
    }
    public void maintenance(){
        Wheel until;
        int count_new = 0, count_pump = 0;
        for(int i = 0; i < wheels.length; ++i){
            if(wheels[i].getState() == Wheel.UNTORN){
                System.out.println("Шина "+(i+1)+" заменена");
                ++count_new;
                until = new Wheel();
                wheels[i] = until;
            }
            if(wheels[i].getState() == Wheel.LOWERED){
                ++count_pump;
                wheels[i].PumpUp();
            }
            System.out.println("Шина "+(i+1)+": Все в порядке");
        }
        System.out.println("Количество услуг: " + (count_new+count_pump)+"\n-"+(count_new*150+count_pump*20+10)+"$\n");
        System.out.println();
    }
    public void OverPump(int wheel_num){
        wheels[wheel_num].PumpUp();
    }
    private boolean compareWheels(Wheel wheel1, Wheel wheel2){
        if((wheel1.getDiameter() == wheel2.getDiameter())){
            return true;
        }else if((wheel1.getDiameter() != wheel2.getDiameter()) && (wheel1.getType().equals("until") || wheel2.getType().equals("until"))){
            return true;
        }else{
            return false;
        }
    }
}
