import java.util.*;
public class ama21
{

    static Scanner sc=new Scanner(System.in);
    static List<Integer> merchantids=new ArrayList<>();
    static List<Integer> userids=new ArrayList<>();
    static List<Integer> userwalletmoney=new ArrayList<>();
     static List<String> merchantnames=new ArrayList<>();
     static List<String> merchantspasswords=new ArrayList<>();
     static List<Integer> merchantstatus=new ArrayList<>();
     static List<String> usernames=new ArrayList<>();
     static List<String> userpasswords=new ArrayList<>();
     static List<String> merchantproducts=new ArrayList<>();
     static List<Integer> price=new ArrayList<>();
     static List<Integer> quantity=new ArrayList<>();
     static List<String> usercart=new ArrayList<>();
     static List<String> dupusercart=new ArrayList<>();
     static List<String> cartprices=new ArrayList<>();
     static List<String> dupcartprices=new ArrayList<>();
     static List<String> previousorders=new ArrayList<>();
     static int currentuser=-1,usercurrentid=-1;
     static int updatedcartmoney=0;
    public static void admin()
    {
    System.out.println("\tAdmin logged successfully");
    
    while(true)
    {
    System.out.println("----");
    System.out.print("1.List all merchants\n2.merchants waiting list\n3.delete merchant\n4.View all products\n5.exit");
    System.out.print("\nEnter choice : ");
    int adminchoice=sc.nextInt();
    if(adminchoice==1)
    {
        for(int i=0;i<merchantstatus.size();i++)
        {
            if(merchantstatus.get(i)==1)
            {
            System.out.println("Merchant ID : "+merchantids.get(i)+"\nMerchant Name : "+merchantnames.get(i));
            
            }
        }
    }
    else if(adminchoice==2)
    {
        for(int i=0;i<merchantstatus.size();i++)
        {
            if(merchantstatus.get(i)==-1)
            {
                System.out.print(merchantids.get(i)+"\n"+merchantnames.get(i)+"\n");
                System.out.println(" 1 for approve /  0 to disapprove");
                System.out.print("enter choice : ");
                int adminapp=sc.nextInt();
                if(adminapp==1)
                {
                    merchantstatus.set(i,1);
                    System.out.println("\tapproved successfully");
                    System.out.println("------");
                }
                else if(adminapp==0)
                {
                    merchantstatus.set(i, 0);
                    System.out.println("\tdisapproved successfully");
                    System.out.println("------");
                }
                else
                {
                    break;
                }
            }
        }
    }
    else if(adminchoice==3)
    {
        for(int i=0;i<merchantstatus.size();i++)
        {
            if(merchantstatus.get(i)==1)
            {
                System.out.print("Merchant ID : "+merchantids.get(i)+"\nMerchant Name : "+merchantnames.get(i));
                System.out.println();
            }
        }
        

        System.out.println("enter merchant id : ");
        int deleteid=sc.nextInt();
        for(int i=0;i<merchantids.size();i++)
        {
            if(deleteid==merchantids.get(i))
            {
                merchantids.remove(i);
                merchantnames.remove(i);
                merchantspasswords.remove(i);
                merchantstatus.remove(i);
                for(int j=0;j<merchantproducts.size();j++)
                {
                    if(Integer.toString(deleteid).equals(merchantproducts.get(j).substring(0,3)))
                    {
                        merchantproducts.remove(j);
                        price.remove(j);
                        quantity.remove(j);
                    }
                }
                System.out.println("\tmerchant removed successfully");
            }
        
    }
    }
    else if(adminchoice==4)
    {
       for(int i=0;i<merchantproducts.size();i++)
       {
           System.out.println("Product : "+merchantproducts.get(i)+"\nPrice : "+price.get(i)+"\nQuantity : "+quantity.get(i));
       }
       System.out.println("\tfetched successfully");
    }
    else if(adminchoice==5)
    {
       break;
    }
    
    else
    {
        System.out.println("invalid choice");
    }
    }
    }
    public static void merchant()
    {
        System.out.println("\t"+merchantnames.get(currentuser)+" logged in successfully");
        while(true)
        {
            System.out.println("-----\n1.Add product\n2.review product\n3.update product\n4.exit");
           
            System.out.print("enter choice : ");
            int merchantchoice=sc.nextInt();
            if(merchantchoice==1)
            {
                
                    System.out.println("enter product name : ");
                    String product=sc.next();
                    String updateproname=merchantids.get(currentuser)+product;
                    merchantproducts.add(updateproname);
                    System.out.println("enter price of product : ");
                    int priceofpro=sc.nextInt();
                    price.add(priceofpro);
                    System.out.println("enter quantity of product : ");
                    int quan=sc.nextInt();
                    quantity.add(quan);
                    System.out.println("\tproduct added successfully");

                
              

            }
            else if(merchantchoice==2)
            {
                for(int i=0;i<merchantproducts.size();i++)
                {
                    String pro=merchantproducts.get(i);
                    String id=Integer.toString(merchantids.get(currentuser));
                    if(pro.substring(0,3).equals(id))
                    {
                        System.out.println("Product name : "+pro.substring(3)+"\nPrice : "+price.get(i)+"\nQuantity : "+quantity.get(i));
                    }
                }
            }
            else if(merchantchoice==3)
            {
                for(int i=0;i<merchantproducts.size();i++)
                {
                    if(merchantproducts.get(i).substring(0,3).equals(Integer.toString(merchantids.get(currentuser))))
                    {
                        System.out.println("Product name : "+merchantproducts.get(i).substring(3));
                        System.out.println("Price : "+price.get(i));
                        System.out.println("Quantity : "+quantity.get(i));

                    }
                }
                System.out.print("enter product name to be updated : ");
                String produ=sc.next();
                for(int i=0;i<merchantproducts.size();i++)
                {
                    if(merchantproducts.get(i).substring(0,3).equals(Integer.toString(merchantids.get(currentuser))) && merchantproducts.get(i).substring(3).equals(produ) )
                    {
                        System.out.println("enter updated name : ");
                        String upd=sc.next();
                        System.out.println("enter updated price : ");
                        int updp=sc.nextInt();
                        System.out.println("enter updated quantity : ");
                        int updq=sc.nextInt();
                        String updt=merchantproducts.get(i).substring(0,3)+upd;
                        merchantproducts.set(i, updt);
                        price.set(i, updp);
                        quantity.set(i, updq);
                        System.out.println("\tproduct updated successfully");
                    }
                }
            }
            else if(merchantchoice==4)
            {
                break;
            }
            else
            {
                System.out.println("invalid choice");
            }
        }
    }
    public static void merchantID()
    {
        while(true)
        {
        System.out.println("\tMerchant login panel");
        System.out.print("1.Existing merchant\n2.New merchant\n3.exit\n");
        System.out.print("Enter choice : ");
        int choi=sc.nextInt();
        if(choi==2)
        {
            
            System.out.println("Enter username : ");
            String newmerchantname=sc.next();
            System.out.println("enter password : ");
            String newmerchantpass=sc.next();
            System.out.println("confirm password : ");
            String newmerchantfinalpass=sc.next();
            if(newmerchantpass.equals(newmerchantfinalpass))
            {
                merchantids.add(101+merchantids.size());
                merchantnames.add(newmerchantname);
                merchantspasswords.add(newmerchantpass);
                merchantstatus.add(-1);
            }

    }
    else if(choi==1)
    {
        System.out.println("Enter username : ");
        String merchantname=sc.next();
        System.out.println("enter password : ");
        String merchantpass=sc.next();
        for(int i=0;i<merchantids.size();i++)
        {
            if(merchantnames.get(i).equals(merchantname) && merchantspasswords.get(i).equals(merchantpass))
            {
                if(merchantstatus.get(i)==-1)
                {
                    System.out.println("waiting for admin approval");
                }
                else if(merchantstatus.get(i)==1)
                {
                   // System.out.println(merchantnames.get(i)+" logged in successfully");
                    currentuser=i;
                    merchant();
                }
                else if(merchantstatus.get(i)==0)
                {
                    System.out.println("admin rejected ur request");
                }
            }
        }

    }
    else if(choi==3)
    {
        break;
    }
    else{
        System.out.println("invalid choice");
    }
}
}
    public static void userID()

