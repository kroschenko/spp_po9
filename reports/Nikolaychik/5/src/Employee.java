abstract public class Employee {
    protected int age;
    protected String name;
    protected int money;
    protected int mood;
    abstract protected void Interaction(Employee employee,int cost);
    public void out(){
        System.out.println("age: " + age);
        System.out.println("name: " +name);
        System.out.println("money: " +money);
        System.out.println("mood: " +mood);
        System.out.println();
    }
    Employee(int age,String name,int money,int mood){
        this.mood=mood;
        this.age=age;
        this.money=money;
        this.name=name;
    }
}
