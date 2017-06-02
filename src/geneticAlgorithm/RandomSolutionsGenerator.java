package geneticAlgorithm;


import entities.Product;
import entities.Solution;
import services.Fitness;
import services.SchedulerAlgorithm;
import services.StockConstraints;

import java.util.*;

public class RandomSolutionsGenerator {


    private SchedulerAlgorithm processingAlgorithm;

    private Map<Product, Integer> productsWithStock = new HashMap<>();

    public Map<Product, Integer> getProductsWithStock() {
        return productsWithStock;
    }

    public void setProductsWithStock(Map<Product, Integer> productsWithStock) {
        this.productsWithStock = productsWithStock;
    }

    public SchedulerAlgorithm getProcessingAlgorithm() {
        return processingAlgorithm;
    }

    public void setProcessingAlgorithm(SchedulerAlgorithm processingAlgorithm) {
        this.processingAlgorithm = processingAlgorithm;
    }


    //generate a random solution
    public Solution generateRandomSolution(HashMap<Product, Integer> Stock) {


        Solution sol = new Solution();
        sol.setInitialStock(productsWithStock);

        Random rn = new Random();
        int k = 0;
        for (int i = 0; i < this.getTotalNrProducts(); i++) {
            boolean OK = true;
            while (OK) {
                int productNr = Math.abs(rn.nextInt() % productsWithStock.size());
                Object obj = Stock.keySet().toArray()[productNr];
                Product p = ((Product) obj);
                if (Stock.get(p) > 0) {
                    sol.getProducts().add(k, p);
                    int stock = Stock.get(p) - 1;
                    Stock.put(p, stock);
                    k++;
                    OK = false;
                }
            }

        }

        //get processing time for solution products
        this.processingAlgorithm.setProducts(sol.getProducts());
        this.processingAlgorithm.computeProcessingTime();

        Fitness f = new Fitness();
        f.setProcessingTime(this.processingAlgorithm.getProcessingTime());
        StockConstraints stockC = new StockConstraints();

        f.setStockConstraints(stockC);
        sol.setFitnessValue(f);

        return sol;
    }

    //generate more random solutions
    public List<Solution> generateRandomSolutions(int nrSol) {

        List<Solution> solutions = new ArrayList<>();
        HashMap<Product, Integer> ProdStock;

        for (int i = 1; i <= nrSol; i++) {

            //create a new stock for each solution
            ProdStock = new HashMap<>(this.productsWithStock);
            Solution s = this.generateRandomSolution(ProdStock);

            solutions.add(s);
        }

        return solutions;
    }

    public int getTotalNrProducts() {
        int allStock = 0;
        for (int s : this.productsWithStock.values()) {
            allStock += s;
        }

        return allStock;
    }

}
