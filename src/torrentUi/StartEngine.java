/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package torrentUi;

import jBittorrentAPI.*;
import jBittorrentAPI.Utils;
import java.io.File;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

/**
 * Class that serves as a way to communicate
 * between the API and the GUI.
 * Inherits from the SwingWorker class, it is a way of startin a new thread
 * @author janfsd
 */
public class StartEngine extends SwingWorker<Void, Object> {

    private DownloadManager dm;
    private TorrentProcessor tp;
    private TorrentFile torrentfile;
    private File file;
    private JTextArea log;
    private JProgressBar jp;
    private JLabel speedLabel;
    

    /**
     * Constructor for the StartEngine object
     * @param file File The bittorrent file
     * @param log JTextArea
     * @param jp JProgressBar
     * @param speedLabel JLabel
     */
    public StartEngine(File file, JTextArea log, JProgressBar jp, JLabel speedLabel) {
                    
            this.file = file;
            this.log = log;
            this.jp = jp;
            this.speedLabel = speedLabel;
        
    }

    /**
     * Starts a new thread in the background, for this case
     * starts the API
     * @return void
     */
    public Void doInBackground() {

        try {
            tp = new TorrentProcessor();
           torrentfile = tp.getTorrentFile(tp.parseTorrent(file));
 

        if (torrentfile != null) {
                log.append("Torrent parsed...\n");
                dm = new DownloadManager(torrentfile, Utils.generateID(), log, jp, speedLabel);
                dm.startListening(6881, 6889);
                log.append("Listening started...\n");
                dm.startTrackerUpdate();
                log.append("Tracker Update...\n");
                dm.blockUntilCompletion();
                dm.stopTrackerUpdate();
                dm.closeTempFiles();
                log.append("Closing files\n");


            } else {
//                System.err.println(
//                        "Provided file is not a valid torrent file");
//                System.err.flush();
//                System.exit(1);
                log.append("Provided file is not a valid torrent file");
            }
        } catch (Exception e) {

            log.append("Error while processing torrent file. Please restart the client");
            //e.printStackTrace();
//            System.err.println("Error while processing torrent file. Please restart the client");

            System.exit(1);
        }
        return null;
    }


}
