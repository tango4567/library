package com.sowmitras.utils;

import android.app.Activity;
import android.os.Environment;

import com.sowmitras.utils.pojo.Contact;

import java.io.File;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.List;

import static com.sowmitras.utils.Tout.print;

public class CreateCsvFile {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String FILE_HEADER = "Name, Number";

    public CreateCsvFile() {
    }

    /**
     *
     * @param activity
     * @param fileName
     * @param students
     * */
    public static boolean writeCsvFile(Activity activity, String fileName, List<Contact> students) {
        boolean operation = false;
        File file = new File(Environment.getRootDirectory().getAbsolutePath(), fileName);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(activity.getFilesDir().getAbsolutePath() + "_" + file.getName());

            fileWriter.append("Name, Number".toString());
            fileWriter.append("\n");
            Iterator iterator = students.iterator();
            while (iterator.hasNext()) {
                Contact student = (Contact) iterator.next();
                fileWriter.append(String.valueOf(student.getName()));
                fileWriter.append(",");
                fileWriter.append(String.valueOf(student.getNumber()));
                fileWriter.append("\n");
            }
            fileWriter.close();
            operation = true;
        } catch (Exception var14) {
            print("Error in file creation !!!");
            var14.printStackTrace();
        }
        return operation;
    }
}
