public class Engineer extends Employee{
    Engineer(int age,String name,int money,int mood){
        super(age,name,money,mood);
    }
    @Override
    protected void Interaction(Employee employee, int cost){
        employee.money+=cost/2;
        this.money+=cost/2;
        employee.mood+=cost/4;
        this.mood+=cost/4;
    }
}
