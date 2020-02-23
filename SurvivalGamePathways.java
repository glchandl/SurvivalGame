import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.EventHandler;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SurvivalGamePathways extends Application implements ActionListener  {
SurvivalGame survive = new SurvivalGame();
int width = 800;
int height = 700;
Text night = new Text(20,20,"");
String nightWeather;
String nightShip;
String nightEvents;
String dam="";
Text damage = new Text(20,20,"");
Text beachingMessage ;

Button shelter = new Button("Shelter");
Button d1Debris = new Button("Inventory Wreckage");
Button fire = new Button("Fire");
Button helpMessage = new Button("Help Message");
Button shelterContinue = new Button("Continue");
        Button shelter1 = new Button("Shelter");
        Button d1Debris1 = new Button("Inventory Wreckage");
        Button fire1 = new Button("Fire");
        Button helpMessage1 = new Button("Help Message");
        Button shelterContinue1 = new Button("Continue");
        Text anima;
        String anim;
        Button end = new Button("End");



private Pane isDead(Pane p){
        Pane r;
        if(survive.isAlive()){
              r =   p;
        }
        else{
                end.relocate(400,300);
                Text yeet = new Text(20,20,survive.getTheEnd()); yeet.setFont(Font.font("Ink Free", 38));
                r = new Pane(yeet, end);
        }
        return r;
}


private HBox makeProgressBar(){
        HBox progressBar = new HBox();
        Text water = new Text("           Water: " + survive.getWater()) ;
        Text food = new Text("           Food: " + survive.getFood());
        Text exposure = new Text("           Exposure: " + survive.getExposure()) ;
        Text injury = new Text("           Injury: " + survive.getInjury());
        progressBar.getChildren().addAll(water, food, exposure, injury);
        return progressBar;
}
private BorderPane makeBorderPane(){
                BorderPane border = new BorderPane();
                return border;
        }
        BorderPane border9 = makeBorderPane();
private Text nightText(){

        return new Text(20,20,"Night has fallen. "+ nightEvents);
}
private Text beachText(){
        return new Text(20,20,"What would you like to work on? ");
}

private Pane setBeach(){
        HBox beach = new HBox(30);
        if(!survive.getShelter()){
                beach.getChildren().add(shelter1);
        }
        if(!survive.getFire()){
                beach.getChildren().add(fire1);
        }
        if(!survive.getHelpMessage()){
                beach.getChildren().add(helpMessage1);
        }


        if(!survive.getDebrisChecked() && survive.getHelpMessage() && survive.getFire() && survive.getShelter()){
               beach.getChildren().add(shelterContinue1);
               beachingMessage.setText("There is nothing to work on.  You just wasted an entire day.");
        }
        beach.relocate(250,400);
        Pane beachPane = new Pane(beachText(), beach);
        beachPane.setMinSize(width,height);
        return beachPane;
}


    public void start(Stage primaryStage) throws Exception {

                BorderPane border = makeBorderPane();
                border.setOnMouseMoved(event -> border.setBottom(makeProgressBar()));



            BorderPane border1 = makeBorderPane();
            border1.setOnMouseMoved(event -> border1.setBottom(makeProgressBar()));


            BorderPane border2 = makeBorderPane();
            border2.setOnMouseMoved(event -> border2.setBottom(makeProgressBar()));


            BorderPane border3 = makeBorderPane();
            border3.setOnMouseMoved(event -> border3.setBottom(makeProgressBar()));


            BorderPane border4 = makeBorderPane();
            border4.setOnMouseMoved(event -> border4.setBottom(makeProgressBar()));


            BorderPane border5 = makeBorderPane();
            border5.setOnMouseMoved(event -> border5.setBottom(makeProgressBar()));


            BorderPane border6 = makeBorderPane();
            border6.setOnMouseMoved(event ->  border6.setBottom(makeProgressBar()));


            BorderPane border7 = makeBorderPane();
            border7.setOnMouseMoved(event -> border7.setBottom(makeProgressBar()));


            BorderPane border8 = makeBorderPane();
            border8.setOnMouseMoved(event -> border8.setBottom(makeProgressBar()));



            border9.setOnMouseMoved(event -> border9.setBottom(makeProgressBar()));


            BorderPane border10 = makeBorderPane();
            border10.setOnMouseMoved(event ->  border10.setBottom(makeProgressBar()));


            BorderPane border11 = makeBorderPane();
            border11.setOnMouseMoved(event -> border11.setBottom(makeProgressBar()));

            BorderPane border12 = makeBorderPane();
            border12.setOnMouseMoved(event -> border12.setBottom(makeProgressBar()));

            Text night = nightText();
            night.setOnMouseMoved(event -> night.setText("Night has fallen"+nightEvents));

            Pane beach1 = setBeach();
            //beach1.setOnMouseMoved(event -> {border12.setCenter(setBeach()); });


            Text anima = new Text(20,20,"");
            anima.setOnMouseMoved(event -> anima.setText(survive.getWoods()));

            BorderPane border13 = makeBorderPane();
            border13.setOnMouseMoved(event -> border13.setBottom(makeProgressBar()));

            BorderPane border14 = makeBorderPane();
            border14.setOnMouseMoved(event -> border14.setBottom(makeProgressBar()));


//Start Pane
            Text startMessage = new Text(130, 200, "Choose Your Own Survival");
            startMessage.setFont(Font.font("Ink Free", FontWeight.BOLD, 50));
            startMessage.setStroke(Color.RED);
            Button startButton = new Button("Start");
            startButton.relocate(390, 400);
            Pane back = new Pane(startMessage, startButton);

            //Starts,

            back.setMinSize(width, height);
            Scene startScreen = new Scene(back);
            primaryStage.setScene(startScreen);
            primaryStage.show();


//Crash Pane
            Text crashMessage = new Text(20, 20, "Boom! One of the engines of your airplane explodes! \nYou look around, and see only " +
                    "ocean. \nWait, there! An island! \nYou quickly navigate your rapidly descending " +
                    "plane to the island, and make an emergency landing. \nYou climb out of the smoking wreckage and " +
                    "look around. \nYou see the beach that you landed on, a forest to the right, and a rocky area to the " +
                    "left.");
            Button crashContinue = new Button("Continue");
            crashContinue.relocate(390, 400);

            Pane crashPane = new Pane(crashMessage, crashContinue);
            crashPane.setMinSize(width, height);
            border.setCenter(crashPane);
            border.setBottom(makeProgressBar());
            Scene crashScene = new Scene(border);
//Day 1 Choice 1 Pane
            Text d1Message = new Text(20, 20, "You look around at your surroundings, " +
                    "and realize you have a decision to make. \nYou can either choose to explore the island, " +
                    "or look through the wreckage of your airplane. \n Which do you do?");
            Button d1Explore = new Button("Explore");
            d1Explore.relocate(250, 400);
            d1Debris.relocate(450, 400);
            Pane d1c1Pane = new Pane(d1Message, d1Debris, d1Explore);
            d1c1Pane.setMinSize(width, height);
            border1.setCenter(d1c1Pane);
            border1.setBottom(makeProgressBar());
            Scene d1c1Scene = new Scene(border1);

//Day 1 Explore 1 Pane
            Text exploreMessage = new Text(20, 20, "You can either head to the rocky area or the forest. \nWhich way do you go?");
            Button forest = new Button("Toward the forest");
            forest.relocate(250, 400);
            Button rocks = new Button("Toward the rocks");
            rocks.relocate(450, 400);
            Pane explorePane = new Pane(exploreMessage, forest, rocks);
            explorePane.setMinSize(width, height);
            border2.setCenter(explorePane);
            border2.setBottom(makeProgressBar());
            Scene d1e1Scene = new Scene(border2);

//Day 1 Debris Inventory Pane
            survive.setCrash();
            String crashSupplies = survive.getCrash();
            Text debrisMessage = new Text(20, 20, "You look through the wreckage and find " + crashSupplies);
            Button d1dContinue = new Button("Continue");
            d1dContinue.relocate(390, 400);
            Pane d1dPane = new Pane(debrisMessage, d1dContinue);
            d1dPane.setMinSize(width, height);
            border3.setCenter(d1dPane);
            border3.setBottom(makeProgressBar());
            Scene d1dScene = new Scene(border3);

//Debris Pane
            Text debrisMessage1 = new Text(20, 20, "You look through the wreckage and find " + crashSupplies);
            Button debrisContinue = new Button("Continue");
            debrisContinue.relocate(390,400);
            Pane debrisPane = new Pane(debrisMessage1, debrisContinue);
            debrisPane.setMinSize(width,height);
            border14.setCenter(debrisPane);
            border14.setBottom(makeProgressBar());
            Scene debrisScene = new Scene(border14);


//Day 1 Choice 2
            Text d1ciiMessage = new Text(20, 20, "The sun is getting close to the horizon. \nYou can either build a fire or a shelter.");
            fire.relocate(250, 400);
            shelter.relocate(450, 400);
            Pane d1ciiPane = new Pane(d1ciiMessage, fire, shelter);
            d1ciiPane.setMinSize(width, height);
            border4.setBottom(makeProgressBar());
            border4.setCenter(d1ciiPane);
            Scene d1ciiScene = new Scene(border4);

//Make Fire
            Text fireMessage = new Text(20, 20, "You successfully built a fire!");
            Button fireContinue = new Button("Continue");
            fireContinue.relocate(390, 400);
            Pane firePane = new Pane(fireMessage, fireContinue);
            firePane.setMinSize(width, height);
            border5.setCenter(firePane);
            border5.setBottom(makeProgressBar());
            Scene fireScene = new Scene(border5);

//Make Shelter
            Text shelterMessage = new Text(20, 20, "You successfully built a shelter!");
            shelterContinue.relocate(390, 400);
            Pane shelterPane = new Pane(shelterMessage, shelterContinue);
            shelterPane.setMinSize(width, height);
            border6.setCenter(shelterPane);
            border6.setBottom(makeProgressBar());
            Scene shelterScene = new Scene(border6);

//Explore Forest
            Text forestMessage = new Text(20, 20, anim);
            Button forestContinue = new Button("Continue");
            forestContinue.relocate(390, 400);
            Pane forestPane = new Pane(anima, forestContinue);
            forestPane.setMinSize(width, height);
            border7.setCenter(forestPane);
            border7.setBottom(makeProgressBar());
            Scene forestScene = new Scene(border7);

//Explore Rocks
            Text rockMessage = new Text(20, 20, "You get some water from a freshwater spring that is running though the rocks." +
                    " \nYou get a little hurt from climbing around on the rocks.");
            Button rockContinue = new Button("Continue");
            rockContinue.relocate(390, 400);
            Pane rockPane = new Pane(rockMessage, rockContinue);
            rockPane.setMinSize(width, height);

            border8.setCenter(rockPane);
            border8.setBottom(makeProgressBar());
            Scene rockScene = new Scene(border8);

//Night Falls

            Text nightMessage = night;
            Button nightContinue = new Button("Continue");
            nightContinue.relocate(390, 400);
            Pane nightPane = new Pane(night, damage, nightContinue);
            nightPane.setMinSize(width, height);
            border9.setCenter(nightPane);
            border9.setBottom(makeProgressBar());
            Scene nightScene = new Scene(isDead(border9));

//Morning
            Text morningMessage = new Text(20, 20, "Good morning! It looks like a great day to do something that will either " +
                    "\nreplenish your food or water (Explore) \nor increase your changes of being rescued (Beach Project)");
            Button explore = new Button("Explore");
            explore.relocate(250, 400);
            Button beach = new Button("Beach Project");
            beach.relocate(450, 400);

            Pane morningPane = new Pane(morningMessage, explore, beach);
            morningPane.setMinSize(width, height);
            border10.setCenter(morningPane);
            border10.setBottom(makeProgressBar());
            Scene morningScene = new Scene(border10);

//Exploring!
            Text exploringMessage = new Text(20, 20, "You can either head to the rocky area or the forest. \nWhich way do you go?");
            Button forest1 = new Button("Toward the forest");
            forest1.relocate(250, 400);
            Button rocks1 = new Button("Toward the rocks");
            rocks1.relocate(450, 400);
            Pane exploringPane = new Pane(exploringMessage, forest1, rocks1);
            exploringPane.setMinSize(width, height);
            border11.setCenter(exploringPane);
            border11.setBottom(makeProgressBar());
            Scene exploreScene = new Scene(isDead(border11));

//Beaching
            beach1.relocate(100,100);
            //Pane beachingPane = new Pane(beachingMessage, beach1);
            beach1.setMinSize(width,height);
            border12.setCenter(beach1);
            border12.setBottom(makeProgressBar());
            Scene beachingScene = new Scene(isDead(border12));

//Make Shelter
            Text helpMessage = new Text(20, 20, "You successfully built a help message!");
            Button helpContinue = new Button("Continue");
            helpContinue.relocate(390, 400);
            Pane helpPane = new Pane(helpMessage, helpContinue);
            helpPane.setMinSize(width, height);
            border13.setCenter(helpPane);
            border13.setBottom(makeProgressBar());
            Scene helpScene = new Scene(isDead(border13));



            startButton.setOnMouseClicked(event -> { primaryStage.setScene(crashScene); });
            crashContinue.setOnMouseClicked(event -> { primaryStage.setScene(d1c1Scene);});
            d1Explore.setOnMouseClicked(event -> { primaryStage.setScene(d1e1Scene);});
            d1Debris.setOnMouseClicked(event -> {primaryStage.setScene(d1dScene); survive.setWater(50); survive.setDebrisChecked(true);});
            forest.setOnMouseClicked(event -> {survive.Woods();  primaryStage.setScene(forestScene); anima.setText(survive.getWoods());});
            rocks.setOnMouseClicked(event -> { survive.Rocks(); primaryStage.setScene(rockScene); });
            rockContinue.setOnMouseClicked(event -> { primaryStage.setScene(d1ciiScene);});
            forestContinue.setOnMouseClicked(event -> { primaryStage.setScene(d1ciiScene);});
            shelter.setOnMouseClicked(event -> { primaryStage.setScene(shelterScene);survive.setShelter(true);});
            fire.setOnMouseClicked(event -> { primaryStage.setScene(fireScene);survive.setFire(true);});
            fireContinue.setOnMouseClicked(event -> {nightEvents = survive.dayPasses();night.setText("Night has fallen"+nightEvents); primaryStage.setScene(nightScene); });
            shelterContinue.setOnMouseClicked(event -> {nightEvents = survive.dayPasses();night.setText("Night has fallen"+nightEvents);primaryStage.setScene(nightScene); });
            nightContinue.setOnMouseClicked(event -> {primaryStage.setScene(morningScene);});
            explore.setOnMouseClicked(event -> {primaryStage.setScene(exploreScene);});
            d1dContinue.setOnMouseClicked(event -> primaryStage.setScene(d1ciiScene));
            beach.setOnMouseClicked(event -> {primaryStage.setScene(beachingScene);});
            shelter1.setOnMouseClicked(event -> {primaryStage.setScene(shelterScene);survive.setShelter(true);});
            fire1.setOnMouseClicked(event -> {primaryStage.setScene(fireScene);survive.setFire(true);});
            d1Debris1.setOnMouseClicked(event -> {primaryStage.setScene(debrisScene);survive.setWater(50); survive.setDebrisChecked(true);});
            helpMessage1.setOnMouseClicked(event -> {primaryStage.setScene(helpScene);survive.setHelpMessage(true);});
            helpContinue.setOnMouseClicked(event -> {nightEvents = survive.dayPasses();night.setText("Night has fallen"+nightEvents);primaryStage.setScene(nightScene);});
            forest1.setOnMouseClicked(event -> {survive.Woods();  primaryStage.setScene(forestScene); anima.setText(survive.getWoods());});
            rocks1.setOnMouseClicked(event -> { survive.Rocks(); primaryStage.setScene(rockScene); });
            debrisContinue.setOnMouseClicked(event -> {nightEvents = survive.dayPasses();night.setText("Night has fallen"+nightEvents);primaryStage.setScene(nightScene); });
            end.setOnMouseClicked(event -> primaryStage.close());

        }

        @Override
        public void actionPerformed(ActionEvent e) {
                makeProgressBar();
                night.setText("Night has fallen"+nightEvents);
                isDead(border9);
                anima.setText(survive.getWoods());
        }
}






