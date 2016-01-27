package levensthein;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	print(LevenshteinDistance("záhonyi","dániel"));
		
	}

	
	public static void print( int[][] d){
		
		for(int i=0; i<d.length; i++){
			for(int j=0; j<d[i].length;j++)
				System.out.print(d[i][j]);
			System.out.println("");
		}
	}
	
	
	public static int[][] LevenshteinDistance( String s, String t){
		  // for all i and j, d[i,j] will hold the Levenshtein distance between
		  // the first i characters of s and the first j characters of t;
		  // note that d has (m+1)*(n+1) values
		  
		 int[][] d = new int[s.length()+1][t.length()+1];
		
		 for(int i=0; i<s.length()+1;i++)
			 for(int j=0; j<t.length()+1;j++)
				 d[i][j]=0;
			 
		  // source prefixes can be transformed into empty string by
		  // dropping all characters
		  for(int i=1; i<s.length()+1; i++)
		      d[i][0] = i;
		 
		  for(int i=1; i<t.length()+1; i++)
		      d[0][i] = i;
		 
		 print(d);
		  // target prefixes can be reached from empty source prefix
		  // by inserting every character
		 
		  for(int j=1; j<t.length()+1; j++)
			  for(int i=1; i<s.length()+1; i++)
		          {
				  System.out.println(i+","+j);
				 
				  if(s.charAt(i-1)==t.charAt(j-1))
				  {
					
					  d[i][j] = d[i-1][j-1];  
				  }
				  else{
					 int del= d[i-1][j] - 2;
					 int h=  d[i-1][j-1] + 1;
					 int ins = d[i][j-1] - 1;
					  
					 if(h<=del && h<=ins)
			            d[i][j] =h;
					 
					 else if(del<h && del<= ins)
						 d[i][j] =del;
					 else
						 d[i][j] = ins;
				  }
		            
		          } 
		  return d;	
	
	}
	}
