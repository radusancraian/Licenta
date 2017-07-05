package entities;


import java.util.List;

public class AssembledProduct {

    public static boolean checkNecessaryComponent(Component c, Product p) {
        List<Component> finalProductComponents = p.getComponents();

        for (Component comp : finalProductComponents) {
            if (comp.getCategory().compareTo(c.getCategory()) == 0 && comp.getType().compareTo(c.getType()) == 0)
                return true;
        }
        return false;
    }
}
