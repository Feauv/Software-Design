import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * The BlockingBuffer acts as a shared location between filters. It acts as an access point for the inputting and
 * outputting of filters.
 */
public class BlockingBuffer {

    /**
     * Where input is stored in a BlockingBuffer
     */
    private final ArrayBlockingQueue<List<Character>> buffer;
    /**
     * Name of the input filter
     */
    private final String producer;
    /**
     * Name of the output filter
     */
    private final String consumer;

    /**
     * A BlockingBuffer requires at least a capacity for its constructor. I added the inputted Strings so the filter
     * names could be printed out instead of just Producer and Consumer
     * @param capacity Capacity for ArrayBlockingQueue
     * @param producer Name of Input Runnable
     * @param consumer Name of Output Runnable
     */
    public BlockingBuffer(int capacity, String producer, String consumer) {

        buffer = new ArrayBlockingQueue<>(capacity);
        this.producer = producer;
        this.consumer = consumer;

    }


    /**
     * Deals with input coming into the buffer
     * @param value Input List
     * @throws InterruptedException
     */
    public void blockingPut(List<Character> value) throws InterruptedException {
        buffer.put(value); // place value in buffer
        System.out.println(producer + " writes " + value +
                "\tBuffer cells occupied: " + buffer.size());
    }


    /**
     * Deals with output going out of the buffer
     * @return Output List
     * @throws InterruptedException
     */
    public List<Character> blockingGet() throws InterruptedException {
        List<Character> readValue = buffer.take(); // remove value from buffer
        System.out.println(consumer + " reads " +
                readValue + "\tBuffer cells occupied: " + buffer.size());

        return readValue;
    }

}
