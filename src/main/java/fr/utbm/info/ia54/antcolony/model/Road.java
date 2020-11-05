package fr.utbm.info.ia54.antcolony.model;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import fr.utbm.info.ia54.antcolony.model.City;

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
	
	//Weights to be added next round
	private Long futureWeight;
	
	
	public void increaseFutureWeight(Long increase)
	{
		this.futureWeight+=increase;
	}
	
	public Set<City> getCities()
	{
		Set<City> cities = new HashSet<City>();
		cities.add(city1);
		cities.add(city2);
		return cities;
	}
	

	//Returns null if attempting to travel along that road starting from a city not connected by that road
	public City travel(City startingCity) {
		City endingCity=null;
		
		if(startingCity==city1)
		{
			endingCity=city2;
		}
		else if(startingCity==city2)
		{
			endingCity=city1;
		}
		
		return endingCity;
	}
	

	
	public static void sortRoadsByWeights(List<Road> roads)
	{
		Collections.sort(roads, new Comparator<Road>() 
		{
		    @Override
		    public int compare(Road r1, Road r2) 
		    {
		    	int res=0;
        		if(r1.weight<r2.weight)
        		{
        			res = -1;
        		}
        		else if(r1.weight>r2.weight)
        		{
        			res = 1;
        		}
        		return res;
			}
		});
	}
	
	//Display stuff
	
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
	
	//Autogen
	
	public Road() {
		super();
		this.city1 = null;
		this.city2 = null;
		this.timeTaken = new Long(0);
		this.weight = new Long(0);
		this.futureWeight = new Long(0);
	}

	public Road(City city1, City city2, Long timeTaken, Long weight, Long futureWeight) {
		super();
		this.city1 = city1;
		this.city2 = city2;
		this.timeTaken = timeTaken;
		this.weight = weight;
		this.futureWeight = futureWeight;
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

	public Long getTimeTaken() {
		return timeTaken;
	}

	public void setTimeTaken(Long timeTaken) {
		this.timeTaken = timeTaken;
	}

	public Long getWeight() {
		return weight;
	}

	public void setWeight(Long weight) {
		this.weight = weight;
	}

	public Long getFutureWeight() {
		return futureWeight;
	}

	public void setFutureWeight(Long futureWeight) {
		this.futureWeight = futureWeight;
	}
	
}
