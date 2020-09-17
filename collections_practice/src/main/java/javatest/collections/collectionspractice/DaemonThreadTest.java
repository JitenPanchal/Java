package javatest.collections.collectionspractice;

import java.io.FileReader;
import java.io.IOException;

public class DaemonThreadTest {
	//Main Thread
    public static void main(String[] args) throws InterruptedException, ClassNotFoundException
    {
//    	Integer i1 = 127;
//    	 
//        Integer i2 = 127;
// 
//        System.out.println(i1 == i2);
 
        Integer i3 = 128;
 
        Integer i4 = 128;
 
        System.out.println(i3 == i4);
        
    	String s = "ONE"+1+2+"TWO"+"THREE"+3+4+"FOUR"+"FIVE"+5; 
    	 
        System.out.println(s);
        
    	Class.forName("javatest.collections.collectionspractice.DaemonThreadTest");
    	
    	 Bx b = new Bx();
    	 
         System.out.println(b.i);
    	
        UserThread userThread = new UserThread();   //Creating the UserThread
 
        userThread.setDaemon(true);        //Changing the thread as Daemon
 
        userThread.start();               //Starting the thread
        
        Thread.sleep(1);
        
        FileReader x;
//        userThread.join();
    }
}

class UserThread extends Thread
{
    @Override
    public void run()
    {
        for(int i = 0; i < 1; i++)
        {
            System.out.println("This is an user thread...." + i);
        }
    }
}

class A
{
    static int i = 1111;
 
    static
    {
        i = i-- - --i;
    }
 
    {
        i = i++ + ++i;
    }
}
 
class Bx extends A
{
    static
    {
        i = --i - i--;
    }
 
    {
        i = ++i + i++;
    }
    
    int methodOfA()
    {
        return (true ? null : 0);
    }
}
 

 
