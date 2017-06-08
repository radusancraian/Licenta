package services;

import entities.*;
import entities.Component;
import geneticAlgorithm.*;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class MainClass extends JFrame {


    public static void main(String[] args) {

       // new MainClass();

        ProductionLine prodLine = new ProductionLine();
        List<Product> products = new ArrayList<>();
        Machinery m1, m2, m3, m4, m5, m6, m7;
        m1 = new Machinery();
        m2 = new Machinery();
        m3 = new Machinery();
        m4 = new Machinery();
        m5 = new Machinery();
        m6 = new Machinery();
        m7 = new Machinery();

        Product p1, p2, p3, p4;
        List<Component> componentsLaptop1 = new ArrayList<>();
        List<Component> componentsLaptop2 = new ArrayList<>();
        List<Component> componentsLaptop3 = new ArrayList<>();
        List<Component> componentsLaptop4 = new ArrayList<>();

        Component motherBoard1, motherBoard2, motherBoard3, cpu1, cpu2, cpu3, ram1, ram2, ram3, graphics1, graphics2,
                 graphics3, hardDiks1, hardDisk2, hardDisk3, keyboard1, keyboard2, keyboard3, housing1, housing2,
                 housing3;

        motherBoard1 = new Component("MotherBoardASUS", Component.Category.MotherBoard, Component.Type.ASUS, 12);
        motherBoard2 = new Component("MotherBoardSkyLake", Component.Category.MotherBoard, Component.Type.Skylake, 7);
        motherBoard3 = new Component("MotherBoardMSI", Component.Category.MotherBoard, Component.Type.MSI, 9);

        cpu1 = new Component("Cpu1", Component.Category.CPU, Component.Type.I3, 4);
        cpu2 = new Component("Cpu2", Component.Category.CPU, Component.Type.I5, 8);
        cpu3 = new Component("Cpu3", Component.Category.CPU, Component.Type.I7, 7);

        ram1 = new Component("ram1", Component.Category.RAM, Component.Type.DDR2, 5);
        ram2 = new Component("ram2", Component.Category.RAM, Component.Type.DDR3, 7);
        ram3 = new Component("ram3", Component.Category.RAM, Component.Type.DDR4, 8);

        graphics1 = new Component("graphics1", Component.Category.GraphicsCard, Component.Type.NVIDIA, 6);
        graphics2 = new Component("graphics2", Component.Category.GraphicsCard, Component.Type.AMDRadeon, 3);
        graphics3 = new Component("graphics3", Component.Category.GraphicsCard, Component.Type.ASUSGTX, 5);

        hardDiks1 = new Component("hardDisk1TB", Component.Category.HardDisk, Component.Type.HDD1TB, 7);
        hardDisk2 = new Component("hardDisk512GB", Component.Category.HardDisk, Component.Type.HDD512GB, 5);
        hardDisk3 = new Component("hardDisk512GB", Component.Category.HardDisk, Component.Type.HDD2TB, 10);

        keyboard1 = new Component("keyboard1", Component.Category.Keyboard, Component.Type.ASUSK52, 3);
        keyboard2 = new Component("keyboard2", Component.Category.Keyboard, Component.Type.ACER5250, 4);
        keyboard3 = new Component("keyboard3", Component.Category.Keyboard, Component.Type.Compaq, 5);

        housing1 = new Component("Housing1", Component.Category.Housing, Component.Type.Housing1, 12);
        housing2 = new Component("Housing2", Component.Category.Housing, Component.Type.Housing2, 11);
        housing3 = new Component("Housing3", Component.Category.Housing, Component.Type.Housing3, 15);

        //assign Components to machinery
        m1.addComponent(motherBoard1);
        m1.addComponent(motherBoard2);
        m1.addComponent(motherBoard3);

        m2.addComponent(cpu1);
        m2.addComponent(cpu2);
        m2.addComponent(cpu3);

        m3.addComponent(ram1);
        m3.addComponent(ram2);
        m3.addComponent(ram3);

        m4.addComponent(graphics1);
        m4.addComponent(graphics2);
        m4.addComponent(graphics3);

        m5.addComponent(hardDiks1);
        m5.addComponent(hardDisk2);
        m5.addComponent(hardDisk3);

        m6.addComponent(keyboard1);
        m6.addComponent(keyboard2);
        m6.addComponent(keyboard3);

        m7.addComponent(housing1);
        m7.addComponent(housing2);
        m7.addComponent(housing3);

        //add Machineries to product line
        prodLine.addMachinery(m1);
        prodLine.addMachinery(m2);
        prodLine.addMachinery(m3);
        prodLine.addMachinery(m4);
        prodLine.addMachinery(m5);
        prodLine.addMachinery(m6);
        prodLine.addMachinery(m7);

        //components for laptop 1
        componentsLaptop1.add(motherBoard1);
        componentsLaptop1.add(cpu1);
        componentsLaptop1.add(ram1);
        componentsLaptop1.add(graphics1);
        componentsLaptop1.add(hardDiks1);
        componentsLaptop1.add(keyboard2);
        componentsLaptop1.add(housing1);


        //components for laptop 2
        componentsLaptop2.add(motherBoard2);
        componentsLaptop2.add(cpu1);
        componentsLaptop2.add(ram2);
        componentsLaptop2.add(graphics1);
        componentsLaptop2.add(keyboard3);
        componentsLaptop2.add(hardDisk3);
        componentsLaptop2.add(housing3);

        //components for laptop3
        componentsLaptop3.add(motherBoard2);
        componentsLaptop3.add(cpu1);
        componentsLaptop3.add(ram1);
        componentsLaptop3.add(graphics1);
        componentsLaptop3.add(keyboard1);
        componentsLaptop3.add(hardDisk2);
        componentsLaptop3.add(housing2);

        //components for laptop4
        componentsLaptop4.add(motherBoard1);
        componentsLaptop4.add(cpu1);
        componentsLaptop4.add(ram1);
        componentsLaptop4.add(graphics2);
        componentsLaptop4.add(keyboard3);
        componentsLaptop4.add(hardDiks1);
        componentsLaptop4.add(housing1);


        p1 = new Product("Laptop1", componentsLaptop1);
        p2 = new Product("Laptop2", componentsLaptop2);
        p3 = new Product("Laptop3", componentsLaptop3);
        p4 = new Product("Laptop4",componentsLaptop4 );

        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);

        HashMap<Product, Integer> ProductsAndStock = new HashMap<>();

        ProductsAndStock.put(products.get(0), 30);
        ProductsAndStock.put(products.get(1), 40);
        ProductsAndStock.put(products.get(2), 50);
        ProductsAndStock.put(products.get(3), 20);

        List<Solution> solutions, newRandomSolutions;

        SchedulerAlgorithm algo = new SchedulerAlgorithm(products, prodLine);
        SolutionServices solService = new SolutionServices();

        RandomSolutionsGenerator rndSols = new RandomSolutionsGenerator();

        rndSols.setProcessingAlgorithm(algo);
        rndSols.setProductsWithStock(ProductsAndStock);
        solutions = rndSols.generateRandomSolutions(100);

        GeneticAlgorithm gnAlgo = new GeneticAlgorithm(solutions);
        gnAlgo.setSelectionOperator(new Selection());
        gnAlgo.setCrossOverOperator(new CrossOver());
        gnAlgo.setMutationOperator(new Mutation());


        for( int i = 1; i <= 200; i++) {
            newRandomSolutions = rndSols.generateRandomSolutions( solutions.size() / 2);
            gnAlgo.getSelectionOperator().selectionFunctionality(solutions, newRandomSolutions);
            gnAlgo.getCrossOverOperator().crossOverAll(solutions);
            solService.computeAllStockConstraints(solutions);
            gnAlgo.getMutationOperator().mutationFunctionality(solutions, algo);
            solService.computeAllStockConstraints(solutions);
            solService.computeAllProcessingTime(solutions, algo);


            for( Solution s : solutions)
            {
                System.out.println( s.getFitnessValue().getStockConstraints().getNrProductsNotRespectStock());
            }



            System.out.println("Iteratia " + i + " timp procesare: " +
                    solutions.get(0).getFitnessValue().getProcessingTime() + " constrangeri: " +
                    solutions.get(0).getFitnessValue().getStockConstraints().getNrProductsNotRespectStock());

        }

        System.out.println("Iteratia   timp procesare: " +
                solutions.get(0).getFitnessValue().getProcessingTime() + " constrangeri: " +
                solutions.get(0).getFitnessValue().getStockConstraints().getNrProductsNotRespectStock());


    }


    public MainClass()
    {

        this.setSize(400, 400);

        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();

        int xPos = (dim.width / 2) - (this.getWidth() / 2);
        int yPos = (dim.height / 2) - (this.getHeight() /2);

        this.setLocation(xPos, yPos);
        this.setResizable(false);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.setTitle("Planificare in productie");

        JPanel thePanel = new JPanel();
        JTextField t1 = new JTextField();

        t1.setBounds(20, 250, 50, 20);
        this.add(t1);


        this.add(thePanel);

        this.setVisible(true);
    }


}
