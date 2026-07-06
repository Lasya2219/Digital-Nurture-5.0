package Financial_Forecasting;

public class Company {
    int currentRevenue;
    double growthRate;
    int years;

    Company(int currentRevenue, double growthRate, int years) {
        this.currentRevenue = currentRevenue;
        this.growthRate = growthRate;
        this.years = years;
    }
}
