package com.leetcode.leetcode.listQuestions.iterations;

import java.util.*;

public class Iterations {
    public static void main(String[] args) {

        //using for loop
        List<Integer>list=new ArrayList<>();
        for (int i=0;i<10;i++){
            list.add(i);
            System.out.println(list);
            list.remove(3);
            for (int i1=0;i1<list.size();i1++){
                System.out.println(list.get(i1)+" ");
            }
        }
        //using for each: The for-each loop is a simple and readable way to iterate over elements in a list.
        // It does not allow modification of the list during iteration.
        List<Integer> list2 = Arrays.asList(1, 3, 2, 4, 2, 5);
        for (Integer num : list2) {
            System.out.println("Print List:" + num);
        }

        //2. Iterator
        //       The Iterator interface provides methods to iterate over a collection
        //       and allows safe removal of elements during iteration.

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            System.out.println(next);
//            iterator.remove();
        }

        /*     Cursor: Generally used for database operations, not for lists.
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "user", "password");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM mytable");

        while (resultSet.next()) {
            String data = resultSet.getString("column_name");
            System.out.println(data);
            }

         */
        /*
               ListIterator: Bidirectional traversal and element modification.

         */
        List<String> list1 = new ArrayList<>(Arrays.asList("A", "B", "C", "D"));
        ListIterator<String> listIterator = list1.listIterator();
        while (listIterator.hasNext()) {
            String item = listIterator.next();
            System.out.println(item);
            // Modify element during iteration
            // listIterator.set("E");
        }
        while (listIterator.hasPrevious()) {
            String item = listIterator.previous();
            System.out.println(item);
        }
        /*
        Enumeration:        Enumeration: Used with legacy classes, no element removal.

         */
        Vector<String> vector = new Vector<>(Arrays.asList("A", "B", "C", "D"));
        Enumeration<String> enumeration = vector.elements();
        while (enumeration.hasMoreElements()) {
            String item = enumeration.nextElement();
            System.out.println(item);
        }
    }
}
