package services;

import entities.*;
import entities.Component;
import geneticAlgorithm.*;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

import javax.swing.*;


public class MainUI {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {


        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainUI window = new MainUI();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


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
        motherBoard2 = new Component("MotherBoardSkyLake", Component.Category.MotherBoard, Component.Type.Skylake, 34);
        motherBoard3 = new Component("MotherBoardMSI", Component.Category.MotherBoard, Component.Type.MSI, 21);

        cpu1 = new Component("Cpu1", Component.Category.CPU, Component.Type.I3, 11);
        cpu2 = new Component("Cpu2", Component.Category.CPU, Component.Type.I5, 18);
        cpu3 = new Component("Cpu3", Component.Category.CPU, Component.Type.I7, 28);

        ram1 = new Component("ram1", Component.Category.RAM, Component.Type.DDR2, 35);
        ram2 = new Component("ram2", Component.Category.RAM, Component.Type.DDR3, 25);
        ram3 = new Component("ram3", Component.Category.RAM, Component.Type.DDR4, 39);

        graphics1 = new Component("graphics1", Component.Category.GraphicsCard, Component.Type.NVIDIA, 12);
        graphics2 = new Component("graphics2", Component.Category.GraphicsCard, Component.Type.AMDRadeon, 6);
        graphics3 = new Component("graphics3", Component.Category.GraphicsCard, Component.Type.ASUSGTX, 8);

        hardDiks1 = new Component("hardDisk1TB", Component.Category.HardDisk, Component.Type.HDD1TB, 11);
        hardDisk2 = new Component("hardDisk512GB", Component.Category.HardDisk, Component.Type.HDD512GB, 32);
        hardDisk3 = new Component("hardDisk512GB", Component.Category.HardDisk, Component.Type.HDD2TB, 23);

        keyboard1 = new Component("keyboard1", Component.Category.Keyboard, Component.Type.ASUSK52, 12);
        keyboard2 = new Component("keyboard2", Component.Category.Keyboard, Component.Type.ACER5250, 7);
        keyboard3 = new Component("keyboard3", Component.Category.Keyboard, Component.Type.Compaq, 32);

        housing1 = new Component("Housing1", Component.Category.Housing, Component.Type.Housing1, 12);
        housing2 = new Component("Housing2", Component.Category.Housing, Component.Type.Housing2, 23);
        housing3 = new Component("Housing3", Component.Category.Housing, Component.Type.Housing3, 31);

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
        p4 = new Product("Laptop4", componentsLaptop4);

        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);

        HashMap<Product, Integer> ProductsAndStock = new HashMap<>();

        ProductsAndStock.put(products.get(0), 300);
        ProductsAndStock.put(products.get(1), 421);
        ProductsAndStock.put(products.get(2), 32);
        ProductsAndStock.put(products.get(3), 199);

        List<Solution> solutions, newRandomSolutions;

        SchedulerAlgorithm algo = new SchedulerAlgorithm(products, prodLine);
        SolutionServices solService = new SolutionServices();

        RandomSolutionsGenerator rndSols = new RandomSolutionsGenerator();

        rndSols.setProcessingAlgorithm(algo);
        rndSols.setProductsWithStock(ProductsAndStock);
        int n = 80;
        solutions = rndSols.generateRandomSolutions(n);

        GeneticAlgorithm gnAlgo = new GeneticAlgorithm(solutions);
        gnAlgo.setSelectionOperator(new Selection());
        gnAlgo.setCrossOverOperator(new CrossOver());
        gnAlgo.setMutationOperator(new Mutation());


        for (int i = 1; i <= 3000; i++) {

            //evaluate solutions ( sort by stock constraints and processing time )
            Collections.sort(solutions);

            System.out.println("Iteratia " + i + " timp procesare: " +
                    solutions.get(0).getFitnessValue().getProcessingTime() + " constrangeri: " +
                    solutions.get(0).getFitnessValue().getStockConstraints().getNrProductsNotRespectStock());

            gnAlgo.getSelectionOperator().selectionFunctionality(solutions);

            gnAlgo.getCrossOverOperator().crossOverAll(solutions);

            solService.computeAllStockConstraints(solutions);

            gnAlgo.getMutationOperator().mutationFunctionality(solutions);

            solService.computeAllProcessingTime(solutions, algo);
            solService.computeAllStockConstraints(solutions);
            Collections.sort(solutions);

            newRandomSolutions = rndSols.generateRandomSolutions(n / 4 );
            solService.addNewPopulation(solutions, newRandomSolutions);

        }



    }

    /**
     * Create the application.
     */
    public MainUI() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(36, 21, 81, 68);
        frame.getContentPane().add(panel);
    }
}
