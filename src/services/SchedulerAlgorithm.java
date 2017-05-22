package services;


import com.sun.org.apache.bcel.internal.generic.LUSHR;
import entities.*;

import java.util.*;

public class SchedulerAlgorithm {

    private ProductionLine prodLine;
    private List<Product> products = new ArrayList<>();
    private int[][] inputMatrix;
    private int[][] outputMatrix;

    public SchedulerAlgorithm(List<Product> products, ProductionLine prodLine) {
        this.products = products;
        this.prodLine = prodLine;
    }

    public int[][] getInputMatrix() {
        return inputMatrix;
    }

    public void setInputMatrix(int[][] inputMatrix) {
        this.inputMatrix = inputMatrix;
    }

    public int[][] getOutputMatrix() {
        return outputMatrix;
    }

    public void setOutputMatrix(int[][] outputMatrix) {
        this.outputMatrix = outputMatrix;
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


    //get input and output processing time
    public void computeSchedulingInputOutputMatrices() {

        inputMatrix = new int[products.size()][prodLine.getMachineryList().size()];
        outputMatrix = new int[products.size()][prodLine.getMachineryList().size()];

        int colDim = prodLine.getMachineryList().size();
        int lineDim = products.size();
        inputMatrix[0][0] = 0;
        Product firstProd = products.get(0);
        List<Machinery> machineries = prodLine.getMachineryList();

        //generate first line for the first product
        for (int i = 1; i <= machineries.size(); i++) {

            //check if the products needs the machinery component
            List<Component> machineryComponents = machineries.get(i - 1).getComponents();

            for (Component comp : machineryComponents) {
                if (AssembledProduct.checkNecessaryComponent(comp, firstProd)) {
                    if (i != machineries.size()) {
                        inputMatrix[0][i] = outputMatrix[0][i - 1] = inputMatrix[0][i - 1] + comp.getAssemblyTime();
                    } else {
                        outputMatrix[0][i - 1] = inputMatrix[0][i - 1] + comp.getAssemblyTime();
                    }
                }
            }

        }

        //generate first col for the first product
        for (int i = 1; i < products.size(); i++) {

            //check if the products needs the machinery component
            List<Component> machineryComponents = machineries.get(0).getComponents();

            for (Component comp : machineryComponents) {
                if (AssembledProduct.checkNecessaryComponent(comp, products.get(i - 1))) {
                    inputMatrix[i][0] = inputMatrix[i - 1][0] + comp.getAssemblyTime();
                }
                if (AssembledProduct.checkNecessaryComponent(comp, products.get(i))) {
                    outputMatrix[i][0] = inputMatrix[i][0] + comp.getAssemblyTime();
                }
            }
        }


        for (int i = 1; i < products.size(); i++)
            for (int j = 1; j < machineries.size(); j++) {

                //check if the products needs the machinery component
                List<Component> MachineryComponents = machineries.get(j - 1).getComponents();
                for (Component comp : MachineryComponents) {
                    if (AssembledProduct.checkNecessaryComponent(comp, products.get(i))) {
                        inputMatrix[i][j] = Math.max(inputMatrix[i][j - 1] + comp.getAssemblyTime()
                                , outputMatrix[i - 1][j]);
                        List<Component> currentMachineryComponents = machineries.get(j).getComponents();
                        for (Component currentComp : currentMachineryComponents) {
                            if (AssembledProduct.checkNecessaryComponent(currentComp, products.get(i))) {
                                outputMatrix[i][j] = inputMatrix[i][j] + currentComp.getAssemblyTime();
                            }
                        }
                    }
                }

            }
    }
}
