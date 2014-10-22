import java.io.*;
import java.util.LinkedList ;

public class Loadarticle {
	private static final String[][] String = null;
	public static void Load() throws IOException{
		long time1, time2 ;
		time1 = System.currentTimeMillis() ;
		FileReader Pa = new FileReader("C:\\The_Dream_of_the_Red_Chamber.txt") ;
		int c = Pa.read();
		int total = 0 ; //字數
		int[][] Htable = new int[100000][2] ;//[0][1]:次數/字碼
		Htable[10][0] = -1 ;
		Htable[32][0] = -1 ;
		Htable[42][0] = -1 ;
		Htable[48][0] = -1 ;
		Htable[49][0] = -1 ;
		Htable[50][0] = -1 ;
		Htable[183][0] = -1 ;
		Htable[8212][0] = -1 ;
		Htable[8230][0] = -1 ;
		Htable[12288][0] = -1 ;
		Htable[12289][0] = -1 ;
		Htable[12290][0] = -1 ;
		Htable[12298][0] = -1 ;
		Htable[12299][0] = -1 ;
		Htable[12300][0] = -1 ;
		Htable[12301][0] = -1 ;
		Htable[12302][0] = -1 ;
		Htable[12303][0] = -1 ;
		Htable[12308][0] = -1 ;
		Htable[12309][0] = -1 ;
		Htable[65281][0] = -1 ;
		Htable[65288][0] = -1 ;
		Htable[65292][0] = -1 ;
		Htable[65293][0] = -1 ;
		Htable[65289][0] = -1 ;
		Htable[65306][0] = -1 ;
		Htable[65307][0] = -1 ;
		Htable[65311][0] = -1 ;
		
		while(c != -1){ //直接映射 編碼 = 位置			
			if(Htable[c][0] == -1) //如果是標點符號，再讀
			{
				c = Pa.read() ;
				continue ;
			}
			else
			{
				Htable[c][0]++ ;
				Htable[c][1] = c ;
				total++ ;
			}
			c = Pa.read() ;
		}
		
		int s , e ; //讓第一個雲素非0
		for( s = 0 ; Htable[s][0] <= 0 ; s++ ) ; //縮減陣列範圍
		for( e = 99999 ; Htable[e][0] <= 0 ; e-- ) ;
		int p , sorted ;
		int value ; //字的數量
		int index ; //字的編號
		//insert sort
		for(p=s+1; p<e+1 ; p++){
			value = Htable[p][0] ; //抓new 值
			index = Htable[p][1] ;
			sorted = p - 1 ;
			while( sorted >= s && Htable[sorted][0] > value){
				Htable[sorted+1][0] = Htable[sorted][0] ;
				Htable[sorted+1][1] = Htable[sorted][1] ; 
				sorted = sorted - 1 ; 
			}
			Htable[sorted + 1][0] = value ;
			Htable[sorted + 1][1] = index ;
			
		}
		FileWriter output = new FileWriter("D:\\output.txt" );
		PrintWriter out = new PrintWriter(output) ;
		out.println("字頻序號\t字:出現次數\r\n") ;
		s=1 ;
		for(c = e ; c >= 0 ; c--){
			if(Htable[c][0] > 0){
				out.println(s+"\t\t"+(char)Htable[c][1] + ":" + Htable[c][0]) ;
				s++ ;
			}
			if(!(Htable[c][0] != 0))
				break ;
		}
		time2 = System.currentTimeMillis() ;
		out.println("\r\n紅樓夢有"+total+"字而時間共花了"+(time2-time1)+"ms") ;
		Pa.close() ;
		output.close() ;
		
		
	}
}
