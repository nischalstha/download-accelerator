package ProjectFall2016;
 
public class FileManagerDriver 
{
    public static void main(String[] args) 
    {
        //provide the source file (absolute or relative) with number of partitions required
        CustomFileManager c = new CustomFileManager("clients.txt", 5);
        c.createPartitions();
    }
 
}