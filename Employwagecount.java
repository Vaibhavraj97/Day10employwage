package com.bridgelabz.Countwage;
import java.util.ArrayList;
import java.util.HashMap;
public class Employwagecount {
	

	public class Employee_Wage_Computation_Problem
	{
	    static class Company_Emp_Wage
	    {
	        final String Company_Name;
	        final int Wage_Per_Hr;
	        final int Max_Working_Days;
	        final int Max_Working_Hrs;
	        int totalEmpWage;

	        Company_Emp_Wage(String companyName, int wagePerHr, int maxWorkingDays, int maxWorkingHrs)
	        {
	            Company_Name = companyName;
	            Wage_Per_Hr = wagePerHr;
	            Max_Working_Days = maxWorkingDays;
	            Max_Working_Hrs = maxWorkingHrs;
	            totalEmpWage = 0;
	        }

	        void setTotalEmployeeWage(int totalEmpWage)
	        {
	            this.totalEmpWage = totalEmpWage;
	        }

	        @Override
	        public String toString() {
	            System.out.println("Details of " + Company_Name + " employee");
	            System.out.println("-----------------------------------------------------");
	            System.err.println("Wage per hour:" + Wage_Per_Hr);
	            System.out.println("Maximum working days:" + Max_Working_Days);
	            System.out.println("Maximum working hours:" + Max_Working_Hrs);
	            return "Total wage for a month of " + Company_Name + " employee is " + totalEmpWage + "\n";
	        }
	    }

	    static class EmployeeWageComputation
	    {

	        public static final int PART_TIME = 1;
	        public static final int FULL_TIME = 2;

	        ArrayList<Company_Emp_Wage> companies;
	        HashMap<String, Integer> totalEmpWages;


	        public EmployeeWageComputation()
	        {
	            companies = new ArrayList<>();
	            totalEmpWages = new HashMap<>();
	        }

	        private void addCompany(String companyName, int wagePerHr, int maxWorkingDays, int maxWorkingHrs)
	        {
	            Company_Emp_Wage company = new Company_Emp_Wage(companyName, wagePerHr, maxWorkingDays, maxWorkingHrs);
	            companies.add(company);
	            totalEmpWages.put(companyName, 0);
	        }

	        int generateEmployeeType()
	        {
	            return (int) (Math.random() * 100) % 3;
	        }

	        int getWorkingHrs(int empType)
	        {
	            return switch (empType) {
	                case FULL_TIME -> 8;
	                case PART_TIME -> 4;
	                default -> 0;
	            };
	        }

	        private void calculateTotalWage()
	        {
	            for (Company_Emp_Wage company : companies)
	            {
	                int totalWage = calculateTotalWage(company);
	                company.setTotalEmployeeWage(totalWage);
	                System.out.println(company);
	            }
	        }

	        int calculateTotalWage(Company_Emp_Wage companyEmpWage)
	        {
	            System.out.println("Computation of total wage of " + companyEmpWage.Company_Name + " employee");
	            System.out.println("-----------------------------------------------------");
	            System.out.printf("%4s\t%4s\t%2s\t%4s\n", "Day", "Workinghrs", "Wage", "Total working hrs");

	            int workingHrs, totalWage = 0;
	            for (int day = 1, totalWorkingHrs = 0; day <= companyEmpWage.Max_Working_Days
	                    && totalWorkingHrs <= companyEmpWage.Max_Working_Hrs; day++, totalWorkingHrs += workingHrs)
	            {
	                int empType = generateEmployeeType();
	                workingHrs = getWorkingHrs(empType);
	                int wage = workingHrs * companyEmpWage.Wage_Per_Hr;
	                totalWage += wage;
	                System.out.printf("%4d\t%5d\t%10d\t%10d\n", day, workingHrs, wage, totalWorkingHrs + workingHrs);
	            }
	            totalEmpWages.put(companyEmpWage.Company_Name, totalWage);
	            return totalWage;
	        }

	        private int getTotalEmpWage(String companyName)
	        {
	            return totalEmpWages.get(companyName);
	        }

	        public void main(String[] args)
	        {
	            EmployeeWageComputation employeeWageComputation = new EmployeeWageComputation();
	            employeeWageComputation.addCompany("BridgeLabz", 4, 30, 100);
	            employeeWageComputation.addCompany("Crazzall", 5, 40, 170);
	            employeeWageComputation.addCompany("1Clickdesign", 19, 10, 150);
	            employeeWageComputation.calculateTotalWage();
	            String query = "BridgeLabz";
	            int totalWage = employeeWageComputation.getTotalEmpWage(query);
	            System.out.println("Total Employee Wage for " + query + " company is " + totalWage);
	        }
	    }

	}
