package com.mycompany.a2;

import com.codename1.ui.Form;


import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.Container;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Component;
import com.codename1.ui.layouts.BoxLayout;


import java.lang.String;

public class Game extends Form {
	//a2 now has scoreview and mapview to help the observers get notified of changes
	private GameWorld gw;
	private MapView mv;
	private ScoreView sv;
//	private boolean flagCheck = false;
	
	/**
	 * Instantiates a new game.
	 */
	public Game() {
		//new A2 initalizations in the constructor to register new observers
		gw = new GameWorld();
		
		mv = new MapView();
		sv = new ScoreView();
		gw.addObserver(mv);
		gw.addObserver(sv);
		this.setLayout(new BorderLayout());
		
		gw.init();
		
		
		
		
		//the next part here is going to create a bunch of containers and add buttons
		//will also implement the toolbar
		//container of the BoxLayout for the west side
		Container leftContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
		// create accelerate button and set all the styles to it along with the action listeners for the command pattern
		Button accelButton = new Button("Accelerate");
		
		AccelerateCommand accel = new AccelerateCommand(gw);
		accelButton.setCommand(accel);
		addKeyListener('a', accel);
		leftContainer.add(accelButton);
		leftContainer.getAllStyles().setPadding(Component.TOP, 50);
		
		accelButton.getAllStyles().setPadding(TOP, 5);
		accelButton.getAllStyles().setPadding(BOTTOM, 5);
		accelButton.getAllStyles().setBgTransparency(255);
		accelButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		accelButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		accelButton.getAllStyles().setBorder(Border.createLineBorder(5, ColorUtil.BLACK));
		
		//left turn button and style 
		Button leftButton = new Button("Left");
		LeftCommand left = new LeftCommand(gw);
		leftButton.setCommand(left);
		addKeyListener('l', left);
		leftContainer.add(leftButton);
		leftContainer.getAllStyles().setPadding(Component.TOP, 50);
		
		leftButton.getAllStyles().setPadding(TOP, 5);
		leftButton.getAllStyles().setPadding(BOTTOM, 5);
		leftButton.getAllStyles().setBgTransparency(255);
		leftButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		leftButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		leftButton.getAllStyles().setBorder(Border.createLineBorder(5, ColorUtil.BLACK));
		
		//goes into the west container 
		add(BorderLayout.WEST, leftContainer);
		
		//code for the right container intiated as a box layout like before
		Container rightContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
		
		//brake button with style 
		Button brakeButton = new Button("Brake");
		BrakeCommand brake = new BrakeCommand(gw);
		brakeButton.setCommand(brake);
		addKeyListener('b', brake);
		rightContainer.add(brakeButton);
		brakeButton.getAllStyles().setPadding(Component.TOP, 50);
		
		brakeButton.getAllStyles().setPadding(TOP, 5);
		brakeButton.getAllStyles().setPadding(BOTTOM, 5);
		brakeButton.getAllStyles().setBgTransparency(255);
		brakeButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		brakeButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		brakeButton.getAllStyles().setBorder(Border.createLineBorder(5, ColorUtil.BLACK));
		
		//Right button with style 
		Button rightButton = new Button("Right");
		RightCommand right = new RightCommand(gw);
		rightButton.setCommand(right);
		addKeyListener('r', right);
		rightContainer.add(rightButton);
		rightButton.getAllStyles().setPadding(Component.TOP, 50);
		
		rightButton.getAllStyles().setPadding(TOP, 5);
		rightButton.getAllStyles().setPadding(BOTTOM, 5);
		rightButton.getAllStyles().setBgTransparency(255);
		rightButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		rightButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		rightButton.getAllStyles().setBorder(Border.createLineBorder(5, ColorUtil.BLACK));
		
		//adds them to the east container
		add(BorderLayout.EAST, rightContainer);
		
		Container bottomContainer = new Container(new FlowLayout(Component.CENTER));
		
		//flag collision button with style
		Button flagButton = new Button("Collide with Flag");
		FlagCommand flag = new FlagCommand(gw);
		flagButton.setCommand(flag);
		bottomContainer.add(flagButton);
		flagButton.getAllStyles().setPadding(Component.TOP, 50);
		
		flagButton.getAllStyles().setPadding(TOP, 5);
		flagButton.getAllStyles().setPadding(BOTTOM, 5);
		flagButton.getAllStyles().setBgTransparency(255);
		flagButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		flagButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		flagButton.getAllStyles().setBorder(Border.createLineBorder(5, ColorUtil.BLACK));
		
		//spider collision with style
		Button spiderButton = new Button("Collide with Spider");
		SpiderCommand spider = new SpiderCommand(gw);
		spiderButton.setCommand(spider);
		addKeyListener('g', spider);
		bottomContainer.add(spiderButton);
		spiderButton.getAllStyles().setPadding(Component.TOP, 50);
		
		spiderButton.getAllStyles().setPadding(TOP, 5);
		spiderButton.getAllStyles().setPadding(BOTTOM, 5);
		spiderButton.getAllStyles().setBgTransparency(255);
		spiderButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		spiderButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		spiderButton.getAllStyles().setBorder(Border.createLineBorder(5, ColorUtil.BLACK));
		//food station collision with style
		Button foodButton = new Button("Collide with Food Station");
		FoodCommand food = new FoodCommand(gw);
		foodButton.setCommand(food);
		addKeyListener('f', food);
		bottomContainer.add(foodButton);
		foodButton.getAllStyles().setPadding(Component.TOP, 50);
		
		foodButton.getAllStyles().setPadding(TOP, 5);
		foodButton.getAllStyles().setPadding(BOTTOM, 5);
		foodButton.getAllStyles().setBgTransparency(255);
		foodButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		foodButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		foodButton.getAllStyles().setBorder(Border.createLineBorder(5, ColorUtil.BLACK));
		
		//Clock tick with style
		Button tickButton = new Button("Tick");
		TickCommand tick = new TickCommand(gw);
		tickButton.setCommand(tick);
		addKeyListener('t', tick);
		bottomContainer.add(tickButton);
		tickButton.getAllStyles().setPadding(Component.TOP, 50);
		
		tickButton.getAllStyles().setPadding(TOP, 5);
		tickButton.getAllStyles().setPadding(BOTTOM, 5);
		tickButton.getAllStyles().setBgTransparency(255);
		tickButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		tickButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		tickButton.getAllStyles().setBorder(Border.createLineBorder(5, ColorUtil.BLACK));
		
		//adds them to the south component
		add(BorderLayout.SOUTH, bottomContainer);
		
		//exit, about , help and the sound check box buttons are created with style then added to the toolbar
		
		ExitCommand exit = new ExitCommand(gw);
		AboutCommand about = new AboutCommand(gw);
		HelpCommand help = new HelpCommand(gw);
		CheckBox sound = new CheckBox("Sound");
		SoundCommand soundCmd = new SoundCommand(gw, sound);
		sound.setCommand(soundCmd);
		sound.getAllStyles().setBgTransparency(255);
		sound.getAllStyles().setBgColor(ColorUtil.GRAY);
		//container for toolbar
		Toolbar myToolbar = new Toolbar();
		setToolbar(myToolbar);
			
		//this is the title of the game 
		myToolbar.setTitle("The Path Game");
		myToolbar.getAllStyles().setBgColor(ColorUtil.BLUE);
		//adds the commands to the side menu and help goes on the right side of the bar		
		myToolbar.addCommandToSideMenu(accel);
		myToolbar.addCommandToSideMenu(exit);
		myToolbar.addCommandToSideMenu(about);
		myToolbar.addComponentToSideMenu(sound);
		myToolbar.addCommandToRightBar(help);
		
		
		
		
		
		//map and scorview are added into the boder layout
		add(BorderLayout.NORTH, sv);
		add(BorderLayout.CENTER, mv);
		
		
		
		//observers are notified of the chages made by invoking the commands 
		gw.notifyObservers();
		//will show everything to the screen
		this.show();
		
		//sets the height and width of to the map value
		gw.setHeight(mv.getHeight());
		gw.setWidth(mv.getWidth());
		//play();
		
		
	}
}
	
	
	
	
	
	

	/**
	 * Play.
	 */
