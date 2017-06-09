package hospital;

//Parent Class here
public class Hospital implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Hospital Fields
	public Care[] employees;
	public Patient[] patients;

	// This is my Main method
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Patient[] patient = new Patient[2];
		patient[0] = new Patient ();
		patient[0].injuries = "Broken Leg";
		patient[0].temperature = 78.0;
		patient[0].name = "Alice";
		patient[1] = new Patient ();
		patient[1].injuries ="Skull injury";
		patient[1].temperature = 90.0;
		patient[1].pressure = 80.0;
		Doctor doctor = new Doctor();
 		doctor.handOutmeds = "Cialis";
		doctor.dischargesPatient = (1);
		Nurse nurse = new Nurse ();
		nurse.shots = (2);
		Person person = new Person ();
		person.temperature = 66.5;
		person.name = "Bob";
		person.age = 37;
		
		System.out.println(person.age);
		System.out.println(patient[1].injuries);
		System.out.println(patient[1].temperature);
		System.out.println(patient[0].name);
		System.out.println(doctor.handOutmeds);
		System.out.println(doctor.dischargesPatient);
		System.out.println(nurse.shots);
	}
}
class Person implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int age;
	public String name;
	public String address;
	public double temperature;
	public double pressure;
}

class Doctor extends Person implements Care {
	public String handOutmeds;
	public int dischargesPatient;
	
// method
	public double takeTemperature(Patient p) {
		double tempAsTaken = p.temperature; // TODO get real temperature
		return tempAsTaken;
		
	}
	// method
	public String readChart(Patient p) {
		String s = "Needs surgey";
		return s;

	}
	// method
	public BloodPressure readBloodPressure(Patient p) {
		BloodPressure pressure = new BloodPressure();
		pressure.systolic = 65;
		pressure.dyastolic = 100;
		return pressure;
	}
}

class Patient extends Person {
	public String injuries;
	public int bill;
	public double temperature;
	public double pressure;
	
}

class Nurse extends Person implements Care 	{
	public int hours;
	public int shots;
	public double temperature;
	public double pressure;
	
	// method
	public double takeTemperature(Patient p) {
		double temperature = 78.0; // TODO get real temperature
		return temperature;
	}
	// method
	public String readChart(Patient p) {
		String s = "In Good Health!";
		return s;
	}
	// method
	public BloodPressure readBloodPressure(Patient p) {
		BloodPressure pressure = null; // TODO get real pressure
		pressure.systolic = 80;
		pressure.dyastolic = 120;
		return pressure;
	}
}

class BloodPressure implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int systolic ;
	public int dyastolic;
}


interface Care {
	double takeTemperature(Patient p);
	String readChart(Patient p);
	BloodPressure readBloodPressure(Patient p);
}
