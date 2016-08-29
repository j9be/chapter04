package packt.java9.by.example.mastermind;

/**
 * Represents a color in the MasterMind table.
 * Each color has a serial value that is used
 * internally to sort the colors so that there
 * is a first color, last color and for each
 * color, except the last, there is a next
 * color managed by a color manager.
 * <p>
 * Colors are equal if the serial number is the same.
 * </p>
 */
public class Color {
    /**
     * A special object that represents a
     * value that is not a valid color.
     */
    public static final Color none = new Color();
}
