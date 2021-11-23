package com.pb.tkachenkoya.hw9;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class FileNumbers {

    public static void createNumbersFile(){
                 try (PrintWriter writer = new PrintWriter(new FileOutputStream ("numbers.txt"))) {
                Random random = new Random();

            int [][] a=new int[10][10];
                        for (int i = 0; i < a.length; i++) {
                for (int j = 0; j <a[i].length; j++){
                    a[i][j] = random.nextInt(100);
                    writer.print(a[i][j]);
                    writer.print(" ");
                   if (j==9){
                       writer.write("\n");
                   }else continue;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public static void createOddNumbersFile() throws IOException {

        try(Scanner in = new Scanner(new File("numbers.txt"))) {
            PrintWriter writer = new PrintWriter(new FileOutputStream ("odd-numbers.txt")); {
                while (in.hasNextLine()) {
                    Scanner str = new Scanner(in.nextLine());
                    while (str.hasNextInt()) {
                        int mod = str.nextInt();
                        if (mod % 2 == 0) {
                            mod = 0;
                            writer.print(mod + " ");
                        } else
                            writer.print(mod + " ");
                    }  str.close();
                   writer.println();
                }
            }writer.close();
        }catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
            e.printStackTrace();
            }
        catch (IOException e) {
            e.printStackTrace();
            }
    }

        public static void main(String[] args) throws IOException {
        createNumbersFile();
        createOddNumbersFile();
    }


}
