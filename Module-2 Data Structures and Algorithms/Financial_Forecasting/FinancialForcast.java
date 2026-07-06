package Financial_Forecasting;

public class FinancialForcast {
    public static double forecastRevenue(double currentRevenue, double growthRate, int years) {
        if(years == 0) {
            return currentRevenue;
        }


        // Recursive case: calculate the revenue for the next year and add it to the current revenue
        return growthRate * forecastRevenue(currentRevenue, growthRate, years - 1) + currentRevenue;
    }

    public static void main(String[] args) {
        Company company = new Company(1000, 0.1, 3);
        double forecastedRevenue = forecastRevenue(company.currentRevenue, company.growthRate, company.years);
        System.out.println("Forecasted Revenue after " + company.years + " years: " + forecastedRevenue);
    }
}
