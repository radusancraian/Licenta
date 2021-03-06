package entities;


public  class Component {

    private String name;
    private int assemblyTime;
    private Type type;
    private Category category;
    public enum Category {CPU, RAM, MotherBoard, GraphicsCard, HardDisk, Keyboard, Housing};
    public enum Type { I3, I5, I7, AMDRyzen1800X, GB4 , GB2,  GB8,  ASUS, Skylake, NVIDIA , AMDRadeon, MSI, HDD1TB, HDD512GB,
    ASUSK52, ACER5250, ASUSGTX, HDD2TB, Compaq, Housing1, Housing2, Housing3};

    public Component(String name, Category category, Type type, int assemblyTime  )
    {
        this.name = name;
        this.assemblyTime = assemblyTime;
        this.category = category;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAssemblyTime() {
        return assemblyTime;
    }

    public void setAssemblyTime(int assemblyTime) {
        this.assemblyTime = assemblyTime;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
