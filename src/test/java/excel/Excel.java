package excel;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Excel {

    public static void main(String[] args) throws IOException {
        String path = System.getProperty("user.home") + "\\Downloads";
        String extension = ".xlsx";
        System.out.println(getLastCreatedFile(path, extension).getName());
    }


    public static File getLastCreatedFile(String path, String extension) throws IOException {
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        List<File> files = new LinkedList<>(Arrays.asList(listOfFiles)).stream()
                .filter(f -> f.getName().endsWith(extension)).collect(Collectors.toList());

        File returnFile = null;

        for (File file : files) {
            if (returnFile == null) returnFile = file;

            FileTime returnFileTime = Files.readAttributes(returnFile.toPath(), BasicFileAttributes.class).creationTime();
            FileTime fileTime = Files.readAttributes(file.toPath(), BasicFileAttributes.class).creationTime();

            if (fileTime.compareTo(returnFileTime) > 0) returnFile = file;
        }
        return returnFile;
    }

}
