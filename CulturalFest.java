import java.util.Scanner;
class evedetails extends Thread
{
 public void run()
{
 System.out.println("Events: Dance performance,music concerts,Drama\nDate 23rd December,2024");
}
}
class eveplace extends Thread
{
 public void run()
{
 System.out.println("Places: Auditorium,Playgroung\nTime: 6pm-10pm");
}
}

//abstract class
abstract class Event
{
 String eventName;
 String eventPerformer;
 String eventTime;
 String venue;
 int ticketPrice;
public Event(String eventName,String eventPerformer,String eventTime,String venue,int ticketPrice)
{
 this.eventName=eventName;
 this.eventPerformer=eventPerformer;
 this.eventTime=eventTime;
 this.venue=venue;
 this.ticketPrice=ticketPrice;
}
 abstract void showEventDetails();
 //abstract void bookTicket(String eve_name,String time,String food);
}

 class Admin extends Event
{
 String[] event_name=new String[20];
 String[] event_performer=new String[20];
 String[] event_time=new String[20];
 String[] venue=new String[20];
 int[] ticket_price=new int[20];
 int n=0;

  public Admin(String eventName,String eventPerformer,String eventTime,String venues,int ticketPrice)
  {
  super(eventName,eventPerformer,eventTime,venues,ticketPrice);
  event_name[n]=eventName;
  event_performer[n]=eventPerformer;
  event_time[n]=eventTime;
  venue[n]=venues;
  ticket_price[n]=ticketPrice;
  n=n+1;
  }
  void showEventDetails()
 {
  for(int i=0;i<n;i++)
  {
    System.out.println("Event name: "+event_name[i]+" , Performer: "+event_performer[i]+" , Time: "+event_time[i]+", Venue: "+venue[i]+" , Ticket price: "+ticket_price[i]);
  }
 } 
  public void addEvent(String eve_name,String p_name,String time,String place,int money)
 {
  event_name[n]=eve_name;
  event_performer[n]=p_name;
  event_time[n]=time;
  venue[n]=place;
  ticket_price[n]=money;
  n=n+1;
 }
}

class User {
    static int regUsers = 0;  // Static variable to count registered users
    String[] event_name=new String[20];
    String[] event_time=new String[20];
    String[] foodOption=new String[20];
    String[] User_name=new String[20];
    String[] Dept=new String[20];
   // int n=0;

    public User(String eventName,String eventTime, String food,String name,String dept)
    {
        event_name[regUsers]=eventName;
        event_time[regUsers]=eventTime;
        foodOption[regUsers]=food;
        User_name[regUsers]=name;
        Dept[regUsers]=dept;
        regUsers=regUsers+1;
    }

    void showBookingDetails() 
 {
    System.out.println("Booking Ticket details");
        for(int i=0;i<regUsers;i++)
   {
    System.out.println("Event name: "+event_name[i]+", Time: "+event_time[i]+" , Food : "+foodOption[i]+" , Name : "+User_name[i]+", Dept. "+Dept[i]);
   }

 }
    
    void bookTicket(String eventName,String eventTime, String food,String name,String dept) {
        event_name[regUsers]=eventName;
        event_time[regUsers]=eventTime;
        foodOption[regUsers]=food;
        User_name[regUsers]=name;
        Dept[regUsers]=dept;
        System.out.println("Name "+User_name[regUsers]+" Booking for the event " +  event_name[regUsers] + " time " + event_time[regUsers]+ " with food option " + foodOption[regUsers]);
        regUsers=regUsers+1;
    
    }


}

public class CulturalFest 
{
  public static void main(String args[])
{
  Scanner sc = new Scanner(System.in);
  Admin admin = new Admin("Music Concert","A.K.Roy","7 pm","Auditorium",400);
  User user = new User("Music Concert","7 pm","Veg","abcd","cse");
  int ch=0;
  System.out.println("Cultural fest 2024 ");
  evedetails ob = new evedetails();
  eveplace ob1 = new eveplace();
  ob.setPriority(Thread.MAX_PRIORITY);
  ob.setPriority(Thread.MIN_PRIORITY);
  ob.start();
  ob1.start();
  while(ch!=3)
{
  System.out.println("\n1. Admin\n 2. User \n 3. Exit\n Select Option : ");
  ch=sc.nextInt();
  switch(ch)
 {
 case 1:
       System.out.println("\nFor Admin : \n 1. Add Event \n 2. View Event \n 3. Show Booking details\n Select Option : ");
       int adminCh=sc.nextInt();
       switch(adminCh)
       {
       case 1:
            {
             Scanner sc1 = new Scanner(System.in);
             try
            {
             System.out.println("Enter the Event name: ");
	     String eve_name=sc1.nextLine();
	     System.out.println("Enter the time: ");
	     String time=sc1.nextLine();
	     System.out.println("Enter the performer/performers name: ");
	     String p_name=sc1.nextLine();
             System.out.println("Enter the place name: ");
	     String place=sc1.nextLine();
             System.out.println("Enter the money : ");
	     int money=sc1.nextInt();
             admin.addEvent(eve_name,p_name,time,place,money);
            }
            catch(Exception e)
           {
	    System.out.println("Invalid input ");
	   }
             break;
             }
      case 2:
             admin.showEventDetails();
             break;
      case 3:
             user.showBookingDetails();
             break;
      default:
             System.out.println("Invalid Option ");
             break;
      }
      break;
 
 case 2:
       System.out.println("\nFor User : \n 1. View Event details \n 2. Book Ticket\n Select Option : ");
       int userCh=sc.nextInt();
        switch(userCh)
       {
         case 1:
               admin.showEventDetails();
               break;
         case 2:
	       Scanner sc2 = new Scanner(System.in);
               try
               {
               System.out.println("Enter the event name: ");
               String eve_nameCh=sc2.nextLine();
               System.out.println("Enter the time: ");
	       String timeCh=sc2.nextLine();
               System.out.println("Enter the food choice \n 1. Veg \n 2. Non-Veg \n Select the option: ");
	       String food=sc2.nextLine();
               System.out.println("Enter your name : ");
               String user_name=sc2.nextLine();
               System.out.println("Enter your Dept.: ");
	       String dept=sc2.nextLine();
               user.bookTicket(eve_nameCh,timeCh,food,user_name,dept);
               }
               catch(Exception e)
               {
                System.out.println("Invalid input ");
               }
	       break;
         
         default:
             System.out.println("Invalid Option ");
             break;
       }       
       break;
 case 3:
      System.out.println("Exit ");
      break;
 default:
       System.out.println("Invalid Option ");
       break;
   }
  }
 }
}