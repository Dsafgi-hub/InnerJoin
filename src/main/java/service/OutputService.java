package service;

import instance.Line;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutputService {
   public static void printList(List<Line> list) {
       for(Line line: list) {
           if (line.getJoinField() == null) {
               System.out.printf("%-5d %12s \n", line.getId(), line.getField());
           } else {
               System.out.printf("%-5d %12s %12s\n", line.getId(), line.getField(), line.getJoinField());
           }

       }
   }

   public static void printMap(HashMap<Integer, Line> hashMap) {
       for(Map.Entry<Integer,Line> entry: hashMap.entrySet()) {
           System.out.printf("%-5d %12s %12s\n", entry.getKey(), entry.getValue().getField(), entry.getValue().getJoinField());
       }
   }

}
