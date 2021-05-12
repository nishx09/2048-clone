package src;

/**
 *
 * Represents an individual tile in the game. Has an integer value and a color
 * value - both of which change as they are combined
 *
 * @author Nishant Garg
 * @version April 11, ,2021
 *
 */
public class Tile
{
    int value;

    /**
     * @brief: Constructs a basic tile with a value of 0
     */
    public Tile()
    {
        value = 0;
    }


    /**
     * @brief Constructs a tile with a value of number
     *
     * @param number number to set value to
     */
    public Tile( int number )
    {
        value = number;
    }


    /**
     *
     * @brief Gets the tile's value
     *
     * @return value
     */
    public int getValue()
    {
        return value;
    }


    /**
     *
     * @brief Sets the tile's value
     *
     * @param value value to set the tile to
     */
    public void setValue( int value )
    {
        if (value < 0) {
            throw new IllegalArgumentException();
        }
        this.value = value;
    }


    /**
     * @brief Represents the tile as a String - used in the GUI
     */
    public String toString()
    {
        return String.valueOf(value);
    }


}