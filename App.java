

/*linked list, queue = domestic, international 
   */ 
import java.io.*;
import java.util.*;

public class App
{
    public static void main(String[] args) throws IOException, FileNotFoundException {
    
        Scanner in = new Scanner(System.in);        
        Scanner inLine = new Scanner(System.in);   
        int countSize = 0;
        boolean isContinue = true;
        TicketAirLines cust = new TicketAirLines();
        LinkList ticketList = new LinkList();
        LinkList tempList = new LinkList();
        Queue domesticQ = new Queue();
        Queue internationalQ = new Queue();
        Queue tempD = new Queue();
        Queue tempI = new Queue();

        while(isContinue) {
            System.out.println("\n*****************************************");
            System.out.println("       KL AirLines Ticketing System      ");
            System.out.println("*****************************************");
            System.out.println("1. Show The Packages");
            System.out.println("2. Enter Customer Info");
            System.out.println("3. Payment ");
            System.out.println("4. Customer's name for Domestic");
            System.out.println("5. Customer's name for International");
            System.out.println("6. Highest and Lowest payment");
            System.out.println("7. Display data (Name, Package, Date Depart, Total Price) ");
            System.out.println("8. EXIT");
            System.out.print("Enter choice [1/2/3/4/5/6/7/8] : ");
            String opt = in.next();
            
            
            if (opt.charAt(0) == '1') 
            {
               System.out.print("\n"+
               "\n*************************************************"+
               "\n               Domestic Flight                   "+
               "\n**************************************************"+
               "\n|Package | Destination | Price : Adult :  Child  |"+
               "\n|   DA   |   Langkawi  |   RM  :  150  :   85    |"+
               "\n|   DB   |   Sabah     |   RM  :  200  :   100   |"+
               "\n|   DC   |   Johor     |   RM  :  100  :   70    |"+
               "\n|   DD   | Terengganu  |   RM  :  95   :   55    |"+
               "\n|   DE   |   Pahang    |   RM  :  95   :   55    |"+
               "\n**************************************************"+
               "\n              Internatinal Flight                "+
               "\n**************************************************"+
               "\n|Package | Destination | Price : Adult :  Child  |"+
               "\n|   IA   |   London    |   RM  : 2600  :  2000   |"+
               "\n|   IB   |  Australia  |   RM  : 1500  :  1000   |"+
               "\n|   IC   |   Japan     |   RM  : 3000  :  2400   |"+
               "\n|   ID   |   Germany   |   RM  : 3200  :  2600   |"+
               "\n|   IE   |   Mekah     |   RM  : 2000  :  1600   |"+
               "\n**************************************************"+
               "\n");    
            }
            else if (opt.charAt(0) == '2')   
            {   String returnDate;
                System.out.println("Enter the following information");
                System.out.print("Name                                  : ");
                String name = inLine.next();
                System.out.print("Number Of Adult(13 years and above)   : ");
                int numAdult=inLine.nextInt();
                System.out.print("Number Of Child(12 years and below)   : ");
                int numChild=inLine.nextInt();
                System.out.print("Number Of Infant(2 years and below)   : ");
                int numInfant=inLine.nextInt();
                System.out.print("Flight Type (Inter/Domes)             : ");
                String flightType = inLine.next();
                System.out.print("Package (type as in view package)     : ");
                String packages = inLine.next();
                System.out.print("Depart Date(eg. 010214)               : \n");
                String departDate = inLine.next();
                TicketAirLines ticket=new TicketAirLines(name, numAdult, numChild, numInfant, flightType, packages, departDate);
                ticketList.insertAtFront(ticket);
                
                
                if(ticket.getFlightType().equalsIgnoreCase("Domes"))
                      { domesticQ.enqueue(ticket);}
                else
                  {  internationalQ.enqueue(ticket);}
           
                 
            }
            else if(opt.charAt(0) == '3')//Payment
            {
                Object d;
                TicketAirLines t;
                double grandP;
                System.out.print("Enter the name: ");
                String n=in.next();
                d=ticketList.getFirst();
                while(d!=null)
                {
                    t=(TicketAirLines)d;
                    
                    if(t.getName().equalsIgnoreCase(n)&& t.getFlightType().equalsIgnoreCase("Domes")){
                       grandP = t.calGrandPriceDomestic();
                       System.out.print("Payment (include taxes): \n" + grandP);}
                    
                    if(t.getName().equalsIgnoreCase(n)&& t.getFlightType().equalsIgnoreCase("Inter")){
                       grandP = t.calGrandPriceInternational();
                       System.out.print("Payment: (include taxes) \n" + grandP);}     
                            
                    d=ticketList.getNext();
                }
            }
            else if (opt.charAt(0) == '4')// display customer's name from queue DomesticQ
            {
                Object data;
                TicketAirLines tt;
                int c=0;
                System.out.println("Customer's name: ");
                while(!domesticQ.isEmpty())
                {
                    data= domesticQ.dequeue();
                    tt=(TicketAirLines)data;
                    System.out.println("\t"+ (c+1) +". " +tt.getName());
                    tempD.enqueue(data);
                    c++;
                }
                while(!tempD.isEmpty())
                {
                    data = tempD.dequeue();
                    domesticQ.enqueue(data);
                }
            }
            else if (opt.charAt(0) == '5')//display customer's name from queue InternationalQ
            {
                Object data;
                TicketAirLines t;
                int c=0;
                System.out.println("Customer's name: ");
                while(!internationalQ.isEmpty())
                {
                    data= internationalQ.dequeue();
                    t=(TicketAirLines)data;
                    System.out.println("\t"+ (c+1) +". " +t.getName());
                    tempI.enqueue(data);
                    c++;
                }
                while(!tempI.isEmpty())
                {
                    data = tempI.dequeue();
                    internationalQ.enqueue(data);
                }
             }
            else if(opt.charAt(0) == '6')
            {
                Object dataI, dataD;
                TicketAirLines paymentI, paymentD; 
                TicketAirLines lowestD = null; TicketAirLines highestD = null;
                TicketAirLines lowestI = null; TicketAirLines highestI = null;
                double HI, LI, HD, LD;
                
                dataI= internationalQ.dequeue();
                paymentI=(TicketAirLines)dataI;
                HI = paymentI.calGrandPriceInternational();
                LI = paymentI.calGrandPriceInternational();
                lowestI = paymentI; highestI =paymentI;
            
                tempI.enqueue(dataI);
                while(!internationalQ.isEmpty()) 
                {
                    dataI= internationalQ.dequeue();
                    paymentI=(TicketAirLines)dataI;
                    
                    if(paymentI.calGrandPriceInternational()>HI)
                       { HI=paymentI.calGrandPriceInternational();
                        highestI = paymentI;}
                        
                    if(paymentI.calGrandPriceInternational()<LI);
                    {LI=paymentI.calGrandPriceInternational();
                        lowestI = paymentI;}
                    tempI.enqueue(dataI);
                  
                } 
                
                dataD= domesticQ.dequeue();
                paymentD=(TicketAirLines)dataD;
                HD = paymentD.calGrandPriceDomestic();
                LD = paymentD.calGrandPriceDomestic();
                lowestD = paymentD; highestD =paymentD;
                tempD.enqueue(dataD);
                while(!domesticQ.isEmpty())
                {
                    dataD= domesticQ.dequeue();
                    paymentD=(TicketAirLines)dataD;
                    if(paymentD.calGrandPriceDomestic()>HD)
                       { HD=paymentD.calGrandPriceDomestic();
                        highestD = paymentD;}
                        
                    if(paymentD.calGrandPriceDomestic()<LD);
                    {LD=paymentD.calGrandPriceDomestic();
                        lowestD = paymentD;}
                    tempD.enqueue(dataD);
                }
                while(!tempI.isEmpty() || !tempD.isEmpty())
                {
                    dataI = tempI.dequeue();
                    internationalQ.enqueue(dataI);
                    dataD = tempD.dequeue();
                    domesticQ.enqueue(dataD);
                }
                
                System.out.println(
                "Highest for International :" + highestI.getName()+ " -> RM "+ highestI.calGrandPriceInternational()+
                "\nLowest for International  :" + lowestI.getName()+ " -> RM "+ lowestI.calGrandPriceInternational()+
                "\nHighest for Domestic      :" + highestD.getName()+ " -> RM "+ highestD.calGrandPriceDomestic()+
                "\nLowest for Domestic       :" + lowestD.getName()+ " -> RM "+ lowestD.calGrandPriceDomestic());
                
                
            }
            else if (opt.charAt(0) == '7')
            {
                Object data;  TicketAirLines t;
                    System.out.print("(Name, Package, Date Depart, Total Price)\n"+
                                     "\n               Domestic Flight                   "+
                                     "\n-------------------------------------------------");
             
                while(!domesticQ.isEmpty())
                {
                    data= domesticQ.dequeue();
                    t=(TicketAirLines)data;
                    System.out.print(t.toString());
                    tempD.enqueue(data);
                }
                while(!tempD.isEmpty())
                {
                    data = tempD.dequeue();
                    domesticQ.enqueue(data);
                }
                    System.out.print(
                                     "\n-------------------------------------------------");
                    System.out.print("\n"+
                                     "\n"+
                                     "\n              Internatinal Flight                "+
                                     "\n-------------------------------------------------");
                                 
                while(!internationalQ.isEmpty())
                {
                    data= internationalQ.dequeue();
                    t=(TicketAirLines)data;
                    System.out.print(t.toString());
                    tempI.enqueue(data);
                }
                while(!tempI.isEmpty())
                {
                    data = tempI.dequeue();
                    internationalQ.enqueue(data);
                }
                System.out.print(
                                     "\n-------------------------------------------------");
            }
            else if (opt.charAt(0) == '8') { isContinue = false; break; }
            
            else {
                System.out.println("Invalid in");
            }
            
        }
        
        
        System.out.println("System aborted");
    
    }
}

