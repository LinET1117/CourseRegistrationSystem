package finaltest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DeleteSwitch {

  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new FileReader("new_delete_DB_student(刪除過後的資料學生 已排序).csv"));
    Map<String, List<String>> map = new TreeMap<String, List<String>>();
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
    writer.close();
    
}

private static String getField(String line) {
    return line.split(",")[0];// extract value you want to sort on
}

}
