package packt.java9.by.example.mastermind.lettered;

import packt.java9.by.example.mastermind.Color;
import packt.java9.by.example.mastermind.ColorManager;

public class LetteredColorManager extends ColorManager {
    private final LetteredColor first;
    public LetteredColorManager(int nrColors) {
        super(nrColors);

        first = new LetteredColor();
        Color previousColor = first;
        for (int i = 1; i < nrColors; i++) {
            final Color thisColor = new LetteredColor();
            successor.put(previousColor, thisColor);
            previousColor = thisColor;
        }
        successor.put(previousColor, Color.none);
    }
    public Color firstColor() {
        return first;
    }
}
