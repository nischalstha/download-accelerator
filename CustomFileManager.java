package ProjectFall2016;
import java.io.*;
 
public class CustomFileManager 
{
    private File source;
    private int partitions;
    FileInputStream reader;
    FileOutputStream writer;
    private byte [] data;
    protected static int fileMinSize;
    private int leftOverBytes;
    private boolean lastPartitionFlag = false;
    //user will pass the source file and number of partitions required
    CustomFileManager(String fileName, int p)
    {
        try
        {
            source = new File(fileName);
            partitions = p;
            //min size of each partition
            fileMinSize  = (int) (source.length()/partitions);
            //extra bytes with the last partition along with min size
            leftOverBytes = (int) (source.length()%partitions);
            reader = new FileInputStream(source);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Error opening the source file");
        }
    }
     
    //This method will find the size of each partition and call to helper methods for read source file
    //and write into each partition
    public void createPartitions()
    {
        int fileCounter = 1;
        for(int i = 0 ; i < partitions ; i++)
        {
            //check if it's the last partition
            if(i == (partitions - 1))
            {
                lastPartitionFlag = true;
            }
            data = readFile();
            writeFile(data, "File" + fileCounter + ".zip" );
            fileCounter++;
        }
        System.out.println("Partitions successfully created");
	    System.out.print("\n");

    }
     
    private void writeFile(byte [] d, String fileName)
    {
        try
        {
            System.out.println("Writing " + d.length + " bytes to " + fileName);
            writer = new FileOutputStream(new File(fileName));
            writer.write(d);
            writer.flush();
            writer.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Error writing file");
            System.exit(0);
        }
    }
     
    private byte [] readFile()
    {
        byte [] tempData;
        if(lastPartitionFlag)
            tempData = new byte[fileMinSize+leftOverBytes];
        else
            tempData = new byte[fileMinSize];
        try
        {
            reader.read(tempData, 0, tempData.length);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Error reading file");
            System.exit(0);
        }
        return tempData;
    }
}