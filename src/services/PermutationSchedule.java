package services;


import entities.Product;

import java.util.List;

public class PermutationSchedule {


    private static int iteratie = -1;
    private static int[] indexes = new int[12], usedIndexes = new int[12];

    static void back(int k, int len, List<Product> productsList, List<Product> initialList, SchedulerAlgorithm algo,
                     int[] processingTimes)
    {
        if(k-1 == len)
        {
            for(int i = 1; i <= len;i++) {
                Product p = new Product(initialList.get(indexes[i] - 1).getName(), initialList.get(indexes[i] - 1).getComponents());
                productsList.set( i - 1, p);
            }
            algo.setProducts(productsList);
            algo.computeProcessingTime();
            iteratie ++;
            processingTimes[iteratie] = algo.getProcessingTime();

        }
        else
        {
            for(int  i = 1; i <= len; i++)
                // if the value on the i position is not used
                if(usedIndexes[i] == 0)
                {
                    indexes[k] = i;
                    usedIndexes[i] = 1;
                    back(k+1,len, productsList,initialList, algo, processingTimes);
                    usedIndexes[i] = 0;
                }
        }
    }

}
