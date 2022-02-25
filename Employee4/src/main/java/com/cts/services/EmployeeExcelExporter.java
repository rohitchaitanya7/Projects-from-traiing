package com.cts.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import com.cts.model.Employee;
import com.cts.model.Student;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class EmployeeExcelExporter {
	@Autowired
	private XSSFWorkbook workbook;
	@Autowired
	private XSSFSheet sheet;
	@Autowired
	private XSSFSheet sheet1;

	private List<Employee> employeeList;
	private List<Student> studentList;

	

	public EmployeeExcelExporter(List<Employee> employeeList, List<Student> studentList) {
		super();
		this.employeeList = employeeList;
		this.studentList = studentList;
		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet("Employee");
		sheet1 =  workbook.createSheet("Student");
	}

	private void writeHeaderRow() {
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue("Employee Id");

		cell = row.createCell(1);
		cell.setCellValue("Employee Name");

		cell = row.createCell(2);
		cell.setCellValue("department");

		cell = row.createCell(3);
		cell.setCellValue("email");

		cell = row.createCell(4);
		cell.setCellValue("salary");

		cell = row.createCell(4);
		cell.setCellValue("experience");

	}

	private void writeDateROws() {
		int rowCount = 1;

		for (Employee employee : employeeList) {
			Row row = sheet.createRow(rowCount++);
			Cell cell = row.createCell(0);
			cell.setCellValue(employee.getId());
			cell = row.createCell(1);
			cell.setCellValue(employee.getName());
			cell = row.createCell(2);
			cell.setCellValue(employee.getDepartment());
			cell = row.createCell(3);
			cell.setCellValue(employee.getSalary());
			cell = row.createCell(4);
			cell.setCellValue(employee.getExperience());
		}
	}

	private void writeHeaderRow1() {
		
		Row row = sheet1.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue("Student Id");

		cell = row.createCell(1);
		cell.setCellValue("Student Name");

		cell = row.createCell(2);
		cell.setCellValue("course");

		cell = row.createCell(3);
		cell.setCellValue("email");
	}
	private void writeDateRows() {
		int rowCount = 1;
		for (Student s : studentList) {
			Row row = sheet1.createRow(rowCount++);
			Cell cell = row.createCell(0);
			cell.setCellValue(s.getId());
			cell = row.createCell(1);
			cell.setCellValue(s.getName());
			cell = row.createCell(2);
			cell.setCellValue(s.getCourse());
			cell = row.createCell(3);
			cell.setCellValue(s.getEmail());
		}
	}

	public void export(HttpServletResponse response) throws IOException {
		writeHeaderRow();
		writeDateROws();
		writeHeaderRow1();
		writeDateRows();
		// response.getOutputStream()
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();
	}
}
