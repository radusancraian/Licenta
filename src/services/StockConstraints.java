package services;


import entities.Product;
import entities.Solution;

import java.util.HashMap;
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

    //set stock Constraints
    public void setStockConstraints(Solution s) {

            Map<Product, Integer> newStock;
            newStock =  new HashMap<>(s.getInitialStock());

            for (Product p : s.getProducts()) {
                newStock.put(p, newStock.get(p) - 1);
            }
        this.setStockAfterCrossOver(newStock);
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
