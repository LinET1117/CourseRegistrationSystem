package finaltest;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AddCourse {

  private static String list;
  private static String val;

public static void main(String[] args) throws Exception {
	Map<String, List<String>> map = new TreeMap<String, List<String>>();
	
	
    FileWriter add = new FileWriter("test.csv");
    System.out.println("please input number: ");
    Scanner in = new Scanner(System.in);
    ArrayList<String> input = new ArrayList<String>();
    input.add(in.nextLine());
    input.add(in.nextLine());

    for (String val : input) {
         add.write(val);
         add.write("\n");
    }
    
    /*BufferedReader reader = new BufferedReader(new FileReader("DB_students.csv"));
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
    

    FileWriter writer = new FileWriter("new_DB_students.csv");
    writer.write("student_id, course_id\n");
    for (List<String> list : map.values()) {
        for (String val : list) {
            writer.write(val);
            writer.write("\n");
        }
    }
    writer.close();*/
}

private static String getField(String line) {
    return line.split(",")[0];// extract value you want to sort on
}

}
