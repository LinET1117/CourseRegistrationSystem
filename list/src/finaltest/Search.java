package finaltest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Search {

  String filename = "new_DB_students.csv";

  public void main(String[] args) throws IOException {

    Scanner input = new Scanner(System.in);

    int option = 0;

    while (true) {

      System.out.println("1.Search the student what courses did he/she choose");
      System.out.println("2.Search the course how many stduent choose");
      System.out.println("3.Exit");
      System.out.print("Option : ");

      option = input.nextInt();

      if (option == 1) {

        System.out.print("Input the stduent's id : ");
        searchColunm("student_id", input.next());

      } else if (option == 2) {

        System.out.print("Input the course's id : ");
        searchColunm("course_id", input.next());

      } else if (option == 3) {

        break;

      } else {

        System.out.println("input error");
        continue;

      }
      input.close();
    }

  }

  public void searchRow(String column1, String colunm2) throws IOException {

    try {
      RandomAccessFile file = new RandomAccessFile(filename, "r");

      file.readLine();

      String[] result;

      String row;

      while ((row = file.readLine()) != null) {

        result = row.split(",");

        if (result[0].equals(column1) && result[1].equals(colunm2)) {

          break;

        }

      }

      file.close();

    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

  public void searchColunm(String columnName, String columnValue) throws IOException {

    try {
      RandomAccessFile file = new RandomAccessFile(filename, "r");

      String[] column = file.readLine().split(",");

      int num = 0;

      for (int i = 0; i < column.length; i++) {

        System.out.printf("%s\t", column[i]);

        if (column[i].equals(columnName)) {
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

      System.out.println(count);

    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

}
