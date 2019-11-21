/**
 * Invalid Text File Exception
 *
 * @author Stephan Zapodeanu, szapodea@purdue.edu
 * @version November 10th, 2019
 */

public class InvalidTextFileException extends InvalidFileException {
    public InvalidTextFileException() {
        super();
    }

    public InvalidTextFileException(String message) {
        super(message);
    }
}
