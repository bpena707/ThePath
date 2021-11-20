package com.mycompany.a3;

import com.codename1.ui.Form;



import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.util.UITimer;
import com.codename1.ui.Container;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.layouts.BoxLayout;


import java.lang.String;

public class Game extends Form implements Runnable{
	//a2 now has scoreview and mapview to help the observers get notified of changes
	private GameWorld gw;
	private MapView mv;
	private ScoreView sv;
	
	private AccelerateCommand accel;
	private Button accelButton;
	private BrakeCommand brake;
	private Button brakeButton;
	private RightCommand right;
	private Button rightButton;
	private Button leftButton;
	private LeftCommand left;
	private boolean pause;
	private Button pauseButton;
	private Button positionButton;
	
	private UITimer timer;
	private PositionCommand position;
	//private BGSound bg;


	
	/**
	 * Instantiates a new game.
	 */
	public Game() {
		//new A2 initalizations in the constructor to register new observers
		gw = new GameWorld();
		
		mv = new MapView(gw, this);
		sv = new ScoreView();
		gw.addObserver(mv);
		gw.addObserver(sv);
		this.setLayout(new BorderLayout());
		

		
		
		
		
		//the next part here is going to create a bunch of containers and add buttons
		//will also implement the toolbar
		//container of the BoxLayout for the west side
		Container leftContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
		// create accelerate button and set all the styles to it along with the action listeners for the command pattern
		accelButton = new Button("Accelerate");
		
		accel = new AccelerateCommand(gw);
		accelButton.setCommand(accel);
//		addKeyListener('a', accel);
		leftContainer.add(accelButton);
		leftContainer.getAllStyles().setPadding(Component.TOP, 50);
		
		accelButton.getAllStyles().setPadding(TOP, 5);
		accelButton.getAllStyles().setPadding(BOTTOM, 5);
		accelButton.getAllStyles().setBgTransparency(255);
		accelButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		accelButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		accelButton.getAllStyles().setBorder(Border.createLineBorder(5, ColorUtil.BLACK));
		
		//left turn button and style 
		leftButton = new Button("Left");
		left = new LeftCommand(gw);
		leftButton.setCommand(left);
//		addKeyListener('l', left);
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
		brakeButton = new Button("Brake");
		brake = new BrakeCommand(gw);
		brakeButton.setCommand(brake);
//		addKeyListener('b', brake);
		rightContainer.add(brakeButton);
		brakeButton.getAllStyles().setPadding(Component.TOP, 50);
		
		brakeButton.getAllStyles().setPadding(TOP, 5);
		brakeButton.getAllStyles().setPadding(BOTTOM, 5);
		brakeButton.getAllStyles().setBgTransparency(255);
		brakeButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		brakeButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		brakeButton.getAllStyles().setBorder(Border.createLineBorder(5, ColorUtil.BLACK));
		
		//Right button with style 
		rightButton = new Button("Right");
		right = new RightCommand(gw);
		rightButton.setCommand(right);
//		addKeyListener('r', right);
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
		
		this.pause = false;
		pauseButton = new Button("Pause");
		PauseCommand pause = new PauseCommand(this);
		pauseButton.setCommand(pause);

		
		bottomContainer.add(pauseButton);
		pauseButton.getAllStyles().setPadding(Component.TOP, 50);
		
		pauseButton.getAllStyles().setPadding(TOP, 5);
		pauseButton.getAllStyles().setPadding(BOTTOM, 5);
		pauseButton.getAllStyles().setBgTransparency(255);
		pauseButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		pauseButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		pauseButton.getAllStyles().setBorder(Border.createLineBorder(5, ColorUtil.BLACK));
		
		positionButton = new Button("Position");
		position = new PositionCommand(this, this.mv);
		positionButton.setCommand(position);

		
		bottomContainer.add(positionButton);
		positionButton.getAllStyles().setPadding(Component.TOP, 50);
		
		positionButton.getAllStyles().setPadding(TOP, 5);
		positionButton.getAllStyles().setPadding(BOTTOM, 5);
		positionButton.getAllStyles().setBgTransparency(255);
		positionButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		positionButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		positionButton.getAllStyles().setBorder(Border.createLineBorder(5, ColorUtil.BLACK));
		
		
		
		
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
		gw.init();
		this.show();
//		
//		gw.createSound();
//		revalidate();
		
		
		timer = new UITimer(this);
//		timer.schedule(100, true, this);
		//sets the height and width of to the map value
		gw.setHeight(mv.getHeight());
		gw.setWidth(mv.getWidth());
		play();
		
		

		
	}


	
	



	public void run() {
		Dimension dCmpSize = new Dimension(mv.getWidth(), mv.getHeight());
		
		gw.gameClockTick(dCmpSize, 100);
		
		gw.notifyObservers();
		
	}
	
	public boolean isPaused() {
		return pause;
		
	}
	
	public void setPause(boolean pause) {
		this.pause = pause;
	}
	
	
	
	public void play() {
		
		timer.schedule(20, true, this);
//		if(gw.getSound()){
//			gw.getBackGround().play();
//		}
		
		pauseButton.setText("Pause");
		
		this.setPause(false);
		
		addKeyListener('a', accel);
		addKeyListener('b', brake);
		addKeyListener('l', left);
		addKeyListener('r', right);
		
		accelButton.setEnabled(true);
		brakeButton.setEnabled(true);
		rightButton.setEnabled(true);
		leftButton.setEnabled(true);
		
		this.setPause(false);
		
		//position is false

	}



public void pause(){
		
		timer.cancel();
		
//		gw.getBackGround().pause();
		
		pauseButton.setText("Play");
		
		
		
		this.setPause(true);
		
		accelButton.setEnabled(false);
		brakeButton.setEnabled(false);
		rightButton.setEnabled(false);
		leftButton.setEnabled(false);
		
		
		removeKeyListener('a', accel);
		removeKeyListener('b', brake);
		removeKeyListener('l', left);
		removeKeyListener('r', right);
		addKeyListener('o', position);
		
		position.setEnabled(true);
		positionButton.setEnabled(true);
		
		
		pauseButton.setText("Play");
		this.setPause(true);
		
		
	}
	

	
	
	
}


	
	
	
	
	
	

	