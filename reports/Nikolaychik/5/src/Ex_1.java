public class Ex_1 {
    //когда рабочие трудятся вместе, они получают большую долю
    //и соответственно поовышают настроение, а если приходит начальник
    //то он забирает больше денег и отнимает настроение трудящегося
    Ex_1() {
        Employee Factory[] = new Employee[3];
        //Director dir=new Director(19,"Milosh",300,41);
        Factory[0]=new Director(19,"Milosh",300,41);;
        Factory[1]=new Engineer(44,"Ricardo",100,41);
        Factory[2]=new Engineer(33,"Mykola",150,41);
        for (int i = 0; i < 3; i++) {
            Factory[i].out();
        }
        Factory[0].Interaction(Factory[1],50);
        Factory[0].Interaction(Factory[2],50);
        out(Factory);
        Factory[1].Interaction(Factory[2],50);
        out(Factory);
    }
    void out(Employee Factory[]){
        for (int i = 0; i < 3; i++) {
            Factory[i].out();
        }
        System.out.println();
        System.out.println();
        System.out.println();

    }
}
