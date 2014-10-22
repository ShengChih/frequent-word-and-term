import java.io.* ;
import java.util.* ;


public class program_B {
	public static void main(String[] args) throws IOException {
		new program_B() ;

	}
	public program_B()throws IOException{
		FileReader Pb = new FileReader("C:\\紅樓夢人物.txt") ;
		BufferedReader BufferedStream = new BufferedReader(Pb) ;
		String[] name = new String[1000] ;
		int[] n_value = new int[1000] ;
		String tmp = "" ; 
		int c = 0 ;
		int x = 0 ;
		int indexofname = 0 ;
		
		long time1, time2 ;
		time1 = System.currentTimeMillis() ;
		do{
			tmp = BufferedStream.readLine() ; //讀紅樓夢人物的每一行
			name[c] = tmp ;
			c++ ;
			
			if(tmp==null)
                break;     
		}while(true) ;
		
		Pb.close() ;
		FileReader Ac = new FileReader("C:\\The_Dream_of_the_Red_Chamber.txt") ;
		BufferedReader context = new BufferedReader(Ac) ;
		
		c = c - 1 ;
		String allstr = "" ;
		tmp = "" ;
		
		do{
			
			tmp = context.readLine() ; //讀紅樓夢內容的每一行
			allstr = tmp ; //還原用的
			x = 0 ;
			if(allstr==null)
                break;
			
			while( x < c )
			{
				if((indexofname = tmp.indexOf(name[x]))> 0 ){
					n_value[x]++ ;
					indexofname = indexofname + name[x].length() ;			
					tmp = tmp.substring(indexofname, tmp.length()) ;
				}
				else{
					x++ ;
					tmp = allstr ; 
				}
			}
			  
		}while(true) ;
		
		int value,sorted ;
		String n_data ;
		// insort
		for(x = 1; x < c ; x++){
			value = n_value[x] ; 
			n_data = name[x] ;
			sorted = x - 1 ;
			while( sorted >= 0 && n_value[sorted] > value){
				n_value[sorted+1] = n_value[sorted] ;
				name[sorted+1] = name[sorted] ; 
				sorted = sorted - 1 ; 
			}
			n_value[sorted + 1] = value ;
			name[sorted + 1] = n_data ;
			
		}
		
		FileWriter output = new FileWriter("D:\\outname_sorted.txt" );
		PrintWriter out = new PrintWriter(output) ;
		out.println("人名序號\t人名\t\t出現頻次\r\n") ;
		for(x=c-1,value=1 ; value < 201 ; x--,value++)
		{
			out.println(value+"\t\t"+name[x]+"\t\t"+n_value[x]) ;
		}
		time2 = System.currentTimeMillis() ;
		out.println("\r\n\r\n而時間共花了"+(time2-time1)+"ms") ;
		output.close() ;

	}


}
