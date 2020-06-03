import java.util.List;
import java.util.Scanner;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.io.*;


class SalesUtil {

    static List<ProductPrice> readProductPrice(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        List<ProductPrice> items = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] split = line.split(";");
            ProductPrice nextProductPrice = new ProductPrice( new BigDecimal(split[0]),split[1], new BigDecimal(split[2]));
            items.add(nextProductPrice);
        }
        return items;
    }

    static void exportData(Sum stats, String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write("Netto;" + stats.getNettoSum());
        writer.newLine();
        writer.write("Vat;" + stats.getVatSum());
        writer.newLine();
        writer.write("Brutto;" + stats.getBruttoSum());
        writer.close();
    }

}