package ProjectFall2016;
 
import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.file.StandardOpenOption;
 
public class TCPClientNischal implements Runnable 
{
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
    
	private FileOutputStream fileOut1;
	private FileOutputStream fileOut2;
	private FileOutputStream fileOut3;
	private FileOutputStream fileOut4;
	private FileOutputStream fileOut5;
 
	public TCPClientNischal(Socket socket2) {

	}

	/*Creating five sockets for each thread to receive file*/
	public void createSocket1()
    {
        try
        {
        	//my ip address- 150.243.207.41
        	//narayan id address - 150.243.211.14
        	//ashish ip address - 150.243.193.157
        	
        	
            socket1 = new Socket("150.243.218.59", 3339);
            System.out.println("Connected");
            inStream1 = new DataInputStream(socket1.getInputStream());
            outStream1 = new DataOutputStream(socket1.getOutputStream());

        } 
        catch (UnknownHostException u) 
        {
            u.printStackTrace();
        } 
        catch (IOException io) 
        {
            io.printStackTrace();
        }
    }
	
	/* Creating five "receiveFile" class for each thread to receive the file from server
	 * and download it. */
	 private void receiveFile1()
	    {
	        try
	        {
	            int fileSize = inStream1.readInt();
	            byte data[] = new byte[fileSize];
	            fileOut1 = new FileOutputStream("File1-download.zip");       
	            int count = 0, totalBytes = 0;
	            while(true)
	            {
	                count = inStream1.read(data,0,fileSize);
	                byte[] arrayBytes = new byte[count];
	                System.arraycopy(data, 0, arrayBytes, 0, count);
	                totalBytes = totalBytes + count;
	                if(count>0)
	                {
	                    fileOut1.write(arrayBytes);
	                    fileOut1.flush();
	                }
	                if(totalBytes == fileSize)
	                    break;
	            }
	            System.out.println("File Size is: "+fileSize + ", number of bytes read are: " + totalBytes);
	             
	            socket1.close();
	            inStream1.close();
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }
	    }
	
	public void createSocket2()
    {
        try
        {
            socket2 = new Socket("150.243.218.59", 3340);        
            System.out.println("Connected");
            inStream2 = new DataInputStream(socket2.getInputStream());
            outStream2 = new DataOutputStream(socket2.getOutputStream());

        } 
        catch (UnknownHostException u) 
        {
            u.printStackTrace();
        } 
        catch (IOException io) 
        {
            io.printStackTrace();
        }
    }
	
