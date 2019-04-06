package com.danske.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * FileUtilites reads input source file from resources file
 * and return list of data which contains list if numbers in each line
 *
 * @since 06/04/2019
 */
public class FileUtilities {
    /**
     * method is to read the input source and return list of lines
     * wherein each line contains list of numbers present
     * @param fileName
     * @return list of list
     */
    public List<List<Integer>> readFile(String fileName) {
        FileInputStream inputStream = null;
        List<List<Integer>> inputList = new ArrayList<List<Integer>>();
        try {
            ClassLoader classLoader = this.getClass().getClassLoader();
            File configFile = new File(classLoader.getResource(fileName).getFile());
            inputStream = new FileInputStream(configFile);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                //printing data which is present in input file
                System.out.println(line);
                List<Integer> list = inputToArray(line.split(" "));
                if (list.size() != 0) {
                    inputList.add(list);
                } else {
                    break;
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return inputList;
    }

    /**
     * input array contains data split based on " " (space)
     * and each number present at array index is put into list
     * @param input array
     * @return list of integer at every line
     */
    public static List<Integer> inputToArray(String[] input) {
        List<Integer> list = new ArrayList<Integer>();
        for (String entry : input) {
            int number = Integer.parseInt(entry);
            list.add(number);
        }

        if (list != null && list.size() != 0) {
            return list;
        }
        return null;
    }

}
