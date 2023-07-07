import java.util.ArrayList;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {
        //set initial capacity to 5
        List<String> list=new ArrayList<String> (5);
        list.add("John");
        list.add("Ari");
        list.add("Jack");
        list.add("Jill");
        list.add("AJ");
        for (String str : list) {
            System.out.println(str);
        }
    }
}
