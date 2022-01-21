import java.util.*;

public class rail5
{
    static Scanner sc=new Scanner(System.in);
    static String adminid="rail",adminpass="0000";
    static List<String> usernames=new ArrayList<>();
    static List<String> userpasswords=new ArrayList<>();
    static List<Integer> userids=new ArrayList<>();
    static int currentuser=-1;
    static List<String> stations=new ArrayList<>(){{add("CBE");add("TIR");add("ERO");add("SEL");add("CHE");}};
    static List<Integer> seatfilled=new ArrayList<>();
    static List<String> userbookings=new ArrayList<>();
    static List<Integer> seatnum=new ArrayList<>();
    static List<String> boardindpoints=new ArrayList<>();
    static List<String> destinationpoints=new ArrayList<>();
    static List<String> cancelledpnrs=new ArrayList<>();
    static List<String> waitinglist=new ArrayList<>();
    static List<String> waitingboarding=new ArrayList<>();
    static List<Integer> waitingboardingpoint=new ArrayList<>();
    static List<String> userbookingstatus=new ArrayList<>();
    static List<String> waitingbookingstatus=new ArrayList<>();
    static List<String> waitingdestination=new ArrayList<>();
    static List<Integer> waitingdestinationpoint=new ArrayList<>();
    static List<String> cancelledwaitingpnrs=new ArrayList<>();
    static List<String> waitingstatus=new ArrayList<>();
    static int seats[][]={{0,0,0,0,0},
                        {1,1,1,1,1},
                        {1,1,1,1,1}, {1,1,1,1,1}, {0,0,0,0,0}, {1,1,1,1,1}, {1,1,1,1,1}, {0,0,0,0,0}, {1,1,1,1,1}, {0,0,0,0,0}};
    public static void Admin()
    {
        while(true)
        {
        System.out.print("1.view booking history\n2.waiting list\n3.exit\nenter choice : ");
            int adminchoice=sc.nextInt();
            if(adminchoice==1)
            {
            for(int i=0;i<userbookings.size();i++)
            {
                System.out.println("---------");
                System.out.println("pnr number is :"+userbookings.get(i).substring(3));
                System.out.println("seat number is : "+seatnum.get(i));
                System.out.println("boarding point : "+boardindpoints.get(i));
                System.out.println("destination point : "+destinationpoints.get(i));
                System.out.println("Booking status : "+userbookingstatus.get(i));
                System.out.println("---------");
            }
        }
        else if(adminchoice==2)
        {
            for(int i=0;i<waitinglist.size();i++)
            {
            System.out.println("---------");
            System.out.println("pnr number is :"+waitinglist.get(i).substring(3));
            //System.out.println("seat number is : "+seatnum.get(i));
            System.out.println("boarding point : "+waitingboarding.get(i));
            System.out.println("destination point : "+waitingdestination.get(i));
            System.out.println("Booking status : "+waitingstatus.get(i));
            System.out.println("---------");
            }
        }
        else if(adminchoice==3)
        {
            break;
        }
        else{
            System.out.print("invalid chhoice");
        }
        
        }
    }
    public static void userID()
    {
        while(true)
        {
        System.out.print("1.Existing user\n2.New user\n3.exit\nenter choice : ");
        int userchoice=sc.nextInt();
        if(userchoice==1)
        {
            int c=0;
            System.out.print("enter username : ");
            String enterusername=sc.next();
            System.out.print("enter userpassword : ");
            String enteruserpass=sc.next();
            for(int i=0;i<userids.size();i++)
            {
                if(usernames.get(i).equals(enterusername) && userpasswords.get(i).equals(enteruserpass))
                {
                    currentuser=i;
                    user();
                    c++;
                }
            }
            if(c==0)
            {
                System.out.println("account not found");
            }
        }
        else if(userchoice==2)
        {
            System.out.print("enter newusername : ");
            String newenterusername=sc.next();
            System.out.print("enter newuserpassword : ");
            String newenteruserpass=sc.next();
            userids.add(101+userids.size());
            usernames.add(newenterusername);
            userpasswords.add(newenteruserpass);
            System.out.println("account created successfully\n---------");

        }
        else if(userchoice==3)
        {
            break;
        }
        else
        {
            System.out.println("invalid input");
        }
    }
    }

