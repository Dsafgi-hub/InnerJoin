package service;

import instance.Line;

import java.nio.file.Path;
import java.util.ArrayList;


public class Service {
    public static void main(String[] args) {
        if (args.length > 1) {
            ArrayList<Line> firstArrayList = InputFileService.uploadEmployeeFromFile(Path.of(args[0]));
            ArrayList<Line> secondArrayList = InputFileService.uploadEmployeeFromFile(Path.of(args[1]));
            OutputService.printArrayList(InnerJoinService.innerJoin(firstArrayList, secondArrayList));


        } else {
            System.out.println("Внимание! Укажите путь к обоим файлам во входных аргументах(args[0] и args[1])");
        }
    }

}
