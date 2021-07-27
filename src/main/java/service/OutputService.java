package service;

import instance.Line;

import java.util.ArrayList;

public class OutputService {
   public static void printArrayList (ArrayList<Line> arrayList) {
       for(Line line: arrayList) {
           System.out.println(line);
       }
   }
}
