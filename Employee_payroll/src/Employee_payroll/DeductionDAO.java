package Employee_payroll;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeductionDAO {
    public List<Deduction> getAllDeductions() {
        List<Deduction> deductions = new ArrayList<>();
        String query = "SELECT * FROM deductions";
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                int deductionId = resultSet.getInt("deduction_id");
                int employeeId = resultSet.getInt("employee_id");
                String deductionType = resultSet.getString("deduction_type");
                double amount = resultSet.getDouble("amount");
                deductions.add(new Deduction(deductionId, employeeId, deductionType, amount));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deductions;
    }

    public void insertDeduction(Deduction deduction) {
        String insertQuery = "INSERT INTO deductions (employee_id, deduction_type, amount) VALUES (?, ?, ?)";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, deduction.getEmployeeId());
            preparedStatement.setString(2, deduction.getDeductionType());
            preparedStatement.setDouble(3, deduction.getAmount());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                deduction.setDeductionId(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateDeduction(Deduction deduction) {
        String updateQuery = "UPDATE deductions SET employee_id = ?, deduction_type = ?, amount = ? WHERE deduction_id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            preparedStatement.setInt(1, deduction.getEmployeeId());
            preparedStatement.setString(2, deduction.getDeductionType());
            preparedStatement.setDouble(3, deduction.getAmount());
            preparedStatement.setInt(4, deduction.getDeductionId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteDeduction(int deductionId) {
        String deleteQuery = "DELETE FROM deductions WHERE deduction_id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
            preparedStatement.setInt(1, deductionId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	public Deduction getDeductionById(int deductionId) {
		// TODO Auto-generated method stub
		return null;
	}
}
