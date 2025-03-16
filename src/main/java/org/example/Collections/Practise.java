package org.example.Collections;

import com.sun.source.tree.Tree;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Practise {
    static class Employee{
        public String name;
        public String department;
        public double sal;
        Employee(String name, String department, double sal){
            this.name=name;
            this.department=department;
            this.sal=sal;
        }

        public String getName() {
            return name;
        }

        public String getDepartment() {
            return department;
        }

        public double getSal() {
            return sal;
        }
    }
    static class Product{
        private String name;
        private double price;
        Product(String name, double price){
            this.name=name;
            this.price=price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
    }

    static class Task{
        int timestamp;
        String taskDescription;
        Task(int timestamp, String taskDescription){
            this.timestamp=timestamp;
            this.taskDescription=taskDescription;
        }

        public int getTimestamp() {
            return timestamp;
        }

        public String getTaskDescription() {
            return taskDescription;
        }
    }
    public static void main(String[] args) {
        List<Integer>integers= Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        int evenSum=integers.stream().filter(i->i%2==0).reduce(0, Integer::sum);

        List<String> words=Arrays.asList("String1","String2","Tring1","Tring2");
        Map<Character, List<String>> map= words.stream().collect(Collectors.groupingBy(s -> s.charAt(0)));


        List<Employee>employees=Arrays.asList(
                new Employee("name1", "dept1",100.0),
                new Employee("name1", "dept2",130.0),
                new Employee("name1", "dept1",180.0),
                new Employee("name1", "dept2",120.0)
        );

        Map<String, Double>avgDeptSal=employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSal)));
        avgDeptSal.forEach((dept, sal)-> System.out.println(dept+"- "+sal));


        List<List<Integer>>nestedList=Arrays.asList(Arrays.asList(1,2,3,4), Arrays.asList(5,6,7,8));

        List<Integer>flatten=nestedList.stream().flatMap(List::stream).toList();
        flatten.forEach(System.out::println);



        List<String>words2=Arrays.asList("abcd","abcd1","abcd2","abcd3","abcd3","abcd2","abcd3");
        Map<String, Long>map1=words2.stream().collect(Collectors.groupingBy(s->s, Collectors.counting()));
        map1.forEach((str, count)-> System.out.println(str+" "+count));

        List<Product>products=Arrays.asList(
                new Product("product1",120.0),
                new Product("product2",130.0),
                new Product("Product4",140.0)
        );
        int THRESHOLD=120;
        products.stream().filter(product -> product.getPrice()>THRESHOLD).sorted(Comparator.comparingDouble(Product::getPrice).reversed()).toList().forEach(p1-> System.out.println(p1.getName()+" "+p1.getPrice()));


        Map<String, Integer> map11 = new HashMap<>();
        map11.put("apple", 2);
        map11.put("banana", 3);
        map11.put("orange", 1);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("banana", 4);
        map2.put("apple", 1);
        map2.put("kiwi", 5);


        Map<String, Integer>mergedMap=Stream.concat(map11.entrySet().stream(), map2.entrySet().stream()).collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                Integer::sum
        ));
        mergedMap.forEach((str,cnt)-> System.out.println(str+" "+cnt));


        TreeMap<Integer, String>tmap=new TreeMap<>();
        tmap.put(1, "String1");
        tmap.put(2, "String2");
        tmap.put(3, "String3");
        tmap.put(4,"String4");

        SortedMap<Integer, String>sub=tmap.subMap(2,true, 4, false);
        sub.forEach((num, cnt)-> System.out.println(num+" "+cnt));


        words2.stream().collect(Collectors.groupingBy(s->s, TreeMap::new, Collectors.counting()));


        List<Task>taskList=Arrays.asList(
                new Task(1,"task-123"),
                new Task(2, "task-321"),
                new Task(3, "task-4321"),
                new Task(1, "Task-1231")
        );
        TreeMap<Integer, List<Task>>timeStampedTasks=taskList.stream().collect(
                Collectors.groupingBy(
                        Task::getTimestamp,
                        TreeMap::new,
                        Collectors.toList()
                )
        );
    }
    private static int[] nearestKey(List<Integer>list, int key){
        TreeSet<Integer>tset=new TreeSet<>(list);
        return new int[]{tset.floor(key),tset.ceiling(key)};
    }
}
