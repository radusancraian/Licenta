package services;


import entities.Product;
import entities.Solution;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionServices {


   public void computeAllStockConstraints(List<Solution> solutions)
   {   int index = 0;
       for(Solution s : solutions) {

          Map<Product, Integer> stock = new HashMap<Product, Integer>
                  (s.getFitnessValue().getStockConstraints().computeStockConstraints(s));

         s.getFitnessValue().getStockConstraints().setStockAfterCrossOver(stock);
         s.getFitnessValue().getStockConstraints().setNrProductsNotRespectStock();
         index++;
       }
   }

   public void computeAllProcessingTime(List<Solution> solutions, SchedulerAlgorithm algo)
   {
       for(Solution s : solutions) {
           algo.setProducts(s.getProducts());
           algo.computeProcessingTime();
           s.getFitnessValue().setProcessingTime(algo.getProcessingTime());
       }
   }


    public void addNewPopulation ( List<Solution> actualSolution, List<Solution> newSolutions)
    {
        int size  = actualSolution.size();
        actualSolution.subList( 3 * size / 4  - 1, size - 1).clear();
        actualSolution.addAll(newSolutions);
    }

}
