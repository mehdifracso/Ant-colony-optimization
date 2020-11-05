package fr.utbm.info.ia54.antcolony.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;


public class Environment {

	
	public List<City> cities;
	public List<Road> roads;
	
	
	public Environment(boolean isDefaultMap)
	{
		cities=new ArrayList<City>();
		roads=new ArrayList<Road>();
		if(isDefaultMap)
		{
			makeDefaultMap();
		}
	}
	
	public void makeDefaultMap()
	{
		City city;
		
		city=new City();
		city.setName("Strasbourg");
		city.setX(new Double(800));
		city.setY(new Double(200));
		cities.add(city);

		city=new City();
		city.setName("Paris");
		city.setX(new Double(400));
		city.setY(new Double(300));
		cities.add(city);

		city=new City();
		city.setName("Belfort");
		city.setX(new Double(700));
		city.setY(new Double(400));
		cities.add(city);

		city=new City();
		city.setName("Toulouse");
		city.setX(new Double(300));
		city.setY(new Double(600));
		cities.add(city);

		city=new City();
		city.setName("Marseille");
		city.setX(new Double(650));
		city.setY(new Double(700));
		cities.add(city);

		Road road;
		
		road=new Road();
		road.setCity1(getCityByName("Strasbourg"));
		road.setCity2(getCityByName("Paris"));
		road.setTimeTaken(new Long(270));
		roads.add(road);
		
		road=new Road();
		road.setCity1(getCityByName("Strasbourg"));
		road.setCity2(getCityByName("Belfort"));
		road.setTimeTaken(new Long(105));
		roads.add(road);
		
		road=new Road();
		road.setCity1(getCityByName("Strasbourg"));
		road.setCity2(getCityByName("Toulouse"));
		road.setTimeTaken(new Long(600));
		roads.add(road);
		
		road=new Road();
		road.setCity1(getCityByName("Strasbourg"));
		road.setCity2(getCityByName("Marseille"));
		road.setTimeTaken(new Long(480));
		roads.add(road);
		
		road=new Road();
		road.setCity1(getCityByName("Paris"));
		road.setCity2(getCityByName("Belfort"));
		road.setTimeTaken(new Long(300));
		roads.add(road);
		
		road=new Road();
		road.setCity1(getCityByName("Paris"));
		road.setCity2(getCityByName("Toulouse"));
		road.setTimeTaken(new Long(420));
		roads.add(road);
		
		road=new Road();
		road.setCity1(getCityByName("Paris"));
		road.setCity2(getCityByName("Marseille"));
		road.setTimeTaken(new Long(390));
		roads.add(road);
		
		road=new Road();
		road.setCity1(getCityByName("Belfort"));
		road.setCity2(getCityByName("Toulouse"));
		road.setTimeTaken(new Long(480));
		roads.add(road);
		
		road=new Road();
		road.setCity1(getCityByName("Belfort"));
		road.setCity2(getCityByName("Marseille"));
		road.setTimeTaken(new Long(420));
		roads.add(road);
		
		road=new Road();
		road.setCity1(getCityByName("Toulouse"));
		road.setCity2(getCityByName("Marseille"));
		road.setTimeTaken(new Long(240));
		roads.add(road);
		
		
	}
	
	public City getCityByID(UUID id)
	{
		City resultCity = null;
		
		for(City city : cities)
		{
			if(city.getUuid().equals(id))
			{
				resultCity=city;
			}
		}
		
		return resultCity;
	}
	
	public City getCityByName(String name)
	{
		City resultCity = null;
		
		for(City city : cities)
		{
			if(city.getName().equals(name))
			{
				resultCity = city;
			}
		}
		
		return resultCity;
	}
	
	public List<Road> getAdjacentRoads(City city)
	{
		List<Road> roads=new ArrayList<Road>();
		
		for(Road road : this.roads)
		{
			if(road.getCity1()==city || road.getCity2()==city)
			{
				roads.add(road);
			}
		}
		
		return roads;
	}
	
	public void updateWeights()
	{
		for(Road road : roads)
		{
			road.setWeight(road.getWeight()+road.getFutureWeight());
			road.setFutureWeight(new Long(0));
		}
	}
	
	
	
	
	//Display stuff
	
	public List<Circle> getCitiesRepresentation()
	{
		List<Circle> citiesRep=new ArrayList<Circle>();
		
		for(City city : cities)
		{
			citiesRep.add(city.getCircle());
		}
		
		return citiesRep;
	}
	
	public List<Line> getRoadsRepresentation()
	{
		List<Line> roadsRep=new ArrayList<Line>();
		
		for(Road road : roads)
		{
			roadsRep.add(road.getLine());
		}
		
		return roadsRep;
	}
	
	public List<Text> getCitiesNames()
	{
		List<Text> citiesNames=new ArrayList<Text>();
		

		for(City city : cities)
		{
			citiesNames.add(city.getCityText());
		}
		
		return citiesNames;
	}
	
	public List<Text> getRoadsWeights()
	{
		List<Text> roadsWeights=new ArrayList<Text>();
		
		for(Road road : roads)
		{
			roadsWeights.add(road.getRoadText());
		}
		
		return roadsWeights;
	}
	
	
	
	
	
	
	
	
	//Autogen

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public List<Road> getRoads() {
		return roads;
	}

	public void setRoads(List<Road> roads) {
		this.roads = roads;
	}
}
