package packt.java9.by.example.mastermind;

import java.util.HashMap;
import java.util.Map;

public class ColorManager {
    final protected int nrColors;
    final protected Map<Color, Color> successor = new HashMap<>();
    final private Color first;

    public ColorManager(int nrColors) {
        this.nrColors = nrColors;
        first = new Color();
        Color previousColor = first;
        for (int i = 1; i < nrColors; i++) {
            final Color thisColor = new Color();
            successor.put(previousColor, thisColor);
            previousColor = thisColor;
        }
        successor.put(previousColor, Color.none);
    }

    public Color firstColor() {
        return first;
    }

    Color nextColor(Color color) {
        return successor.get(color);
    }
}
