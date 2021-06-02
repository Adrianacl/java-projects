import java.text.NumberFormat;
import java.text.DecimalFormat;


public class Shipment {

	private Package package1;
	private Package package2;
	private String message;
	private NumberFormat currency;
	private DecimalFormat decimal;
	
	public Shipment() {
		
		this.package1 = new Package();
		this.package2 = new Package();
		this.currency = NumberFormat.getCurrencyInstance();
		this.decimal = new DecimalFormat("#.##");

	}
	
	public void inputPackages() {
		
		System.out.println("Welcome to Adriana de Lazzari's shipping calculator!");
		
		System.out.println("Enter first package dimensions: ");
		this.package1.inputLength();
		this.package1.inputWidth();
		this.package1.inputHeight();
		
		System.out.println("Enter second package dimensions: ");
		this.package2.inputLength();
		this.package2.inputWidth();
		this.package2.inputHeight();
		
		System.out.print("Package 1 - ");
		this.package1.displayDimensions();
		System.out.print("Package 2 - ");
		this.package2.displayDimensions();
	}
	
	public void calculateCost() {
		
		double package1Vol = this.package1.calcVolume();
		double package1Cost = 3;
		if(package1Vol - 1 > 0) {
			package1Cost += package1Vol - 1;
		}
		this.message = "Package 1 will cost "+this.currency.format(package1Cost)+" to ship.";
		
		double package2Vol = this.package2.calcVolume();
		double package2Cost = 3;
		if(package2Vol - 1 > 0) {
			package2Cost += package2Vol - 1;
		}
		this.message += "\nPackage 2 will cost "+this.currency.format(package2Cost)+" to ship.";
		
		this.message += "\nCost difference is "+this.currency.format(Math.abs(package1Cost - package2Cost));
		
		if(package1Cost == package2Cost) {
			this.message += "\nThe first package has the same cost as the second package";
		}else if(package1Cost > package2Cost) {
			double proportion = package1Cost / package2Cost;
			if(proportion < 2) {
				this.message += "\nThe first package is slightly more than the second package.";
			}else if(proportion < 3) {
				this.message += "\nThe first package is twice the second package.";
			}else if(proportion < 4) {
				this.message += "\nThe first package is triple the second package.";
			}else if(proportion < 5) {
				this.message += "\nThe first package is quadruple the second package.";
			}else {
				this.message += "\nThe first package is "+this.decimal.format(proportion)+"x the second package.";
			}
		}else {
			double proportion = package2Cost / package1Cost;
			if(proportion < 2) {
				this.message += "\nThe second package is slightly more than the first package.";
			}else if(proportion < 3) {
				this.message += "\nThe second package is twice the first package.";
			}else if(proportion < 4) {
				this.message += "\nThe second package is triple the first package.";
			}else if(proportion < 5) {
				this.message += "\nThe second package is quadruple the first package.";
			}else {
				this.message += "\nThe second package is "+this.decimal.format(proportion)+"x the first package.";
			}
		}
	}
	
	public void display() {
		
		System.out.println(this.message);
	}
	
	public static void main(String[] args) {
		
		Shipment shipment = new Shipment();
		shipment.inputPackages();
		shipment.calculateCost();
		shipment.display();
	}
}