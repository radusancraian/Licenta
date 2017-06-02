package geneticAlgorithm;

import entities.Solution;

import java.util.Collections;
import java.util.List;


public class Selection {

    public void selectionFunctionality(List<Solution> actualSolutions, List<Solution> newSolutions) {

        //sort the current population
        Collections.sort(actualSolutions);

        //add new random solutions on the second half of population
        for (int i = actualSolutions.size() / 2; i <= actualSolutions.size() - 1; i++) {
            actualSolutions.set(i, newSolutions.get(i - actualSolutions.size() / 2));
        }

        //sort the current population
        Collections.sort(actualSolutions);
    }

}