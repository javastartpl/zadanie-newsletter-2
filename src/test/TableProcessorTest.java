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
}
