package service;

import instance.InnerJoinLine;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class OutputFileService {
    static void writeResultToFile(List<InnerJoinLine> result, Path filename)  {
        try (BufferedWriter writer = Files.newBufferedWriter(filename)) {
            for(InnerJoinLine line: result) {
                writer.write(String.valueOf(line));
            }
            writer.flush();
        } catch (IOException e) {
            System.out.println("Внимание! Проверьте путь к файлу: файл для записи результата не найден");
        }
    }
}
