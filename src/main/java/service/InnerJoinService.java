package service;

import instance.Line;

import java.util.*;


public class InnerJoinService {
    public static ArrayList<Line> innerJoin(ArrayList<Line> firstArrayList, ArrayList<Line> secondArrayList) {
        ArrayList<Line> result = new ArrayList<>();
        for (Line firstLine: firstArrayList) {
            for (Line secondLine: secondArrayList) {
                if (firstLine.getId() == secondLine.getId()) {
                    result.add(new Line(firstLine.getId(), firstLine.getField(), secondLine.getField()));
                }
            }
        }
        return result;
    }

    public static LinkedList<Line> innerJoin(LinkedList<Line> firstLinkedList, LinkedList<Line> secondLinkedList) {
        LinkedList<Line> result = new LinkedList<>();
        Iterator<Line> firstIter = firstLinkedList.listIterator();
        Iterator<Line> secondIter = secondLinkedList.listIterator();
        Line firstLine = firstIter.next();
        Line secondLine = secondIter.next();

        while (true)  {
            int compare = Integer.compare(firstLine.getId(), secondLine.getId());
            if (compare < 0) {
                if (firstIter.hasNext()) {
                    firstLine = firstIter.next();
                } else {
                    break;
                }
            } else if (compare > 0) {
                if (secondIter.hasNext()) {
                    secondLine = secondIter.next();
                } else {
                    break;
                }
            } else {
                result.addLast(new Line(firstLine.getId(), firstLine.getField(), secondLine.getField()));
                if (firstIter.hasNext() && secondIter.hasNext()) {
                    firstLine = firstIter.next();
                    secondLine = secondIter.next();
                } else {
                    break;
                }
            }
        }
        return result;
    }

    public static HashMap<Integer, Line> innerJoin(HashMap<Integer, Line> firstHashMap, HashMap<Integer, Line> secondHashMap) {
        HashMap<Integer, Line> result = new HashMap<>();

        HashMap<Integer, Line> smallHashMap = firstHashMap.size() < secondHashMap.size() ? firstHashMap : secondHashMap;
        HashMap<Integer, Line> bigHashMap = firstHashMap.size() < secondHashMap.size() ? secondHashMap : firstHashMap;

        for (Map.Entry<Integer,Line> entry: smallHashMap.entrySet()) {
            if (bigHashMap.containsKey(entry.getKey())) {
                result.putIfAbsent(entry.getKey(), new Line(entry.getKey(), entry.getValue().getField(), bigHashMap.get(entry.getKey()).getField()));
            }
        }

        return result;
    }

}
