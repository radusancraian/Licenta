package geneticAlgorithm;

import entities.Product;
import entities.Solution;
import services.StockConstraints;

import java.util.*;


public class Selection {

    public void selectionFunctionality(List<Solution> actualSolutions) {

        int index = 0;
        //save the first quart from propulation on the 3rd quart
        for (int i = actualSolutions.size() / 2; i <= (3 * actualSolutions.size()) / 4 - 1; i++) {

            Solution actualS = actualSolutions.get(index);

            Solution s = new Solution();
            Fitness f = new Fitness();
            StockConstraints stockC = new StockConstraints();
            Map<Product, Integer> stockAferCrossOver = new  HashMap<>(actualS.getFitnessValue()
                    .getStockConstraints().getStockAfterCrossOver());

            Map<Product, Integer> initialStock = new HashMap<>(actualS.getInitialStock());
            stockC.setStockAfterCrossOver(stockAferCrossOver);
            f.setStockConstraints(stockC);
            f.setProcessingTime(actualS.getFitnessValue().getProcessingTime());
            List<Product> products = new ArrayList<>();
            for ( Product p : actualS.getProducts())
            {
                Product pr = new Product(p.getName(), p.getComponents());
                products.add(pr);
            }
            s.setFitnessValue(f);
            s.setProducts(products);
            s.setInitialStock(initialStock);
            actualSolutions.set(i, s);
            index++;
        }

    }

}