//	private void play() {
//		//instantiates new label to enter command
//		//then adds component
//		Label myLabel = new Label("Enter a Command: ");
//		this.addComponent(myLabel);
//		final TextField myTextField = new TextField();
//		this.addComponent(myTextField);
//		this.show();
//		
//		myTextField.addActionListener(new ActionListener() {
//			
//			/**
//			 * Action performed is a listener that uses a switch statement that grab the input from the user so that 
//			 * the appropriate action is performed
//			 *
//			 * @param evt the evt
//			 */
//			public void actionPerformed(ActionEvent evt) {
//				String sCommand = myTextField.getText().toString();
//				myTextField.clear();
//				if(sCommand.length() != 0)
//					switch(sCommand.charAt(0)) {
//					case 'a':
//						gw.accelerate();
//						break;
//					case 'b':
//						gw.brake();
//						break;
//					case 'l':
//						gw.turnLeft();
//						break;
//					case 'r': 
//		                gw.turnRight();
//		                break;
////					case '1':
////						gw.flagCollision('number');
////						break;
//		            case 'f': 
//		                gw.foodStationCollision();
//		                break;
//		            case 'g': 
//		                gw.spiderCollision();
//		                break;
//		            case't':
//		            	gw.gameClockTick();
//		            	break;
//		            case'd':
//		            	gw.display();
//		            	break;
//		            case 'm': 
//		                gw.map();
//		                break;
//		            case 'x': //this case performs the boolean function and asks for an input from the user to see if the game will be closed
//		            	System.out.println("Would you like to quit? Input y for yes n for no");
//			             flagCheck = true;
//		                break;
//		            case 'y': 
//		            	if(flagCheck == true)  
//		                System.exit(0);
//		                break;
//		            case 'n': 
//		                if(flagCheck == false)
//		                	flagCheck = true;
//		                break;	
//		            default: //tells the user that no command was entered 
//		                System.out.println("no command entered");
//		                break;
//					}
//			
//			}
//		}
//		);
//	}
//}
