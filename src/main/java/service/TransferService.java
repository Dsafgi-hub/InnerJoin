package service;

import instance.Line;

import java.util.*;

public class TransferService {
    public static LinkedList<Line> transferToLinkedList(ArrayList<Line> list){
        LinkedList<Line> result = new LinkedList<>(list);
        result.sort(Comparator.comparingInt(Line::getId));
        return result;
    }

    public static HashMap<Integer, Line> transferToHashMap(LinkedList<Line> linkedList) {
        HashMap<Integer, Line> result = new HashMap<>();
        for (Line line : linkedList) {
            result.putIfAbsent(line.getId(), line);
        }
        return result;
    }
}
