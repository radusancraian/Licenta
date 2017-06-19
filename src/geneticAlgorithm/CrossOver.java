package geneticAlgorithm;


import entities.Product;
import entities.Solution;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CrossOver {

    //crossOver functionality
    public void crossOver(Solution s1, Solution s2) {

        Random rn = new Random();
        int r = Math.abs(rn.nextInt() % s1.getProducts().size());

        for (int i = r; i < s1.getProducts().size(); i++) {
            Product p = new Product(s1.getProducts().get(i).getName(), s1.getProducts().get(i).getComponents());
            s1.getProducts().set(i, s2.getProducts().get(i));
            s2.getProducts().set(i, p);
        }

    }

    //crossOver all Solutions
    public void crossOverAll(List<Solution> solutions) {

        for (int i = 0; i < solutions.size() / 2 - 1; i += 2) {
            crossOver(solutions.get(i), solutions.get(i + 1));
        }

    }

}
