package services;


public class Fitness  {

    private int processingTime;

    public int getProcessingTime() {
        return processingTime;
    }

    public void setProcessingTime(int processingTime) {
        this.processingTime = processingTime;
    }

    private StockConstraints stockConstraints;


    public StockConstraints getStockConstraints() {
        return stockConstraints;
    }

    public void setStockConstraints(StockConstraints stockConstraints) {
        this.stockConstraints = stockConstraints;
    }
}
