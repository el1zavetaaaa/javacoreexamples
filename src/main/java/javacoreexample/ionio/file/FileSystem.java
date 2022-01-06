package javacoreexample.ionio.file;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileSystem {
    public static void main(String[] args) throws IOException {
        File file = new File("files");
        String[] getFilesWithRightName = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.startsWith("file");
            }
        });

        System.out.print("Specific files with prefix 'file' into directory 'files': ");
        for (String getArrayOfFiles : getFilesWithRightName) {
            System.out.print("\n" + getArrayOfFiles);
        }

        File file1 = new File("files\\fileInput.txt");
        System.out.println("\n" + "\nAbsolute path to file: " + file1.getAbsolutePath());
        System.out.println("Parent file: " + file1.getParentFile());
        System.out.println("File name: " + file1.getName());
        System.out.println("Whether you can read a file: " + file1.canRead());
        System.out.println("Whether you can write into a file: " + file1.canWrite());
        System.out.println("Last modified: " + file1.lastModified());
        System.out.println("Hashcode: " + file1.hashCode());

        Path paths = Paths.get("files","fileChannel.txt");

        Stream<String> lines = Files.lines(paths);
        lines.forEach((s -> System.out.println(s)));
    }
}
