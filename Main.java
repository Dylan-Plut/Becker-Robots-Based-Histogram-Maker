//Main class to run code
//Created by Dylan Plut
//Last modified 2023-11-19

import becker.robots.*;
 
public class Main
{
   public static void main(String[] args)
   {
      City statCity = new City("Stats.txt");
      statCity.showThingCounts(true);
      
      //Robot Objects
      HistogramBot histBotN = new HistogramBot (statCity, 1, 0, Direction.EAST, "BotN");
      HistogramBot histBotS = new HistogramBot (statCity, 7, 0, Direction.EAST, "BotS");
      
      Thread thread = new Thread(histBotN);
      Thread thread2 = new Thread(histBotS);

      //To run both robots at the 'same' time
      thread.start();
      thread2.start();
   }
} 