package service;

import instance.Line;

import java.util.*;

public class TransferService {
    public static LinkedList<Line> transferToLinkedList(ArrayList<Line> list) {
        LinkedList<Line> result = new LinkedList<>();
        list.stream()
                .sorted(Comparator.comparingInt(Line::getId))
                .forEachOrdered(result::add);
        return result;
    }

    public static HashMap<Integer, ArrayList<Line>> transferToHashMap(LinkedList<Line> linkedList) {
        HashMap<Integer, ArrayList<Line>> result = new HashMap<>();
        linkedList.forEach(line -> result.putIfAbsent(line.getId(), new ArrayList<>()));
        linkedList.stream()
                .filter(line -> result.containsKey(line.getId()))
                .forEach(line -> result.get(line.getId()).add(line));
        return result;
    }
}
