/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package torrentUi;

import java.io.File;
import javax.swing.filechooser.*;

/**
 * TorrentFilter class for showing only .torrent files
 * @author janfsd
 */
public class TorrentFilter extends FileFilter {
    
    /**
     * Accepts alle directories and torrent files
     * @param f File
     * @return boolean true if there is a directory or .torrent to show
     */
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }

        String extension = Utils.getExtension(f);
        if (extension != null) {
            if (extension.equals(Utils.torrent)) {
                    return true;
            } else {
                return false;
            }
        }

        return false;
    }

    //The description of this filter
    public String getDescription() {
        return "Just Torrent Files";
    }
}
