import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;

public class DataSerializer
{
    private static String currentPath = null;

    public static void serializeData(ArrayList<MyShape> shapes, String path)
    {  
        ArrayList<HashMap> objectsArray = new ArrayList<HashMap>(); 
         
        // Serialization
        for (MyShape myShape : shapes) 
        {
            objectsArray.add(DataMenager.prepareShapeProperties(myShape));
        }

        try
        {  
            MyLogger.logger.log(Level.INFO, "Trying to open file");
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(new File(path));
            ObjectOutputStream out = new ObjectOutputStream(file);
            
            MyLogger.logger.log(Level.INFO, "File opened");
            // Method for serialization of object
            // DataMenager.prepareData(myShape);

            out.writeObject(objectsArray);
            
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

    public static ArrayList<HashMap> deserializeData(String path)
    {
        ArrayList<HashMap> objectsArray = null;
        try
        {  
            // Reading the object from a file
            FileInputStream file = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(file);
            currentPath = path;
             
            // Method for deserialization of object
            objectsArray = (ArrayList)in.readObject();
             
            in.close();
            file.close();
             
            System.out.println("Object has been deserialized ");
            for (HashMap<String, String> shapeProperties : objectsArray) 
            {
                for (String key: shapeProperties.keySet()) 
                {
                    System.out.println(shapeProperties.get(key));
                }   
            }
        }
         
        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }
         
        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
        }

        return objectsArray;
    }

    public static String getCurrentPath() 
    {
        return currentPath;
    }
}
