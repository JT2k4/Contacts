package view;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Menu {
    private ArrayList mChon= new ArrayList();
    private String title=""; 
//--------------------------------------

    public Menu(String[] mc, String td){
       for(String m:mc) mChon.add(m);
       title=td;
    }
/**
 * This is for menus with changing elements
 */
    public Menu(ArrayList mc, String td){
       mChon = mc;
       title=td;
    }
//--------------------------------------
    public void setTitle(String td){
        title=td;
    }
//--------------------------------------
    public ArrayList getmChon() {
        return mChon;
    }
//--------------------------------------    
    public void addItem(Object a){
        mChon.add(a);
    }
//--------------------------------------
    public void display(){
        System.out.println(title);
        System.out.println("-----------------------------");
        for(int i=0; i<mChon.size();i++) 
            System.out.println((i+1)+". "+mChon.get(i));
        System.out.println("-----------------------------");
    }
//--------------------------------------   
    public int getSelected(){
        display();
        System.out.print("Please select..: ");
        Scanner sc= new Scanner(System.in);
        return sc.nextInt();
    }
//--------------------------------------
    public abstract void execute(int n);
//--------------------------------------
    public void run(){
        while(true){
            int n=getSelected();
            if(n>mChon.size() || n <= 0) break;
            execute(n);
        }
    }

//--------------------------------------    
}
