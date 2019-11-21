import java.io.File;

/**
 * Class UnkownFile
 *
 * Sources of Help:
 *  * Java Docs
 *  * Piazza
 *  * geeksforgeeks
 *
 * @author Stephan Zapodeanu
 * @version November 10, 2019
 */

public class UnknownFile extends CommonFile {

    public UnknownFile(File unknownFile) throws InvalidFileException {
        super(false, false, "Unknown Program");
        if (!unknownFile.getName().contains(".")) {
            throw new InvalidFileException("Invalid File Exception");
        } else {
            setFileSizeInBytes(unknownFile.length());
            setFile(unknownFile);

        }
    }

    public String getFileType() {
        return "Unknown";
    }

    public String toString() {
        return "UnknownFile[" +
                getFileType() + ", " +
                super.getFileSizeInBytes() + ", " +
                super.getFile().getName() + "]";
    }

    public boolean equals(Object object) {
        return true;
    }
}
