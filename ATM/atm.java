import java.util.*;
class admindetails
{
    String adminname;
    String pin;
    public admindetails(String adminname,String pin)
    {
        this.adminname=adminname;
        this.pin=pin;
    }
}

public class atm {
 
    static String usernames[]={"preetham","chaitanya","shadow"};
    static String userpasswords[]={"1234","5678","8901"};
    static int userbalances[]={500000,100000,20000};
    static int userattempt[]={1,1,1,1};
    static admindetails admindetails=new admindetails("bank","0000");
    static int notesname[]={2000,500,200,100};
    static int demo[]={0,0,0,0};
    static int attempt[]={0,0,0,0};
    static int atmmoneysum=0;
    static List<String> mini=new ArrayList<>();
    public static int currentuser=0;
    static Scanner sc=new Scanner(System.in);
  public static void Admin()
    { 
        System.out.println("Admin logged in successfully"); 
        
    while(true)
    {
    System.out.println("-------"); 
    System.out.println("1.Load");
    System.out.println("2.check");
    System.out.println("3.check atm amount");
    System.out.println("4.Exit");
    System.out.print("Enter choice : "); 
    int adminchoice=sc.nextInt();
    
    if(adminchoice==1)
     {
        for(int i=0;i<demo.length;i++)
        {
            System.out.println("enter no of notes to be added of "+notesname[i]);
            int add=sc.nextInt();
            demo[i]=demo[i]+add;

        }
        System.out.println("Loaded successfully");;
    }

    else if(adminchoice==2)
    {
      for(int i=0;i<demo.length;i++)
      {
          System.out.println(notesname[i]+"-->"+demo[i]);
      }
    }
    else if(adminchoice==3)
    {
        for(int i=0;i<demo.length;i++)
        {
            atmmoneysum=atmmoneysum+notesname[i]*demo[i];

        }
        System.out.println("Total amount in ATM is : "+atmmoneysum);
    }
    else if(adminchoice==4)
    {
        break;
    }
    else
    {
        System.out.println("Invalid input");
        break;
    }
}

}



 
    public static void user()
    {
    System.out.println(usernames[currentuser]+" logged in successfully"); 
       
    while(true)
    {
    
        System.out.println("-------");
    
    System.out.println("1.withdraw");
    System.out.println("2.checkbalance");
    System.out.println("3.pin change");
    System.out.println("4.deposit");
    System.out.println("5.transfer amount");
    System.out.println("6.ministatement");
    System.out.println("7.exit");
    System.out.print("Enter choice : "); 
    int userchoice=sc.nextInt();
    if(userchoice==1)
    {
        System.out.println("enter amount");
        int enteramount=sc.nextInt();
        int temp=enteramount;
        int withdrawnotes[]={0,0,0,0};
        
        int updated[]=new int[4];
        for(int i=0;i<4;i++)
        {
            
            updated[i]=demo[i];
        }
      
         if(enteramount<=userbalances[currentuser] && enteramount<=atmmoneysum)
         {
            if (enteramount % 10 == 0 && enteramount % 100 == 0) 
            {
                while (enteramount >= 2000 && updated[0] > 0) {
                    enteramount -= 2000;
                    updated[0]--;
                    withdrawnotes[0]++;
                }
                while (enteramount >= 500 && updated[1] > 0) {
                    enteramount -= 500;
                    updated[1]--;
                    withdrawnotes[1]++;
                }
                while (enteramount >= 200 && updated[2] > 0) {
                    enteramount -= 200;
                    updated[2]--;
                    withdrawnotes[2]++;
                }
                while (enteramount >= 100 && updated[3] > 0) {
                    enteramount -= 100;
                    updated[3]--;
                    withdrawnotes[3]++;
                }
    
                if (enteramount == 0) 
                {
                    demo[0] = updated[0];
                    demo[1] = updated[1];
                    demo[2] = updated[2];
                    demo[3] = updated[3];
                    int withupdated=userbalances[currentuser]-temp;
                    userbalances[currentuser]=withupdated;
                   for(int i=0;i<4;i++)
                   {
                       System.out.print(withdrawnotes[i]+" ");
                   }
                    System.out.println("Widthdraw Successfull !");
                    String date = Integer.toString(currentuser)+java.time.LocalDateTime.now() + "---withdrawl---" +userbalances[currentuser];
                    mini.add(date);
                } 
                else 
                {
                    System.out.println("Sorry for the inconvinience !");
                }
            }
           
         }
                else
                {
                    for(int i=0;i<demo.length;i++)
                    {
                        System.out.println(notesname[i]+"-->"+demo[i]);
                    }
                }  
            }
            
        
    
    else if(userchoice ==2)
    {
        System.out.println("Balance is : "+userbalances[currentuser]);
    }
    else if(userchoice==3)
    {
        System.out.println("enter current pin");
         String prevpin=sc.next();
         if(prevpin.equals(userpasswords[currentuser]))
         {
            System.out.println("enter new pin");
            String newpin=sc.next();
            userpasswords[currentuser]=newpin;
            System.out.println("success pin changed");
        }
    }
    else if(userchoice==4)
    {
        System.out.println("enter deposit amount");
        int depositamount=sc.nextInt();
        int temp=depositamount;
        int depositnotes[]={0,0,0,0};
       int depupdated[]=new int[4];
       for(int i=0;i<4;i++)
       {
           
           depupdated[i]=demo[i];
       }
     
       if (depositamount % 10 == 0 && depositamount % 100 == 0) 
           {
               while (depositamount >= 2000) {
                   depositamount -= 2000;
                   depupdated[0]++;
                   depositnotes[0]++;
               }
               while (depositamount >= 500) {
                depositamount -= 500;
                depupdated[1]++;
                depositnotes[1]++;
            }
            while (depositamount >= 200) {
                depositamount -= 200;
                depupdated[2]++;
                depositnotes[2]++;
            }
            while (depositamount >= 100) {
                depositamount -= 100;
                depupdated[3]++;
                depositnotes[3]++;
            }
   
               if (depositamount == 0) 
               {
                   demo[0] = depupdated[0];
                   demo[1] = depupdated[1];
                   demo[2] = depupdated[2];
                   demo[3] = depupdated[3];
                   int updated=userbalances[currentuser]+temp;
                   userbalances[currentuser]=updated;
                   for(int i=0;i<4;i++)
                   {
                       System.out.print(depositnotes[i]+" ");
                   }
               }
               String date = Integer.toString(currentuser)+java.time.LocalDateTime.now() + "---deposit---" +userbalances[currentuser];
               mini.add(date);
    
        System.out.println("amount added successfully");
    }
}
    else if(userchoice==5)
    {
        System.out.println("enter useraccount name : ");
        String user=sc.next();
        for(int i=0;i<usernames.length;i++)
        {
            if(user.equals(usernames[i]))
            {
                System.out.println("enter amount");
                int amountenter=sc.nextInt();
                userbalances[i]=userbalances[i]+amountenter;
                System.out.println("transfer successfull");
                userbalances[currentuser]=userbalances[currentuser]-amountenter;
            }
            
        }
        String date = Integer.toString(currentuser)+java.time.LocalDateTime.now() + "---transfer---" +userbalances[currentuser];
        mini.add(date);
    }
    else if(userchoice==6)
    {
       for(int i=0;i<mini.size();i++)
       {
           if(mini.get(i).substring(0,1).equals(Integer.toString(currentuser)))
           {
               System.out.println(mini.get(i).substring(1));
           }
       }
    }
    else if(userchoice==7)
    {
       break;
    }
    else
    {
        System.out.println("Invalid choice");
        break;
    }
    }
}

