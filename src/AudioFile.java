import java.io.File;
import java.io.ObjectOutputStream;
import java.util.Objects;

/**
 * Class AudioFile
 *
 *Sources of Help:
 *  * Java Docs
 *  * Piazza
 *  * geeksforgeeks
 * @author Stephan Zapodeanu, szapodea@purdue.edu
 * @version November 10, 2019
 */
public class AudioFile extends CommonFile {
    private int songLength;

    public AudioFile(File audio, int songLengthInSeconds) throws InvalidAudioFileException {
        super(true, true, "iTunes");
        if (songLengthInSeconds < 0) {
            throw new InvalidAudioFileException("Invalid Audio File Exception");
        } else {
            super.setFile(audio);
            songLength = songLengthInSeconds;
            super.setFileSizeInBytes(audio.length());
        }

    }

    public String getFileType() {
        return "Audio";
    }

    public String getSongLength() {
        int minutes = 0;
        int newSongLength = songLength;
        while (newSongLength > 60) {
            minutes++;
            newSongLength -= 60;
        }
        int seconds = newSongLength;
        return String.format("%d minutes and %d seconds", minutes, seconds);
    }

    @Override
    public String toString() {
        return "AudioFile[" +
                getFileType() + ", " +
                super.getFileSizeInBytes() + ", " +
                super.getFile().getName() + ", " +
                getSongLength() + "]";
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof AudioFile) {
            AudioFile audioFile = (AudioFile) object;
            return audioFile.getOpenable() == this.getOpenable() &&
                    audioFile.getPlayable() == this.getPlayable() &&
                    audioFile.getSongLength().equals(this.getSongLength())  &&
                    audioFile.getFileSizeInBytes() == this.getFileSizeInBytes() &&
                    audioFile.getOpensWith().equals(this.getOpensWith()) &&
                    audioFile.getFile() == this.getFile();
        }
        return false;
    }

}
