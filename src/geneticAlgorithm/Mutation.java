package geneticAlgorithm;


import entities.Product;
import entities.Solution;
import services.SchedulerAlgorithm;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Mutation {


    public void mutationFunctionality(List<Solution> population, SchedulerAlgorithm algo)
    {
        Random rn = new Random();

        for (Solution s: population) {

            if (s.getFitnessValue().getStockConstraints().getNrProductsNotRespectStock() != 0)
            {
                int index = Math.abs(rn.nextInt() % s.getProducts().size());
                Map<Product, Integer> Stock = s.getFitnessValue().getStockConstraints().getStockAfterCrossOver();

                //if there are more products than normal, try to change specified product with another one
               if (Stock.get(s.getProducts().get(index)) < 0)
               {
                   Iterator it = Stock.entrySet().iterator();
                   boolean found = false;
                   while (it.hasNext() && !found) {
                       Map.Entry pair = (Map.Entry)it.next();
                       int value = (Integer)pair.getValue();
                       Product p = (Product)pair.getKey();

                       //if the found product has lower stock than normal put it instead of indexed product
                       if (value > 0 ) {
                           s.getProducts().set(index, p);
                           found = true;
                       }
                       it.remove();

                   }
               }
            }
        }
    }
}