    public static void main(String[] args) {
        //Scanner sc=new Scanner(System.in);
        
        while(true)
        {
        System.out.println("WELCOME TO MY ATM");
        System.out.println("1.Admin");
        System.out.println("2.User");
        System.out.println("3.Exit");
        System.out.print("Enter your choice : ");
        int a=sc.nextInt();
        if(a==1)
        {
            System.out.print("Enter username :");
            System.out.println();
            String giveadminuser=sc.next();
            System.out.println("enter password : ");
            String giveadminpass=sc.next();
            //System.out.println(admindetails.adminname+" "+admindetails.pin);
            if(giveadminuser.equals(admindetails.adminname) && giveadminpass.equals(admindetails.pin))
            {
                Admin();
            }
            else
            {
                System.out.println("Invalid admin credentials");
            }
        }
        else if(a==2)
        {
            userlogin();
        }
           

        
        else if(a==3)
        {

            break;
        }
        else
        {
            System.out.println("Invalid input");
        }
        }
    }
    public static void userlogin()
    {
        int k=1;
        System.out.println("Enter username : ");
            String giveuser=sc.next();
        //    System.out.println("enter password");
        //    String givepassword=sc.next();
           int attem;
           for(int i=0;i<usernames.length;i++)
           {
            attem=0;
               if(usernames[i].equals(giveuser))
               {
                   currentuser=i;
                   attem=0;
                   while(attem<3)
                   {
                    if(attempt[currentuser]>3 || attempt[currentuser]==3)
                    {
                        System.out.println("your account has been blocked"); 
                        break;
                    }
                    else
                    {
                    System.out.println("enter password");
                    String givepassword=sc.next();
                    if(userpasswords[i].equals(givepassword))
                    {
                        
                        user();
                        break;
                    }
                    else 
                   {
                       System.out.println("wrong password");
                        attem++;
                        attempt[currentuser]=attempt[currentuser]+1;
                   }
                }
                if(attem>=3)
                {
                    System.out.println("your account has been blocked");
                }
               }
           }
    }
}
}
