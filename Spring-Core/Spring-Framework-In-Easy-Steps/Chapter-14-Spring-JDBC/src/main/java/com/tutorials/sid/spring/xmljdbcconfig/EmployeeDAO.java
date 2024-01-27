/**
 * 
 */
package com.tutorials.sid.spring.xmljdbcconfig;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.tutorials.sid.spring.bean.Employee;

/**
 * @author Lenovo
 *
 */
public class EmployeeDAO {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void employeeSave(Employee employee) {
		int status = jdbcTemplate.update("insert into employee (id, first_name, last_name) values(" + employee.getId()
				+ ",\"" + employee.getFirstName() + "\",\"" + employee.getLastName() + "\")");
		if (status > 0) {
			System.out.println("Employee save");
		} else {
			System.out.println("Employee not save");
		}
	}

	public void employeeUsingPlaceholderSave(Employee employee) {
		String sql = "insert into employee (id, first_name, last_name) values(?,?,?)";
		int status = jdbcTemplate.update(sql, employee.getId(), employee.getFirstName(), employee.getLastName());
		if (status > 0) {
			System.out.println("Employee save");
		} else {
			System.out.println("Employee not save");
		}
	}

	public void employeeUpdate(Employee employee) {
		String sql = "update employee set first_name=?, last_name=? where id=?";
		int status = jdbcTemplate.update(sql, employee.getFirstName(), employee.getLastName(), employee.getId());
		if (status > 0) {
			System.out.println("Employee Updated-" + status);
		} else {
			System.out.println("Employee not Updated");
		}
	}

	public void employeeDelete(Employee employee) {
		String sql = "delete from employee where id=?";
		int status = jdbcTemplate.update(sql, employee.getId());
		if (status > 0) {
			System.out.println("Employee Delete-" + status);
		} else {
			System.out.println("Employee not Delete");
		}
	}

	public Employee employeeSelect(int id) {
		String sql = "Select * from employee where id=?";
		Employee employee = jdbcTemplate.queryForObject(sql, employeeRowMapping(), id);
		return employee;
	}

	public List<Employee> employeeSelectList() {
		String sql = "Select * from employee";
		List<Employee> employee = jdbcTemplate.query(sql, employeeRowMapping());
		return employee;
	}

	private RowMapper<Employee> employeeRowMapping() {
		return (rs, rowNum) -> {
			Employee employee = new Employee();
			employee.setId(rs.getInt(1));
			employee.setFirstName(rs.getString("first_name"));
			employee.setLastName(rs.getString("last_name"));
			return employee;
		};
	}

}
