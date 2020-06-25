import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Collections;
public class Reflection {
    public static void main(String[] args){
        Class<Student> student = /*~~~Complete this line~~~*/ Student.class;
        Method[] methods = /*~~~Complete this line~~~*/ student.getDeclaredMethods(); 
        //getMethods returns even undeclared methods, here we are using the Student class declared in another file

        ArrayList<String> methodList = new ArrayList<>();
        for(/*~~~Complete this line~~~*/ Method m: methods){
            methodList.add(/*~~~Complete this line~~~*/m.getName());
        }
        Collections.sort(methodList);
        for(String name: methodList){
            System.out.println(name);
        }
    }
}