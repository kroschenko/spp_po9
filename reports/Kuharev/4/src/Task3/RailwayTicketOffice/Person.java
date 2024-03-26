package RailwayTicketOffice;

import com.sun.tools.javac.Main;

import java.util.Scanner;

abstract public class Person {
    int type;
    abstract public void Action();
    abstract public void Menu(String action);
}
