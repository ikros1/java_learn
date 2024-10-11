package java_se.interface_example;

/**
 * 稿费收入税率是20%
 */
public class RoyaltyIncome implements Income {
    public double income = 0.0;
    public RoyaltyIncome(double income) {
        this.income = income;
    }
    public double getTax(){
        return income*0.05;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }
    // TODO

}
