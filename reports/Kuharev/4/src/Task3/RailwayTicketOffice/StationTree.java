package RailwayTicketOffice;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

public class StationTree {
    static private Node root = root = new Node("Technical University");//корневая станция
    static private int level = 0;
    public StationTree(){

    }
    public static void insert(String name, String station){
        Node parent = findParent(name);
        if(parent == null){
            System.out.println("Station not found");
            return;
        }
        Node child = findParent(station);
        if(child != null){
            System.out.println("Station already exist");
            return;
        }
        Node new_node = new Node(station);
        new_node.setParent(parent);
        parent.setChild(new_node);
        System.out.println("Success");
    }
    public static Node findParent(String name){
        if(name.equals(root.getStation())){
            return root;
        }
        return findParent(root, name);
    }
    public static Node findParent(Node current, String name){
        if (current == null) {
            return null;
        }
        if (current.getStation().equals(name)) {
            return current;
        }
        ArrayList<Node> child = current.getChildren();
        if(child == null){
            return null;
        }
        for (int i = 0; i < child.size(); ++i) {
            Node foundNode = findParent(child.get(i), name);
            if (foundNode != null) {
                return foundNode;
            }
        }
        return null;
    }//?????????????????????????????????????????????add stations tree output
    public static void show(){
        show(root);
    }
    public static void show(Node current){
        String symb = "├─";
        ++level;
        if (current == null) {
            return;
        }
        System.out.println(current.getStation());
        ArrayList<Node> child = current.getChildren();

        if(child == null){
            return;
        }
        for (int i = 0; i < child.size(); ++i) {
            if(i == child.size()-1){
                symb = "└─";
            }
            for(int j = 0; j < level*2; ++j)
                System.out.print("  ");
            System.out.print(symb);
            show(child.get(i));
            //System.out.print(child.get(i).getStation());
        }
        --level;
        return;
    }//??????????????????????????????????????????????????????????????????
    public static ArrayList<String> showToRoot(String name){
        Node parent = findParent(name);
        if(parent == null){
            System.out.println("Station not found");
            return null;
        }
        ArrayList<String> path = new ArrayList<String>();
        System.out.println("Path to station '" + name + "': ");
        path.add(name);
        showToRoot(parent, path);
        String tab = "";
        for(int i = path.size()-1; i > -1; --i){
            if(i == path.size()-1){
                System.out.println(path.get(i));
            }else{
                tab+="  ";
                System.out.println(tab+"└─"+path.get(i));
            }
        }
        return path;
    }
    public static void showToRoot(Node grandParent, ArrayList<String> path){
        Node parent = grandParent.getParent();
        path.add(parent.getStation());
        if(!parent.equals(root)){
            showToRoot(parent, path);
        }
        return;
    }
}
/*
├─
│
└─
 */