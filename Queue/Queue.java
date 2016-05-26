
/**
 * This class definition will implemente all
 * the methods specified in the QueueADT interface
 * This class will override all abstract methods in
 * QueueADT file
 * 
 * @author Tan Do
 * @version 4/29/2016
 */
public class Queue<T> implements QueueADT<T>
{
    // instance variables 
    private int counter;   //keeps track of items in a list 
    private T [ ] store;   //holds the items for queue

    /**
     * Constructor for objects of class Queue
     */
    public Queue()
    {
        // initialise instance variables
        counter = 0;
        store = (T[ ]) new Object[10];
    }

    /**
     * Overloaded constructor to use to set the fields instead of using the default fields 
     * 
     * @param int count - sets how many objects there will be in the array 
     */
    public Queue(int count)
    {
        counter = count; 
        store = (T[ ]) new String[count];
    }

    /**
     * This is a return method that simple returns the counter field 
     * 
     * @return counter - returns the field of counter 
     */
    public int getCounter()
    {
        return counter; 
    }

    /**  
     * Adds one element to the rear of this queue. 
     * @param element  the element to be added to the rear of the queue  
     */
    public void enqueue(T element)
    {
        if(counter < store.length)
        {
            store[counter] = element; 
            counter++;
        }
        else
        {
            System.out.println("No space left");
        }
    }

    /**  
     * Removes and returns the element at the front of this queue.
     * @return the element at the front of the queue
     */
    public T dequeue()
    {
        T result;

        if(counter == 0)
        {
            System.out.println("No element found");
            result = null;
        }
        else
        {
            result = store[0];
            
            //shifts the array up one, the last array will now hold nothing
            store[0] = null; 
            store[0] = store[1];
            store[1] = store[2];
            store[2] = store[3];
            counter--;
        }

        return result; 
    }

    /**  
     * Returns without removing the element at the front of this queue.
     * @return the first element in the queue
     */
    public T first()
    {
        T result;

        result = store[0]; 

        return result; 
    }

    /**  
     * Returns true if this queue contains no elements.
     * @return true if this queue is empty
     */
    public boolean isEmpty()
    {
        boolean result; 
        if (counter == 0)
        {
            result = true; 
        }
        else
        {
            result = false; 
        }

        return result; 
    }

    /**  
     * Returns the number of elements in this queue. 
     * @return the integer representation of the size of the queue
     */
    public int size()
    {
        int result;

        result = counter;

        return result; 
    }

    /**  
     * Returns a string representation of this queue. 
     * @return the string representation of the queue
     */
    public String toString()
    {
        StringBuilder str = new StringBuilder( );
        for(int i = 0; i < counter; i++)
        {
            str.append(store[i]).append("\n");
        }
        return new String(str);
    }

}
