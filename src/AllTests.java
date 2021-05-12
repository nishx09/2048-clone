/**
 * Author: Nishant Garg
 * Revised: April 11, 2021
 *
 * Description: Testing all of the modules
 */

package src;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestTile.class,
        TestBoard.class
})

public class AllTests
{
}
