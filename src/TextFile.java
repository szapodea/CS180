import java.io.*;
import java.nio.file.Files;

/**
 * TextFile Class
 * <p>
 * Sources of Help:
 * * Java Docs
 * * Piazza
 * * geeksforgeeks
 *
 * @author Stephan Zapodeanu, szapodea@purdue.edu
 * @version November 10, 2019
 */

public class TextFile extends CommonFile {
    private long numberOfLines;

    public TextFile(File text) throws IOException, InvalidTextFileException {
        super(true, false, "TextEdit");
        long lines = 0;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(text));
        String isLine = bufferedReader.readLine();
        while (isLine != null) {
            lines++;
            isLine = bufferedReader.readLine();
        }
        if (lines < 0) {
            throw new InvalidTextFileException("Interrupted Text File Exception!");
        } else {
            numberOfLines = lines;
            super.setFileSizeInBytes(text.length());
        }

    }

    public String getFileType() {
        return "Text";
    }

    public long getLines() {
        return numberOfLines;
    }

    public long getOccurrences(String charSequence) throws FileNotFoundException, IOException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(this.getFile()));
            String line;
            int count = 0;
            while (bufferedReader.readLine() != null) {
                line = bufferedReader.readLine();
                if (line.contains(charSequence)) {
                    count++;
                }
            }
            return count;
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("e");
        }
    }

    @Override
    public String toString() {
        return "TextFile[" +
                getFileType() + ", " +
                super.getFileSizeInBytes() + ", " +
                super.getFile().getName() + ", " +
                getLines() + "]";
    }
    //canOpen, canPlay, numberOfLines, fileSizeInBytes, programToOpen fields, and the file object.
    public boolean equals(Object object) {
        if (object instanceof TextFile) {
            TextFile textFile = (TextFile) object;
            return getOpenable() == textFile.getOpenable() &&
                    getPlayable() == textFile.getPlayable() &&
                    getFileSizeInBytes() == textFile.getFileSizeInBytes() &&
                    getLines() == textFile.getLines() &&
                    textFile.getOpensWith().equals(getOpensWith()) &&
                    textFile.getFile() == getFile();
        }
        return false;
    }
}
