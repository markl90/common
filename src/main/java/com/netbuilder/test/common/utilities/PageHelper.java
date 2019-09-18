package com.netbuilder.test.common.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class PageHelper {

      public void waitForLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(pageLoadCondition);
    }

    public int getHttpStatusCode(String pageUrl) {
        int code = 0;
        try {
            URL url = new URL(pageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            code = connection.getResponseCode();
            System.out.println("code: " + code);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return code;
    }

    /**
     * Custom wait where a wait was needed after clicking the expand button
     * on a collapsed description for the full length of it to load.
     *
     * Therefore is takes the WebDriver as a parameter and the second number resulting in a pass if it is
     * greater that the first number.
     * This can be used to wait for any second number to become larger than an initial number before moving on.
     *
     * @param driver
     * The chosen WebDriver
     * @param firstNumber
     * The initial number
     * @param secondNumber
     * The number that the user wants to wait to be larger than the first before proceeding.
     */
    public void waitForLengthToIncrease(WebDriver driver, int firstNumber, WebElement secondNumber) {
        ExpectedCondition<Boolean> customCondition = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return (firstNumber < secondNumber.getText().length());
            }
        };
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(customCondition);
    }


    public static void createFile(String fileName, String content){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/test/resources/reports/"+fileName+".txt"));
            writer.write(content);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToFile(String fileName, String content){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/test/resources/reports/"+fileName+".txt", true));
            writer.append(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static int readNumberofLines(String fileName){
        int lines = 0;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("src/test/resources/reports/"+fileName+".txt"));


        while (reader.readLine() != null) lines++;
        reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }



    public static void closeFileResource(String fileName){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/test/resources/reports/"+fileName+".txt"));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
