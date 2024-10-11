package java_se.interface_example;

public class SalaryIncome implements Income{
    public double income = 0.0;
	// TODO
    public SalaryIncome(double income) {
        this.income = income;
    }
    public double getTax(){
        if (income<=5000){
            return 0;
        }else {
            return (income-5000) * 0.5;
        }

    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }
}