	private void receiveFile2()
    {
        try
        {
            int fileSize = inStream2.readInt();
            byte data[] = new byte[fileSize];
            fileOut2 = new FileOutputStream("File2-download.zip");       
            int count =0, totalBytes=0;
            while(true)
            {
                count = inStream2.read(data,0,fileSize);
                byte[] arrayBytes = new byte[count];
                System.arraycopy(data, 0, arrayBytes, 0, count);
                totalBytes = totalBytes + count;
                if(count>0)
                {
                    fileOut2.write(arrayBytes);
                    fileOut2.flush();
                }
                if(totalBytes == fileSize)
                    break;
            }
            System.out.println("File Size is: "+fileSize + ", number of bytes read are: " + totalBytes);
             
            socket2.close();
            inStream2.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
	
	public void createSocket3()
    {
        try
        {
            socket3 = new Socket("150.243.218.59", 3341);

            System.out.println("Connected");
            inStream3 = new DataInputStream(socket3.getInputStream());
            outStream3 = new DataOutputStream(socket3.getOutputStream());

        } 
        catch (UnknownHostException u) 
        {
            u.printStackTrace();
        } 
        catch (IOException io) 
        {
            io.printStackTrace();
        }
    }
	
	private void receiveFile3()
    {
        try
        {
            int fileSize = inStream3.readInt();
            byte data[] = new byte[fileSize];
            fileOut3 = new FileOutputStream("File3-download.zip");       
            int count =0, totalBytes=0;
            while(true)
            {
                count = inStream3.read(data,0,fileSize);
                byte[] arrayBytes = new byte[count];
                System.arraycopy(data, 0, arrayBytes, 0, count);
                totalBytes = totalBytes + count;
                if(count>0)
                {
                    fileOut3.write(arrayBytes);
                    fileOut3.flush();
                }
                if(totalBytes == fileSize)
                    break;
            }
            System.out.println("File Size is: "+fileSize + ", number of bytes read are: " + totalBytes);
             
            socket3.close();
            inStream3.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
	
	public void createSocket4()
    {
        try
        {
            socket4 = new Socket("150.243.218.59", 3342);
      
            System.out.println("Connected");
            inStream4 = new DataInputStream(socket4.getInputStream());
            outStream4 = new DataOutputStream(socket4.getOutputStream());

        } 
        catch (UnknownHostException u) 
        {
            u.printStackTrace();
        } 
        catch (IOException io) 
        {
            io.printStackTrace();
        }
    }
	
	private void receiveFile4()
    {
        try
        {
            int fileSize = inStream4.readInt();
            byte data[] = new byte[fileSize];
            fileOut4 = new FileOutputStream("File4-download.zip");       
            int count =0, totalBytes=0;
            while(true)
            {
                count = inStream4.read(data,0,fileSize);
                byte[] arrayBytes = new byte[count];
                System.arraycopy(data, 0, arrayBytes, 0, count);
                totalBytes = totalBytes + count;
                if(count>0)
                {
                    fileOut4.write(arrayBytes);
                    fileOut4.flush();
                }
                if(totalBytes == fileSize)
                    break;
            }
            System.out.println("File Size is: "+fileSize + ", number of bytes read are: " + totalBytes);
             
            socket4.close();
            inStream4.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
	
	public void createSocket5()
    {
        try
        {
            socket5 = new Socket("150.243.218.59", 3343);
           
            System.out.println("Connected");
            inStream5 = new DataInputStream(socket5.getInputStream());
            outStream5 = new DataOutputStream(socket5.getOutputStream());

        } 
        catch (UnknownHostException u) 
        {
            u.printStackTrace();
        } 
        catch (IOException io) 
        {
            io.printStackTrace();
        }
    }
 
	private void receiveFile5()
    {
        try
        {
            int fileSize = inStream5.readInt();
            byte data[] = new byte[fileSize];
            fileOut5 = new FileOutputStream("File5-download.zip");       
            int count =0, totalBytes=0;
            while(true)
            {
                count = inStream5.read(data,0,fileSize);
                byte[] arrayBytes = new byte[count];
                System.arraycopy(data, 0, arrayBytes, 0, count);
                totalBytes = totalBytes + count;
                if(count>0)
                {
                    fileOut5.write(arrayBytes);
                    fileOut5.flush();
                }
                if(totalBytes == fileSize)
                    break;
            }
            System.out.println("File Size is: "+ fileSize + ", number of bytes read are: " + totalBytes);
             
            socket5.close();
            inStream5.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
 
    public static void mergeFiles(File[] files, File mergedFile) throws IOException
    {

    	FileOutputStream fos = null;
    	int fileSize;
    	FileInputStream fis = null;
    	
    	//Runs a loop indexing each files in the array and merges them one by one.
    	for (File f : files)
    	{
			System.out.println("Merging: " + f.getName()); 		
    		try
    		{
    			fis = new FileInputStream(f);
    			fos = new FileOutputStream(mergedFile, true);

    			fileSize  = (int) (f.length());
    			byte[] tempData = new byte[fileSize];
    			fis.read(tempData);
    			fos.write(tempData);
    			fos.flush();
    			fos.close();
    			
    		}
    		catch (Exception e)
    		{
    			e.printStackTrace();
    		}	
    	}
    }
 
    public static void main(String[] args) throws Exception 
    {
    	
        long startTime = System.currentTimeMillis();

    	/* Creating five objects of TCPClientNischal to create each threads.*/
        TCPClientNischal fileClient1 = new TCPClientNischal(socket1);      
        TCPClientNischal fileClient2 = new TCPClientNischal(socket2);
        TCPClientNischal fileClient3 = new TCPClientNischal(socket3);
        TCPClientNischal fileClient4 = new TCPClientNischal(socket4);
        TCPClientNischal fileClient5 = new TCPClientNischal(socket5);
        
        /*Creating five anonymous threads and calling the methods */
        Thread t1 = new Thread(new TCPClientNischal(socket1))
		{
			public void run()
			{
				fileClient1.createSocket1();
				fileClient1.receiveFile1();
				
			}
		};
		
		Thread t2 = new Thread(new TCPClientNischal(socket2))
		{
			public void run()
			{
				fileClient2.createSocket2();
				fileClient2.receiveFile2();
				
			}
		};
		
		Thread t3 = new Thread(new TCPClientNischal(socket3))
		{
			public void run()
			{
				fileClient3.createSocket3();
				fileClient3.receiveFile3();
				
			}
		};
		
		Thread t4 = new Thread(new TCPClientNischal(socket4))
		{
			public void run()
			{
				fileClient4.createSocket4();
				fileClient4.receiveFile4();
				
			}
		};
		Thread t5 = new Thread(new TCPClientNischal(socket5))
		{
			public void run()
			{
				fileClient5.createSocket5();
				fileClient5.receiveFile5();
				
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
//	    System.out.println("The start time of thread5 is : " +  System.nanoTime() + " in nano seconds.");
//	    System.out.println("The status of thread5 = " + t5.isAlive());


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
//	    System.out.println("The status of thread5 = " + t5.isAlive());
//	    System.out.println("The end time of thread5 is : " +  System.nanoTime() + " in nano seconds.");
//	    System.out.print("\n");
	    
	        
	    
	    //Stating the path of sourceFile that needs to be merged. 
	    String sourceFile1Path = "File1-download.zip";
    	String sourceFile2Path = "File2-download.zip";
    	String sourceFile3Path = "File3-download.zip";
    	String sourceFile4Path = "File4-download.zip";
    	String sourceFile5Path = "File5-download.zip";
    	
    	//Stating the path of mergedFile.
    	String mergedFilePath = "MergedDownload.zip";
    	
    	//Creating an array of files and indexing them.
    	File[] files = new File[5];
    	files[0] = new File(sourceFile1Path);
    	files[1] = new File(sourceFile2Path);
    	files[2] = new File(sourceFile3Path);
    	files[3] = new File(sourceFile4Path);
    	files[4] = new File(sourceFile5Path);
    	
    	//Creating mergedFile
    	File mergedFile = new File(mergedFilePath);
    	
    	//Calls mergeFiles method passing array of files and the mergedFile.
    	mergeFiles(files, mergedFile);
    	
    	long stopTime = System.currentTimeMillis();
	    long elapsedTime = stopTime - startTime;
	    System.out.println("\n");
	    System.out.println("The time taken to download this file before merging is " + elapsedTime);
	    System.out.println("\n");	
    }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}