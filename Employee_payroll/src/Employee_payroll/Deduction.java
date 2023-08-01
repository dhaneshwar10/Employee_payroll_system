package Employee_payroll;
public class Deduction {
    private int deductionId;
    private int employeeId;
    private String deductionType;
    private double amount;

    public Deduction(int deductionId, int employeeId, String deductionType, double amount) {
        this.deductionId = deductionId;
        this.employeeId = employeeId;
        this.deductionType = deductionType;
        this.amount = amount;
    }

	public int getDeductionId() {
		return deductionId;
	}

	public void setDeductionId(int deductionId) {
		this.deductionId = deductionId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getDeductionType() {
		return deductionType;
	}

	public void setDeductionType(String deductionType) {
		this.deductionType = deductionType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

    
}

