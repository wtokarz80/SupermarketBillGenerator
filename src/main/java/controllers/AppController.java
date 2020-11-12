package controllers;

import services.BillGenerator;
import tools.ReadCSVFile;
import tools.ReadTxtFile;
import view.DisplayResult;

import java.util.List;
import java.util.Map;

public class AppController {

    private ReadCSVFile readCSVFile;
    private ReadTxtFile readTxtFile;
    private BillGenerator billGenerator;
    private DisplayResult displayResult;

    public AppController(ReadCSVFile readCSVFile, ReadTxtFile readTxtFile, BillGenerator billGenerator, DisplayResult displayResult) {
        this.readCSVFile = readCSVFile;
        this.readTxtFile = readTxtFile;
        this.billGenerator = billGenerator;
        this.displayResult = displayResult;

    }

    public void init(){

        List<List<String>> productPrices = readCSVFile.readCSVFile();
        List<String> products = readTxtFile.readTxtFile();
        double totalPrice = billGenerator.calculatePrice(productPrices, products);
        displayResult.displayResult(totalPrice);

    }

}
