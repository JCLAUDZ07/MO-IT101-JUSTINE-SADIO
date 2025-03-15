package com.mycompany.motorph;

class Employee {
    String employeeID, lastName, firstName, birthday, address, phoneNumber;
    String sssNumber, philhealthNumber, tinNumber, pagibigNumber, status, position, immediateSupervisor;
    double basicSalary, riceSubsidy, phoneAllowance, clothingAllowance, grossSemiMonthlyRate, hourlyRate;
    double weeklyHoursWorked, sssContribution, philhealthContribution, pagibigContribution, withholdingTax, netSalary;

    public Employee(String employeeID, String lastName, String firstName, String birthday, String address, String phoneNumber, 
                    String sssNumber, String philhealthNumber, String tinNumber, String pagibigNumber, String status, 
                    String position, String immediateSupervisor, double basicSalary, double riceSubsidy, 
                    double phoneAllowance, double clothingAllowance, double grossSemiMonthlyRate, double hourlyRate, double weeklyHoursWorked) { 
        this.employeeID = employeeID;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthday = birthday;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.sssNumber = sssNumber;
        this.philhealthNumber = philhealthNumber;
        this.tinNumber = tinNumber;
        this.pagibigNumber = pagibigNumber;
        this.status = status;
        this.position = position;
        this.immediateSupervisor = immediateSupervisor;
        this.basicSalary = basicSalary;
        this.riceSubsidy = riceSubsidy;
        this.phoneAllowance = phoneAllowance;
        this.clothingAllowance = clothingAllowance;
        this.grossSemiMonthlyRate = grossSemiMonthlyRate;
        this.hourlyRate = hourlyRate;
        this.weeklyHoursWorked = weeklyHoursWorked;

        // Compute deductions
        this.sssContribution = computeSSS(basicSalary);
        this.philhealthContribution = computePhilHealth(basicSalary);
        this.pagibigContribution = computePagibig(basicSalary);
        this.withholdingTax = computeWithholdingTax(basicSalary);
        
        // Compute Net Salary
        this.netSalary = computeWeeklySalary() - (sssContribution + philhealthContribution + pagibigContribution + withholdingTax);
    }

    public double computeWeeklySalary() {
        return weeklyHoursWorked * hourlyRate;
    }

    private double computeSSS(double salary) {
        return Math.min(1350.0, salary * 0.045); // Example rate: 4.5% capped at 1350
    }

    private double computePhilHealth(double salary) {
        return Math.min(1800.0, salary * 0.03); // Example rate: 3% capped at 1800
    }

    private double computePagibig(double salary) {
        return Math.min(1200.0, salary * 0.02); // Example rate: 2% capped at 1200
    }

    private double computeWithholdingTax(double salary) {
        return salary > 80000 ? salary * 0.2 : salary * 0.15; // Sample tax brackets
    }

    public void displayInfo() {
        System.out.println("------------------------------------");
        System.out.println("Employee ID       : " + employeeID);
        System.out.println("Name             : " + firstName + " " + lastName);
        System.out.println("Birthday         : " + birthday);
        System.out.println("Address          : " + address);
        System.out.println("Phone Number     : " + phoneNumber);
        System.out.println("SSS Number       : " + sssNumber);
        System.out.println("Philhealth Number: " + philhealthNumber);
        System.out.println("TIN Number       : " + tinNumber);
        System.out.println("Pag-ibig Number  : " + pagibigNumber);
        System.out.println("Status           : " + status);
        System.out.println("Position         : " + position);
        System.out.println("Supervisor       : " + immediateSupervisor);
        System.out.println("Basic Salary     : " + basicSalary);
        System.out.println("Rice Subsidy     : " + riceSubsidy);
        System.out.println("Phone Allowance  : " + phoneAllowance);
        System.out.println("Clothing Allowance: " + clothingAllowance);
        System.out.println("Gross Semi-monthly Rate: " + grossSemiMonthlyRate);
        System.out.println("Hourly Rate      : " + hourlyRate);
        System.out.println("Weekly Hours Worked: " + weeklyHoursWorked);
        System.out.println("Weekly Salary    : " + computeWeeklySalary());

        // Deductions
        System.out.println("SSS Contribution : " + sssContribution);
        System.out.println("PhilHealth       : " + philhealthContribution);
        System.out.println("Pag-IBIG         : " + pagibigContribution);
        System.out.println("Withholding Tax  : " + withholdingTax);
        System.out.println("Net Salary       : " + netSalary);
        
        System.out.println("------------------------------------\n");
    }
}

public class MotorPH {
    public static void main(String[] args) {
        System.out.println("MotorPH System is Running...");

        Employee emp1 = new Employee("10001", "Garcia", "Manuel III", "10/11/1983", "Valero Carpark Building Valero Street 1227, Makati City", "966-860-270", 
                                     "44-4506057-3", "820126853951", "442-605-657-000", "691295330870", "Regular", "Chief Executive Officer", "N/A", 
                                     90000.00, 1500.00, 2000.00, 1000.00, 45000.00, 535.71, 45.5);
        
        Employee emp2 = new Employee("10002", "Lim", "Antonio", "06/19/1988", "San Antonio De Padua 2, Block 1 Lot 8 and 2, Dasmarinas, Cavite", "171-867-411", 
                                     "52-2061274-9", "331735646338", "683-102-776-000", "663904995411", "Regular", "Chief Operating Officer", "Garcia, Manuel III", 
                                     60000.00, 1500.00, 2000.00, 1000.00, 30000.00, 357.14, 38.2);
        
        Employee emp3 = new Employee("10003", "Aquino", "Bianca Sofia", "08/04/1989", "Rm. 402 4/F Jiao Building Timog Avenue Cor. Quezon Avenue 1100, Quezon City", "966-889-370", 
                                     "30-8870406-2", "177451189665", "971-711-280-000", "171519773969", "Regular", "Chief Finance Officer", "Garcia, Manuel III", 
                                     60000.00, 1500.00, 2000.00, 1000.00, 30000.00, 357.14, 40.2);

        emp1.displayInfo();
        emp2.displayInfo();
        emp3.displayInfo();
    }
}
