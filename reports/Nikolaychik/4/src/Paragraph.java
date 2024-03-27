public class Paragraph {
    String storage;
    Paragraph(String storage){
        this.storage= storage;
    }
    public void out(){
        System.out.println(this.storage);
        System.out.println();
    }
}
