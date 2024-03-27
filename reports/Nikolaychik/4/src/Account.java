import java.util.ArrayList;
import java.util.Vector;

public class Account {
    final static short in_type=0,out_type=1,to_type=2;
    static ArrayList<Account> stored_accounts = null;
    int id;
    int money;
    ArrayList<History> history;

    Account(){
        this.id=0;
        if(stored_accounts==null){
            stored_accounts=new ArrayList<Account>();
        }
        this.history=new ArrayList<History>();
        stored_accounts.add(this);
        boolean flag=true;
        for (int i=1;this.id==0;i++){
            flag=true;
            for(int j=0;j<stored_accounts.size();j++){
                if(stored_accounts.get(j).id == i)
                {
                    flag=false;
                }
            }
            if(flag) {
                this.id = i;
            }
        }
        this.money=0;

    }

    public void Operation_in(int size){
        this.money+=size;
        this.history.add(new History(size,in_type,this.id,this.id));
    }
    public boolean Operation_out(int size){
        if(this.money>size) {
            this.money -= size;
            this.history.add(new History(size, out_type, this.id, this.id));
            return true;
        }
        else {
            System.out.println("Нет денюх");
            return false;
        }
    }
    public boolean Operation_to(int size, int to_id){
        Account temp=null;
        for(int i=0; i<stored_accounts.size();i++){
            if(stored_accounts.get(i).id==to_id)
                temp = stored_accounts.get(i);
        }
        if(temp==null){
            System.out.println("Нет такого пользователя");
            return false;
        }
        if(this.money>size) {
            this.money -= size;
            temp.money += size;
            this.history.add(new History(size, to_type, this.id, temp.id));
            temp.history.add(new History(size, in_type, this.id, temp.id));
            return true;
        }
        else {
            System.out.println("Нет денюх");
            return false;
        }
    }

    public int getId() {
        return id;
    }

    public void refresh(){
        System.out.println("id " + this.id);
        System.out.println("money " +this.money);

    }
    public void output_history(){
        for(int i=0;i<this.history.size();i++){
            System.out.println("////////////////////////////////////////////////////");
            System.out.println("История пользователя "+ this.id);
            System.out.println("////////////////////////////////////////////////////");
            if(this.history.get(i).type == in_type) System.out.println("Поступление средств");
            if(this.history.get(i).type == out_type) System.out.println("Вывод средств");
            if(this.history.get(i).type == to_type) System.out.println("Перечисление средств");
            System.out.println("дата "+this.history.get(i).date.toString());
            System.out.println("величина "+this.history.get(i).size);
            System.out.println("от "+this.history.get(i).from_id);
            System.out.println("к "+this.history.get(i).to_id);
            System.out.println();
            System.out.println();
        }
    }
}
