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



}
