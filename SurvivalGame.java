import javafx.scene.chart.BarChart;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class SurvivalGame {
    private int food = 20;
    private int water = 30;
    private int exposure = 0;
    private int injury = 15;
    private boolean exposureToElements = false;
    private boolean injuredPermanately = false;
    private boolean starving = false;
    private boolean dehydrated = false;
    private boolean alive = true;

    private  String theEnd = "  Yeah you died...sorry bro :(";
    private String animal;
     private String weather;
    private String crash;
    private String woods;
    private String rocks;
    private boolean waterbottle;
    private boolean canvas;
    private boolean rope;
    private boolean backpack;
    private boolean poisoned = false;
    private boolean shelter;
    private boolean helpMessage = false;
    private boolean ship = false;
    private boolean fire = false;
    private boolean debrisChecked = false;
    boolean shipNotices;


    private int fI = 0;
    private int wI = 0;
    private int daysPassed = 0;
    private String ani = "";
    private String shipEvent = "";
    private String weatherReport = "";
    private double rand;


    //Methods for events
    public void setWeather(String s){
        weather = s;
    }
     public void newWeather() {
         double ran = (Math.random() * 100);
         String weather1;
         if (ran <= 10) {
             weather1 = "stormy";
         } else if (ran > 10 && ran <= 40) {
             weather1 = "rainy";

         } else if (ran > 40 && ran <= 70) {
             weather1 = "cold";
         } else {
             weather1 = "clear";
         }
         setWeather(weather1);
     }
    public String dayPasses(){

        String weatherReport1 = nightWeather();
        String shipEvent1 = nightShip();

        daysPassed++;
        if(food != 0) {
            if(food >= 20){food = food - 20;}
            else{food = 0;}
            fI = 0;
        }
        else{
            fI++;
        }
        if(water != 0){
            if(water >=30){
                    water = water - 30;}
            else{ water = 0;}
            wI = 0;
        }
        else{
            wI++;
        }
        if(exposure != 0){
            exposure = exposure ;
        }
        if(injury != 0 && !poisoned){
            injury = injury ;
        }
        if(poisoned){
            injury = injury + 20;
        }

        int probOfNotice = 90;
        if(fire && !helpMessage){probOfNotice = 80;}
        if(helpMessage && !fire){probOfNotice = 70;}
        if(helpMessage && fire){probOfNotice = 60;}
        if((Math.random() * 100) > 50){
            shipEvent = "\nA ship passed in the night";
            //shipPassing = true;
            if((Math.random() * 20 * daysPassed)>= probOfNotice){
                shipEvent = "\nA ship passed in the night and noticed you. You've been saved!";
               shipNotices = true;
            }
        }
        if(exposure >= 100){
            exposureToElements = true;
        }
        else if(injury >= 100){
            injuredPermanately = true;
        }
        else if(food == 0 && fI >=5){
            starving = true;
        }
        else if(water == 0 && wI >=3){
            dehydrated = true;
        }
        if(exposureToElements||injuredPermanately||starving||dehydrated){
            alive = false;
        }
        else{
            alive = true;
        }
        if(!alive){

            return theEnd;
        }
        System.out.println(daysPassed);
        return  weatherReport1 + shipEvent1;
    }
    //public String getNight(){


   // }

public String nightShip(){
        boolean shipPassing = false;
    boolean shipNotices = false;
    int probOfNotice = 90;
    if(fire && !helpMessage){probOfNotice = 80;}
    if(helpMessage && !fire){probOfNotice = 70;}
    if(helpMessage && fire){probOfNotice = 60;}
    if((Math.random() * 100) > 50) {
        shipEvent = "\nA ship passed in the night, but didn't notice you";
        shipPassing = true;
        if ((Math.random() * 20 * daysPassed) >= probOfNotice) {
            shipEvent = "\nA ship passed in the night and noticed you. You've been saved!";
            shipNotices = true;
        }
    }
    return shipEvent;
}

public String nightWeather(){
    double ran = (Math.random() * 100);
        weatherReport = "\nOvernight, it was clear.";
    if(ran > 70 && exposure >= 15){
        exposure = exposure - 15;
        if((shelter || fire) && exposure >= 5){
            exposure = exposure-5;
        }
        setWeatherReport("\nOvernight, it was clear.");
    }
    if(ran > 40 && ran <= 70){
        exposure = exposure + 10;
        if(fire){exposure = exposure -5;
            }
        setWeatherReport("\nOvernight, it was cold.");
    }
    if(ran > 10 && ran <= 40){

        exposure = exposure + 15;
        if(shelter){exposure = exposure -5;}
        setFire(false);
        System.out.println(fire);
        setHelpMessage(false);

        water = water +15;
        setWeatherReport("\nOvernight, it was rainy. \nThe rain gave you some more water! \nAny fires were put out and any help messages were damaged");
    }
    if(ran <= 10){

        exposure = exposure + 20;
        setFire(false);
        setShelter(false);
        setHelpMessage(false);
        water = water +15;
        setWeatherReport("\nOvernight, it was stormy.  \nThe storm gave you some more water! \nAny shelters or help messages were damaged, and any fires were put out.");
    }
    if(exposure < 0){
        exposure = 0;
    }
        return weatherReport;
}



    public void setCrash() {
        rand = Math.random()*100;
        if(rand <= 10){
            waterbottle = false;
            canvas = false;
            rope = false;
            backpack = false;
            crash = "nothing of use.";
        }
        else if(rand > 10 && rand <= 20){
            waterbottle = true;
            canvas = false;
            rope = false;
            backpack = false;
            crash = "a water bottle.";
        }
        else if(rand > 20 && rand <= 60){
            waterbottle = true;
            canvas = true;
            rope = false;
            backpack = false;
            crash = "a water bottle and a 10x20 sheet of canvas.";
        }
        else if(rand > 40 && rand <= 80){
            waterbottle = true;
            canvas =true;
            rope = true;
            backpack = false;
            crash = "a water bottle, some rope, and a 10x20 sheet of canvas.";
        }
        else{
            waterbottle = true;
            canvas = true;
            rope = true;
            backpack = true;
            crash = "a water bottle, some rope, a 10x20 sheet of canvas, and a backpack.";
        }

    }

    public String setAnimal() {
        double rando = Math.random()*100;
        if(rando <= 60){
            animal = "a frog.";
        }
        else if(rando > 60 && rando <= 80){
            animal = "some birds.";
        }
        else if(rando > 80 && rando <= 98){
            animal = "bees. They sting you, which hurts";
            injury = injury + 10;
        }
        else{
            animal = "a snake. It bites you. Is it venomous? You hope not.";
            injury = injury + 20;
            poisoned = true;

        }
        return animal;
    }

    public void Woods(){
       ani = "\nAs you are walking through the forest, you run into "+setAnimal();

      //  if(animal != null){
       //     ani = "\nAs you are walking through the forest, you run into "+animal;
      //  }
        setFood((int)(Math.random()*60));

    }
    public String getWoods(){
        return "You find some food." + ani;
    }

    public void Rocks(){
        setWater(60);
        setInjury((int)(Math.random()*20));

    }

    public void setWater(int waterChange){
        water = water + waterChange;
    }

    public void setFire(boolean d){
        fire = d;
    }
    public void setShelter(boolean s){
        shelter= s;
    }

    public void setFood(int foodChange){
        food = food + foodChange;
    }

    public void setExposure(int oofy){
        exposure = exposure + oofy;
    }

    public void setInjury(int hurty){
        injury = getInjury() + hurty;
    }

    public void setDebrisChecked(boolean d){
        debrisChecked = d;
    }
    public void setWeatherReport(String s){
         weatherReport = s;
    }

    public boolean getDebrisChecked(){
        return debrisChecked;
    }
    public int getExposure() {
        return exposure;
    }

    public int getFood() {
        return food;
    }

    public int getInjury() {
        return injury;
    }

    public int getWater() {
        return water;
    }

    public String getCrash(){
        return crash;
    }

    public String getAnimal() {
        return animal;
    }

    public String getWeather() {
        return weather;
    }
    public boolean getShelter(){
        return shelter;
    }
    public boolean getFire(){
        return fire;
    }
    public boolean getHelpMessage(){
        return helpMessage;
    }
    public void setHelpMessage(boolean h){
        helpMessage = h;
    }

    public boolean isAlive(){
        return alive;
    }

    public String getTheEnd() {
        return theEnd;
    }
}