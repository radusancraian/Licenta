package entities;


import java.util.List;

public class Product {

    private String name;
    private List<Component> components;

    public Product(String name, List<Component> components) {
        this.name = name;
        this.components = components;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }

    public void addComponent(Component c)
    {
        this.components.add(c);
    }

    public void removeComponent(Component c)
    {
        this.components.remove(c);
    }
}
