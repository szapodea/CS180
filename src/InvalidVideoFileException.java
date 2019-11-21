/**
 * Invalid Video File Exception
 *
 * @author Stephan Zapodeanu, szapodea@purdue.edu
 * @version November 10th, 2019
 */

public class InvalidVideoFileException extends InvalidFileException {
    public InvalidVideoFileException() {
        super();
    }

    public InvalidVideoFileException(String message) {
        super(message);
    }
}
