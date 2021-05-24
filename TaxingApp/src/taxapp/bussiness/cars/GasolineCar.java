package taxapp.bussiness.cars;

public class GasolineCar implements CarRole {

	private CarRole innerDiesel;

	public GasolineCar(CarRole innerDiesel) {
		this.innerDiesel = innerDiesel;
	}

	public double computeTax() {
		return innerDiesel.computeTax();
	}

	public String toString() {
		return "GasolineCar [innerDiesel=" + innerDiesel + "]";
	}

}
