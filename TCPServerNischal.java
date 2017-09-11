package ProjectFall2016;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
 
public class TCPServerNischal 
{
    private ServerSocket serverSocket1 = null;
    private ServerSocket serverSocket2 = null;
    private ServerSocket serverSocket3 = null;
    private ServerSocket serverSocket4 = null;
    private ServerSocket serverSocket5 = null;
    
    private static Socket socket1 = null;
    private static Socket socket2 = null;
    private static Socket socket3 = null;
    private static Socket socket4 = null;
    private static Socket socket5 = null;
    
    private DataInputStream inStream1 = null;
    private DataOutputStream outStream1 = null;
	
    private DataInputStream inStream2 = null;
    private DataOutputStream outStream2 = null;
    
    private DataInputStream inStream3 = null;
    private DataOutputStream outStream3 = null;
    
    private DataInputStream inStream4 = null;
    private DataOutputStream outStream4 = null;
    
    private DataInputStream inStream5 = null;
    private DataOutputStream outStream5 = null;
    
    private final int bufferSize = 512*1024; //buffer size 512 KB
 
    public TCPServerNischal() 
    {
 
    }
 
    /* Creating each "createSocket" class for each thread to create
     * each socket with unique port. */
    private void createSocket1() 
    {
        try
        {
            serverSocket1 = new ServerSocket(3339);
            socket1 = serverSocket1.accept();
                 
            inStream1 = new DataInputStream(socket1.getInputStream());
            outStream1 = new DataOutputStream(socket1.getOutputStream());
            System.out.println("Socket 1 Connected");
        }
        catch (IOException io) 
        {
            io.printStackTrace();
        }
    }
    
    private void createSocket2() 
    {
        try
        {
            serverSocket2 = new ServerSocket(3340);
            socket2 = serverSocket2.accept();
                 
            inStream2 = (new DataInputStream(socket2.getInputStream()));
            outStream2 = new DataOutputStream(socket2.getOutputStream());
            System.out.println("Socket 2 Connected");
        }
        catch (IOException io) 
        {
            io.printStackTrace();
        }
    }
    
    private void createSocket3() 
    {
        try
        {
            serverSocket3 = new ServerSocket(3341);
            socket3 = serverSocket3.accept();
                 
            inStream3 = new DataInputStream(socket3.getInputStream());
            outStream3 = new DataOutputStream(socket3.getOutputStream());
            System.out.println("Socket 3 Connected");
        }
        catch (IOException io) 
        {
            io.printStackTrace();
        }
    }
     
    private void createSocket4() 
    {
        try
        {
            serverSocket4 = new ServerSocket(3342);
            socket4 = serverSocket4.accept();
                 
            inStream4 = new DataInputStream(socket4.getInputStream());
            outStream4 = new DataOutputStream(socket4.getOutputStream());
            System.out.println("Socket 4 Connected");
        }
        catch (IOException io) 
        {
            io.printStackTrace();
        }
    }
     
    private void createSocket5() 
    {
        try
        {
            serverSocket5 = new ServerSocket(3343);
            socket5 = serverSocket5.accept();
                 
            inStream5 = new DataInputStream(socket5.getInputStream());
            outStream5 = new DataOutputStream(socket5.getOutputStream());
            System.out.println("Socket 5 Connected");
        }
        catch (IOException io) 
        {
            io.printStackTrace();
        }
    }
     
