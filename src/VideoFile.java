import java.io.File;

/**
 * Class VideoFile
 * Sources of Help:
 *  * Java Docs
 *  * Piazza
 *  * geeksforgeeks
 *
 * @author Stephan Zapodeanu, szapodea@purdue.edu
 * @version November 10, 2019
 */
public class VideoFile extends CommonFile {
    private long videoLengthInSeconds;

    public VideoFile(File video, long videoLength) throws InvalidVideoFileException {
        super(true, true, "Quicktime Player");
        if (videoLength < 0) {
            throw new InvalidVideoFileException("Invalid Video File Exception");
        }
        videoLengthInSeconds = videoLength;
        super.setFile(video);
        super.setFileSizeInBytes(video.length());
    }

    public String getFileType() {
        return "Video";
    }

    public String getVideoLength() {
        long minutes = 0;
        long newSongLength = videoLengthInSeconds;
        while (newSongLength > 60) {
            minutes++;
            newSongLength -= 60;
        }
        long seconds = newSongLength;

        return String.format("%d minutes and %d seconds", minutes, seconds);
    }

    public String toString() {
        return "VideoFile[" +
                getFileType() + ", " +
                super.getFileSizeInBytes() + ", " +
                super.getFile().getName()  + ", " +
                getVideoLength() + "]";
    }

    public boolean equals(Object object) {
        return true;
    }
}
