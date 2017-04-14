package entities;


import java.util.ArrayList;
import java.util.List;

public class ProductionLine {

    private List<Machinery> machineryList;

    public ProductionLine() {
        this.machineryList = new ArrayList<>();
    }

    public List<Machinery> getMachineryList() {
        return machineryList;
    }

    public void setMachineryList() {
        this.machineryList =  new ArrayList<>();
    }

    public void addMachinery(Machinery m)
    {
        machineryList.add(m);
    }

    public void removeMachinery(Machinery m)
    {
        machineryList.remove(m);
    }

}
