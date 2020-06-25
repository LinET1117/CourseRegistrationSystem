package finaltest;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Search {
  
  String filename;
  
  public Search (String filename) {
    this.filename = filename;
  }

  public long searchRow(String column1, String colunm2) throws IOException {

    try {
      RandomAccessFile file = new RandomAccessFile(filename, "r");

      file.readLine();

      long pointer = 0;

      long prepointer = 0;

      String[] result;

      String row;

      while ((row = file.readLine()) != null) {

        prepointer = pointer;

        pointer = file.getFilePointer();

        result = row.split(",");

        if (result[0].equals(column1) && result[1].equals(colunm2)) {

          break;

        }

      }

      file.close();

      return prepointer;

    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      return 0;
    }

  }

  public int searchColunm(String columnName, String columnValue) throws IOException {

    try {
      RandomAccessFile file = new RandomAccessFile(filename, "r");

      String[] column = file.readLine().split(",");

      int num = 0;

      for (int i = 0; i < column.length; i++) {
        
        System.out.printf("%s\t", column[i]);

        if ( column[i].equals(columnName) ) {
          num = i;
        }
        
      }

      System.out.println("");
      
      int count = 0;

      String line;

      String[] result;

      while ((line = file.readLine()) != null) {

        result = line.split(",");

        if (result[num].equals(columnValue)) {
          System.out.println(result[0] + "\t" + result[1]);
          count++;
        }

      }

      file.close();

      return count;

    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      return 0;
    }

  }

}
