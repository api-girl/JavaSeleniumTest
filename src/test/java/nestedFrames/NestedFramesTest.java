package nestedFrames;

import base.BaseTest;
import first_level_pages.NestedFramesPage;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class NestedFramesTest extends BaseTest {
    NestedFramesPage frames;

    private String leftFrameSelector = "frame-left";
    private String middleFrameSelector = "frame-middle";
    private String rightFrameSelector = "frame-right";

    @Test
    public void testVerifyFramesContent(){
        frames = homePage.goToNestedFramesPage();

        String assertError = "The frame text doesn't equal the expected.";

        String[] expectedResultArray = {"LEFT", "RIGHT", "MIDDLE", "BOTTOM"};
        String [] actualResultArray = {frames.goToNestedFrame(leftFrameSelector),
                                        frames.goToNestedFrame(rightFrameSelector),
                                        frames.goToNestedFrame(middleFrameSelector),
                                        frames.goToSingleFrame()
                                        };
        //comparing two arrays: the assert depends on the array members order!
        assertEquals(actualResultArray, expectedResultArray, assertError);

    }
}
