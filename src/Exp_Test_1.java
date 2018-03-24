import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Exp_Test_1 {

    public static <T> void copyList(List<? extends T> source, List<? super T> target) {

        source.stream().forEach(target::add);

    }

    public static void main(String[] args) {

        /*List<Integer> source = new ArrayList<>();
        List<Integer> target = new LinkedList<>();

        for(int i=1;i<10;i++){
            source.add(i);
        }

        copyList(source,target);

        target.stream().forEach(System.out::println);*/
        String a ="Hello";
        String b = null;
        String c = a+b;
        //String d = a.concat(b);

        //System.out.println(null);
    }
}
