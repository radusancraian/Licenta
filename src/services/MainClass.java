package services;

import entities.Component;
import entities.Machinery;
import entities.Product;
import entities.ProductionLine;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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

        motherBoard1 = new Component("MotherBoardASUS", Component.Category.MotherBoard, Component.Type.ASUS, 3);
        motherBoard2 = new Component("MotherBoard", Component.Category.MotherBoard, Component.Type.Skylake, 3);
        cpu1 = new Component("Cpu1", Component.Category.CPU, Component.Type.I3, 1);
        cpu2 = new Component("Cpu2", Component.Category.CPU, Component.Type.I5, 1);
        ram1 = new Component("ram1", Component.Category.RAM, Component.Type.DDR2, 2);
        ram2 = new Component("ram2", Component.Category.RAM, Component.Type.DDR3, 2);
        graphics1 = new Component("graphics1", Component.Category.GraphicsCard, Component.Type.NVIDIA, 1);
        graphics2 = new Component("graphics2", Component.Category.GraphicsCard, Component.Type.AMDRadeon, 1);


        //assign Components to machinery
        m1.addComponent(motherBoard1);
        m1.addComponent(motherBoard2);
        m2.addComponent(cpu1);
        m2.addComponent(cpu2);
        m3.addComponent(ram1);
        m3.addComponent(ram2);
        m4.addComponent(graphics1);
        m4.addComponent(graphics2);

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
        componentsLaptop2.add(cpu2);
        componentsLaptop2.add(ram2);
        componentsLaptop2.add(graphics2);

        //components for laptop3
        componentsLaptop3.add(motherBoard1);
        componentsLaptop3.add(cpu1);
        componentsLaptop3.add(ram1);
        componentsLaptop3.add(graphics1);

        p1 = new Product("Laptop1", componentsLaptop1);
        p2 = new Product("Laptop2", componentsLaptop2);
        p3 = new Product("Laptop3", componentsLaptop3);

        products.add(p1);
        products.add(p2);
        products.add(p3);

        SchedulerAlgorithm algo = new SchedulerAlgorithm(products, prodLine);
        int[][] inputMatrix, outputMatrix;

        inputMatrix = algo.computeSchedulingInputMatrix();
        outputMatrix = algo.computeSchedulingOutputMatrix(inputMatrix);
         System.out.println("Input time");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println(inputMatrix[i][j] + " ");
            }
            System.out.println();
        }



    }
}
