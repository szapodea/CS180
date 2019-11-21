import java.io.File;


/**
 * CommonFile Class
 * Sources of Help:
 *  * Java Docs
 *  * Piazza
 *  * geeksforgeeks
 *
 * @author Stephan Zapodeanu, szapodea@purdue.edu
 * @version November 10, 2019
 */
public abstract class CommonFile {
    private boolean canOpen;
    private boolean canPlay;
    private File file;
    private long fileSizeInBytes;
    private String programToOpenIn;

    public CommonFile() {
        canOpen = false;
        canPlay = false;
        programToOpenIn = null;
    }

    public CommonFile(boolean canOpen, boolean canPlay, String programToOpenIn) {
        this.canOpen = canOpen;
        this.canPlay = canPlay;
        this.programToOpenIn = programToOpenIn;
    }

    public boolean getOpenable() {
        return canOpen;
    }

    public boolean getPlayable() {
        return canPlay;
    }

    public long getFileSizeInBytes() {
        return fileSizeInBytes;
    }

    public File getFile() {
        return file;
    }

    public abstract String getFileType();

    public String getExtension() {
        String fileName =  file.getName();
        String output = fileName.substring(fileName.indexOf("."));
        return output;
    }

    public String getOpensWith() {
        return programToOpenIn;
    }

    public void setCanOpen(boolean canOpen) {
        this.canOpen = canOpen;
    }

    public void setCanPlay(boolean canPlay) {
        this.canPlay = canPlay;
    }

    public void setProgramToOpenIn(String programToOpenIn) {
        this.programToOpenIn = programToOpenIn;
    }

    public void setFileSizeInBytes(long fileSizeInBytes) {
        this.fileSizeInBytes = fileSizeInBytes;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String toString() {
        return String.format("CommonFile[%d, %s]", fileSizeInBytes, this.getExtension());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        CommonFile that = (CommonFile) object;
        return canOpen == that.canOpen &&
                canPlay == that.canPlay &&
                fileSizeInBytes == that.fileSizeInBytes &&
                file.equals(that.file) &&
                programToOpenIn.equals(that.programToOpenIn);
    }
}
