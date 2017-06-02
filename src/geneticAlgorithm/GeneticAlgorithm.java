package geneticAlgorithm;


import entities.Solution;

import java.util.List;

public class GeneticAlgorithm {

    private List<Solution> population;

    private CrossOver crossOverOperator;

    private Mutation mutationOperator;

    private Selection selectionOperator;

    public Selection getSelectionOperator() {
        return selectionOperator;
    }

    public void setSelectionOperator(Selection selectionOperator) {
        this.selectionOperator = selectionOperator;
    }

    public CrossOver getCrossOverOperator() {
        return crossOverOperator;
    }

    public void setCrossOverOperator(CrossOver crossOverOperator) {
        this.crossOverOperator = crossOverOperator;
    }


    public Mutation getMutationOperator() {
        return mutationOperator;
    }

    public void setMutationOperator(Mutation mutationOperator) {
        this.mutationOperator = mutationOperator;
    }

    public GeneticAlgorithm (List<Solution> population)
    {
        this.population = population;
    }

    public List<Solution> getPopulation() {
        return population;
    }

    public void setPopulation(List<Solution> population) {
        this.population = population;
    }
}