    {
        while(true)
        {
        System.out.println("\tUser login panel");
        System.out.print("1.Existing user\n2.New user\n3.exit\n");
        System.out.print("Enter choice : ");
        int userchoi=sc.nextInt();
        if(userchoi==1)
        {
            int use=0;
            System.out.println("Enter username");
            String username=sc.next();
            System.out.println("enter password");
            String userpass=sc.next();
            for(int i=0;i<usernames.size();i++)
            {
               if(username.equals(usernames.get(i)) && userpass.equals(userpasswords.get(i)))
               {
                    usercurrentid=i;
                    user();
                    use++;
               }
            } 
            if(use==0)
            {
                System.out.println("account not found");
            } 
        }
        else if(userchoi==2)
        {
            System.out.println("Enter username");
            String newusername=sc.next();
            System.out.println("enter password");
            String newuserpass=sc.next();
            System.out.println("confirm password");
            String newuserfinalpass=sc.next();
           

            if(newuserpass.equals(newuserfinalpass))
            {
               userids.add(201+userids.size());
                usernames.add(newusername);
                userpasswords.add(newuserpass);
                System.out.println("would you like to add money in ur wallet\n1.yes\n2.no");
                int wallet=sc.nextInt();
                if(wallet==1)
                {
                    System.out.println("enter amount to be added : ");
                    int add=sc.nextInt();
                    userwalletmoney.add(add);
                    System.out.println("\tamount added successfully");
                }
                else if(wallet==2){
                    userwalletmoney.add(0);
                }

               
            }
        }
        else if(userchoi==3)
        {
            break;
        }
        else{
            System.out.println("invalid choice");
        }
        }
    }
    public static void user()
    {
        System.out.println("\t"+usernames.get(usercurrentid)+" logged in successfully");
        while(true)
        {
            System.out.print("1.available products\n2.go to cart\n3.check wallet balance\n4.order history\n5.exit\nenter choice : ");
            int userchoi=sc.nextInt();
            if(userchoi==1)
            {
        
            for(int i=0;i<merchantproducts.size();i++)
            {

                System.out.println("Product name : "+merchantproducts.get(i).substring(3)+"   Price : "+price.get(i));
            }
            while(true)
            {
            System.out.print("\n1.add products to ur cart\n2.exit\n");
            System.out.print("enter choice : ");
            int use=sc.nextInt();
            if(use==1)
            {
            System.out.print("enter product name : ");
            String pro=sc.next();
            System.out.print("enter product price : ");
            int pri=sc.nextInt();
            for(int i=0;i<merchantproducts.size();i++)
            {
                if(pro.equals(merchantproducts.get(i).substring(3)) && pri==price.get(i))
                {
                    if(quantity.get(i)>0)
                    {
                    //usercart.add(Integer.toString(userids.get(usercurrentid))+Integer.toString(merchantids.get(i))+merchantproducts.get(i).substring(3));
                    usercart.add(Integer.toString(userids.get(usercurrentid))+merchantproducts.get(i));
                   cartprices.add(Integer.toString(userids.get(usercurrentid))+Integer.toString(price.get(i)));
                   dupusercart.add(Integer.toString(userids.get(usercurrentid))+merchantproducts.get(i));
                    dupcartprices.add(Integer.toString(userids.get(usercurrentid))+Integer.toString(price.get(i)));
                   System.out.println("\tProduct added successfully");
                    }
                    else
                    {
                        System.out.println("out of stock");
                    }
                }
                
            }
        }
        else if(use==2)
        {
            break;
        }
        }
        }
        else if(userchoi==2)
        {
            int cartamount=0;
            for(int i=0;i<dupusercart.size();i++)    
            {
                if(Integer.toString(userids.get(usercurrentid)).equals(dupusercart.get(i).substring(0,3)))
                {
                    cartamount=cartamount+Integer.parseInt(dupcartprices.get(i).substring(3));
                  
                }
              
            } 
            System.out.println("items in the cart");
            for(int i=0;i<dupusercart.size();i++)
            {
                if(dupusercart.get(i).substring(0,3).equals(Integer.toString(userids.get(usercurrentid))) && Integer.toString(userids.get(usercurrentid)).equals(cartprices.get(i).substring(0,3)))
                {
                    System.out.println("product name : "+dupusercart.get(i).substring(6)+" price : "+dupcartprices.get(i).substring(3));
                }
            }
            System.out.println("\ttotal cost of cart :" +cartamount);
            
            while(true)
            { 
            System.out.print("to buy items in cart\n1.to check out using wallet\n2.go for COD\n3.exit\nenter choice : ");
            int buyuser=sc.nextInt();
            int c;
            if(buyuser==1)
            {
                c=0;
                if(cartamount<=userwalletmoney.get(usercurrentid))
                {
                   
                    for(int i=0;i<usercart.size();i++)
                    {
                       
                            if(usercart.get(i).substring(0,3).equals(Integer.toString(userids.get(usercurrentid))))
                            {
                                for(int j=0;j<merchantproducts.size();j++)
                                {
                                    if(usercart.get(i).substring(3).equals(merchantproducts.get(j)))
                                    {
                                        
                                        int updatedquanity=quantity.get(j)-1;
                                       
                                        quantity.set(j, updatedquanity);
                                        c++;
                                        previousorders.add(dupusercart.get(i));
                                        dupusercart.remove(i);
                                        dupcartprices.remove(i);
                                       System.out.println("\tbought successfully");
                                    }
                                }
                            }
                    }
                    if(c>0)
                    {
                         updatedcartmoney=userwalletmoney.get(usercurrentid)-cartamount;
                        userwalletmoney.set(usercurrentid,updatedcartmoney);
                    }
                }
                else
                {
                    System.out.println("insufficient amount");
                }
            }
            else if(buyuser==2)
            {
                for(int i=0;i<usercart.size();i++)
                    {
                       
                            if(usercart.get(i).substring(0,3).equals(Integer.toString(userids.get(usercurrentid))))
                            {
                                for(int j=0;j<merchantproducts.size();j++)
                                {
                                    if(usercart.get(i).substring(3).equals(merchantproducts.get(j)))
                                    {
                                        
                                        int updatedquanity=quantity.get(j)-1;
                                       
                                        quantity.set(j, updatedquanity);
                                        
                                        previousorders.add(dupusercart.get(i));
                                        dupusercart.remove(i);
                                        dupcartprices.remove(i);
                                       System.out.println("\tbought successfully and payment should be done at the time of delivery");
                                    }
                                }
                            }
              
            } 
               

            }
            else if(buyuser==3)
            {
                break;
            }
            else{
                System.out.println("invalid input");
            }
            }
        }
    
    
    
        else if(userchoi==3)
        {
           
            while(true)
            {
                System.out.print("1.add money to wallet\n2.check balance\n3.exit\nenter choice : ");
               int wall=sc.nextInt();
               if(wall==1)
               {
                   System.out.print("enter amount : ");
                   int add=sc.nextInt();
                   int up=userwalletmoney.get(usercurrentid)+add;
                   userwalletmoney.set(usercurrentid, up);
                   System.out.println("\tamount added successfully");
               }
               else if(wall==2)
               {
                System.out.println(userwalletmoney.get(usercurrentid));
               }
               else if(wall==3)
               {
                   break;
               }
            }
        }
        else if(userchoi==4)
        {
           for(int i=0;i<previousorders.size();i++)
           {
                System.out.println("product name : " +previousorders.get(i).substring(6));
           }
        } 
        else if(userchoi==5)
        {
            break;
        }
        else{
            System.out.println("invalid input");
       }  
    }   
     
    }
 public static void main(String[] args) 
    {
    String adminuserid="mysite";
    String adminpin="0000";
    while(true)
    {
    System.out.print("\tWelcome to my site\n");
    System.out.print("1.Admin\n2.Merchant\n3.User\n4.Exit\n");
    System.out.print("Enter choice : ");
    int choice=sc.nextInt();
  
    if(choice==1)
    {
       
        System.out.println("Enter adminusername : ");
        String adminuser=sc.next();
        System.out.println("Enter adminpassword : ");
        String password=sc.next();
        if(adminuser.equals(adminuserid) && password.equals(adminpin))
        {
            admin();
        }
        else
        {
            System.out.println("invalid credentials");
        }

    }
    else if(choice==2)
    {
      
       merchantID();
    }
    else if(choice==3)
    {
        userID();
    }
    else if(choice==4)
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
}
