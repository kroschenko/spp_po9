public class Main {
    public static void main(String[] args) {
        System.out.println("\n1 ПРИМЕР\n");
        example_1();
        System.out.println("\n2 ПРИМЕР\n");
        example_2();

    }
    public static void example_1(){
        Account acc1 = new Account();
        Account acc2 = new Account();
        acc1.refresh();
        System.out.println("\nПополнение 500\n");
        acc1.Operation_in(500);
        acc1.refresh();
        acc2.refresh();
        System.out.println("\nПеревод 250\n");
        acc1.Operation_to(250, acc2.getId());
        acc1.refresh();
        acc2.refresh();
        System.out.println("\nВывод 200\n");
        acc2.Operation_out(200);
        acc2.refresh();
    }
    public static void example_2(){
        Page page = new Page();
        page.out();
        System.out.println("\nУдаление и добавление параграфа\n");
        page.addParagraph(0,new Paragraph("ABOBA"));
        page.delParagraph(2);
        System.out.println();
        page.out();
    }
    public static void example_3(){
        Hospital hospital= new Hospital();
        hospital.out_doc();
        hospital.out_pat();
    }
}