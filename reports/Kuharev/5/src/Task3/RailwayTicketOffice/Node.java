package RailwayTicketOffice;

import java.util.ArrayList;

public class Node{
    public String station_name;
    public Node parent;
    public Node child;
    private ArrayList<Node> children;
    public Node(String station){
        this.station_name = station;
        this.parent = null;
        this.child = null;
        children = new ArrayList<Node>();
    }
    public void setParent(Node parent){
        this.parent = parent;
    }
    public void setChild(Node child){
        this.child = child;
        children.add(child);
    }
    public Node getParent(){
        return parent;
    }
    public Node getChild(){
        return child;
    }
    public ArrayList<Node> getChildren(){
        return children;
    }
    public String getStation(){
        return station_name;
    }
}
