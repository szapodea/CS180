import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * class ImageFile
 * <p>
 * Sources of Help:
 * Java Docs
 * Piazza
 * geeksforgeeks
 *
 * @author Stephan Zapodeanu, szapodea@purdue.edu
 * @version November 10th, 2019
 */

public class ImageFile extends CommonFile {
    private int imageHeight;
    private int imageWidth;
    private boolean isAnimated;

    public ImageFile(File image) throws InvalidImageFileException, IOException {
        super(true, false, "Preview");
        try {
            BufferedImage bufferedImage = ImageIO.read(image);
            imageHeight = bufferedImage.getHeight();
            imageWidth = bufferedImage.getWidth();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (imageWidth <= 0 && imageHeight <= 0) {
            throw new InvalidImageFileException("Invalid Image File Exception!");
        } else {
            super.setFileSizeInBytes(image.length());
            if (image.getName().contains(".gif")) {
                isAnimated = true;
            } else {
                isAnimated = false;
            }
        }
    }

    public String getFileType() {
        return "Image";
    }

    public int getImageHeight() {
        return imageHeight;
    }

    public int getImageWidth() {
        return imageWidth;
    }

    public boolean animated() {
        return isAnimated;
    }

    public String toString() {
        return "ImageFile[" +
                getFileType() + ", " +
                super.getFileSizeInBytes() + ", " +
                super.getFile().getName() + ", " +
                imageHeight + "x" + imageWidth + ", " +
                animated() + "]";
    }
// canOpen, canPlay, isAnimated, fileSizeInBytes, imageHeight, imageWidth, programToOpen fields, and the file object.
    public boolean equals(Object object) {
        if (object instanceof ImageFile) {
            ImageFile imageFile = (ImageFile) object;
            return imageFile.getOpenable() == this.getOpenable() &&
                    imageFile.getPlayable() == this.getPlayable() &&
                    imageFile.animated() == this.animated()  &&
                    imageFile.getFileSizeInBytes() == this.getFileSizeInBytes() &&
                    imageFile.getImageHeight() == this.getImageHeight() &&
                    imageFile.getImageWidth() == this.getImageWidth() &&
                    imageFile.getOpensWith().equals(this.getOpensWith()) &&
                    imageFile.getFile() == this.getFile();
        }
        return false;
    }


}
