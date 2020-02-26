package org.springtutorial.springxmlconfiguration;

public class Drawing {
	private Shape shape;

	public Drawing(Shape shape) {
		this.shape = shape;
	}

	public Shape getShape() {
		return shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}

	public void preparing() {	
		System.out.println("Preparing ...");
	}
	
	public void draw() {
		shape.draw();
	}
}
