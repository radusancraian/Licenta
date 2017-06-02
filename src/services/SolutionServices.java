package services;


import entities.Solution;

import java.util.List;

public class SolutionServices {


   public void computeAllStockConstraints(List<Solution> solutions)
   {
       for(Solution s : solutions) {
           s.getFitnessValue().getStockConstraints().setStockConstraints(s);
           s.getFitnessValue().getStockConstraints().setNrProductsNotRespectStock();
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

}
