import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparePractice {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("mark", 24));
        personList.add(new Person("jeno", 23));
        personList.add(new Person("jisung", 21));

        Collections.sort(personList);
        System.out.println(personList);

        personList.sort(new nameSort());
        System.out.println(personList);
    }
}

class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public int getAge(){
        return this.age;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String toString() {
        return "[" + name + ": " + age + "]";
    }

    @Override
    public int compareTo(Person o) {
        // Integer.compare(a,b)
        // a value less than 0 if x < y;
        // a value greater than 0 if x > y
        return Integer.compare(this.age, o.getAge());
    }
}

//class Person implements Comparator<Person> {
//    private String name;
//    private int age;
//
//    public Person(String name, int age){
//        this.name = name;
//        this.age = age;
//    }
//
//    public String getName(){
//        return this.name;
//    }
//
//    @Override
//    public String toString() {
//        return "[" + name + ": " + age + "]";
//    }
//
//    @Override
//    public int compare(Person o1, Person o2) {
//        return o1.getName().compareTo(o2.getName());
//    }
//}

class nameSort implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        // a value less than 0 if this string is lexicographically less than the string argument;
        // a value greater than 0 if this string is lexicographically greater than the string argument.
        return o1.getName().compareTo(o2.getName());
    }
}