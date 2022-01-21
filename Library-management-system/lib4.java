import java.util.*;
import java.text.SimpleDateFormat;  
import java.text.ParseException;  
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class lib4
{
    static Scanner sc=new Scanner(System.in);
    static Calendar cal = Calendar.getInstance();
    static String adminusername="admin",password="0000";
    static List<Integer> bookids=new ArrayList<>();
    static List<Integer> deletedbookids=new ArrayList<>();
    static List<String> booknames=new ArrayList<>();
    static List<Integer> bookprice=new ArrayList<>();
    static List<Integer> bookquantity=new ArrayList<>();
    static List<Integer> userids=new ArrayList<>();
    static List<Integer> deleteduserids=new ArrayList<>();
    static List<String> usernames=new ArrayList<>();
    static List<String> userpasswords=new ArrayList<>();
    static List<Integer> usercautiondeposit=new ArrayList<>();
    static List<LocalDate> userborrowedcurrentdate=new ArrayList<>();
    static List<LocalDate> userborrowedreturndate=new ArrayList<>();
    static List<String> usercart=new ArrayList<>();
    static List<String> userbookcart=new ArrayList<>();
    static List<String> usercartstatus=new ArrayList<>();
    static List<Integer> booktakingatatime=new ArrayList<>();
    static int currentuser=-1;
    static List<Integer> userborrowlimit=new ArrayList<>();
    static List<Integer> fineamount=new ArrayList<>();
    public static void Admin()
    {
        
System.out.print("\033[H\033[2J");
        System.out.println("\tWelcome admin");
        while(true)
        {
            System.out.print("1.Available books\n2.Add Book\n3.Update Book\n4.Delete book\n5.members list\n6.add member/delete member\n7.exit\nenter choice : ");
            int adminchoice=sc.nextInt();
            if(adminchoice==1)
            {
                
System.out.print("\033[H\033[2J");
                for(int i=0;i<bookids.size();i++)
                {
                    System.out.println("Book ID : "+bookids.get(i)+"\tBook name : "+booknames.get(i)+"\tBook price : "+bookprice.get(i)+"\tBook quantity : "+bookquantity.get(i));
                }
            }
            else if(adminchoice==2)
            {
                
System.out.print("\033[H\033[2J");
                int bookid=-1;
                System.out.println("Enter book name : ");
                String name=sc.next();
                System.out.println("Enter book price : ");
                int price=sc.nextInt();
                System.out.println("Enter book quantity : ");
                int quantity=sc.nextInt();
                if(deletedbookids.size()>0)
                {
                    bookid=deletedbookids.get(0);
                    deletedbookids.remove(0);
                }
                else
                {
                 bookid=101+bookids.size();
                }
                bookids.add((bookid));
                booknames.add(name); bookprice.add(price); bookquantity.add(quantity);
                System.out.println("book added successfully");
            }
           else if(adminchoice==3)
            {
                
System.out.print("\033[H\033[2J");
                System.out.println("Available books");
                for(int i=0;i<bookids.size();i++)
                {
                    System.out.println("Book ID : "+bookids.get(i)+"\tBook name : "+booknames.get(i)+"\tBook price : "+bookprice.get(i)+"\tBook quantity : "+bookquantity.get(i));
                }
                System.out.print("Enter book id to be updated : ");
                int upid=sc.nextInt();
                for(int i=0;i<bookids.size();i++)
                {
                    if(bookids.get(i)==upid)
                    {
                        System.out.println("enter new book name : ");
                        String upna=sc.next();
                        booknames.set(i, upna);
                        System.out.println("enter new price : ");
                        int newprice=sc.nextInt();
                        bookprice.set(i,newprice);
                        System.out.println("enter new quantity : ");
                        int newquan=sc.nextInt();
                        bookquantity.set(i, newquan);
                        System.out.println("\tBook updated successfully");
                    }
                }
            }
           else if(adminchoice==4)
            {
                
System.out.print("\033[H\033[2J");
                for(int i=0;i<bookids.size();i++)
                {
                    System.out.println("Book ID : "+bookids.get(i)+"\tBook name : "+booknames.get(i));
                }
                while(true)
                {
                    System.out.print("1.delete book\n2.exit\nenter choice : ");
                    int delchoi=sc.nextInt();
                    if(delchoi==1)
                    {
                    System.out.println("enter bookid to be deleted : ");
                    int deleid=sc.nextInt();
                    for(int i=0;i<bookids.size();i++)
                    {
                        if(deleid==bookids.get(i))
                        {
                            deletedbookids.add(bookids.get(i));
                            bookids.remove(i); booknames.remove(i) ;bookprice.remove(i);bookquantity.remove(i);
                            System.out.println("book deleted from library");
                        }
                    }
                }
                else if(delchoi==2)
                {
                    break;
                }
                }
           }
           else if(adminchoice==5)
            {
                
System.out.print("\033[H\033[2J");
                for(int i=0;i<userids.size();i++)
                {
                    System.out.println("user id : "+userids.get(i)+"\n user name : "+usernames.get(i));
                }
            }
            else if(adminchoice==6)
            {
                

                System.out.print("\033[H\033[2J");
                while(true)
                {
                    System.out.print("1.add member\n2.delete member\n3.exit\nenter choice : ");
                    int ch=sc.nextInt(),userid=-1;
                    if(ch==1)
                    {
                        System.out.println("enter username : ");
                        String username=sc.next();
                        System.out.println("enter userpassword : ");
                        String userpassword=sc.next();
                        if(deleteduserids.size()>0)
                        {
                            userid=deleteduserids.get(0);
                            deleteduserids.remove(0);
                        }
                        else
                        {
                             userid=201+userids.size();
                        }
                       
                        userids.add((userid));
                        usernames.add(username); userpasswords.add(userpassword);
                        usercautiondeposit.add(1500);
                        booktakingatatime.add(0);
                        userborrowlimit.add(0);
                        System.out.println("user created successfully");
                    }
                    else if(ch==2)
                    {
                        
System.out.print("\033[H\033[2J");
                        for(int i=0;i<userids.size();i++)
                        {
                            System.out.println("user id : "+userids.get(i)+"\n user name : "+usernames.get(i));
                        }
                        System.out.print("enter userid to be deleted : ");
                        int enteruser=sc.nextInt();
                        for(int i=0;i<userids.size();i++)
                        {
                            if(enteruser==userids.get(i))
                            {
                                deleteduserids.add(userids.get(i));
                                userids.remove(i);
                                usernames.remove(i); userpasswords.remove(i);
                                int refund=usercautiondeposit.get(i);
                                usercautiondeposit.remove(i);
                                booktakingatatime.remove(i);
                                userborrowlimit.remove(i);
                                for(int j=0;j<usercart.size();j++)
                                {
                                    if(usercart.get(j).substring(0,3).equals(Integer.toString(enteruser)))
                                    {
                                        usercart.remove(j);userbookcart.remove(j);userborrowedcurrentdate.remove(j);
                                        userborrowedreturndate.remove(j);usercartstatus.remove(j);fineamount.remove(j);

                                    }
                                }
                                System.out.println("user deleted successfully and refunded amount is : "+refund);
                            }
                        }
                    }
                    else if(ch==3)
                    {
                        break;
                    }
                    else{
                        System.out.println("invalid choice");
                    }
                }

            }
          
            else if(adminchoice==7)
            {
                break;
            }
            else{
                System.out.println("invlaid choice");
            }

        }
    }
    public static void userid()
    {
        while(true)
        {
        System.out.println("\tWelcome to user panel\n1.Already a member please login\n2.New user\n3.exit\nenter choice : ");
        int usch=sc.nextInt();
        if(usch==1)
        {
            
System.out.print("\033[H\033[2J");
            System.out.println("enter userid : ");
            int usid=sc.nextInt();
            System.out.println("enter userpassword : ");
            String usepass=sc.next();
            for(int i=0;i<userids.size();i++)
            {
                if(usid==userids.get(i) && usepass.equals(userpasswords.get(i)))
                {
                    currentuser=i;
                    user();
                }
            }

        }
        else if(usch==2)
        {
            
System.out.print("\033[H\033[2J");
            System.out.println("Get a membership by contacting administrator");
        }
        else if(usch==3)
        {
            break;
        }
    }
        
    }
    public static void user()
    {
        System.out.println("\tWelcome "+usernames.get(currentuser));
        while(true)
        {
            System.out.println("1.Borrow book\n2.return book\n3.cart\n4.lost book\n5.exit\nenter choice : ");
            int userchoice=sc.nextInt();
            if(userchoice==1)
            {
                
System.out.print("\033[H\033[2J");
                if(booktakingatatime.get(currentuser)<3)
                {
                System.out.println("Available books");
                for(int i=0;i<bookids.size();i++)
                {
                    if(bookquantity.get(i)>0)
                    {
                    System.out.println("Book ID : "+bookids.get(i)+"\tBook name : "+booknames.get(i));
                    }
                }
           
                if(usercautiondeposit.get(currentuser)>=500)
                {
                    System.out.println("enter bookid : ");
                    int borid=sc.nextInt();
                    
                    for(int i=0;i<bookids.size();i++)
                    {
                        if(bookids.get(i)==borid)
                        {
                            if(bookquantity.get(i)>0)
                            {
                                String boo=Integer.toString(userids.get(currentuser))+Integer.toString(bookids.get(i))+booknames.get(i);
                                int Update=bookquantity.get(i)-1;
                                bookquantity.set(i, Update);
                                LocalDate takendate = LocalDate.now();
                                userborrowedcurrentdate.add(takendate);
                                usercart.add(boo);userbookcart.add(booknames.get(i)); usercartstatus.add("taken");
                                fineamount.add(0);
                                int limit=booktakingatatime.get(currentuser)+1;
                                booktakingatatime.set(currentuser, limit);
                                System.out.println("You have to return the book within 15 days or fine will be charged");
                            }
                        }
                       
                    }
                }
            }
            else if(booktakingatatime.get(currentuser)>=3)
            {
                System.out.println("borrow limit reached");
            }
             else
            {
                System.out.println("you cannot borrow a book contact administrator");
            }
            }
            else if(userchoice==2)
            {
                
System.out.print("\033[H\033[2J");
                for(int i=0;i<usercart.size();i++)
                {
                    if(Integer.toString(userids.get(currentuser)).equals(usercart.get(i).substring(0,3)) && usercartstatus.get(i).equals("taken"))
                    {
                        System.out.println("Book id : "+usercart.get(i).substring(3,6)+"\tBook name : "+userbookcart.get(i));
                    }
                }
                System.out.println("enter bookid to be returned : ");
                int userboo=sc.nextInt();
                for(int i=0;i<usercart.size();i++)
                {
                    if(Integer.toString(userids.get(currentuser)).equals(usercart.get(i).substring(0,3)) && usercartstatus.get(i).equals("taken") && Integer.toString(userboo).equals(usercart.get(i).subSequence(3, 6)))
                    {
                        for(int j=0;j<bookids.size();j++)
                        {
                            if(userboo==bookids.get(j))
                            {
                               
                                LocalDate returndate=LocalDate.now();
                                long result = ChronoUnit.DAYS.between(userborrowedcurrentdate.get(i),returndate);
                                if(result>15)
                                {
                                    if(usercautiondeposit.get(currentuser)>0)
                                    {
                                    int fine=(int)result-15;
                                    int amount=fine*10;
                                    int wallmon=usercautiondeposit.get(currentuser)-amount;
                                    usercautiondeposit.set(currentuser,wallmon);
                                    int upd=bookquantity.get(j)+1;
                                    bookquantity.set(j,upd);
                                    userborrowedreturndate.add(returndate);
                                    fineamount.set(i, amount);
                                    usercartstatus.set(i, "returned");
                                    booktakingatatime.set(currentuser,booktakingatatime.get(currentuser)-1 );
                                    System.out.println(amount+" fine taken successfully");
                                    System.out.println("Book returned successfully");
                                    }
                                    else
                                    {
                                        System.out.println("sufficient amount not present");
                                    }

                                }
                                else if(result<=15)
                                {
                                    int upd=bookquantity.get(j)+1;
                                    bookquantity.set(j,upd);
                                    usercartstatus.set(i, "returned");
                                    userborrowedreturndate.add(returndate);
                                    booktakingatatime.set(currentuser,booktakingatatime.get(currentuser)-1 );
                                    System.out.println("Book returned successfully");
                                }
                              
                               
                            }
                        }
                    }

                }

            }
            else if(userchoice==3)
            {
                
System.out.print("\033[H\033[2J");
                for(int i=0;i<usercart.size();i++)
                {
                    if(Integer.toString(userids.get(currentuser)).equals(usercart.get(i).substring(0,3)))
                    {
                        System.out.println("Book id : "+usercart.get(i).substring(3,6)+"\nBook name : "+userbookcart.get(i)+"\nReturn status : "+usercartstatus.get(i)+"\nFine amount : "+fineamount.get(i));
                    }
                }
            }
            else if(userchoice==4)
            {
                
System.out.print("\033[H\033[2J");
                for(int i=0;i<usercart.size();i++)
                {
                    if(Integer.toString(userids.get(currentuser)).equals(usercart.get(i).substring(0,3)) && usercartstatus.get(i).equals("taken"))
                    {
                        System.out.println("Book id : "+usercart.get(i).substring(3,6)+"\tBook name : "+userbookcart.get(i));
                    }
                }
                System.out.print("enter bookid which you lost : ");
                int lostbookid=sc.nextInt();
                for(int i=0;i<usercart.size();i++)
                {
                    if(Integer.toString(userids.get(currentuser)).equals(usercart.get(i).substring(0,3)) && usercartstatus.get(i).equals("taken") && Integer.toString(lostbookid).equals(usercart.get(i).subSequence(3, 6)))
                    {
                        for(int j=0;j<bookids.size();j++)
                        {
                            if(lostbookid==bookids.get(j))
                            {
                               
                                int price=(int)bookprice.get(j)/2;
                                if(usercautiondeposit.get(currentuser)>=price)
                                {
                                    int upd=bookquantity.get(j)-1;
                                    bookquantity.set(j,upd);
                                int wallupd=usercautiondeposit.get(currentuser)-price;
                                usercautiondeposit.set(currentuser, wallupd);
                                usercartstatus.set(i, "lost fine paid");
                                fineamount.set(i, price);
                                booktakingatatime.set(booktakingatatime.get(currentuser),booktakingatatime.get(currentuser)-1 );
                                System.out.println("Fine paid successfully");
                                }
                                else
                                {
                                    System.out.println("amount is not sufficent in account");
                                    break;  
                                }
                                
                            }
                        }
                    }
                }


            }
            else if(userchoice==5)
            {
                
System.out.print("\033[H\033[2J");
                break;
            }
            else{
                System.out.println("invalid choice");
            }
        }
    }
    public static void main(String[] args) 
    {
        while(true)
        {
            System.out.print("\tWelcome to the Library\n1.Admin\n2.user\n3.exit\nenter choice : ");
            int choice=sc.nextInt();
            if(choice==1)
            {
                System.out.println("Enter admin username : ");
                String adminname=sc.next();
                System.out.println("Enter admin password : ");
                String adminpass=sc.next();
                if(adminname.equals(adminusername) && adminpass.equals(password))
                {
                    Admin();
                }
                else{
                    System.out.println("invalid credentials");
                }
            }
            else if(choice==2)
            {
                userid();
            }
            else if(choice==3)
            {
                break;
            }
            else{
                System.out.println("invalid choice");
            }
        }
    }
}
