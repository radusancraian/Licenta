package entities;


import java.util.ArrayList;
import java.util.List;

public class Machinery {

    private List<Component> components;

    public Machinery() {

        this.components = new ArrayList<>();
    }

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }

    public void addComponent(Component comp)
    {
        components.add(comp);
    }

    public void removeComponent(Component comp)
    {
        components.remove(comp);
    }

    public void addComponentToProduct(Component c, Product p)
    {
        p.addComponent(c);
    }
}
