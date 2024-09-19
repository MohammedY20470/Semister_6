package week1;

public class Main{
    public static void main(String[] args) {
        Point point[]= new Point[10];
        for(int i=0; i<point.length; i++){
            //pointer= new object of pointer
            point[i]= new Point();
            //this will link the objects together 
            if(i != 0){
                point[i].next= point[i-1];
            }
        }
        for(int i=0; i<point.length; i++){
            //this case will be diffrent you are creaating a
            //  pointer that points at another object 
            //  and changing it is content : )
            Point changePointVal= point[i];
            changePointVal.x = i+1;
            changePointVal.y = i+3;
        }
        System.out.println("end");
    }
}