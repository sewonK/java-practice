import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class StreamPractice {
    public static void main(String[] args) {
        String[] strArr = {"aaa", "bbb", "ccc"};
        List<String> strList = Arrays.asList(strArr);

        Arrays.sort(strArr);
        Collections.sort(strList);
        for(String str : strArr)
            System.out.println(str);
        for(String str : strList)
            System.out.println(str);

        Stream<String> stringStream1 = strList.stream();
        Stream<String> stringStream2 = Arrays.stream(strArr);

        stringStream1.sorted().forEach(System.out::println);
        stringStream2.sorted().forEach(System.out::println);
    }
}
