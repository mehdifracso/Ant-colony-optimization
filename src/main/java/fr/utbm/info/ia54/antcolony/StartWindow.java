package fr.utbm.info.ia54.antcolony;

import fr.utbm.info.ia54.antcolony.model.DeathAgent;
import fr.utbm.info.ia54.antcolony.model.MainAgent;
import io.sarl.bootstrap.SRE;
import io.sarl.bootstrap.SREBootstrap;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StartWindow extends Application{
	
	static private Stage stage;
	
	//Items to put on the screen
	private Scene s;
	private VBox layout;
	private Button startButton;
	private CheckBox defaultMapCheckBox;
	private CheckBox debugModeCheckBox;
	/*
	private CheckBox benchesCheckBox;
	private CheckBox exitCheckBox;
	private Slider agentsDelaySlider;
	private Slider agentsSimultaneousSlider;
	private Slider agentsTotalSlider;
	private  Label agentsDelayLabel;
	private  Label agentsSimultaneousLabel;
	private  Label agentsTotalLabel;
	*/
	
	public static void main(String[]args) {
		Application.launch(args);
	}
	
	/*
	//Pass instructions you need to pass to the main agent like so
	public static void spawnMainAgent(boolean pillars, boolean benches, boolean randomExit, double agentsDelay, int agentsSimultaneous, int agentsTotal) throws Exception {
		SREBootstrap bootstrap = SRE.getBootstrap();
		bootstrap.startAgent(MainAgent.class, pillars, benches, randomExit, agentsDelay, agentsSimultaneous, agentsTotal);
	}
	*/
	
	public static void spawnMainAgent(boolean isDefaultMap, boolean isDebugMode) throws Exception {
		SREBootstrap bootstrap = SRE.getBootstrap();
		bootstrap.startAgent(MainAgent.class, isDefaultMap, isDebugMode);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		StartWindow.stage=primaryStage;
		primaryStage.setWidth(700);
		primaryStage.setHeight(700);
		primaryStage.setTitle("Launching options");
		
		layout = new VBox();
		layout.setSpacing(20);
		
		startButton = new Button("Start Colony");
		
		startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	try {
            		/*
            		init stuff here
            		boolean benches = benchesCheckBox.isSelected();
            		boolean randomExit = exitCheckBox.isSelected();
            		double agentsDelay =  agentsDelaySlider.getValue();
            		int agentsSimultaneous =  (int) agentsSimultaneousSlider.getValue();
            		int agentsTotal =  (int) agentsTotalSlider.getValue();
            		*/

            		boolean isDefaultMap = defaultMapCheckBox.isSelected();
            		boolean isDebugMode = debugModeCheckBox.isSelected();
            		//Pass stuff here as well
					StartWindow.spawnMainAgent(isDefaultMap, isDebugMode);
				} catch (Exception e) {
					e.printStackTrace();
				}
            }
        });

		defaultMapCheckBox = new CheckBox("Default Map");
		defaultMapCheckBox.setSelected(true);
		debugModeCheckBox = new CheckBox("Debug Mode");
		debugModeCheckBox.setSelected(true);
		/*
		benchesCheckBox = new CheckBox("Benches");
		benchesCheckBox.setSelected(true);
		exitCheckBox = new CheckBox("Random exit");
		agentsDelaySlider = new Slider();
		agentsDelaySlider.setMin(0.1);
		agentsDelaySlider.setMax(5);
		agentsDelaySlider.setValue(2); 
		agentsDelaySlider.setBlockIncrement(0.1);
		
		agentsDelayLabel = new Label("Agent spawn delay : " + agentsDelaySlider.getValue() + " seconds");
		
		agentsDelaySlider.valueProperty().addListener( 
	             new ChangeListener<Number>() { 
	  
	            public void changed(ObservableValue <? extends Number >  
	                      observable, Number oldValue, Number newValue) 
	            { 
	            	DecimalFormatSymbols symbols = new DecimalFormatSymbols();
	            	symbols.setDecimalSeparator('.');
	            	DecimalFormat dec = new DecimalFormat("#0.0", symbols);
	            	
	            	double val = Double.parseDouble(dec.format(newValue.doubleValue()));
	            	
	            	agentsDelaySlider.setValue(val);
	                agentsDelayLabel.setText("Agent spawn delay: " + val + " seconds"); 
	            }
	    });
		
		agentsSimultaneousSlider = new Slider();
		agentsSimultaneousSlider.setMin(1);
		agentsSimultaneousSlider.setMax(5000);
		agentsSimultaneousSlider.setValue(50); 
		
		agentsSimultaneousLabel = new Label("Amount of simulateneous agents : " + (int)agentsSimultaneousSlider.getValue());
		
		agentsSimultaneousSlider.valueProperty().addListener( 
	             new ChangeListener<Number>() { 
	  
	            public void changed(ObservableValue <? extends Number >  
	                      observable, Number oldValue, Number newValue) 
	            { 
	            	
	            	agentsSimultaneousSlider.setValue(Math.round(newValue.doubleValue()));
	            	agentsSimultaneousLabel.setText("Amount of simulateneous agents: " + Math.round(newValue.doubleValue())); 
	            }
	    });
		
		agentsTotalSlider = new Slider();
		agentsTotalSlider.setMin(1);
		agentsTotalSlider.setMax(5000);
		agentsTotalSlider.setValue(100); 
		
		agentsTotalLabel = new Label("Amount of total agents to spawn : " + (int)agentsTotalSlider.getValue());
		
		agentsTotalSlider.valueProperty().addListener( 
	             new ChangeListener<Number>() { 
	  
	            public void changed(ObservableValue <? extends Number >  
	                      observable, Number oldValue, Number newValue) 
	            { 
	            	agentsTotalSlider.setValue(Math.round(newValue.doubleValue()));
	            	agentsTotalLabel.setText("Amount of total agents to spawn : " + Math.round(newValue.doubleValue())); 
	            }
	    });
		
		layout.getChildren().add(benchesCheckBox);
		layout.getChildren().add(exitCheckBox);
		layout.getChildren().add(agentsDelaySlider);
		layout.getChildren().add(agentsDelayLabel);
		layout.getChildren().add(agentsSimultaneousSlider);
		layout.getChildren().add(agentsSimultaneousLabel);
		layout.getChildren().add(agentsTotalSlider);
		layout.getChildren().add(agentsTotalLabel);
		*/
		layout.getChildren().add(defaultMapCheckBox);
		layout.getChildren().add(debugModeCheckBox);
		layout.getChildren().add(startButton);
		
		layout.setAlignment(Pos.CENTER); 
		
		s = new Scene(layout, 600, 600);
		primaryStage.setScene(s);
		
		primaryStage.show();
	}

	public static Stage getStage() {
		return stage;
	}
	
	@Override
	public void stop()throws Exception {
	    System.out.println("Closing application");
	    
	    SREBootstrap bootstrap = SRE.getBootstrap();
		bootstrap.startAgent(DeathAgent.class);
	}
}
