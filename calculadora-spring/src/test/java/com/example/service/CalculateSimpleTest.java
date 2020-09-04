
package com.example.service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class CalculateSimpleTest {
    public CalculateSimpleTest() {
    }
    String baseUrl = "http://localhost:5050/calculadora";
    WebDriver driver;
    String expectedResult;
    String actualResult = "";
    String chromePath = System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe";
    
    @BeforeTest
    public void launchBrowser(){       
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }
    
    //Limpiar campos
    @BeforeMethod
    public void borrar(){
        driver.findElement(By.name("a")).clear();
        driver.findElement(By.name("b")).clear();
    }
    
    //Hacer test a suma
    @Test
    public void suma(){

        driver.findElement(By.name("a")).sendKeys("5");
        driver.findElement(By.name("b")).sendKeys("7");
        
        WebElement sumar = driver.findElement(By.xpath("/html/body/form/p[1]/input[1]"));
        sumar.click();
        
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        
        expectedResult="12";
        WebElement resultado = driver.findElement(By.xpath("/html/body/form/h1[2]/p"));
        actualResult = resultado.getText();
        
        Assert.assertEquals(actualResult, expectedResult);  
    }
     //Hacer test a resta
    @Test
    public void resta(){
        driver.findElement(By.id("a")).sendKeys("15");
        driver.findElement(By.id("b")).sendKeys("5");
        
        WebElement restar = driver.findElement(By.xpath("/html/body/form/p[1]/input[2]"));
        restar.click();
        
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        
        expectedResult=10;
        WebElement resultado = driver.findElement(By.xpath("/html/body/form/h1[2]/p"));
        actualResult = resultado.getText();
        
        Assert.assertEquals(actualResult, expectedResult);  
    }
    //Hacer test para multiplicar
    @Test
    public void multiplicar(){
        driver.findElement(By.id("a")).sendKeys("5");
        driver.findElement(By.id("b")).sendKeys("5");
        
        WebElement multiplicar = driver.findElement(By.xpath("/html/body/form/p[1]/input[3]"));
        multiplicar.click();
        
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        
        expectedResult=25;
        WebElement resultado = driver.findElement(By.xpath("/html/body/form/h1[2]/p"));
        actualResult = resultado.getText();
        
        Assert.assertEquals(actualResult, expectedResult);
    }
    
    //Hacer test para dividir
    @Test
    public void dividir(){
        driver.findElement(By.name("a")).sendKeys("15");
        driver.findElement(By.name("b")).sendKeys("5");
        
        WebElement dividir = driver.findElement(By.xpath("/html/body/form/p[1]/input[4]"));
        dividir.click();
        
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        
        expectedResult=3;
        WebElement resultado = driver.findElement(By.xpath("/html/body/form/h1[2]/p"));
        actualResult = resultado.getText();
        
        Assert.assertEquals(actualResult, expectedResult);
    }
    
//    @Test
//    public void fibonacci(){
//        driver.findElement(By.name("c")).sendKeys("6");
//        
//        WebElement fibonacci = driver.findElement(By.xpath("/html/body/form/p[2]/input[1]"));
//        fibonacci.click();
//        
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//        }
//        
//        expectedResult="8";
//        WebElement resultado = driver.findElement(By.xpath("/html/body/form/h1[2]/p"));
//        actualResult = resultado.getText();
//        
//        Assert.assertEquals(actualResult, expectedResult);
//    }
//    
//    @Test
//    public void factorial(){
//        driver.findElement(By.id("c")).sendKeys("4");
//        
//        WebElement factorial = driver.findElement(By.xpath("/html/body/form/p[2]/input[2]"));
//        factorial.click();
//        
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//        }
//        
//        expectedResult="24";
//        WebElement resultado = driver.findElement(By.xpath("/html/body/form/h1[2]/p"));
//        actualResult = resultado.getText();
//        
//        Assert.assertEquals(actualResult, expectedResult);
//    }
//    
//    @Test
//    public void raizCuadrada(){
//        driver.findElement(By.name("c")).sendKeys("9");
//        
//        WebElement factorial = driver.findElement(By.xpath("/html/body/form/p[2]/input[3]"));
//        factorial.click();
//        
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//        }
//        
//        expectedResult="3.0";
//        WebElement resultado = driver.findElement(By.xpath("/html/body/form/h1[2]/p"));
//        actualResult = resultado.getText();
//        
//        Assert.assertEquals(actualResult, expectedResult);
//    }
//    
//    @Test
//    public void cuadrado(){
//        driver.findElement(By.name("c")).sendKeys("4");
//        
//        WebElement factorial = driver.findElement(By.xpath("/html/body/form/p[2]/input[4]"));
//        factorial.click();
//        
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//        }
//        
//        expectedResult="16";
//        WebElement resultado = driver.findElement(By.xpath("/html/body/form/h1[2]/p"));
//        actualResult = resultado.getText();
//        
//        Assert.assertEquals(actualResult, expectedResult);
//    }
}
