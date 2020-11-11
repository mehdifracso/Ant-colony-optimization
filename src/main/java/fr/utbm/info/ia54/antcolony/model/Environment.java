package fr.utbm.info.ia54.antcolony.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import javafx.geometry.Rectangle2D;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Screen;


public class Environment {

	
	public List<City> cities;
	public List<Road> roads;
	
	
	public Environment(String map)
	{
		cities=new ArrayList<City>();
		roads=new ArrayList<Road>();
		if(map.equals("Default Map"))
		{
			makeDefaultMap();
		}
		else
		{
			File mapFile = new File("src/main/java/fr/utbm/info/ia54/antcolony/model/benchmarks/"+map+".tsp");
			Scanner scanner = null;
			String line = null;
			String data[] = null;
			Double maxX = new Double(0);
			Double maxY = new Double(0);
			City city;
			try 
			{
				scanner = new Scanner(mapFile);
			} 
			catch (FileNotFoundException e) 
			{
				System.out.println("Error reading map file.");
			}
			while (scanner.hasNextLine()) 
			{
				line = scanner.nextLine();
				if(line != null && !line.isEmpty() && Character.isDigit(line.charAt(0)))
				{
					data = line.split(" ");
					city=new City();
					city.setName("City "+data[0]);
					city.setX(Double.parseDouble(data[1]));
					city.setY(Double.parseDouble(data[2]));
					cities.add(city);

					maxX=Math.max(Double.parseDouble(data[1]), maxX);
					maxY=Math.max(Double.parseDouble(data[2]), maxY);
				}
			}
			
			autoGenerateRoads();
			resizeMap(maxX, maxY);
		}
	}
	
	//Generates roads with timeTaken based on distance
	public void autoGenerateRoads()
	{
		Road road;
		Double dist;
		int i,j;
		
		for(i=0;i<this.cities.size();i++)
		{
			for(j=i+1;j<this.cities.size();j++)
			{
				road=new Road();
				road.setCity1(getCityByName(this.cities.get(i).getName()));
				road.setCity2(getCityByName(this.cities.get(j).getName()));
				dist = Math.sqrt(Math.pow(this.cities.get(i).getX()-this.cities.get(j).getX(),2)+Math.pow(this.cities.get(i).getY()-this.cities.get(j).getY(),2));
				road.setTimeTaken(new Long(dist.longValue()));
				roads.add(road);
			}
		}
	}
	
	public void resizeMap(Double maxX, Double maxY)
	{
		Rectangle2D screenBounds = Screen.getPrimary().getBounds();
		Double scale = Math.min(maxX/screenBounds.getMaxX() , maxY/screenBounds.getMaxY())*2;
		for(City city : cities)
		{
			city.setX(city.getX()/scale);
			city.setY(city.getY()/scale);
		}
		System.out.println(screenBounds.getMaxY());
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
