import java.util.ArrayList;

public class Page {
    ArrayList<Paragraph> list;
    public void out(){
        for(int i=0;i<this.list.size();i++){
            this.list.get(i).out();
        }
    }
    Page(){
        this.list = new ArrayList<Paragraph>();
        this.list.add(new Paragraph("afqasgtregghfew dfgtrw rtew re trewy trew\n erytrwhtrdrew"));
        this.list.add(new Paragraph("afqtrewy trew\n erytrwhtrdrew"));
        this.list.add(new Paragraph("afqasgtreвнпраовопапавоав trew\n eryвапорваdrew"));
    }
    Paragraph getParagraph(int index){
        return this.list.get(index);
    }
    void delParagraph(int index){
        this.list.remove(index);
    }
    void addParagraph(int index, Paragraph para){
        this.list.add(index,para);
    }
    void addParagraphEnd(int index, Paragraph para){
        this.list.add(para);
    }
}
