/**
 * Invalid Image File Exception
 *
 * @author Stephan Zapodeanu, szapodea@purdue.edu
 * @version November 10th, 2019
 */

public class InvalidImageFileException extends InvalidFileException {
    public InvalidImageFileException() {
        super();
    }

    public InvalidImageFileException(String message) {
        super(message);
    }
}
