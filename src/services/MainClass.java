package services;

import entities.*;

import java.util.*;

public class MainClass {

    public static void main(String[] args) {

        ProductionLine prodLine = new ProductionLine();
        List<Product> products = new ArrayList<>();
        Machinery m1, m2, m3, m4;
        m1 = new Machinery();
        m2 = new Machinery();
        m3 = new Machinery();
        m4 = new Machinery();
        Product p1, p2, p3;
        List<Component> componentsLaptop1 = new ArrayList<>();
        List<Component> componentsLaptop2 = new ArrayList<>();
        List<Component> componentsLaptop3 = new ArrayList<>();

        Component motherBoard1, motherBoard2, cpu1, cpu2, ram1, ram2, graphics1, graphics2;

        motherBoard1 = new Component("MotherBoardASUS", Component.Category.MotherBoard, Component.Type.ASUS, 2);
        motherBoard2 = new Component("MotherBoard", Component.Category.MotherBoard, Component.Type.Skylake, 4);
        cpu1 = new Component("Cpu1", Component.Category.CPU, Component.Type.I3, 3);
        cpu2 = new Component("Cpu2", Component.Category.CPU, Component.Type.I5, 1);
        ram1 = new Component("ram1", Component.Category.RAM, Component.Type.DDR2, 5);
        ram2 = new Component("ram2", Component.Category.RAM, Component.Type.DDR3, 7);
        graphics1 = new Component("graphics1", Component.Category.GraphicsCard, Component.Type.NVIDIA, 6);
        graphics2 = new Component("graphics2", Component.Category.GraphicsCard, Component.Type.AMDRadeon, 1);


        //assign Components to machinery
        m1.addComponent(motherBoard1);
        m1.addComponent(motherBoard2);
        m2.addComponent(cpu1);
       // m2.addComponent(cpu2);
        m3.addComponent(ram1);
        m3.addComponent(ram2);
        m4.addComponent(graphics1);
       // m4.addComponent(graphics2);

        //add Machineries to product line
        prodLine.addMachinery(m1);
        prodLine.addMachinery(m2);
        prodLine.addMachinery(m3);
        prodLine.addMachinery(m4);

        //components for laptop 1
        componentsLaptop1.add(motherBoard1);
        componentsLaptop1.add(cpu1);
        componentsLaptop1.add(ram1);
        componentsLaptop1.add(graphics1);


        //components for laptop 2
        componentsLaptop2.add(motherBoard2);
        componentsLaptop2.add(cpu1);
        componentsLaptop2.add(ram2);
        componentsLaptop2.add(graphics1);

        //components for laptop3
        componentsLaptop3.add(motherBoard2);
        componentsLaptop3.add(cpu1);
        componentsLaptop3.add(ram1);
        componentsLaptop3.add(graphics1);

        p1 = new Product("Laptop1", componentsLaptop1);
        p2 = new Product("Laptop2", componentsLaptop2);
        p3 = new Product("Laptop3", componentsLaptop3);

        products.add(p1);
        products.add(p2);
        products.add(p3);
        HashMap<Product, Integer>  ProductsAndStock = new HashMap<>();

        ProductsAndStock.put(products.get(0), 3);
        ProductsAndStock.put(products.get(1), 4);
        ProductsAndStock.put(products.get(2), 5);

        int allStock = 0;
        for (int s : ProductsAndStock.values()) {
            allStock += s;
        }


        SchedulerAlgorithm algo = new SchedulerAlgorithm(products, prodLine);
        SolutionServices solService = new SolutionServices();
        List<Solution> solutions, newRandomSolutions;

        solutions = solService.generateRandomSolutions(ProductsAndStock, 12, products, algo, 10);
        solutions = solService.sortSolutionsByProcessingTime(solutions);

        newRandomSolutions = solService.generateRandomSolutions(ProductsAndStock, allStock,   products, algo, solutions.size() / 2);

        //add new random solutions on the second half of population
        for(int i  = solutions.size() / 2 ;  i <= solutions.size() - 1 ;  i++)
        {
            solutions.set(i, newRandomSolutions.get( i - solutions.size() /2 ));
        }

        //sort the new Population
        solutions = solService.sortSolutionsByProcessingTime(solutions);
        solService.crossOverAll(solutions);
        solService.setStockConstraints(solutions);
    }
}
