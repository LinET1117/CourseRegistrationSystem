package finaltest;
import java.io.*; 
import java.util.HashSet;
import java.io.BufferedReader;
import java.io.FileReader;


public class DeleteCourse {

	public static void main(String[] args) throws IOException {
		// TODO �۰ʲ��ͪ���k Stub
 
        PrintWriter pw = new PrintWriter("new_delete_DB_student(�R���L�᪺��ƾǥ� �w�Ƨ�).csv");  
        BufferedReader br2 = new BufferedReader(new FileReader("delete(�Q�n�R�������).txt"));
        String line2 = br2.readLine(); 


        
        // hashset for storing lines of delete.txt
        HashSet<String> hs = new HashSet<String>(); 
          
        // loop for each line of delete.txt
        while(line2 != null) 
        { 
            hs.add(line2); 
            line2 = br2.readLine(); 
        } 
                      
        // BufferedReader object for new_DB_students.csv 
        BufferedReader br1 = new BufferedReader(new FileReader("new_DB_students.csv")); 
          
        String line1 = br1.readLine(); 
          
        // loop for each line of new_DB_students.csv
        while(line1 != null) 
        { 
            // if line is not present in delete.txt 
            // write it to new_delete_DB_student(�R���L�᪺��ƾǥ� �w�Ƨ�).csv 
            if(!hs.contains(line1)) 
                pw.println(line1); 
              
            line1 = br1.readLine(); 
        } 
          
        pw.flush(); 
          
        // closing resources 
        br1.close(); 
        br2.close(); 
        pw.close(); 
          
        System.out.println("File operation performed successfully"); 
	}
	
	
	
	

}
