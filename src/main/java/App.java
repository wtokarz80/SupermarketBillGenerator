import controllers.AppController;
import services.BillGenerator;
import tools.ReadCSVFile;
import tools.ReadTxtFile;
import view.DisplayResult;

public class App {

    public static void main(String[] args) {

        String filePathCVS = "src/main/resources/product_prices.csv";
        String filePathTxt = "src/main/resources/basket.txt";

        ReadCSVFile readCSVFile = new ReadCSVFile(filePathCVS);
        ReadTxtFile readTxtFile = new ReadTxtFile(filePathTxt);
        BillGenerator billGenerator = new BillGenerator();
        DisplayResult displayResult = new DisplayResult();

        AppController appController = new AppController(readCSVFile, readTxtFile, billGenerator, displayResult);
        appController.init();

    }


}
