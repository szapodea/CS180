/**
 * Invalid Audio File Exception
 *
 * @author Stephan Zapodeanu, szapodea@purdue.edu
 * @version November 10th, 2019
 */

public class InvalidAudioFileException extends InvalidFileException {
    public InvalidAudioFileException() {
        super();
    }

    public InvalidAudioFileException(String message) {
        super(message);
    }
}
