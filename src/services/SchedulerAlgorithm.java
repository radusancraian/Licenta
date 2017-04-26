package services;


import entities.*;

import java.util.ArrayList;
import java.util.List;

public class SchedulerAlgorithm {

    private ProductionLine prodLine;
    private List<Product> products = new ArrayList<>();

    public SchedulerAlgorithm(List<Product> products, ProductionLine prodLine) {
        this.products = products;
        this.prodLine = prodLine;
    }

    public ProductionLine getProdLine() {
        return prodLine;
    }

    public void setProdLine(ProductionLine prodLine) {
        this.prodLine = prodLine;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int[][] computeSchedulingInputMatrix() {
        List<Machinery> machineries = prodLine.getMachineryList();

        int colDim = prodLine.getMachineryList().size();
        int lineDim = products.size();

        int[][] inputTimeMatrix = new int[lineDim][colDim];

        int col = 0;
        inputTimeMatrix[0][0] = 0;
        Product firstProd = products.get(0);

        //generate first line for the first product
        for (int i = 1; i < machineries.size(); i++) {

            //check if the products needs the machinery component
            List<Component> machineryComponents = machineries.get(i - 1).getComponents();

            for (Component comp : machineryComponents) {
                if (AssembledProduct.checkNecessaryComponent(comp, firstProd)) {
                    inputTimeMatrix[0][i] = inputTimeMatrix[0][i - 1] + comp.getAssemblyTime();
                }
            }

        }

        //generate first col for the first product
        for (int i = 1; i < products.size(); i++) {

            inputTimeMatrix[i][0] = inputTimeMatrix[i - 1][0] + products.get(i - 1).getComponents().get(0).getAssemblyTime();
        }

        for (int i = 1; i < products.size(); i++)
            for (int j = 1; j < machineries.size(); j++) {

                //check if the products needs the machinery component
                List<Component> MachineryComponents = machineries.get(j - 1).getComponents();
                for (Component comp : MachineryComponents) {
                    if (AssembledProduct.checkNecessaryComponent(comp, products.get(i))) {
                        if (j + 1 < colDim)
                            inputTimeMatrix[i][j] = Math.max(inputTimeMatrix[i][j - 1] + comp.getAssemblyTime()
                                    , inputTimeMatrix[i - 1][j + 1]);
                            //last column
                        else {
                            List<Component> LastMachineryComponents = machineries.get(j).getComponents();
                            for (Component compLast : LastMachineryComponents) {
                                if (AssembledProduct.checkNecessaryComponent(compLast, products.get(i - 1))) {
                                    inputTimeMatrix[i][j] = Math.max(inputTimeMatrix[i][j - 1] + comp.getAssemblyTime()
                                            , inputTimeMatrix[i][j - 1] + compLast.getAssemblyTime());
                                }
                            }
                        }
                    }
                }

    }

        return inputTimeMatrix;
}


    public int[][] computeSchedulingOutputMatrix(int[][] inputTimeMatrix) {

        List<Machinery> machineries = prodLine.getMachineryList();

        int colDim = prodLine.getMachineryList().size();
        int lineDim = products.size();

        int[][] outputTimeMatrix = new int[lineDim][colDim];

        for (int i = 0; i < products.size(); i++)
            for (int j = 0; j < machineries.size(); j++) {

                //check if the products needs the machinery component
                List<Component> MachineryComponents = machineries.get(j).getComponents();

                for (Component comp : MachineryComponents) {
                    if (AssembledProduct.checkNecessaryComponent(comp, products.get(i))) {
                        outputTimeMatrix[i][j] = inputTimeMatrix[i][j] + comp.getAssemblyTime();
                    }
                }

            }
        return outputTimeMatrix;
    }
}
