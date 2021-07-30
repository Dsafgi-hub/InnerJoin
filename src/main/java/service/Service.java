package service;

import innerJoin.*;
import instance.Line;

import java.nio.file.Path;
import java.util.*;


public class Service {
    public static void main(String[] args) {
        if (args.length > 4) {
            ArrayList<Line> firstArrayList = InputFileService.uploadFromFile(Path.of(args[0]));
            ArrayList<Line> secondArrayList = InputFileService.uploadFromFile(Path.of(args[1]));

            InnerJoin<ArrayList<Line>> arrayListInnerJoin = new ArrayListInnerJoin();
            OutputFileService.writeResultToFile(arrayListInnerJoin.innerJoin(firstArrayList, secondArrayList), Path.of(args[2]));

            LinkedList<Line> firstLinkedList = TransferService.transferToLinkedList(firstArrayList);
            LinkedList<Line> secondLinkedList = TransferService.transferToLinkedList(secondArrayList);
            InnerJoin<LinkedList<Line>> linkedListInnerJoin = new LinkedListInnerJoin();
            OutputFileService.writeResultToFile(linkedListInnerJoin.innerJoin(firstLinkedList, secondLinkedList), Path.of(args[3]));

            HashMap<Integer, ArrayList<Line>> firstHashMap = TransferService.transferToHashMap(firstLinkedList);
            HashMap<Integer, ArrayList<Line>> secondHashMap = TransferService.transferToHashMap(secondLinkedList);
            InnerJoin<HashMap<Integer, ArrayList<Line>>> hashMapInnerJoin = new HashMapInnerJoin();
            OutputFileService.writeResultToFile(hashMapInnerJoin.innerJoin(firstHashMap, secondHashMap), Path.of(args[4]));
        } else {
            System.out.println("Внимание! Укажите путь к обоим файлам во входных аргументах(args[0] и args[1])");
        }
    }
}
