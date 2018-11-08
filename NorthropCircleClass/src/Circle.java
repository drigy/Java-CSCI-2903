/*This class receives the radius and has methods for returning
 * the area, circumference; and diameter.
 */
public class Circle 
{

	//This field receives and stores the radius.
	private double radius;

	//This field stores the value for PI
	private double PI = 3.14159;
	
	/* This constructor is used when the object is created and
	 * has an argument at the time of creation. It will take that
	 * argument and store in the field Radius
	 */
	public Circle(double startRadius) 
	{
		this.radius = startRadius;
	}

	/* This constructor is used when their is no argument upon
	 * creation of the object. It sets the radius to O.O.
	 */
	
	public Circle() 
	{
		this.radius = 0.0;
	}
	
	//setRadius is mutator that gives a new value to radius.
	 
	public void setRadius(double newRadius)
	{
		this.radius = newRadius;	
	}
	
	// getRadius is an accessor that returns the radius.
	
	public double getRadius()
	{	
		return this.radius;	
	}

	// getArea is a method that calculates and returns the area of a circle.
	
	public double getArea()
	{
		return PI * this.radius * this.radius;
	}

	// getDiameter is a method that calculates and returns the diameter of a circle.
	
	public double getDiameter() 
	{
		return this.radius *2;
	}

	// getCircumference is a method that calculates and returns the circumference of a circle.
	
	public double getCircumference()
	{
		return 2 * PI * this.radius;	
	}

}