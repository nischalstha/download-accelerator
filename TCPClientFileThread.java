package ProjectFall2016;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
 
public class TCPClientFileThread extends Thread implements Runnable
{
    private Socket socket = null;
    private DataInputStream inStream = null;
    private DataOutputStream outStream = null;
 
    public TCPClientFileThread() 
    {
 
    }
 
    private void createSocket()
    {
        try
        {
            socket = new Socket("localHost", 3339);
            //socket.
            System.out.println("Connected");
            inStream = new DataInputStream(socket.getInputStream());
            outStream = new DataOutputStream(socket.getOutputStream());
        } 
        catch (Exception u) 
        {
            u.printStackTrace();
        } 
    }
 
    private void receiveFile()
    {
        try
        {
            int fileSize = inStream.readInt();
            byte data[] = new byte[fileSize];
            FileOutputStream fileOut = new FileOutputStream("download.zip",true);       
            int count =0, totalBytes=0;
            while(true)
            {
                count = inStream.read(data,0,fileSize);
                byte[] arrayBytes = new byte[count];
                System.arraycopy(data, 0, arrayBytes, 0, count);
                totalBytes = totalBytes + count;
                if(count>0)
                {
                    fileOut.write(arrayBytes);
                    fileOut.flush();
                }
                if(totalBytes == fileSize)
                    break;
            }
            System.out.println("File Size is: "+fileSize + ", number of bytes read are: " + totalBytes);
             
            socket.close();
            inStream.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
     
    public void run()
    {
        createSocket();
        receiveFile();
    }
     
    public static void main(String[] args) throws Exception 
    {
        long startTime = System.currentTimeMillis();

        TCPClientFileThread fileClient = new TCPClientFileThread();
        fileClient.start();
        fileClient.join();
        long stopTime = System.currentTimeMillis();
	    long elapsedTime = stopTime - startTime;
	    System.out.println("\n");
	    System.out.println("The time taken to download this file: " + elapsedTime);
    }
}
