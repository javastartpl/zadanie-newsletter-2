import org.junit.Assert;
import org.junit.Test;

import java.util.NoSuchElementException;

public class TableProcessorTest {

    @Test(expected = NoSuchElementException.class)
    public void throwNoSuchElementExceptionWhenArrayIsEmpty() throws TooSmallArrayException {

        // arrange
        TableProcessor processor = new TableProcessor();
        int[] nums = new int[]{};

        // act
        processor.processTable(nums);

        //assert
    }

    @Test(expected = TooSmallArrayException.class)
    public void throwTooSmallArrayWhenNotEnoughNumbers() throws TooSmallArrayException {

        // arrange
        TableProcessor processor = new TableProcessor();
        int[] nums = new int[]{1};

        // act
        processor.processTable(nums);

        //assert
    }

    @Test
    public void checkIfOutputIsWhatExpectedFirst() throws TooSmallArrayException {
        //arrange
        TableProcessor processor = new TableProcessor();
        int[] nums = new int[]{1, 2, 3, 4, 5};

        //act
        String output = processor.processTable(nums);

        //assert
        Assert.assertEquals("wrong output", "Smallest pair is [1,2] and biggest pair is [4,5]", output);
    }

    @Test
    public void checkIfOutputIsWhatExpectedSecond() throws TooSmallArrayException {
        //arrange
        TableProcessor processor = new TableProcessor();
        int[] nums = new int[]{-5, 0, 5, -10, 5, 15};

        //act
        String output = processor.processTable(nums);

        //assert
        Assert.assertEquals("wrong output", "Smallest pairs are [5,-10],[-10,5],[-5,0] and biggest pair is [5,15]", output);
    }

    @Test
    public void checkIfOutputIsWhatExpectedThird() throws TooSmallArrayException {
        //arrange
        TableProcessor processor = new TableProcessor();
        int[] nums = new int[]{-5, 0, 10, -5, 0, 5, 5};

        //act
        String output = processor.processTable(nums);

        //assert
        Assert.assertEquals("wrong output", "Smallest pair is [-5,0] and biggest pairs are [0,10],[5,5]", output);
    }
}
