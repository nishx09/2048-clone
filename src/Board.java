package src;

/**
 *
 * Game board for 2048 and provides methods for moving up, down, left and
 * right. Also keeps track of score, when game is over or won.
 *
 * @author Nishant Garg
 * @version April 10, 2021
 *
 */
public class Board
{
    public Tile[][] board;
    int edge = 0;
    public int score = 0;


    /**
     * Default constructor for the Board - sets up a 4x4 matrix
     */
    public Board()
    {
        board = new Tile[4][4];
        for ( int i = 0; i < 4; i++ )
        {
            for ( int j = 0; j < 4; j++ )
            {
                board[i][j] = new Tile();
            }
        }
    }

    /**
     * Board constructor with 1 parameter - sets up a board with custom Tiles in it
     * (for testing purposes)
     *
     * @param tt
     */
    public Board(Tile[][] tt) {
        board = new Tile[4][4];
        for ( int i = 0; i < 4; ++i )
        {
            board[i] = tt[i];
        }
    }

    /**
     * Board constructor with 1 parameter - sets up a board where the player
     * has already lost (for testing purposes)
     *
     * @param factor
     */
    public Board( int factor)
    {
        board = new Tile[4][4];
        for ( int i = 0; i < 4; i++ )
        {
            for ( int j = 0; j < 4; j++ )
            {
                board[i][j] = new Tile( ( factor + i + j + 1) * ( i + j + 1) );
            }
        }
    }

    /**
     *
     * @brief Getter method that returns the score
     *
     * @return score
     */
    public int getScore()
    {
        return score;
    }


    /**
     *
     * @brief Finds the the highest tile on the board and returns it
     *
     * @return high
     */
    public int highestTile()
    {
        int high = board[0][0].getValue();
        for ( int i = 0; i < 4; i++ )
        {
            for ( int j = 0; j < 4; j++ )
            {
                if ( board[i][j].getValue() > high )
                {
                    high = board[i][j].getValue();
                }
            }
        }
        return high;
    }


    /**
     * @brief Spawns a 2 at an empty space every time a move is made
     */
    public void spawnRandom()
    {
        boolean empty = true;
        while ( empty ) {
            int row = (int)( Math.random() * 4 );
            int col = (int)( Math.random() * 4 );
            double x = Math.random();
            if ( board[row][col].getValue() == 0 ) {
                if ( x < 0.1 ) {
                    board[row][col] = new Tile( 4 );
                    empty = false;
                } else {
                    board[row][col] = new Tile( 2 );
                    empty = false;
                }
            }
        }
    }

    /**
     * @brief Calls the respective `move` function corresponding to the input
     * and spawns a new tile after making the merging move.
     */
    public void move(MoveT direction){
        switch(direction){
            case w:
                up();
                break;
            case s:
                down();
                break;
            case a:
                left();
                break;
            case d:
                right();
                break;
            default:
                throw new IllegalArgumentException();
        }
        spawnRandom();
    }

    /**
     *
     * @brief Checks if the game is won.
     *
     * @return boolean True if won, else False
     */
    public boolean gameWon() {
        return highestTile() == 2048;
    }

    /**
     *
     * @brief Checks to see if the game is over - that is, checks if any tile (that
     * isn't a 0) is able to combine with the tiles adjacent to it - If not, the
     * game is over
     *
     * @return boolean
     */
    public boolean gameOver()
    {
        int count = 0;
        for ( int i = 0; i < 4; i++ )
        {
            for ( int j = 0; j < 4; j++ )
            {
                if ( board[i][j].getValue() > 0 )
                {
                    if ( i == 0 && j == 0 )
                    {
                        if ( board[i][j].getValue() != board[i + 1][j].getValue()
                                && board[i][j].getValue() != board[i][j + 1].getValue() )
                        {
                            count++;
                        }
                    }
                    else if ( i == 0 && j == 3 )
                    {
                        if ( board[i][j].getValue() != board[i + 1][j].getValue()
                                && board[i][j].getValue() != board[i][j - 1].getValue() )
                        {
                            count++;
                        }
                    }
                    else if ( i == 3 && j == 3 )
                    {
                        if ( board[i][j].getValue() != board[i - 1][j].getValue()
                                && board[i][j].getValue() != board[i][j - 1].getValue() )
                        {
                            count++;
                        }
                    }
                    else if ( i == 3 && j == 0 )
                    {
                        if ( board[i][j].getValue() != board[i - 1][j].getValue()
                                && board[i][j].getValue() != board[i][j + 1].getValue() )
                        {
                            count++;
                        }
                    }
                    else if ( i == 0 && ( j == 1 || j == 2 ) )
                    {
                        if ( board[i][j].getValue() != board[i + 1][j].getValue()
                                && board[i][j].getValue() != board[i][j + 1].getValue()
                                && board[i][j].getValue() != board[i][j - 1].getValue() )
                        {
                            count++;
                        }
                    }
                    else if ( i == 3 && ( j == 1 || j == 2 ) )
                    {
                        if ( board[i][j].getValue() != board[i - 1][j].getValue()
                                && board[i][j].getValue() != board[i][j + 1].getValue()
                                && board[i][j].getValue() != board[i][j - 1].getValue() )
                        {
                            count++;
                        }
                    }
                    else if ( j == 0 && ( i == 1 || i == 2 ) )
                    {
                        if ( board[i][j].getValue() != board[i][j + 1].getValue()
                                && board[i][j].getValue() != board[i - 1][j].getValue()
                                && board[i][j].getValue() != board[i + 1][j].getValue() )
                        {
                            count++;
                        }
                    }
                    else if ( j == 3 && ( i == 1 || i == 2 ) )
                    {
                        if ( board[i][j].getValue() != board[i][j - 1].getValue()
                                && board[i][j].getValue() != board[i - 1][j].getValue()
                                && board[i][j].getValue() != board[i + 1][j].getValue() )
                        {
                            count++;
                        }
                    }
                    else
                    {
                        if ( board[i][j].getValue() != board[i][j - 1].getValue()
                                && board[i][j].getValue() != board[i][j + 1].getValue()
                                && board[i][j].getValue() != board[i - 1][j].getValue()
                                && board[i][j].getValue() != board[i + 1][j].getValue() )
                        {
                            count++;
                        }
                    }
                }
            }
        }
        if ( count == 16 )
        {
            return true;
        }
        return false;
    }

