package org.fsmicdev.play.java8features.streams.sortingandskipping;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

/**
 *
 *
 * @author mic
 */
public class SortAndListOldestFilesSkippingN {

    public SortAndListOldestFilesSkippingN(List<File> files, int numOfNewestToLeave) {
        System.out.println("\n=============== SORTing and Skipping Top " + numOfNewestToLeave + " files ===============\n");

        files.stream()
                .sorted(comparing(File::lastModified).reversed())
                .skip(numOfNewestToLeave)
                .forEach(item -> System.out.println(item.getAbsolutePath() + " last modified " + new Date(item.lastModified())));
    }

    public static void main(String[] args) throws IOException {
        System.out.println("\n=============== All files in current directory ===============");

        Files.list(Paths.get("."))
                .forEach(file -> System.out.println(file.getFileName() + " last modified " + new Date(file.toFile().lastModified())));

        File[] files = new File(".").listFiles();

        List<File> fileList = new ArrayList(Arrays.asList(files));

        SortAndListOldestFilesSkippingN app = new SortAndListOldestFilesSkippingN(fileList, 2);
    }
}
