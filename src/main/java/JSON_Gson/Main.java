package JSON_Gson;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
class Loan{
    @Override
    public String toString() {
        return "Loan: " + super.toString();
    }
}
class Circle{
    @Override
    public String toString() {
        return "Circle: " + super.toString();
    }
}
public class Main {

    static Scanner input = new Scanner(System.in);
    public  static  void  main(String[]  args){

        ArrayList<Object> obj =new ArrayList<Object>();
        obj.add(new Loan());
        obj.add(new Circle());
        obj.add(new Date());
        obj.add("a string");
        for(Object tmp : obj){
            System.out.println(tmp.toString());
        }


    }

}

