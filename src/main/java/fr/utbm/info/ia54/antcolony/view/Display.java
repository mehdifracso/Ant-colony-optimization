package fr.utbm.info.ia54.antcolony.view;

import fr.utbm.info.ia54.antcolony.Main;
import fr.utbm.info.ia54.antcolony.model.Environment;
import fr.utbm.info.ia54.antcolony.model.Metrics;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.application.Platform;

public class Display{
	
	private Environment environment;
	private Metrics metrics;
	private boolean debug;
	
	public void changeDisplayFrameTitle(String title)
	{
		Platform.runLater(new Runnable() {
            @Override
            public void run() {
            	Main.getStage().setTitle(title);
            }
        });
	}
	
	public void changeDisplayFrameSize(Integer width, Integer height)
	{
		Platform.runLater(new Runnable() {
            @Override
            public void run() {
            	Main.getStage().setWidth(width);
            	Main.getStage().setHeight(height);
            	Main.getStage().centerOnScreen();
            }
        });
	}

    public void displaySimulationFrame() {

    	//I dont get it but somehow if I dont include the group stuff here I get errors in the console
    	Platform.runLater(new Runnable() {
            @Override
            public void run() {
    	
    	Group g = new Group();

    	//Things to display

    	g.getChildren().addAll(environment.getCitiesRepresentation());
    	g.getChildren().addAll(environment.getCitiesNames());
    	g.getChildren().addAll(environment.getRoadsRepresentation());
    	
    	if(debug)
    	{
        	g.getChildren().addAll(environment.getRoadsWeights());
    	}

    	//Also display some metrics & stats
    	g.getChildren().addAll(metrics.getMetrics());
    	
    	
    	//Assuming stuff is already being displayed
        //stage.show();
    	
        Scene scene=new Scene(g, Screen.getPrimary().getBounds().getWidth()*3/4, Screen.getPrimary().getBounds().getHeight()*3/4);
        
        
            	Main.getStage().setScene(scene);
            }
        });
    }

	public Display(Environment environment, Metrics metrics) {
		this.environment = environment;
		this.metrics = metrics;
		this.debug=true;
	}
}