import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;


public class vehicle {
    static Scanner sc=new Scanner(System.in);
    static String adminusername="admin",adminpassword="0000";
    static List<Integer> userids=new ArrayList<>();
    static List<String> usernames=new ArrayList<>();
    static List<String> userpasswords=new ArrayList<>();
    static List<Integer> vehicleids=new ArrayList<>();
    static List<Integer> delvehiids=new ArrayList<>();
    static List<String> vehiclename=new ArrayList<>();
    static List<String> vehicletype=new ArrayList<>();
    static List<String> vehiclenumber=new ArrayList<>();
    static List<Integer> vehiclerent=new ArrayList<>();
    static List<String> vehiclestatus=new ArrayList<>();
    
    
    static List<String> usercart=new ArrayList<>();
    static List<String> cartvehiclename=new ArrayList<>();
    static List<String> cartvehiceltype=new ArrayList<>();
    static List<String> cartvehiclestatus=new ArrayList<>();
    static List<Long> cartamount=new ArrayList<>();
    static List<String> borrowdate=new ArrayList<>();
    static List<String> returndate=new ArrayList<>();
    
    static int currentuser=-1;
    static SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    public static void Admin()
    {
        System.out.print("\033[H\033[2J");
        System.out.println("\tWelcome admin");
        while(true)
        {
            System.out.print("1.Add vehicle\n2.Delete vehicle\n3.vehicles list\n4.borrow list\n5.modify vehicle\n6.Available vehicles\n7.exit\nEnter choice : ");
            int adminchoice=sc.nextInt();
            if(adminchoice==1)
            {
                System.out.print("\033[H\033[2J");
                int id=-1;
                System.out.print("Enter vehicle model : ");
                String name=sc.next();
                System.out.print("Enter vehicle type(car/bike) : ");
                String type=sc.next();
                System.out.print("Enter vehicle number : ");
                String no=sc.next();
                System.out.print("Enter vehicle rent for 1 hour : ");
                int rent=sc.nextInt();
                if(delvehiids.size()>0)
                {
                    id=delvehiids.get(0);
                    delvehiids.remove(0);
                }
                else{
                    id=201+vehicleids.size();
                }
                vehiclename.add(name);vehicletype.add(type);vehiclenumber.add(no);vehicleids.add(id);vehiclerent.add(rent);
                System.out.println("Vehicle added successfully"); 
                vehiclestatus.add("free");
            }
            else if(adminchoice==2)
            {
                System.out.print("\033[H\033[2J");
                if(vehiclename.size()>0)
                {
                    System.out.println("Available vehicles");
                    for(int i=0;i<vehiclename.size();i++)
                    {
                        System.out.println("Vehicle id : "+vehicleids.get(i)+"\nvehicle name : "+vehiclename.get(i)+"\nVehicle type : "+vehicletype.get(i)+"\nvehicle number : "+vehiclenumber.get(i)+"\nrent : "+vehiclerent.get(i));
                    }
                    System.out.print("enter vehicle id to be removed : ");
                    int delid=sc.nextInt();
                    for(int i=0;i<vehicleids.size();i++)
                    {
                        if(delid==vehicleids.get(i))
                        {
                            delvehiids.add(vehicleids.get(i));
                            vehicleids.remove(i);vehiclename.remove(i);vehicletype.remove(i);vehiclenumber.remove(i);vehiclerent.remove(i);
                            System.out.println("vehicle deleted successfully");vehiclestatus.remove(i);
                        }
                    }
                }
            }
            else if(adminchoice==3)
            {
                System.out.print("\033[H\033[2J");
                if(vehiclename.size()>0)
                {
                    for(int i=0;i<vehiclename.size();i++)
                    {
                        System.out.println("Vehicle id : "+vehicleids.get(i)+"\nvehicle name : "+vehiclename.get(i)+"\nVehicle type : "+vehicletype.get(i)+"\nvehicle number : "+vehiclenumber.get(i)+"\nrent : "+vehiclerent.get(i));
                    }
                }
                else{
                    System.out.println("No vehicles found");
                }
            }
            else if(adminchoice==4)
            {
                System.out.print("\033[H\033[2J");
            }
            else if(adminchoice==5)
            {
                System.out.print("\033[H\033[2J");
                if(vehiclename.size()>0)
                {
                    System.out.println("Available vehicles");
                    for(int i=0;i<vehiclename.size();i++)
                    {
                        System.out.println("Vehicle id : "+vehicleids.get(i)+"\nvehicle name : "+vehiclename.get(i)+"\nVehicle type : "+vehicletype.get(i)+"\nvehicle number : "+vehiclenumber.get(i)+"\nrent : "+vehiclerent.get(i));
                    }
                    System.out.print("enter vehicle name to be modified : ");
                    int up=sc.nextInt();
                    for(int i=0;i<vehicleids.size();i++)
                    {
                        if(up==vehicleids.get(i))
                        {
                            System.out.print("Enter new name : ");
                            String upna=sc.next();
                            System.out.print("Enter new vehicle number : ");
                            String upno=sc.next();
                            System.out.print("Enter vehicle rent for 1 hour : ");
                            int uprent=sc.nextInt();
                            vehiclename.set(i, upna); vehiclenumber.set(i, upno); vehiclerent.set(i, uprent);
                            System.out.println("vehicle updated successfully");

                        }
                    }
                }
            }
            else if(adminchoice==6)
            {
                for(int i=0;i<vehiclestatus.size();i++)
                {
                    if(vehiclestatus.get(i).equals("free"))
                    {
                        System.out.println("Vehicle id : "+vehicleids.get(i)+"\nvehicle name : "+vehiclename.get(i)+"\nVehicle type : "+vehicletype.get(i)+"\nvehicle number : "+vehiclenumber.get(i)+"\nrent : "+vehiclerent.get(i));
                    }
                }
            }
            else if(adminchoice==7)
            {
                break;
            }
        }
    }
    public static void userID()
    {
        System.out.print("\033[H\033[2J");
        System.out.println("\tuser login panel");
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
        System.out.print("\033[H\033[2J");
        System.out.println(usernames.get(currentuser)+" logged in successfully");
        while(true)
        {
            System.out.print("1.Borrow vehicles\n2.Previous rentals\n3.return vehicle\n4.exit\nenter choice : ");
            int usch=sc.nextInt();
            if(usch==1)
            {
                System.out.println("Availble vehicles");
                for(int i=0;i<vehiclestatus.size();i++)
                {
                    if(vehiclestatus.get(i).equals("free"))
                    {
                        System.out.println("Vehicle id : "+vehicleids.get(i)+"\nvehicle name : "+vehiclename.get(i)+"\nVehicle type : "+vehicletype.get(i)+"\nvehicle number : "+vehiclenumber.get(i)+"\nrent for 1 hour: "+vehiclerent.get(i));

                    }
                }
                System.out.println("enter vehicle id to be rented : ");
                int useen=sc.nextInt();
                for(int i=0;i<vehicleids.size();i++)
                {
                    if(vehicleids.get(i)==useen)
                    {
                        String val=Integer.toString(userids.get(currentuser))+Integer.toString(useen);
                        usercart.add(val);cartvehiceltype.add(vehicletype.get(i));cartvehiclestatus.add("rented");cartamount.add((long)0);vehiclestatus.set(i, "rented");
                       Date date=new Date(); String bd=sdf.format(date); borrowdate.add(bd); returndate.add("not returned");cartvehiclename.add(vehiclename.get(i));
                        System.out.println("vehicle rented successfully");
                    }
                   
                }
            }
            else if(usch==2)
            {
                for(int i=0;i<cartvehiclestatus.size();i++)
                {
                    if(usercart.get(i).substring(0,3).equals(Integer.toString(userids.get(currentuser))) && cartvehiclestatus.get(i).equals("returned"))
                    {
                    System.out.println("vehicle id : "+usercart.get(i).substring(3)+"\nvehicle name : "+cartvehiclename.get(i)+"\nvehicle type : "+cartvehiceltype.get(i)+"\nBorrowdate : "+borrowdate.get(i)+"\nreturn date : "+returndate.get(i)+"\nrent amount : "+cartamount.get(i));
                    
                    }
                    System.out.println("------");
                }
            }
            else if(usch==3)
            {
                for(int i=0;i<usercart.size();i++)
                {
                    if(usercart.get(i).substring(0,3).equals(Integer.toString(userids.get(currentuser))) && cartvehiclestatus.get(i).equals("rented"))
                    {
                        System.out.println("vehicle id : "+usercart.get(i).substring(3)+"\nvehicle name : "+cartvehiclename.get(i)+"\nvehicle type : "+cartvehiceltype.get(i)+"\nBorrowdate : "+borrowdate.get(i));
                    }
                    System.out.println("-----");
                }
                System.out.print("enter vehicle id to be returned : ");
                String retid=sc.next();
                int c=-1;
                for(int i=0;i<usercart.size();i++)
                {
                    c=0;
                    if(retid.equals(usercart.get(i).substring(3)))
                    {
                        Date date1=new Date();
                        String rd=sdf.format(date1);
                        returndate.set(i,rd);
                        long amount=rentamount(borrowdate.get(i), returndate.get(i));
                        cartvehiclestatus.set(i, "returned");
                        cartamount.set(i, amount);
                        System.out.println("vehicle returned and amount should be paid is "+amount);
                        c++;
                    }
                }
                if(c>0)
                {
                    for(int i=0;i<vehicleids.size();i++)
                    {
                        if(Integer.parseInt(retid)==vehicleids.get(i))
                        {
                            vehiclestatus.set(i, "free");
                        }
                    }
                }
            }
            else if(usch==4)
            {
                break;
            }
            else
            {
                System.out.println("invalid choice");
            }
        }
   }
    public static void main(String[] args) 
    {
        while(true)
        {
        System.out.print("\t Welcome to Rent and go\n1.Admin\n2.User\n3.Exit\nEnter choice : ");
        int ch=sc.nextInt();
        if(ch==1)
        {
        System.out.print("Enter admin username : ");
        String adminname=sc.next();
        System.out.print("Enter admin password : ");
        String adminpass=sc.next();
            if(adminname.equals(adminusername) && adminpass.equals(adminpassword))
            {
                Admin();
            }
            else
            {
                System.out.println("Invalid credentials");
            }
        }
        else if(ch==2)
        {
            userID();
        }
        else if(ch==3)
        {
            break;
        }
        else
        {
            System.out.println("invalid input");
        }
    }
}
public static long rentamount(String bd,String rd)
{
    long amount=0;
    try
    {
    Date d1 = sdf.parse(bd);
    Date d2 = sdf.parse(rd);
    long difference_In_Time= d2.getTime() - d1.getTime();
    long difference_In_Hour= TimeUnit.MILLISECONDS.toHours(difference_In_Time)% 24;
    amount=difference_In_Hour;
    }
    catch (ParseException e) 
    {
        e.printStackTrace();
    }
    return amount;
}
   
}
