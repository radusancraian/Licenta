package entities;


import java.util.List;

public class AssembledProduct extends Product {


    public AssembledProduct(String name, List<Component> components) {
        super(name, components);
    }

    public static boolean checkNecessaryComponent(Component c, Product p) {
        List<Component> finalProductComponents = p.getComponents();

        for (Component comp : finalProductComponents) {
            if (comp.getCategory().compareTo(c.getCategory()) == 0 && comp.getType().compareTo(c.getType()) == 0)
                return true;
        }
        return false;
    }
}
