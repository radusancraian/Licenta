package services;


import entities.Product;
import geneticAlgorithm.Solution;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class StockConstraints {

    private Map<Product, Integer> stockAfterCrossOver = new HashMap<>();

    private int nrProductsNotRespectStock;

    public Map<Product, Integer> getStockAfterCrossOver() {
        return stockAfterCrossOver;
    }

    public void setStockAfterCrossOver(Map<Product, Integer> stockAfterCrossOver) {
        this.stockAfterCrossOver = stockAfterCrossOver;
    }

    //compute stock Constraints
    public Map<Product, Integer> computeStockConstraints(Solution s) {

            Map<Product, Integer> newStock;
            newStock =  new HashMap<>(s.getInitialStock());

            for (Product p : s.getProducts()) {
                Iterator it = newStock.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry pair = (Map.Entry)it.next();
                    if ( ((Product)(pair.getKey())).getName().compareTo(p.getName()) == 0) {
                        int stock =  (Integer)pair.getValue() - 1;
                        newStock.put((Product)pair.getKey(), stock);
                    }
                }


            }
       return newStock;
    }


    public int getNrProductsNotRespectStock() {
        return nrProductsNotRespectStock;
    }

    //set the number of products which doesn't respect the initial stock
    public void setNrProductsNotRespectStock() {

        this.nrProductsNotRespectStock = 0;

        for (Integer value : this.stockAfterCrossOver.values()) {

            this.nrProductsNotRespectStock += Math.abs(value);
        }
    }
}
