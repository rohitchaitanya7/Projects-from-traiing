package com.cts;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class HRs {
	 
	public List<HR> HRslist(){
	List<HR> HRs = new ArrayList<HR>();
	HRs.add(new HR(101, "pavan", 5000));
	HRs.add(new HR(109, "rohit", 3000));
	HRs.add(new HR(111, "jerry", 4400));
	HRs.add(new HR(109, "ravi", 3200));
	return HRs;
	}
}
