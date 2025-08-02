import java.util.ArrayList;
import java.util.List;
class Passanger
{
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getFare() {
        return fare;
    }

    public void setFare(float fare) {
        this.fare = fare;
    }
    float fare;
    public Passanger(int id, float fare)
    {
        this.id=id;
        this.fare=fare;
    }
}
public class BusProb {
   
    public String output(int capacity, int stops, List<String> listOfInputStrings, String query)
    {	
    	String queryIndex=query.substring(0,1);
    	String subQuery="";
    	if(query.length()>1) {
    		subQuery=query.substring(3);
    	}
        String outstring="";
        if(queryIndex.equals("1")){
        	int in = 0,out=0;
        	for(String values : listOfInputStrings) {
        		String[] ids = values.split(" ");
        		for(String id : ids) {
        			if(id.charAt(0)=='+') {
        				in++;
        			}else {
        				out++;
        			}
        		}
        	}
        	outstring= in+" passengers got on the bus and "+ out +" passengers got out of the bus";
        	
        }else if(queryIndex.equals("2")){
        	
        	double occupancy = 0;
        	int lessThanQuater=0,moreThanQuater=0,moreThanHalf=0;
        	for(String values : listOfInputStrings) {
        		String[] ids = values.split(" ");
        		for(String id : ids) {
        			if(id.charAt(0)=='+') {
        				occupancy+=1;
        			}else {
        				occupancy-=1;
        			}
        		}
        		for(String id : ids) {
        			if(id.charAt(0)=='+') {
        				if(occupancy<=Math.ceil( capacity/4.0 )) {
        					lessThanQuater+=1;
        				}else if(occupancy> Math.ceil( capacity/4.0 ) && occupancy<=Math.ceil( capacity/2.0 )){
        					moreThanQuater+=1;
        				}else if(occupancy> Math.ceil( capacity/2.0 )) {
        					moreThanHalf+=1;
        				}
        			}
        			
        		}	
        		
        	}
        	outstring = lessThanQuater +" passengers traveled with a fare of "+String.format("%.1f", (capacity*1.6))+", "+moreThanQuater+" passengers traveled with a fare of "+String.format("%.1f", (capacity*1.3))+" and "+moreThanHalf+" passengers traveled with a fare of "+String.format("%.1f", (capacity*1.0));  
        			
        }else if(queryIndex.equals("3")){
        	double occupancy = 0,totalSpend=0;
        	int lessThanQuater=0,moreThanQuater=0,moreThanHalf=0;
        	for(String values : listOfInputStrings) {
        		String[] ids = values.split(" ");
        		for(String id : ids) {
        			if(id.charAt(0)=='+') {
        				occupancy+=1;
        			}else {
        				occupancy-=1;
        			}
        		}
        		for(String id : ids) {
        			if(id.charAt(0)=='+' && id.substring(1).equals(subQuery)) {
        				if(occupancy<=Math.ceil( capacity/4.0 )) {
        					lessThanQuater+=1;
        				}else if(occupancy> Math.ceil( capacity/4.0 ) && occupancy<=Math.ceil( capacity/2.0 )){
        					moreThanQuater+=1;
        				}else if(occupancy> Math.ceil( capacity/2.0 )) {
        					moreThanHalf+=1;
        				}
        			}
        			
        		}
        		totalSpend = lessThanQuater*(capacity*1.6) + moreThanQuater*(capacity*1.3) + moreThanHalf*capacity;
        		outstring = "Passenger "+subQuery +" spent a total fare of "+String.format("%.1f", totalSpend);
        		
        	}
        	
        }else if(queryIndex.equals("4")){
        	int count=0;
        	for(String values : listOfInputStrings) {
        		String[] ids = values.split(" ");
        		for(String id : ids) {
        			if(id.charAt(0)=='+' && id.substring(1).equals(subQuery)) 
        				count+=1;
        		}
        	}
        	
        	outstring="Passenger "+subQuery+" has got on the bus for "+count+" times";
        		
        }else if(queryIndex.equals("5")){
        	int count=0;
        	for(String values : listOfInputStrings) {
        		String[] ids = values.split(" ");
        		for(String id : ids) {
        			if(id.charAt(0)=='+' && id.substring(1).equals(subQuery)) 
        				count+=1;
        			else if(id.charAt(0)=='-' && id.substring(1).equals(subQuery)) 
        				count-=1;
        		}
        	}
        	if(count==1) {
        		outstring="Passenger "+subQuery+" was inside the bus at the end of the trip";
        	}else 
        		outstring="Passenger "+subQuery+" was not inside the bus at the end of the trip";

        }
        return outstring;
    }
    
    public static void main(String[] args) {
    	int capacity=0,stops=0;
    	List<String> listOfInputs=new ArrayList<>();
    	BusProb bp = new BusProb();
    	capacity=30;
        stops=12;
        listOfInputs.add("+100 +101 +102 +103 +104 +105 +106 +107 +108 +109");
        listOfInputs.add("+110 +111 +112 +113 +114 +115 +116 +117 +118 +119 -104 -107");
        listOfInputs.add("+120 +121 +122 +123 +124 +125 -101 -111 -115 -112 -102");
        listOfInputs.add("+126 +127 +128 +129 +130 +131 +132 +133 -120 -110");
        listOfInputs.add("+134 +135 +136 +137 +138 -100 -103");
        listOfInputs.add("+101 +104 +139 +140 -105 -106 -108 -109");
        listOfInputs.add("-113 -114 -116 -117 -118 -119 -121 -122 -123 -124 -125 -126 -127 -128 -129 -130 -131 -132 -133 -134 -135 -136 -137");
        listOfInputs.add("+141 +142");
        listOfInputs.add("+143 +144 +121 +122 +123 +124 +125 +126 -101 -139 -138 -104");
        listOfInputs.add("+145 +146 +147 +148 +149 -143 -144 -124 -125 -126");
        listOfInputs.add("+150 +151 +152 +153 +154 +155 +101 +125 +124 +104 -123 -145 -146");
        listOfInputs.add("+156 -101 -147 -148 -149 -150 -154");
        String query="4, 104";
        String actual=bp.output(capacity, stops, listOfInputs, query);
        //assertEquals(1910926845, actual.hashCode());
        
        System.out.println("actual hascode : "+actual.hashCode()+ " actual : "+ actual );
    }
}