    public static void user()
    {
        System.out.println(usernames.get(currentuser)+" logged in successfully");
             while(true)
            {
                System.out.print("1.Book ticket\n2.cancel ticket\n3.view booking\n4.exit\nenter choice : ");
                int userchoi=sc.nextInt();
                if(userchoi==1)
                {
                    System.out.print("Train Stations ----> ");
                    for(String i:stations)
                    {
                        System.out.print(i+" ");
                    }
                    System.out.println();
                    int count,posati=-1,posatj=-1,startpoint=-1,endpoint=-1,seattaken=-1,pnrnumber=-1,waitingpnr=-1;
                    System.out.print("enter boarding station : ");
                    String boardingstation=sc.next();
                    System.out.print("enter destination station : ");
                    String destinationstation=sc.next();
                    
                    for(int j=0;j<stations.size();j++)
                    {
                        if(boardingstation.equals(stations.get(j)))
                        {
                            startpoint=j;
                           
                        }
                        if(destinationstation.equals(stations.get(j)))
                        {
                            endpoint=j;
                           
                        }
                    }
                    
                    if(!boardingstation.equals(destinationstation) && stations.contains(boardingstation) && stations.contains(destinationstation))
                    {
                        if(boardingstation.equals("CBE") && destinationstation.equals("CHE"))
                        {
                        for(int i=0;i<10;i++)
                        {
                            count=0;
                            for(int j=0;j<5;j++)
                            {
                                if(seats[i][j]==0)
                                {
                                    count++;
                                }
                                
                            }
                           
                            if(count==5)
                            {
                                posati=i;
                                
                                break;
                            }
                        }
                         }
                        else
                        {
                            for(int i=0;i<10;i++)
                            {
                                count=0;
                                for(int j=startpoint;j<=endpoint;j++)
                                {
                                    if(seats[i][j]==0)
                                    {
                                        count++;
                                    }
                                   
                                }
                                if(count-1==endpoint-startpoint)
                                {
                                    posati=i;
                                    break;
                                }
                            }
                        }
                        if(posati>=0)
                        {
                        for(int k=startpoint;k<=endpoint;k++)
                        {
                            seats[posati][k]=1;
                        }
                        seattaken=posati;
                        seatfilled.add(seattaken);
                       
                        System.out.println("ticket booked successfully\n--------");
                        if(cancelledpnrs.size()>0)
                        {
                           pnrnumber=Integer.parseInt(cancelledpnrs.get(0));
                           cancelledpnrs.remove(0);
                        }
                        else{
                         pnrnumber=666+userbookings.size(); 
                        }
                       String pnr=Integer.toString(userids.get(currentuser))+Integer.toString(pnrnumber);
                       userbookings.add(pnr);
                        seatnum.add(posati);
                        boardindpoints.add(boardingstation);
                        destinationpoints.add(destinationstation);
                        userbookingstatus.add("confirmed");
                    
                    
                       
                    
                }
                    else
                    {
                        System.out.println("all seats are filled");
                        while(true)
                        {
                            System.out.print("1.Do you want to book for waiting list\n2.exit\nenter choice : ");
                            int waitingchoice=sc.nextInt();
                            int start=-1,end=-1;
                            if(waitingchoice==1)
                            {
                                System.out.print("Train Stations ----> ");
                                for(String i:stations)
                                {
                                    System.out.print(i+" ");
                                }
                                System.out.println();
                                if(waitinglist.size()<5)
                                {
                                    
                                    System.out.print("enter boarding station : ");
                                    String boa=sc.next();
                                    waitingboarding.add(boa);
                                    System.out.print("enter boarding station : ");
                                    String des=sc.next();
                                    waitingdestination.add(des);
                                    if(boa.equals("CBE")){start=0;}
                                    if(boa.equals("TIR")){start=1;}
                                    if(boa.equals("ERO")){start=2;}
                                    if(boa.equals("SEL")){start=3;}
                                    if(boa.equals("CHE")){start=4;}
                                    if(des.equals("CBE")){end=0;}
                                    if(des.equals("TIR")){end=1;}
                                    if(des.equals("ERO")){end=2;}
                                    if(des.equals("SEL")){end=3;}
                                    if(des.equals("CHE")){end=4;}
                                    waitingboardingpoint.add(start);
                                    waitingdestinationpoint.add(end);
                                    if(cancelledwaitingpnrs.size()>0)
                                    {
                                        waitingpnr=Integer.parseInt(cancelledwaitingpnrs.get(0));
                                        cancelledwaitingpnrs.remove(0);
                                    }
                                    else
                                    {
                                        waitingpnr=201+waitinglist.size();
                                      
                                    }
                                    String waitpnr=Integer.toString(userids.get(currentuser))+Integer.toString(waitingpnr);
                                    waitinglist.add(waitpnr);
                                    waitingstatus.add("waiting list");
                                   System.out.println("waiting ticket has been booked");
                                }
                                else{
                                    System.out.println("No further booking is allowed");
                                }
                                break;
                            }
                            else if(waitingchoice==2)
                            {
                                break;
                            }
                        }
                    }
                      
                    }
                    else{
                        System.out.println("invalid station");
                    }

                    }
                else if(userchoi==2)
                {
                    System.out.println("your bookings");
                    for(int i=0;i<userbookings.size();i++)
                    {
                        if(userbookings.get(i).substring(0,3).equals(Integer.toString(userids.get(currentuser))))
                        {
                            System.out.print("-------\n");
                            System.out.println("pnr number is :"+userbookings.get(i).substring(3));
                            System.out.println("seat number is : "+seatnum.get(i));
                            System.out.println("boarding point : "+boardindpoints.get(i));
                            System.out.println("destination point : "+destinationpoints.get(i));
                            System.out.println("booking status : "+userbookingstatus.get(i));
                            System.out.print("-------\n");
                        }
                    }
                    for(int i=0;i<waitinglist.size();i++)
                    {
                        System.out.print("-------\n");
                        System.out.println("pnr number is :"+waitinglist.get(i).substring(3));
                        System.out.println("boarding point : "+waitingboarding.get(i));
                        System.out.println("destination point : "+waitingdestination.get(i));
                        System.out.println("booking status : "+waitingstatus.get(i));
                        System.out.print("-------\n");
                    } 
                    System.out.print("enter pnr number to be cancelled : ");
                    String enterpnrcancel=sc.next();
                    int startpoint=-1,endpoint=-1,seatnumber=-1,newboa=-1,newdes=-1,c=0,currentwaitingbookingnumber=-1;
                    for(int i=0;i<userbookings.size();i++)
                    {

                        if(userbookings.get(i).substring(0,3).equals(Integer.toString(userids.get(currentuser))) && userbookings.get(i).substring(3).equals(enterpnrcancel))
                        {
                            
                                if(boardindpoints.get(i).equals("CBE")){startpoint=0;}
                                if(boardindpoints.get(i).equals("TIR")){startpoint=1;}
                                if(boardindpoints.get(i).equals("ERO")){startpoint=2;}
                                if(boardindpoints.get(i).equals("SEL")){startpoint=3;}
                                if(boardindpoints.get(i).equals("CHE")){startpoint=4;}
                                if(destinationpoints.get(i).equals("CBE")){endpoint=0;}
                                if(destinationpoints.get(i).equals("TIR")){endpoint=1;}
                                if(destinationpoints.get(i).equals("ERO")){endpoint=2;}
                                if(destinationpoints.get(i).equals("SEL")){endpoint=3;}
                                if(destinationpoints.get(i).equals("CHE")){endpoint=4;}

                                seatnumber=seatnum.get(i);
                                for(int k=startpoint;k<=endpoint;k++)
                                {
                                    seats[seatnumber][k]=0;
                                }
                               for(int j=0;j<waitinglist.size();j++)
                               {
                                   if(waitingboardingpoint.get(j)>=startpoint && waitingdestinationpoint.get(j)>=endpoint)
                                   {
                                        newboa=waitingboardingpoint.get(j);
                                        newdes=waitingdestinationpoint.get(j);
                                        c++;
                                        currentwaitingbookingnumber=j;
                                   }
                               }
                               if(c>0)
                               {
                               for(int k=newboa;k<=newdes;k++)
                               {
                                   seats[seatnumber][k]=1;
                               }
                               String addno=waitinglist.get(currentwaitingbookingnumber);
                               userbookings.add(addno);
                               seatnum.add(seatnumber);
                               userbookingstatus.add("confirmed");
                               waitinglist.remove(currentwaitingbookingnumber);
                               boardindpoints.add(waitingboarding.get(currentwaitingbookingnumber));
                               destinationpoints.add(waitingdestination.get(currentwaitingbookingnumber));
                               waitingboardingpoint.remove(currentwaitingbookingnumber);
                               waitingdestinationpoint.remove(currentwaitingbookingnumber);
                               waitingstatus.remove(currentwaitingbookingnumber);
                                }


                                cancelledpnrs.add(userbookings.get(i).substring(3));
                                userbookings.remove(i);
                                seatnum.remove(i);
                                boardindpoints.remove(i);
                                destinationpoints.remove(i);
                                userbookingstatus.remove(i);
                            
                            System.out.println("cancelled successfully");

                        }
                    }
                    for(int i=0;i<waitinglist.size();i++)
                    {
                        if(waitinglist.get(i).substring(0,3).equals(Integer.toString(userids.get(currentuser))) && waitinglist.get(i).substring(3).equals(enterpnrcancel))
                        {
                            cancelledwaitingpnrs.add(waitinglist.get(i).substring(3));
                            waitinglist.remove(i);
                            waitingboarding.remove(i);
                            waitingboardingpoint.remove(i);
                            waitingstatus.remove(i);
                            waitingdestination.remove(i);
                            waitingdestinationpoint.remove(i);
                            System.out.println("cancelled successfully");
                        }
                    } 
                }
                else if(userchoi==3)
                {
                    while(true)
                    {
                        System.out.print("1.check confirmed tickets\n2.waiting tickets\n3.exit\nenter choice : ");
                        int viewchoice=sc.nextInt();
                        if(viewchoice==1)
                        {
                    for(int i=0;i<userbookings.size();i++)
                    {
                        if(userbookings.get(i).substring(0,3).equals(Integer.toString(userids.get(currentuser))))
                        {
                            System.out.print("-------\n");
                            System.out.println("pnr number is :"+userbookings.get(i).substring(3));
                            System.out.println("seat number is : "+seatnum.get(i));
                            System.out.println("boarding point : "+boardindpoints.get(i));
                            System.out.println("destination point : "+destinationpoints.get(i));
                            System.out.println("booking status : "+userbookingstatus.get(i));
                            System.out.print("-------\n");
                        }
                    }
                }
                else if(viewchoice==2)
                {
                    for(int i=0;i<waitinglist.size();i++)
                    {
                        if(waitinglist.get(i).substring(0,3).equals(Integer.toString(userids.get(currentuser))))
                        {
                            System.out.println("---------");
                            System.out.println("pnr number is :"+waitinglist.get(i).substring(3));
                            //System.out.println("seat number is : "+seatnum.get(i));
                            System.out.println("boarding point : "+waitingboarding.get(i));
                            System.out.println("destination point : "+waitingdestination.get(i));
                            System.out.println("Booking status : "+waitingstatus.get(i));
                            System.out.println("---------");
                        }
                    }
                }
                else if(viewchoice==3)
                {
                    break;
                }
                }
                }
                else if(userchoi==4)
                {
                    break;
                }
                else
                {
                    System.out.println("invalid choice");
                }
            }
                
            }
        
        
    

    public static void main(String[] args) {
    while(true)
    {

        System.out.print("\tWELCOME TO MYRAILS\n1.Admin\n2.user\n3.exit\nenter choice : ");
        int choice=sc.nextInt();
        if(choice==1)
        {
            System.out.print("enter adminusername : ");
            String adminname=sc.next();
            System.out.print("enter adminpassword : ");
            String adminp=sc.next();
            if(adminname.equals(adminid) && adminpass.equals(adminp))
            {
                Admin();
            }
            else
            {
                System.out.println("invalid credentials");
            }
        }
        else if(choice==2)
        {
            userID();
        }
        else if(choice==3)
        {
            break;
        }
        else
        {
            System.out.println("invalid input");
        }

    }
}
}