    /**
     *
     * @brief This method is called when a 'w' or up arrow is pressed - goes through
     * the entire board and calls verticalMove with an "up" parameter for each
     * tile
     */
    public void up()
    {
        for ( int i = 0; i < 4; i++ )
        {
            edge = 0;
            for ( int j = 0; j < 4; j++ )
            {
                if ( board[j][i].getValue() != 0 )
                {
                    if ( edge <= j )
                    {
                        vMerge( j, i, "up" );
                    }
                }
            }
        }
    }


    /**
     *
     * @brief This method is called when a 's' or down arrow is pressed - goes through
     * the entire board and calls verticalMove with a "down" parameter for each
     * tile
     */
    public void down()
    {
        for ( int i = 0; i < 4; i++ )
        {
            edge = 3;
            for ( int j = 3; j >= 0; j-- )
            {
                if ( board[j][i].getValue() != 0 )
                {
                    if ( edge >= j )
                    {
                        vMerge( j, i, "down" );
                    }
                }
            }
        }
    }


    /**
     *
     * @brief Compares two tile's values together and if they are the same or if one is
     * equal to 0 (plain tile) - their values are added (provided that the tiles
     * we are comparing are two different tiles and they are moving towards the
     * appropriate direction) - Uses recursion to go through the entire column
     *
     * @param row row that the compare tile is currently on
     * @param col column that the compare tile is currently on
     * @param direction direction (up or down) that the tile is moving in
     */
    private void vMerge( int row, int col, String direction )
    {
        Tile initial = board[edge][col];
        Tile compare = board[row][col];
        if ( initial.getValue() == 0 || initial.getValue() == compare.getValue() )
        {
            if ( row > edge || ( direction.equals( "down" ) && ( row < edge ) ) )
            {
                int addScore = initial.getValue() + compare.getValue();
                if ( initial.getValue() != 0 )
                {
                    score += addScore;
                }
                initial.setValue( addScore );
                compare.setValue( 0 );
            }
        }
        else
        {
            if ( direction.equals( "down" ) )
            {
                edge--;
            }
            else
            {
                edge++;
            }
            vMerge( row, col, direction );
        }
    }


    /**
     *
     * This method is called when an 'a' or left arrow is pressed - goes through
     * the entire board and calls horizontalMove with a "left" parameter for
     * each tile
     */
    public void left()
    {
        for ( int i = 0; i < 4; i++ )
        {
            edge = 0;
            for ( int j = 0; j < 4; j++ )
            {
                if ( board[i][j].getValue() != 0 )
                {
                    if ( edge <= j )
                    {
                        hMerge( i, j, "left" );
                    }
                }
            }
        }
    }


    /**
     *
     * @brief This method is called when a 'd' or right arrow is pressed - goes through
     * the entire board and calls horizontalMove with a "right" parameter for
     * each tile
     */
    public void right()
    {
        for ( int i = 0; i < 4; i++ )
        {
            edge = 3;
            for ( int j = 3; j >= 0; j-- )
            {
                if ( board[i][j].getValue() != 0 )
                {
                    if ( edge >= j )
                    {
                        hMerge( i, j, "right" );
                    }
                }
            }
        }
    }


    /**
     *
     * @brief Compares two tile's values together and if they are the same or if one is
     * equal to 0 (plain tile) - their values are added (provided that the tiles
     * we are comparing are two different tiles and they are moving towards the
     * appropriate direction) - Uses recursion to go through the entire row
     *
     * @param row row that the compare tile is currently on
     * @param col column that the compare tile is currently on
     * @param direction direction (left or right) that the tile is moving in
     */
    private void hMerge( int row, int col, String direction )
    {
        Tile initial = board[row][edge];
        Tile compare = board[row][col];
        if ( initial.getValue() == 0 || initial.getValue() == compare.getValue() )
        {
            if ( col > edge || ( direction.equals( "right" ) && ( col < edge ) ) )
            {
                int addScore = initial.getValue() + compare.getValue();
                if ( initial.getValue() != 0 )
                {
                    score += addScore;
                }
                initial.setValue( addScore );
                compare.setValue( 0 );
            }
        }
        else
        {
            if ( direction.equals( "right" ) )
            {
                edge--;
            }
            else
            {
                edge++;
            }
            hMerge( row, col, direction );
        }
    }

    /**
     * @brief Returns the board as a String
     */
    public String toString()
    {
        String s = "";
        for ( int i = 0; i < 4; i++ )
        {
            for ( int j = 0; j < 4; j++ )
            {
                s += board[i][j].toString() + "   ";
            }
            s += "\n";
        }
        return s;
    }

}