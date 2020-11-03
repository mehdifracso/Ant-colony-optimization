package fr.utbm.info.ia54.antcolony.model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class Road 
{
	
	//What cities this road connects
	private City city1;
	private City city2;

	//Time it takes to move along this road
	//This can be any arbitrary unit but let's use minutes for consistency
	private Long timeTaken;
	
	//Deciding factor on which road to take
	private Long weight;
	
	
	
	
	public Line getLine()
	{
		Line roadLine=new Line();
		
		Color roadColor=Color.DARKGRAY;
		
		roadLine.setFill(roadColor);
		roadLine.setStartX(city1.getX());
		roadLine.setStartY(city1.getY());
		roadLine.setEndX(city2.getX());
		roadLine.setEndY(city2.getY());
		
		return roadLine;
	}

	public Text getRoadText()
	{
		Text roadText=new Text();
		
		Double textHeight =new Double(20);
		
		roadText.setText(this.weight.toString());
		roadText.setX(this.city1.getX().intValue()+(this.city2.getX().intValue()-this.city1.getX().intValue())/2);
		roadText.setY(this.city1.getY().intValue()+(this.city2.getY().intValue()-this.city1.getY().intValue())/2 - textHeight);
		
		return roadText;
	}
	
	public Road() {
		super();
		this.city1 = null;
		this.city2 = null;
		this.timeTaken = new Long(0);
		this.weight = new Long(0);
	}
	public Road(City city1, City city2, long timeTaken, long weight) {
		super();
		this.city1 = city1;
		this.city2 = city2;
		this.timeTaken = timeTaken;
		this.weight = weight;
	}

	public City getCity1() {
		return city1;
	}

	public void setCity1(City city1) {
		this.city1 = city1;
	}

	public City getCity2() {
		return city2;
	}

	public void setCity2(City city2) {
		this.city2 = city2;
	}

	public long getTimeTaken() {
		return timeTaken;
	}

	public void setTimeTaken(long timeTaken) {
		this.timeTaken = timeTaken;
	}

	public long getWeight() {
		return weight;
	}

	public void setWeight(long weight) {
		this.weight = weight;
	}
}
