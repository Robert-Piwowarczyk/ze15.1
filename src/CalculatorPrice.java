import java.math.BigDecimal;
import java.util.List;


class CalculatorPrice {


    static Sum calculateStats(List<ProductPrice> productPrices) {
        BigDecimal nettoSum = sumNettoPrice(productPrices);
        BigDecimal taxSum = sumTaxPrice(productPrices);
        BigDecimal bruttoSum = sumBruttoPrice(productPrices);
        return new Sum(nettoSum, taxSum, bruttoSum);
    }

    static BigDecimal sumNettoPrice(List<ProductPrice> productPrices) {
        BigDecimal sum = BigDecimal.ZERO;
        for (ProductPrice productPrice : productPrices) {
            sum = sum.add(productPrice.getNettoPrice());
        }
        return sum;
    }

    static BigDecimal sumTaxPrice(List<ProductPrice> productPrices) {
        BigDecimal sum = BigDecimal.ZERO;
        for (ProductPrice productPrice : productPrices) {
            sum = sum.add(productPrice.getTax());
        }
        return sum;
    }

    static BigDecimal sumBruttoPrice(List<ProductPrice> productPrices) {
        BigDecimal sum = BigDecimal.ZERO;
        for (ProductPrice productPrice : productPrices) {
            sum = sum.add(productPrice.getBruttoPrice());
        }
        return sum;
    }
}