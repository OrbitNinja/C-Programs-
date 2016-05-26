
/**
 * This class contains main( ). It is
 * used to test the methods of the ArrayQueue
 * class.
 * 
 * @author Tan Do
 * @version 4/29/2016
 */
public class Driver
{
    public static void main(String[ ] args)
    {
        //create an instance of the queue specifying the data
        //type in the queue will be Integer. Set the initial 
        //capacity of the queue to 5
        Queue<Integer> myItems = new Queue<Integer>( );
        //enqueue some data in the queue
        myItems.enqueue(9);
        myItems.enqueue(7);
        myItems.enqueue(6);
        myItems.enqueue(10);

        //Checks to see if queue is empty
        System.out.println("Is queue empty: " + myItems.isEmpty());
        
        //Print how many items are in the queue
        System.out.println("The number of elements that have been enqueued is " + myItems.size( ));

        //take a look at what is at the front of the queue
        System.out.println("The element at the front of the queue is " + myItems.first( ) );

        //Now dequeue the front of the queue and print the element after it is removed
        System.out.println("The data item being dequeued is " + myItems.dequeue( ));

        //now take a look at how many eelements are left in the queue and what the
        //data item at the front of the queue is
        System.out.println("The number of elements now in the queue is " + myItems.size( ));
        System.out.println("The element at the front of the queue is " + myItems.first( ));

        //now print the entire contents of the queue after the data item 3 has
        //been dequeue
        System.out.println("This is the contents of the queue before enqueueing an 8\n"  + myItems.toString( ));
        myItems.enqueue(8);
        System.out.println("This is the contents of the queue after enqueueing an 8\n" + myItems.toString( ) );

        //new instance of the queue to hold strings instead of integers 
        //initial capacity of the queue to 5
        Queue<String> myWord = new Queue<String>( );

        //enqueue some data in the queue
        myWord.enqueue("T");
        myWord.enqueue("B");
        myWord.enqueue("D");
        myWord.enqueue("A");
        
        //Checks to see if queue is empty
        System.out.println("Is queue empty: " + myWord.isEmpty());

        //Print how many items are in the queue
        System.out.println("The number of elements that have been enqueued is " + myWord .size( ));

        //take a look at what is at the front of the queue
        System.out.println("The element at the front of the queue is " + myWord .first( ) );

        //Now dequeue the front of the queue and print the element after it is removed
        System.out.println("The data item being dequeued is " + myWord.dequeue( ));

        //now take a look at how many eelements are left in the queue and what the
        //data item at the front of the queue is
        System.out.println("The number of elements now in the queue is " + myWord .size( ));
        System.out.println("The element at the front of the queue is " + myWord .first( ));

        //now print the entire contents of the queue after the data item 3 has
        //been dequeue
        System.out.println("This is the contents of the queue before enqueueing an F\n"  + myWord .toString( ));
        myWord .enqueue("F");
        System.out.println("This is the contents of the queue after enqueueing an F\n" + myWord .toString( ) );

    }//end of main( )            
}//end of Driver class
