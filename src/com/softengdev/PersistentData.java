package com.softengdev;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PersistentData {
  // Initializes reader/writer
  private static final String FILE_LOCATION = "resources/persistent_data.txt";
  private File file;
  // private BufferedWriter writer;
  public PersistentData() {
    initialize_data();
  }

  // Loads reader/writer
  private void initialize_data() {
    try {
      file = new File(FILE_LOCATION);
    } catch (NullPointerException e) {
      System.out.println("Code should't get here, but for some reason did, as the file must exist with build version.");
    }
    // try {
    //   reader = new BufferedReader(new FileReader(FILE_LOCATION));
    //   writer = new BufferedWriter(new FileWriter(FILE_LOCATION));
    // } catch (IOException | NumberFormatException e) {
    //   e.printStackTrace();
    // }
  }

  // Returns currently stored value, string
  public String load_value_string() {
    String line = "0";
    try {
      Scanner reader = new Scanner(file);
      while(reader.hasNextLine()) {
        line = reader.nextLine();
      }
      reader.close();
    } catch (FileNotFoundException e) {
      System.out.println("Code should't get here, but for some reason did, as the file must exist with build version.");

    }
    return line;
  }

  public int load_value_int() {
    String val = load_value_string();
    return Integer.parseInt(val);
  }

  // Saves given value, string
  public void save_value_string(String value) {
    try {
      FileWriter writer = new FileWriter(FILE_LOCATION);
      writer.write(value);
      writer.close();
    } catch (IOException e) {
      System.out.println("Code should't get here, but for some reason did, as the file must exist with build version.");
    }
  }
  public void save_value_int(int value) {
    String val = String.valueOf(value);
    save_value_string(val);
  }
}
