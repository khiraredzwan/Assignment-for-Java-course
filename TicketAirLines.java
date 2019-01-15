public class TicketAirLines extends LinkList
{
   private String name; 
   private int numOfAdult;
   private int numOfChild;
   private int numOfInfant;
   private String flightType;
   private String packages;
   private String departDate;
   
   public TicketAirLines()
   {
        name=null;
        numOfAdult=0;
        numOfChild=0;
        numOfInfant=0;
        flightType=null;
        packages=null;
        departDate=null;
   }
    
   public TicketAirLines(String n, int adult, int child, int infant, String flightT, String _packages, String date)
   {
       name=n;
       numOfAdult=adult;
       numOfChild=child;
       numOfInfant=infant;
       flightType=flightT;
       packages=_packages;
       departDate=date;
   }
   
   public void setName(String n){ name=n;}
   public void setNumOfAdult(int adult){numOfAdult=adult;} 
   public void setNumOfChild(int child){numOfChild=child;} 
   public void setNumOfInfant(int infant){numOfInfant=infant;} 
   public void setFlightType(String flightT){flightType=flightT;}
   public void setPackages(String _packages){packages=_packages;}
   public void setDate(String date){departDate=date;}
   
   public String getName(){return name;}
   public int getNumOfAdult(){return numOfAdult;}
   public int getNumOfChild(){return numOfChild;}
   public int getNumOfInfant(){return numOfInfant;}
   public String getFlightType(){return flightType;}
   public String getPackages(){return packages;}
   public String getDate(){return departDate;}
   
   public double calGrandPriceDomestic()
   {
        double price=0; double taxes=0; double GrandPrice=0;
        if (packages=="DA")
        {
            price=(150.00*getNumOfAdult())+ (85.00*getNumOfChild());
            taxes=0.04*price;
            GrandPrice=price+taxes;
        }
        else if(packages=="DB")
        {
            price=(200.00*getNumOfAdult())+ (100.00*getNumOfChild());
            taxes=0.09*price;
            GrandPrice=price+taxes;
        }
        else if(packages=="DC")
        {
            price=(100.00*getNumOfAdult())+ (70.00*getNumOfChild());
            taxes=0.03*price;
            GrandPrice=price+taxes;
        }
        else if(packages=="DD")
        {
            price=(95.00*getNumOfAdult())+ (55.00*getNumOfChild());
            taxes=0.03*price;
            GrandPrice=price+taxes;
        }
        else 
        {
            price=(95.00*getNumOfAdult())+ (55.00*getNumOfChild());
            taxes=0.03*price;
            GrandPrice=price+taxes;
        }
        return GrandPrice;
    }
    
    public double calGrandPriceInternational()
    {
        double price=0; double taxes=0; double GrandPrice=0;
        if(packages== "IA")
        {
            price=(2600.00*getNumOfAdult())+ (2000.00*getNumOfChild());
            taxes=1.7*price;
            GrandPrice=price+taxes;
        }
        else if(packages== "IB")
        {
            price=(1500*getNumOfAdult())+ (1000.00*getNumOfChild());
            taxes=1.5*price;
            GrandPrice=price+taxes;
        }
        else if(packages== "IC")
        {
            price=(3000.00*getNumOfAdult())+ (2400.00*getNumOfChild());
            taxes=1.9*price;
            GrandPrice=price+taxes;
        }
        else if(packages== "ID")
        {
            price=(3200.00*getNumOfAdult())+ (2600.00*getNumOfChild());
            taxes=1.8*price;
            GrandPrice=price+taxes;
        }
        else 
        {
            price=(2000.00*getNumOfAdult())+ (1600.00*getNumOfChild());
            taxes=1.8*price;
            GrandPrice=price+taxes;
        }
        return GrandPrice;
        
   }
   
   public String toString()
   {
       if(flightType == "Inter")
       return "\n"+ name +", "+packages +", "+departDate +", RM" + calGrandPriceInternational()+"";
       else
       return "\n"+ name +", "+packages +", "+departDate +", RM" + calGrandPriceDomestic()+"";
          
   }
    
    
   }

