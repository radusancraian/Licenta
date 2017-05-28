package entities;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution implements Comparable<Solution> {

    private int processingTime;

    private int nrProductsNotInStock;

    private List<Product> products = new ArrayList<Product>();

    private Map<Product, Integer> ProductsWithStock = new HashMap<>();

    private Map<Product, Integer> stockConstraints = new HashMap<>(ProductsWithStock.size());

    public Map<Product, Integer> getStockConstraints() {
        return stockConstraints;
    }

    public void setStockConstraints(Map<Product, Integer> stockConstraints) {
        this.stockConstraints = stockConstraints;
    }

    public Map<Product, Integer> getProductsWithStock() {
        return ProductsWithStock;
    }

    public void setProductsWithStock(Map<Product, Integer> productsWithStock) {
        ProductsWithStock = productsWithStock;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getProcessingTime() {
        return processingTime;
    }

    public void setProcessingTime(int processingTime) {
        this.processingTime = processingTime;
    }

    public int getNrProductsNotInStock() {
        return nrProductsNotInStock;
    }

    public void setNrProductsNotInStock(int nrProductsNotInStock) {
        this.nrProductsNotInStock = nrProductsNotInStock;
    }

    public void addProduct(Product p) {
        this.products.add(p);
    }

    @Override
    public int compareTo(Solution o) {
        if (this.getProcessingTime() > o.getProcessingTime()) {
            return 1;
        } else if (this.getProcessingTime() < o.getProcessingTime()) {

            return -1;

        }
        return 0;
    }
}
