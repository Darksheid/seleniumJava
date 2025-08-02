package playground;


import java.util.*;



public class TreemapHandson {
    
    public TreeMap<Integer,String> createPlayerPositionMap(String cricketDataset)
    {
    	TreeMap<Integer,String> res = new TreeMap<Integer,String>();
    	String[] playerinfo = cricketDataset.split("\\|");
    	for(String data : playerinfo) {
    		Integer posn = Integer.valueOf(data.split(",")[0]);
    		String name = data.split(",")[1];
    		res.put(posn, name);
    	}
        
        return res;
        
    }
    
    public TreeMap<String,Integer> createPlayerScoreMap(String cricketDataset)
    {
    	TreeMap<String,Integer> res = new TreeMap<String,Integer>();
    	String[] playerinfo = cricketDataset.split("\\|");
    	for(String data : playerinfo) {
    		Integer score = Integer.valueOf(data.split(",")[2]);
    		String name = data.split(",")[1];
    		res.put(name, score);
    	}
        
        return res;
        
    }
    public TreeMap<?,?> createMatchesMap(String cricketDataset)
    {
           
        return new TreeMap<>() ;
    }
    
    
    public String getQuery(String cricketDataset,String query)
    {
    	cricketDataset= cricketDataset.replace("\n","|");
    	System.out.println(cricketDataset);
        String[] queryFilter = query.split(" ");
        String res="";
        
        TreeMap<Integer,String> posnMap = createPlayerPositionMap(cricketDataset);
        TreeMap<String,Integer> scoreMap  = createPlayerScoreMap(cricketDataset);
        
        if(queryFilter[0].equals("1")) {
        	int start = Integer.valueOf(queryFilter[1]);
        	int end = Integer.valueOf(queryFilter[2]);
        	for(Integer pos : posnMap.keySet() ) {
        		if(pos>=start && pos<=end) {
        			res=res+pos+" "+posnMap.get(pos)+"\n";
        		}
        	}
        	
        }else if(queryFilter[0].equals("2")) {
        	int th = Integer.valueOf(queryFilter[1]);
        	for(Integer pos : posnMap.keySet() ) {
        		if(scoreMap.get(posnMap.get(pos))>th) {
        			res=res+pos+" "+posnMap.get(pos)+"\n";
        		}
        	}
        	
        	
        }else {
        	Map<String,Integer[]> mapPlayer = new HashMap<String,Integer[]>();
        	String[] matchScore = cricketDataset.split("\\|");
        	Integer[] countMatchAndScore = {0,0};
        	for(String eachMatch : matchScore) {
        		String name = eachMatch.split(",")[1];
        		if(eachMatch.split(",")[0].equals("1"))
        			mapPlayer.put(name, countMatchAndScore);
        	}
        	
        	for(String eachMatch : matchScore) {
        		Integer[] arr = {0,0};
        		if(eachMatch.split(",")[0].equals("1")){
	        		Integer score = Integer.valueOf(eachMatch.split(",")[2]);
	        		String name = eachMatch.split(",")[1];
	        		arr[0]=mapPlayer.get(name)[0]+1;
	        		arr[1]=mapPlayer.get(name)[1]+score;
	        		mapPlayer.put(name, arr );
        		}
        	}
        	
        	
        	
        	double maxavg = 0.0;
        	String mvp = "";
        	for(String name : mapPlayer.keySet()) {
        		int matchesplayed = mapPlayer.get(name)[0];
        		int totalscore = mapPlayer.get(name)[1];
        		double playeravg = (totalscore/matchesplayed);
        		System.out.println(" name : "+name+" opened : "+matchesplayed+" totalscore as opener : "+totalscore+" avg: "+playeravg);
        		if(playeravg > maxavg) {
        			maxavg=playeravg;
        			mvp = name;
        		}
        	}
        	res="The Efficient Opener is "+mvp;

        }
        return res;
    }
    
    
    public static void main(String[] args) {
    	TreemapHandson  th = new TreemapHandson();
    	String expected="The Efficient Opener is Rohit";
        String actual=th.getQuery("1,Rohit,100|2,Virat,56|3,Dhoni,150\n3,Rahul,90|2,Virat,100|1,Rohit,99\n1,Rahul,50|2,Virat,64|3,Rohit,78\n1,Dhoni,95|2,Virat,30|3,Rohit,45\n1,Jadeja,43|2,Virat,54|3,Rohit,78|4,Dhoni,59\n1,Rahul,60|2,Virat,56|3,Rohit,69", "3");
    	System.out.println(actual);
    }
    
}