    /* Similarly as "createSocket" class, creating each "sendFile" class
     * for each thread to send the file to each open sockets.    */
    private void sendFile1()
    {
        try
        {
        	//write the filename below in the File constructor
            File file = new File("File1.zip");
            FileInputStream fileInput1 = new FileInputStream(file);
            int fileSize = (int) file.length();
            System.out.println("Server: File size is:" + fileSize);
            byte [] data = new byte[(int) fileSize];
         
            fileInput1.read(data);
             
            //first send the size of the file to the client
            outStream1.writeInt(fileSize);
            outStream1.flush();
             
            outStream1.write(data);
            outStream1.flush();
            fileInput1.close();
            serverSocket1.close();
            socket1.close();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    private void sendFile2()
    {
        try
        {
        	//write the filename below in the File constructor
            File file = new File("File2.zip");
            FileInputStream fileInput2 = new FileInputStream(file);
            int fileSize = (int) file.length();
            System.out.println("Server: File size is:" + fileSize);
            byte [] data = new byte[(int) fileSize];
         
            fileInput2.read(data);
             
            //first send the size of the file to the client
            outStream2.writeInt(fileSize);
            outStream2.flush();
             
            outStream2.write(data);
            outStream2.flush();
            fileInput2.close();
            serverSocket2.close();
            socket2.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    private void sendFile3()
    {
        try
        {
        	//write the filename below in the File constructor
            File file = new File("File3.zip");
            FileInputStream fileInput3 = new FileInputStream(file);
            int fileSize = (int) file.length();
            System.out.println("Server: File size is:" + fileSize);
            byte [] data = new byte[(int) fileSize];
         
            fileInput3.read(data);
             
            //first send the size of the file to the client
            outStream3.writeInt(fileSize);
            outStream3.flush();
             
            outStream3.write(data);
            outStream3.flush();
            fileInput3.close();
            serverSocket3.close();
            socket3.close();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    private void sendFile4()
    {
        try
        {
        	//write the filename below in the File constructor
            File file = new File("File4.zip");
            FileInputStream fileInput4 = new FileInputStream(file);
            int fileSize = (int) file.length();
            System.out.println("Server: File size is:" + fileSize);
            byte [] data = new byte[(int) fileSize];
         
            fileInput4.read(data);
             
            //first send the size of the file to the client
            outStream4.writeInt(fileSize);
            outStream4.flush();
             
            outStream4.write(data);
            outStream4.flush();
            fileInput4.close();
            serverSocket4.close();
            socket4.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    private void sendFile5()
    {
        try
        {
        	//write the filename below in the File constructor
            File file = new File("File5.zip");
            FileInputStream fileInput5 = new FileInputStream(file);
            int fileSize = (int) file.length();
            System.out.println("Server: File size is:" + fileSize);
            byte [] data = new byte[(int) fileSize];
         
            fileInput5.read(data);
             
            //first send the size of the file to the client
            outStream5.writeInt(fileSize);
            outStream5.flush();
             
            outStream5.write(data);
            outStream5.flush();
            fileInput5.close();
            serverSocket5.close();
            socket5.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) throws InterruptedException
    {
    	/* Create a object of CustomFileManager to partition the original file*/
    	CustomFileManager fileManager = new CustomFileManager("165MB.zip", 5);
    	
    	//150.243.207.41
    	
    	//Partitions the file to five smaller files.
    	fileManager.createPartitions();
    	
     /* Creating each object for each "TCPServerNischal" class to call 
      * createSocket and sendFile methods.    */
     TCPServerNischal fileServer1 = new TCPServerNischal();
     TCPServerNischal fileServer2 = new TCPServerNischal();
     TCPServerNischal fileServer3 = new TCPServerNischal();
     TCPServerNischal fileServer4 = new TCPServerNischal();
     TCPServerNischal fileServer5 = new TCPServerNischal();

     /* Using anonymous to make thread and run by start method for each threads. */
    	Thread t1 = new Thread(new TCPClientNischal(socket1))
    			{
    				public void run()
    				{
    					fileServer1.createSocket1();
    					fileServer1.sendFile1();
    					
    				}
    			};
    	        
        Thread t2 = new Thread(new TCPClientNischal(socket2))
		{
			public void run()
			{
				fileServer2.createSocket2();
				fileServer2.sendFile2();
			}
		};
        
        Thread t3 = new Thread(new TCPClientNischal(socket3))
		{
			public void run()
			{
				fileServer3.createSocket3();
				fileServer3.sendFile3();
			}
		};
      
        Thread t4 = new Thread(new TCPClientNischal(socket4))
		{
			public void run()
			{
				fileServer4.createSocket4();
				fileServer4.sendFile4();
			}
		};
        
        Thread t5 = new Thread(new TCPClientNischal(socket5))
		{
			public void run()
			{
				fileServer5.createSocket5();
				fileServer5.sendFile5();
			}
		};

		/*Start the thread, print the status and start time of the thread and let each thread finish
		first by using .join() */
		t1.start();
//	    System.out.println("The start time of thread1 is : " +  System.nanoTime() + " in nano seconds.");
//	    System.out.println("The status of thread1 = " + t1.isAlive());
	    
	    t2.start();
//	    System.out.println("The start time of thread2 is : " +  System.nanoTime() + " in nano seconds.");
//	    System.out.println("The status of thread2 = " + t2.isAlive());
	    
	    t3.start();
//	    System.out.println("The start time of thread3 is : " +  System.nanoTime() + " in nano seconds.");
//	    System.out.println("The status of thread3 = " + t3.isAlive());

	    t4.start();
//	    System.out.println("The start time of thread4 is : " +  System.nanoTime() + " in nano seconds.");
//	    System.out.println("The status of thread4 = " + t4.isAlive());
	    
	    t5.start();
//	    System.out.println("The status of thread5 = " + t4.isAlive());
//	    System.out.println("The start time of thread5 is : " +  System.nanoTime() + " in nano seconds.");
	    
	    t1.join();
//	    System.out.println("The status of thread1 = " + t1.isAlive());
//	    System.out.println("The end time of thread1 is : " +  System.nanoTime() + " in nano seconds.");
//	    System.out.print("\n");
	    
	    t2.join();
//	    System.out.println("The status of thread2 = " + t2.isAlive());
//	    System.out.println("The end time of thread2 is : " +  System.nanoTime() + " in nano seconds.");
//	    System.out.print("\n");
	    
	    t3.join();
//	    System.out.println("The status of thread3 = " + t3.isAlive());
//	    System.out.println("The end time of thread3 is : " +  System.nanoTime() + " in nano seconds.");
//	    System.out.print("\n");
	    
	    t4.join();
//	    System.out.println("The status of thread4 = " + t4.isAlive());
//	    System.out.println("The end time of thread4 is : " +  System.nanoTime() + " in nano seconds.");
//	    System.out.print("\n");
	    
	    t5.join();
//	    System.out.println("The status of thread4 = " + t4.isAlive());
//	    System.out.println("The end time of thread5 is : " +  System.nanoTime() + " in nano seconds.");   
//	    System.out.print("\n");
	    
    }
    
    public void run() {
		// TODO Auto-generated method stub
		
	}
    
//	public DataInputStream getInStream() 
//	{
//		return inStream;
//	}
//
//	public void setInStream(DataInputStream inStream) 
//	{
//		this.inStream = inStream;
//	}	
}