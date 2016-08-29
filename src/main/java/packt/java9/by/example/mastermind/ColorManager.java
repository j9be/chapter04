package packt.java9.by.example.mastermind;

import java.util.HashMap;
import java.util.Map;

public class ColorManager {
    final protected int nrColors;
    final protected Map<Color, Color> successor = new HashMap<>();
    final private Color first;
    //final List<Color> colors = new ArrayList<>();


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

    /*
        public ColorManager(int nrColors) {
            this.nrColors = nrColors;
            for (int i = 0; i < nrColors; i++) {
                colors.add(new Color());
            }
            first = colors.get(0);
            colors.add(Color.none);
        }
    */
    public Color firstColor() {
        return first;
    }

    Color nextColor(Color color) {
        /*
        if (color == Color.none)
            return null;
        else
            return colors.get(colors.indexOf(color) + 1);*/
        return successor.get(color);
    }
}
