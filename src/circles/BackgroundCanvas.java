package circles;

import javax.swing.*;
import java.awt.*;

public class BackgroundCanvas {

    public static void swapBackground(MainCanvas canvas) {

        canvas.setBackground(Color.getHSBColor(
                (int) (Math.random() * 255),
                (int) (Math.random() * 255),
                (int) (Math.random() * 255))
        );

    }

}