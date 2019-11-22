import java.util.*;
import java.io.*; 


/**
 * Read the file
 * read text into string arr
 * convert that string arr to int arr
 */
class EightBitsBinaryToDecimal {
    public static void main(String[] args) throws IOException{
        File file = new File("binary.txt");
        file.createNewFile(); 
        ArrayList<Integer> inDecimal = new ArrayList<Integer>();

        // Read the file
        Scanner reader = null; 
        try{
            reader = new Scanner(file); 
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        while (reader.hasNextLine()){
            inDecimal.add(Integer.parseInt(reader.nextLine(), 2));
        }
        reader.close();

        // Print the ArrayList
        System.out.println(Arrays.toString(inDecimal.toArray()));
        
        for (int i = 0; i < inDecimal.size(); i++){
            System.out.print((char)(int)inDecimal.get(i));
        }

        File result = new File("result.txt"); 
        result.createNewFile(); 
        PrintWriter writer = new PrintWriter(result); 
        writer.println("In decimal: ");
        writer.println(Arrays.toString(inDecimal.toArray()));
        for (int i = 0; i < inDecimal.size(); i++){
            writer.print((char)(int)inDecimal.get(i));
        }
        writer.close();
    }
}