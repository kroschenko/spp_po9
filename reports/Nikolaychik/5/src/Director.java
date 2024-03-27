public class Director extends Employee{
    Director(int age,String name,int money,int mood){
        super(age,name,money,mood);
    }
    @Override
    protected void Interaction(Employee employee, int cost){
        employee.money+=cost/4;
        this.money+=cost*3/4;
        employee.mood-=cost/4;
        this.mood+=cost/2;
    }
}
