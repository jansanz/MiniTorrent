/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package torrentUi;

import java.io.File;

/**
 * A helper class for handling torrent files
 * @author janfsd
 */
public class Utils {
    public final static String torrent = "torrent";

    /**
     * Gets the extension of a file.
     * @param f File
     * @return String
     */
    public static String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 &&  i < s.length() - 1) {
            ext = s.substring(i+1).toLowerCase();
        }
        return ext;
    }
}
