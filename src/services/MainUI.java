package services;

import entities.*;
import entities.Component;
import geneticAlgorithm.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.List;

import javax.swing.*;


public class MainUI {

    private JFrame frame;
    private JTextField laptop1Txt;
    private JTextField laptop2Txt;
    private JTextField laptop3Txt;
    private JTextField laptop4Txt;
    private static int[] processingTimes = new int[40320];
    private static Solution bestSolution;
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
        frame.setBounds(100, 100, 842, 678);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);


        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setBounds(89, 44, 644, 284);
        frame.getContentPane().add(panel);
        panel.setLayout(new BorderLayout(0, 0));

        JLabel lblLaptop = new JLabel("Laptop 1");
        lblLaptop.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblLaptop.setBounds(25, 375, 75, 14);
        frame.getContentPane().add(lblLaptop);

        JLabel laptop1Label1 = new JLabel("ASUS, I3, RAM 4GB");
        laptop1Label1.setBounds(25, 400, 143, 25);
        frame.getContentPane().add(laptop1Label1);

        JLabel laptop1Label2 = new JLabel("ASUS GTX 1GB, 1TB HDD");
        laptop1Label2.setBounds(25, 411, 153, 28);
        frame.getContentPane().add(laptop1Label2);

        JLabel laptop1Label3 = new JLabel("tastatura ASUS K52");
        laptop1Label3.setBounds(25, 436, 127, 14);
        frame.getContentPane().add(laptop1Label3);

        laptop1Txt = new JTextField();
        laptop1Txt.setBounds(25, 467, 86, 20);
        frame.getContentPane().add(laptop1Txt);
        laptop1Txt.setColumns(10);

        laptop2Txt = new JTextField();
        laptop2Txt.setColumns(10);
        laptop2Txt.setBounds(221, 467, 86, 20);
        frame.getContentPane().add(laptop2Txt);

        JLabel lblLaptop_1 = new JLabel("Laptop 2");
        lblLaptop_1.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblLaptop_1.setBounds(221, 375, 75, 14);
        frame.getContentPane().add(lblLaptop_1);

        JLabel laptop2Label1 = new JLabel("Skylake, I5, RAM 2GB");
        laptop2Label1.setBounds(221, 400, 143, 25);
        frame.getContentPane().add(laptop2Label1);

        JLabel laptop2Label2 = new JLabel("NVIDIA 740M 1GB, 2TB HDD");
        laptop2Label2.setBounds(221, 411, 153, 28);
        frame.getContentPane().add(laptop2Label2);

        JLabel laptop2Label3 = new JLabel("tastatura Compaq");
        laptop2Label3.setBounds(221, 436, 109, 14);
        frame.getContentPane().add(laptop2Label3);

        JLabel lblLaptop_2 = new JLabel("Laptop 3");
        lblLaptop_2.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblLaptop_2.setBounds(414, 375, 75, 14);
        frame.getContentPane().add(lblLaptop_2);

        JLabel laptop3Label1 = new JLabel("Skylake, I7, RAM 8GB");
        laptop3Label1.setBounds(414, 400, 143, 25);
        frame.getContentPane().add(laptop3Label1);

        JLabel laptop3Label2 = new JLabel("NVIDIA 740M 1GB, 512GB HDD");
        laptop3Label2.setBounds(414, 411, 173, 28);
        frame.getContentPane().add(laptop3Label2);

        JLabel laptop3Label3 = new JLabel("tastatura ACER 250");
        laptop3Label3.setBounds(414, 436, 127, 14);
        frame.getContentPane().add(laptop3Label3);

        laptop3Txt = new JTextField();
        laptop3Txt.setColumns(10);
        laptop3Txt.setBounds(414, 467, 86, 20);
        frame.getContentPane().add(laptop3Txt);

        JLabel lblLaptop_3 = new JLabel("Laptop 4");
        lblLaptop_3.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblLaptop_3.setBounds(611, 375, 75, 14);
        frame.getContentPane().add(lblLaptop_3);

        JLabel laptop4Label1 = new JLabel("MSI, AMDRyzen1800X, RAM 4GB");
        laptop4Label1.setBounds(611, 400, 184, 25);
        frame.getContentPane().add(laptop4Label1);

        JLabel laptop4Label2 = new JLabel("NVIDIA 740M 1GB, 1TB HDD");
        laptop4Label2.setBounds(611, 411, 153, 28);
        frame.getContentPane().add(laptop4Label2);

        JLabel laptop4Label3 = new JLabel("tastatura Compaq");
        laptop4Label3.setBounds(611, 436, 109, 14);
        frame.getContentPane().add(laptop4Label3);

        laptop4Txt = new JTextField();
        laptop4Txt.setColumns(10);
        laptop4Txt.setBounds(611, 467, 86, 20);
        frame.getContentPane().add(laptop4Txt);


        JButton btnNewButton = new JButton("Asambleaza numarul de laptop-uri selectat");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                boolean validData = true;
                int nrLaptop1 = 0, nrLaptop2 = 0, nrLaptop3 = 0, nrLaptop4 = 0;
                try {

                    nrLaptop1 = Integer.parseInt(laptop1Txt.getText());
                    nrLaptop2 = Integer.parseInt(laptop2Txt.getText());
                    nrLaptop3 = Integer.parseInt(laptop3Txt.getText());
                    nrLaptop4 = Integer.parseInt(laptop4Txt.getText());

                } catch (NumberFormatException e) {
                    validData = false;
                    JOptionPane.showMessageDialog(frame, "Datele introduse nu sunt valide", "Atentionare",
                            JOptionPane.WARNING_MESSAGE);

                }

                if (validData) {
                    XYSeries series = new XYSeries("Processing times");
                    int[] result = computeAlgorithm(nrLaptop1, nrLaptop2, nrLaptop3, nrLaptop4);


      /*              Arrays.sort(processingTimes);

                    for (int i = 0; i < processingTimes.length; i++) {
                        System.out.println(i + " " + processingTimes[i]);
                    }*/


                    for (int i = 0; i < 50; i++) {
                        series.add(i, result[i]);
                    }


                    XYSeriesCollection data = new XYSeriesCollection(series);

                    JFreeChart chart = ChartFactory.createXYLineChart("Planificare productie", "iteratia", "timpul",
                            data, PlotOrientation.VERTICAL, true, true, false);

                    ChartPanel chartPanel = new ChartPanel(chart);

                    panel.removeAll();
                    panel.add(chartPanel, BorderLayout.CENTER);
                    panel.validate();


                }
            }
        });
        btnNewButton.setBounds(161, 552, 326, 36);
        frame.getContentPane().add(btnNewButton);

        JButton btnAfiseazaSecventa = new JButton("Afiseaza secventa optima");
        btnAfiseazaSecventa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                try{
                    PrintWriter writer = new PrintWriter("secventa-optima.txt", "UTF-8");
                    writer.println("Secventa de produse este:");
                    for(Product p : bestSolution.getProducts()) {
                        writer.println(p.getName() + " ");
                    }
                    writer.println("Timpul total de asamblare este : " + bestSolution.getFitnessValue().getProcessingTime());
                    writer.close();
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(frame, "Eroare la scrierea secventei in fisier", "Eroare",
                            JOptionPane.ERROR_MESSAGE);
                }

                ProcessBuilder pb = new ProcessBuilder("Notepad.exe", "secventa-optima.txt");
                try {
                    pb.start();
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(frame, "Eroare la deschiderea fisierului", "Eroare",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnAfiseazaSecventa.setBounds(583, 552, 192, 36);
        frame.getContentPane().add(btnAfiseazaSecventa);


    }


    public static int[] computeAlgorithm(int nrLaptop1, int nrLaptop2, int nrLaptop3, int nrLaptop4)
    {

        int[] result = new int[1000];

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

        Product p1, p2, p3, p4, p5, p6, p7, p8;
        List<Component> componentsLaptop1 = new ArrayList<>();
        List<Component> componentsLaptop2 = new ArrayList<>();
        List<Component> componentsLaptop3 = new ArrayList<>();
        List<Component> componentsLaptop4 = new ArrayList<>();

        Component motherBoard1, motherBoard2, motherBoard3, cpu1, cpu2, cpu3, cpu4, ram1, ram2, ram3, graphics1, graphics2,
                graphics3, hardDiks1, hardDisk2, hardDisk3, keyboard1, keyboard2, keyboard3, housing1, housing2,
                housing3;

        motherBoard1 = new Component("MotherBoardASUS", Component.Category.MotherBoard, Component.Type.ASUS, 12);
        motherBoard2 = new Component("MotherBoardSkyLake", Component.Category.MotherBoard, Component.Type.Skylake, 34);
        motherBoard3 = new Component("MotherBoardMSI", Component.Category.MotherBoard, Component.Type.MSI, 21);

        cpu1 = new Component("Cpu1", Component.Category.CPU, Component.Type.I3, 11);
        cpu2 = new Component("Cpu2", Component.Category.CPU, Component.Type.I5, 18);
        cpu3 = new Component("Cpu3", Component.Category.CPU, Component.Type.I7, 28);
        cpu4 = new Component("Cpu4", Component.Category.CPU, Component.Type.AMDRyzen1800X, 11);


        ram1 = new Component("ram1", Component.Category.RAM, Component.Type.GB4, 35);
        ram2 = new Component("ram2", Component.Category.RAM, Component.Type.GB2, 25);
        ram3 = new Component("ram3", Component.Category.RAM, Component.Type.GB8, 39);

        graphics1 = new Component("graphics1", Component.Category.GraphicsCard, Component.Type.NVIDIA, 12);
        graphics2 = new Component("graphics2", Component.Category.GraphicsCard, Component.Type.AMDRadeon, 6);
        graphics3 = new Component("graphics3", Component.Category.GraphicsCard, Component.Type.ASUSGTX, 8);

        hardDiks1 = new Component("hardDisk1TB", Component.Category.HardDisk, Component.Type.HDD1TB, 11);
        hardDisk2 = new Component("hardDisk512GB", Component.Category.HardDisk, Component.Type.HDD512GB, 32);
        hardDisk3 = new Component("hardDisk512GB", Component.Category.HardDisk, Component.Type.HDD2TB, 23);

        keyboard1 = new Component("keyboard1", Component.Category.Keyboard, Component.Type. ACER5250, 12);
        keyboard2 = new Component("keyboard2", Component.Category.Keyboard, Component.Type.ASUSK52, 7);
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
        componentsLaptop1.add(graphics3);
        componentsLaptop1.add(hardDiks1);
        componentsLaptop1.add(keyboard2);
        componentsLaptop1.add(housing1);


        //components for laptop 2
        componentsLaptop2.add(motherBoard2);
        componentsLaptop2.add(cpu2);
        componentsLaptop2.add(ram2);
        componentsLaptop2.add(graphics1);
        componentsLaptop2.add(keyboard3);
        componentsLaptop2.add(hardDisk3);
        componentsLaptop2.add(housing3);

        //components for laptop3
        componentsLaptop3.add(motherBoard2);
        componentsLaptop3.add(cpu3);
        componentsLaptop3.add(ram3);
        componentsLaptop3.add(graphics1);
        componentsLaptop3.add(keyboard1);
        componentsLaptop3.add(hardDisk2);
        componentsLaptop3.add(housing2);

        //components for laptop4
        componentsLaptop4.add(motherBoard3);
        componentsLaptop4.add(cpu4);
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

        ProductsAndStock.put(products.get(0), nrLaptop1);
        ProductsAndStock.put(products.get(1), nrLaptop2);
        ProductsAndStock.put(products.get(2), nrLaptop3);
        ProductsAndStock.put(products.get(3), nrLaptop4);

        List<Solution> solutions, newRandomSolutions;

        SchedulerAlgorithm algo = new SchedulerAlgorithm(products, prodLine);
        SolutionServices solService = new SolutionServices();

        RandomSolutionsGenerator rndSols = new RandomSolutionsGenerator();

        rndSols.setProcessingAlgorithm(algo);
        rndSols.setProductsWithStock(ProductsAndStock);
        int n = 100;
        solutions = rndSols.generateRandomSolutions(n);

        GeneticAlgorithm gnAlgo = new GeneticAlgorithm(solutions);
        gnAlgo.setSelectionOperator(new Selection());
        gnAlgo.setCrossOverOperator(new CrossOver());
        gnAlgo.setMutationOperator(new Mutation());


        List<Product> productsList = new ArrayList<>(8);

        p5 = new Product("Laptop11", componentsLaptop1);
        p6 = new Product("Laptop22", componentsLaptop2);
        p7 = new Product("Laptop32", componentsLaptop3);
        p8 = new Product("Laptop42", componentsLaptop4);

        productsList.add(products.get(0));
        productsList.add(p5);
        productsList.add(products.get(1));
        productsList.add(p6);
        productsList.add(products.get(2));
        productsList.add(p7);
        productsList.add(products.get(3));
        productsList.add(p8);
       List<Product> initialList = new ArrayList<>(productsList);
      //  PermutationSchedule.back(1,8, productsList, initialList, algo, processingTimes);




        for (int i = 1; i <= 50; i++) {

            //evaluate solutions ( sort by stock constraints and processing time )
            Collections.sort(solutions);
            result[i - 1] = solutions.get(0).getFitnessValue().getProcessingTime();
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

            newRandomSolutions = rndSols.generateRandomSolutions(n / 4);
            solService.addNewPopulation(solutions, newRandomSolutions);

        }
        bestSolution = solutions.get(0);
        return result;
    }
}
