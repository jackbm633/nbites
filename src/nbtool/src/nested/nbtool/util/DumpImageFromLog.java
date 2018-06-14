package nbtool.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.imageio.ImageIO;

import nbtool.util.SharedConstants;
import nbtool.data.log.Block;
import nbtool.data.log.Log;

public class DumpImageFromLog{
    

    public static void main(String[] args) {

        BufferedImage img = null;
        // Grab the filename of the log from the terminal.
        String fileName = args[0];

        File logFile = new File(fileName);
        FileInputStream fin = null;
        byte[] logContent = null;
        try {
            // Create a FileInputStream object
            fin = new FileInputStream(logFile);
            logContent = new byte[(int) logFile.length()];

            fin.read(logContent);
        } catch (FileNotFoundException fnfe) {
            System.out.println("Log file not found" + fnfe);
        } catch (IOException ioe) {
            System.out.println("Exception caught while reading file" + ioe);
        } finally {
            // Close streams
            try {
                if (fin != null) {
                    fin.close();
                }
            }
             catch (IOException ioe) {
                    System.out.println("Error while closing stream " + ioe);
                }
            }
        

        // We then convert the byte array into a log so we can extract the
        // image.

        Block logBlock = new Block(logContent, 
            SharedConstants.LogType_DEFAULT());

        Log returnedLog = logBlock.parseAsLog();

        img = returnedLog.blocks.get(0).parseAsYUVImage().toBufferedImage();
        
        try {
            File outputFile = new File(fileName + ".png");
            ImageIO.write(img, "png", outputFile);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }




}  


