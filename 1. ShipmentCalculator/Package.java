import java.util.Scanner;

public class Package { 

	
	private double length;
	private double width;
	private double height;
	private Scanner input = new Scanner(System.in);
	
	public Package() {
		
		this.length = 1.0;
		this.width = 1.0;
		this.height = 1.0;
	}
	
	public Package(double length, double width, double height) {
		
		this.length = length;
		this.width = width;
		this.height = height;
	}
	
	public Package(Package pckg) {
		
		this.length =  pckg.length;
		this.width = pckg.width;
		this.height = pckg.height;
    }
	
	public void inputLength() {
		
		System.out.print("Enter the length: ");
		this.length = input.nextDouble();
	}
	public void inputWidth() {
		
		System.out.print("Enter the width: ");
		this.width = input.nextDouble();
	}
	public void inputHeight() {
		
		System.out.print("Enter the height: ");
		this.height = input.nextDouble();
	}
	
	public void displayDimensions() {
		
		System.out.println("Dimensions: " + this.length + " X " + this.width + " X " + this.height);
	}
	
	public double calcVolume() {
		
		return this.length * this.width * this.height;
	}
}


