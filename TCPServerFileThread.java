package ProjectFall2016;

import java.io.*;
import java.io.ObjectOutputStream.PutField;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
 
public class TCPServerFileThread extends Thread implements Runnable
{
    private ServerSocket serverSocket = null;
    private Socket socket = null;
    private DataInputStream inStream = null;
    private DataOutputStream outStream = null;
    private final int bufferSize = 512*1024; //buffer size 512 KB
 
    public TCPServerFileThread() 
    {
 
    }
 
    private void createSocket() 
    {
        try
        {
            serverSocket = new ServerSocket(3339);
            socket = serverSocket.accept();
                 
            inStream = new DataInputStream(socket.getInputStream());
            outStream = new DataOutputStream(socket.getOutputStream());
            System.out.println("Connected");
        }
        catch (IOException io) 
        {
            io.printStackTrace();
        }
    }
     
    private void sendFile()
    {
        try
        {
//write the filename below in the File constructor
            File file = new File("165MB.zip");
            FileInputStream fileInput = new FileInputStream(file);
            int fileSize = (int) file.length();
            System.out.println("Server: File size is:" + fileSize);
            byte [] data = new byte[(int) fileSize];
         
            fileInput.read(data);
             
            //first send the size of the file to the client
            outStream.writeInt(fileSize);
            outStream.flush();
             
            outStream.write(data);
            outStream.flush();
            fileInput.close();
            serverSocket.close();
            socket.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
 
    public void run()
    {
        createSocket();
        sendFile();
    }
    public static void main(String[] args) throws InterruptedException
    {
        TCPServerFileThread fileServer = new TCPServerFileThread();
        fileServer.start();
        fileServer.join();
    }
}