package service;

//Encapsulation---> Binding data with methods
public class EmployeeService {
	
	private String firstName;
	private String lastName;
	private String dependent;
	
	public EmployeeService(String firstName, String lastName, String dependent) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.dependent = dependent;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getDependent() {
		return dependent;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setDependent(String dependent) {
		this.dependent = dependent;
	}

	@Override
	public String toString() {
		return "EmployeeService [firstName=" + firstName + ", lastName=" + lastName + ", dependent=" + dependent + "]";
	}
	
	

}
