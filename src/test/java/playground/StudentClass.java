package playground;

public class StudentClass {
	
	public String getQuery(String studentData,String query){
        String res = "";
        String queryIndex = query.substring(0, 1);
        
        if(queryIndex.equals("1")) {
        	String startChar = query.split(",")[1];
        	String[] names = studentData.split(" ");
        	for(String studName : names) {
        		if(startChar.toLowerCase().equals(studName.toLowerCase().substring(0,1))) {
        			res=res+studName+"\n";
        		}
        	}
        }else if(queryIndex.equals("2")) {
        	String[] names = studentData.split(" ");
        	String[] bloodGroups = query.split(",")[1].split(" ");
        	String srcBg = query.split(",")[2];
        	int index=0;
        	for(String studBg : bloodGroups) {
        		if(srcBg.equals(studBg)) {
        			res=res+names[index]+"\n";
        		}
        		index+=1;
        	}
        }else if(queryIndex.equals("3")) {
        	int th = Integer.valueOf(query.split(",")[1]);
        	String[] scores = studentData.split(" ");
        	int count=0;
        	for(String sc : scores) {
        		if(Integer.valueOf(sc)>=th) {
        			count+=1;
        		}
        	}
        	
        	res= count+" students scored "+th+" above";
        	
        }else  {
        	double avg=0,total=0;
        	String[] scores = studentData.split(" ");
        	for(String sc : scores) {
        		total+=Double.valueOf(sc);
        		}
        	
        	avg=total/(scores.length);
        	
        	res= String.format("%.2f", avg);
        	
        }
        
        return res;
		
		
    }

	public static void main(String[] args) {
		StudentClass  stud = new StudentClass();
		String expected = "73.29";
        String actual = stud.getQuery("96 78 93 45 90 42 69", "4");
		System.out.println(actual+"Is equal expected =>" +actual.equals(expected));

	}

}
