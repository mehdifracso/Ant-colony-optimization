package fr.utbm.info.ia54.antcolony.model;

import java.util.Calendar;

import javafx.scene.text.Text;

public class Metrics
{
	private Text display;

	private Calendar startTime;
	String fastestTime = "TBD";
	Integer roundsElapsed = 0;
	
	public Metrics()
	{
		display=new Text();
		display.setX(925);
		display.setY(25);
		
		startTime = Calendar.getInstance();
		fastestTime = "TBD";
		roundsElapsed = 0;
	}
	
	public Text getMetrics()
	{
		updateDisplay();
		return this.display;
	}
	
	public void updateDisplay()
	{
		
		display.setText("\n\n"
			+"Metrics :\n"
			+ "Elapsed time : " + (Calendar.getInstance().getTime().getTime() - startTime.getTime().getTime())/1000 + " s\n"
    		+ "Fastest time : " + fastestTime + "\n"
			+ "Rounds elapsed : " + roundsElapsed + "\n"
			);
	}
	
	
	
	
	
	
	

	/*
	public void updateSheetMetrics(Long timeAlive)
	{
		updateDisplay();
		//I have to do this check cus this function (along with all other functions in CustomerExitEvent) gets called twice for some reason
		if(!deadAgentNow.contains(deadAgents/2) && deadAgents/2!=0)
		{
			deadAgentNow.add(deadAgents/2);
			clockTime.add(Calendar.getInstance().getTime().getTime() - startTime.getTime().getTime());
			agentTime.add(timeAlive);
			averageTime.add(averageTimeAlive);
			createExcelSheet(); //Since ExitApplicationEvent is broken and only works half the time Ill just create a new sheet everytime an agent exists instead of at the end of the application
		}
	}
	
	public void createExcelSheet()
	{
		try
		{
	        //Create excel
	        Workbook wb = new HSSFWorkbook(); 
	  
	        //Create excel tab
	        Sheet sheet = wb.createSheet("Results");
	        
	        // Specific row number 
	        Row row = sheet.createRow(1); 
	        
	        Cell cell=row.createCell(0);
	        
	        cell.setCellValue("|");
	  
	        // Specific cell number 
	        cell = row.createCell(1); 
	        
	        cell.setCellValue("Agents killed");
	  
	        // Specific cell number 
	        cell = row.createCell(2); 
	        
	        cell.setCellValue("Time elapsed when this agent left the store (in ms)");

	        cell = row.createCell(3); 
	        
	        cell.setCellValue("Time this agent spent in the store (in ms)");
	        
	        cell=row.createCell(4);
	        
	        cell.setCellValue("Average time agents spent in the store at this point in time (in ms)");
	        
	        cell=row.createCell(5);
	        
	        cell.setCellValue("Density of the crowd at this point in time (in customer per m²)");
	        
	        cell=row.createCell(6);
	        
	        cell.setCellValue("|");
	        
	        int i;
	        for(i=0;i<clockTime.size();i++)
	        {
	        	row=sheet.createRow(i+2);
	        	
	        	cell=row.createCell(1);
	        	cell.setCellValue(i+1);
	        	
	        	cell=row.createCell(2);
	        	cell.setCellValue(clockTime.get(i));
	        	
	        	cell=row.createCell(3);
	        	cell.setCellValue(agentTime.get(i));
	        	
	        	cell=row.createCell(4);
	        	cell.setCellValue(averageTime.get(i));
	        	
	        	cell=row.createCell(5);
	        	cell.setCellValue(densityMoment.get(i));
	        }
	        
	        //Create file to write the excel in
	        OutputStream file = new FileOutputStream("SimulationResults.xls"); 
	        
	        //Write to the file
	        wb.write(file);
	        
	        wb.close();
	        file.close();
	        
	        System.out.println("excel sheet successfully created");
		}
		catch(Exception e)
		{
			System.out.println("Error creating excel sheet");
		}
	}
	*/
	
}
