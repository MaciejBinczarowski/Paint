import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.logging.Level;

public class DataSerializer
{
    public static void serializeData(ArrayList<MyShape> shapes)
    {  
        String filename = "file.ser";
         
        // Serialization
        for (MyShape myShape : shapes) 
        {
            
            try
            {  
                MyLogger.logger.log(Level.INFO, "Trying to open file");
                //Saving of object in a file
                FileOutputStream file = new FileOutputStream(new File(filename));
                ObjectOutputStream out = new ObjectOutputStream(file);
                
                MyLogger.logger.log(Level.INFO, "File opened");
                // Method for serialization of object
                // DataMenager.prepareData(myShape);
                Field[] fields = (new DataMenager(myShape)).getClass().getDeclaredFields();
                for (Field field : fields) 
                {
                    MyLogger.logger.log(Level.INFO, "Printing fields");
                    System.out.println(field.getName());   
                }
                out.writeObject(fields);
                
                MyLogger.logger.log(Level.INFO, "Object writed");
                out.close();
                file.close();
                
                System.out.println("Object has been serialized");
    
            }  
            catch(IOException ex)
            {
                System.out.println("IOException is caught");
                System.out.println(ex.getMessage());
            }
        }
    }
}
