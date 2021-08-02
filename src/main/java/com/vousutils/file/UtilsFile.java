package com.vousutils.file;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class UtilsFile {
    /**
     * Determine whether one specific file is occupied.
     *
     * @param f the specific file(absolute path).
     * @return boolean
     * @author Taoning Ge
     * @since 0.3.0
     */
    public static boolean isFileOccupied(String f) {
        File file = new File(f);
        if (!file.exists()) return false;
        try {
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            raf.close();
        } catch (IOException e) {
            return true;
        }
        return false;
    }

    /**
     * Determine whether one specific filename is ok.
     * <p>
     * <strong>\ / : * ? " < > |</strong> are not allowed to appear.
     *
     * @param s one filename
     * @return boolean
     * @author Taoning Ge
     * @since 0.3.0
     */
    public static boolean isFileNameOK(String s) {
        String[] array = new String[]{"\\", "/", ":", "*", "?", "<", ">", "|"};
        for (String a : array) {
            if (s.contains(a)) return false;
        }
        return true;
    }

}
