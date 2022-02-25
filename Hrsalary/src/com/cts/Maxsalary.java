package com.cts;

public class Maxsalary {

	public static void main(String[] args) {

		HRs maxs = new HRs();

		int maxSalary = maxs.HRslist().stream().map(HR::getSalary)
				.max(Integer::compare).get();

		System.out.println("Max salary of the employee:" + maxSalary);

	}

}