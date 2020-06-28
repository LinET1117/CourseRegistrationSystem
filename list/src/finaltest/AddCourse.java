package finaltest;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class AddCourse {


public static void main(String[] args) throws Exception {
	Map<String, List<String>> map = new TreeMap<String, List<String>>();
	
    BufferedReader reader = new BufferedReader(new FileReader("new_DB_students.csv"));
    String line = reader.readLine();//read header
    while ((line = reader.readLine()) != null) {
        String key = getField(line);
        List<String> l = map.get(key);
        if (l == null) {
            l = new LinkedList<String>();
            map.put(key, l);
        }
        l.add(line);
    }
    reader.close();
    
/*___________________________________________________________________*/
    FileWriter addcourse = new FileWriter("new_DB_students.csv");
    addcourse.write("student_id, course_id\n");
    System.out.println("please input number: ");
    Scanner in = new Scanner(System.in);
    List<String> input = new LinkedList<String>();
    input.add(in.next());

    for (String val : input) {
    	addcourse.write(val);
    	addcourse.write("\n");
    }
    in.close();
    
    addcourse.close();
    
    System.out.println("File operation performed successfully.");
    
/*___________________________________________________________________*/
    BufferedReader reader1 = new BufferedReader(new FileReader("new_DB_students.csv"));
    String line1 = reader1.readLine();//read header
    while ((line1 = reader1.readLine()) != null) {
        String key = getField(line1);
        List<String> l = map.get(key);
        if (l == null) {
            l = new LinkedList<String>();
            map.put(key, l);
        }
        l.add(line1);
    }
    reader1.close();
    
    FileWriter writer = new FileWriter("new_DB_students.csv");
    writer.write("student_id, course_id\n");
    for (List<String> list : map.values()) {
        for (String val : list) {
            writer.write(val);
            writer.write("\n");
        }
    }
    writer.close();
}



private static String getField(String line) {
    return line.split(",")[0];// extract value you want to sort on
}

}
