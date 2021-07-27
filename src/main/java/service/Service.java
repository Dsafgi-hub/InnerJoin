package service;

import instance.Line;

import java.nio.file.Path;
import java.util.*;


public class Service {
    public static void main(String[] args) {
        if (args.length > 1) {
            ArrayList<Line> firstArrayList = InputFileService.uploadFromFile(Path.of(args[0]));
            ArrayList<Line> secondArrayList = InputFileService.uploadFromFile(Path.of(args[1]));

            System.out.println("Исходный первый файл:");
            OutputService.printList(firstArrayList);
            System.out.println("\nИсходный второй файл:");
            OutputService.printList(secondArrayList);

            System.out.println("\nРезультаты Inner Join c помощью ArrayList:");
            OutputService.printList(InnerJoinService.innerJoin(firstArrayList, secondArrayList));

            LinkedList<Line> firstLinkedList = TransferService.transferToLinkedList(firstArrayList);
            LinkedList<Line> secondLinkedList = TransferService.transferToLinkedList(secondArrayList);
            System.out.println("\nРезультаты Inner Join c помощью отсортированного ArrayList:");
            OutputService.printList(InnerJoinService.innerJoin(firstLinkedList, secondLinkedList));

            HashMap<Integer, Line> firstHashMap = TransferService.transferToHashMap(firstLinkedList);
            HashMap<Integer, Line> secondHashMap = TransferService.transferToHashMap(secondLinkedList);
            System.out.println("\nРезультаты Inner Join c помощью HashMap:");
            OutputService.printMap(InnerJoinService.innerJoin(firstHashMap, secondHashMap));
        } else {
            System.out.println("Внимание! Укажите путь к обоим файлам во входных аргументах(args[0] и args[1])");
        }
    }
}
