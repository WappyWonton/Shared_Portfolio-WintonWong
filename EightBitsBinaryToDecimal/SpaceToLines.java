import java.util.*; 
import java.io.*; 

class SpaceToLines {
    public static void main(String[] args) throws Exception{
        File file = new File("binary.txt");
        Scanner reader = new Scanner(file);

        // Big ass string
        String bigString = reader.nextLine(); 
        reader.close();
        String newString = bigString.replaceAll(" ", "\n"); 
        PrintWriter writer = new PrintWriter(file);
        writer.print(newString);
        writer.close();
    }
}