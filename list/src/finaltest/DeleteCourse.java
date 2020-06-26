package finaltest;
import java.io.*; 
import java.util.HashSet; 

public class DeleteCourse {

	public static void main(String[] args) throws IOException {
		// TODO 自動產生的方法 Stub
 
        PrintWriter pw = new PrintWriter("new_delete_DB_student(刪除過後的資料學生 已排序).csv");  
        BufferedReader br2 = new BufferedReader(new FileReader("delete(想要刪除的資料).csv"));  
        String line2 = br2.readLine(); 
          
        // hashset for storing lines of delete.csv 
        HashSet<String> hs = new HashSet<String>(); 
          
        // loop for each line of delete.csv
        while(line2 != null) 
        { 
            hs.add(line2); 
            line2 = br2.readLine(); 
        } 
                      
        // BufferedReader object for add_students(加入學生 已排序).csv 
        BufferedReader br1 = new BufferedReader(new FileReader("add_students(加入學生 已排序).csv")); 
          
        String line1 = br1.readLine(); 
          
        // loop for each line of add_students(加入學生 已排序).csv
        while(line1 != null) 
        { 
            // if line is not present in delete.csv 
            // write it to new_delete_DB_student.csv 
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
