package geneticAlgorithm;


import entities.Product;

import java.util.*;

public class Mutation {


    public void mutationFunctionality(List<Solution> population) {
        Random rn = new Random();

        for (int i = 0; i < population.size() / 2; i++) {
            Solution s = new Solution();
            s = population.get(i);
            if (s.getFitnessValue().getStockConstraints().getNrProductsNotRespectStock() != 0) {
                int index = Math.abs(rn.nextInt() % s.getProducts().size());
                Map<Product, Integer> Stock = new HashMap<>(s.getFitnessValue().getStockConstraints().getStockAfterCrossOver());


                Iterator it1 = Stock.entrySet().iterator();
                boolean foundNegative = false;
                while (it1.hasNext() && !foundNegative) {
                    Map.Entry pair = (Map.Entry)it1.next();
                    if ( ((Product)(pair.getKey())).getName().compareTo(s.getProducts().get(index).getName()) == 0) {
                       if ((Integer)pair.getValue() < 0) foundNegative = true;
                    }
                }

                //if there are more products than normal, try to change specified product with another one
                if (foundNegative) {
                    Iterator it = Stock.entrySet().iterator();
                    boolean found = false;
                    while (it.hasNext() && !found) {
                        Map.Entry pair = (Map.Entry) it.next();
                        int value = (Integer) pair.getValue();
                        Product p = new Product (  ((Product) pair.getKey()).getName(),
                                ((Product) pair.getKey()).getComponents());

                        //if the found product has lower stock than normal put it instead of indexed product
                        if (value > 0) {
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
