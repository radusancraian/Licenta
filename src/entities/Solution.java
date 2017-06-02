package entities;


import services.Fitness;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution implements Comparable<Solution> {

    private Fitness fitnessValue;

    private List<Product> products = new ArrayList<Product>();

    private Map<Product, Integer> InitialStock = new HashMap<>();

    public Map<Product, Integer> geInitialStock() {
        return InitialStock;
    }

    public Fitness getFitnessValue() {
        return fitnessValue;
    }

    public void setFitnessValue(Fitness fitnessValues) {
        this.fitnessValue = fitnessValues;
    }

    public Map<Product, Integer> getInitialStock() {
        return InitialStock;
    }

    public void setInitialStock(Map<Product, Integer> InitialStock) {
        this.InitialStock = InitialStock;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product p) {
        this.products.add(p);
    }


    @Override
    public int compareTo(Solution o) {
        int obj1StockConstraints = this.getFitnessValue().getStockConstraints().getNrProductsNotRespectStock();
        int obj2StockConstraints = o.getFitnessValue().getStockConstraints().getNrProductsNotRespectStock();
        int obj1ProcessingTime = this.getFitnessValue().getProcessingTime();
        int obj2ProcessingTime = o.getFitnessValue().getProcessingTime();

        if (obj1StockConstraints < obj2StockConstraints) {
            return -1;
        } else if (obj1StockConstraints > obj2StockConstraints){
            return 1;
        } else {
             if(obj1ProcessingTime < obj2ProcessingTime){
                 return -1;
             } else if (obj1ProcessingTime > obj2ProcessingTime){
                 return 1;
             } else {
                 return 0;
             }
        }
    }
}
