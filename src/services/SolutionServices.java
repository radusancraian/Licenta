package services;

import entities.Product;
import entities.Solution;

import java.util.*;


public class SolutionServices {


    //generate a random solution
    public Solution generateRandomSolution(HashMap<Product, Integer> ProductsAndStock, int nrProducts,
                                           List<Product> products) {
        Solution sol = new Solution();

        Random rn = new Random();
        int k = 0;
        for (int i = 0; i < nrProducts; i++) {
            boolean OK = true;
            while (OK) {
                int product = Math.abs(rn.nextInt() % products.size());
                if (ProductsAndStock.get(products.get(product)) > 0) {
                    sol.getProducts().add(k, products.get(product));
                    int stock = ProductsAndStock.get(products.get(product)) - 1;
                    ProductsAndStock.remove(products.get(product));
                    ProductsAndStock.put(products.get(product), stock);
                    k++;
                    OK = false;
                }
            }
        }
        return sol;
    }

    //generate more random solutions
    public List<Solution> generateRandomSolutions(HashMap<Product, Integer> ProductsWithStock, int nrProducts,
                                                  List<Product> products, SchedulerAlgorithm algo, int nrSol) {
        List<Solution> solutions = new ArrayList<>();
        HashMap<Product, Integer> ProdStock;

        for (int i = 1; i <= nrSol; i++) {

            //create a new stock for each solution
            ProdStock = new HashMap<>(ProductsWithStock);
            Solution s = this.generateRandomSolution(ProdStock, nrProducts, products);

            //calculate processing time for solution products
            algo.setProducts(s.getProducts());
            algo.computeSchedulingInputOutputMatrices();

            //the last element from output matrix is the total processing time
            s.setProcessingTime(algo.getOutputMatrix()[nrProducts - 1][algo.getProdLine().getMachineryList().size() - 1]);
            s.setProductsWithStock(ProductsWithStock);
            solutions.add(s);
        }

        return solutions;
    }


    //sort solutions by processing time
    public List<Solution> sortSolutionsByProcessingTime(List<Solution> solutions) {
        Collections.sort(solutions);

        return solutions;
    }

}
