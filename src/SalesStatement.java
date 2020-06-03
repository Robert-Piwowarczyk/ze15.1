import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

class SalesStatement {
    public static void main(String[] args) {
        try {
            List<ProductPrice> productPrices = SalesUtil.readProductPrice("objects.csv");
            Sum sum = CalculatorPrice.calculateStats(productPrices);
            System.out.println("Sprzedaż Netto: " + sum.getNettoSum() + "zł");
            System.out.println("Suma podatku VAT ze sprzedaży: " + sum.getVatSum() + "zł");
            System.out.println("Sprzedaż Brutto: " + sum.getBruttoSum() + "zł");
            SalesUtil.exportData(sum, "sumNBV.csv");
        } catch (FileNotFoundException e) {
            System.out.println("Nie odnaleziono pliku");
        } catch (IOException e) {
            System.out.println("Nie udało się wyeksportować danych");
        }

    }
}