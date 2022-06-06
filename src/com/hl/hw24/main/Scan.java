package com.hl.hw24.main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static java.nio.file.Files.lines;

public class Scan {
    Scanner in = new Scanner(System.in);
    boolean finished = false;
    Date firstDate;
    LocalDate start;
    Date secondDate;
    LocalDate end;
    String letterCode;
    int count = 0;
    double sumCost = 0;
    DateFormat formatter = new SimpleDateFormat("dd_MM_yyyy");

    public void scan() throws ParseException, IOException {
        while (!finished) {
            System.out.println("Please, enter the first date of the range in format dd_mm_yyyy");
            String tempDate = in.nextLine();
            if (!tempDate.isEmpty()) {
                firstDate = formatter.parse(tempDate);
                start = firstDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            }
            System.out.println("Please, enter the second date of the range");
            tempDate = in.nextLine();
            if (!tempDate.isEmpty()) {

                secondDate = formatter.parse(tempDate);
                if (secondDate.before(firstDate) || secondDate.equals(firstDate)) {
                    System.out.println("second date must be after first date");
                    finished = false;
                }
                end = secondDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            }
            System.out.println("Please, enter currency Letter code");
            letterCode = in.nextLine();
            if (letterCode.isEmpty()) {
                finished = false;
            }
            for (LocalDate date = start; date.isBefore(end); date = date.plusDays(1)) {
                String dates = date.format(DateTimeFormatter.ofPattern("dd_MM_yyyy"));
                if (checkFile(dates)) {
                    Path file = Paths.get("C:\\Users\\Admin\\IdeaProjects\\JavaHomeWork\\src\\com\\hl\\hw24\\resources\\" + dates + ".txt");
                    List<Currency> currency = fileRead(file);
                    if (checkCurrency(currency, letterCode)) {
                        sumCost += (currency.stream().
                                filter(o -> o.letterCode.equals(letterCode)).toList()).get(0).cost;
                        count++;
                        finished = true;
                    }
                } else System.out.println("data not found for date " + dates);
            }
        }
        System.out.printf("average exchange rate of %s for the entered dates %s", letterCode, sumCost / count);
    }

    public boolean checkFile(String date) {
        Path file = Paths.get("C:\\Users\\Admin\\IdeaProjects\\JavaHomeWork\\src\\com\\hl\\hw24\\resources\\" + date + ".txt");
        return Files.exists(file);
    }

    public boolean checkCurrency(List<Currency> currencies, String letterCode) {
        return currencies.stream().map(Currency::getLetterCode).filter(letterCode::equals).findFirst().isPresent();
    }

    public List<Currency> fileRead(Path file) throws IOException {
        List<String> tempList = lines(file).toList();
        List<Currency> currencies = new ArrayList<>();

        for (int i = 0; i < tempList.size(); i++) {
            String[] strings = tempList.get(i).split("\\s");
            Currency currency = new Currency();
            currency.setDigitalCode(strings[0]);
            currency.setLetterCode(strings[1]);
            currency.setUnit(Integer.parseInt(strings[2]));
            currency.setCurrencyName(strings[3]);
            currency.setCost(Double.parseDouble(strings[4]));
            currencies.add(currency);
        }
        return currencies;
    }
}
