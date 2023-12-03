//HistogramBot class to make the histogram
//Dylan Plut
//Last modified 2023-11-20

import becker.robots.*;

public class HistogramBot extends RobotSE implements Runnable
{
   //Class constructor
   public HistogramBot(City aCity, int aStreet, int anAvenue, Direction aDirection, String aName)
   {
      super(aCity, aStreet, anAvenue, aDirection);
      this.robotName = aName;
   }

   //Instance variables
   private String robotName;
   private int thingCount;
   private int stepcount;
   boolean isFirstCall = true;

   private void outputThingCount() 
   {
      System.out.println(this.robotName + " thing count is: " + this.thingCount);
   }

   //Requirement method for runnable
   public void run()
   {
      for (int i = 0; i < 5; i++)
      {
      this.findFirstThing(); 
      this.move();
      this.makeHistogram();
      this.outputThingCount();      
      }
   }

   //Collects things to make histogram
   public void findFirstThing() 
   {
      while (true) 
      {
          if (canPickThing())
           {
              while (canPickThing()) 
              {
                  pickThing();
                  thingCount++;
              }
              break;
          } 
          else if (frontIsClear())
           {
              move();
          } 
          else
           {
              break;
          }
      }
  }
  //Makes the histogram with however many things it has
   public void makeHistogram()
   {
      this.placeLine();
      this.backtoStart();
      this.newLine();
   }
   //helper method
   public void placeLine()
   {
      while (thingCount > 0)
      {
         this.putThing();
         if (frontIsClear())
         {
            this.move();
            stepcount++;
         }
         thingCount--;
      }
   }
   //helper method
   public void backtoStart()
   {
      this.turnAround();
      if (!isFirstCall) {
         stepcount++;
      }
      while (stepcount >= 0)
      {
         this.move();
         stepcount--;   
      }
      isFirstCall = false;
   }
   //helper method
   public void newLine()
   {
      this.turnLeft();
      this.move();
      this.turnLeft();
      
   }
   //Returns thing count
   public int getThingCount() {
      return this.thingCount;
  }

   //Overrides RobotSE method with logic to check wether a move is possible
   public void move()
   {
     if (frontIsClear())
      {
        super.move();
    }
   }
}