package service;

import instance.Line;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;


public class InputFileService {
    public static ArrayList<Line> uploadEmployeeFromFile(Path inputFilePath) {
       ArrayList<Line> arrayList = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(inputFilePath)) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (checkValidData(line)) {
                    String[] params = line.split(",");
                    arrayList.add(new Line(Integer.parseInt(params[0]), params[1]));
                }
            }
        } catch (IOException e) {
            System.out.println("Внимание! Проверьте путь к файлу: исходный файл не найден");
        }
        return arrayList;
    }

    static boolean checkValidData (String line) {
        boolean flag = true;
        String[] fields = line.split(",");
        String commonPart = "Внимание! Проверьте строку " + line.trim() + ".";
        try {
            if (fields.length != 2) {
                throw new InputDataException( commonPart + " В ней должно быть ровно 2 поля");
            }

            if (fields[0].trim().equals("")
                    || fields[1].trim().equals("")) {
                throw new InputDataException( commonPart + " Не должно содержаться пустых полей");
            }

            String id = fields[0].trim();

            if (!id.matches("\\d+")) {
                throw new InputDataException(commonPart + " ID должно быть целым положительным числом");
            }
        } catch (InputDataException e) {
            flag = false;
            System.out.println(e.getMessage());
        }
        return flag;
    }
}

class InputDataException extends Exception {
    InputDataException(String message) {
        super(message);
    }
}