package com.telusko;

public class grp {
	public static void main(String args[])
	{
		int i,j,size=5,temp;
		String temp1;
		String[] students= {"a","b","c","d","e"};
		int[] avg= {9,1,5,6,2};
		int len=students.length;
		int grpno;
		grpno=(len+2)/3;
		
		String[][] grp=new String[grpno][3];
		
		for(i=0;i<size-1;i++)
		{
			for(j=0;j<size-1-i;j++)
			{
				if(avg[j]>avg[j+1])
				{
					temp=avg[j];
					avg[j]=avg[j+1];
					avg[j+1]=temp;
					
					temp1=students[j];
					students[j]=students[j+1];
					students[j+1]=temp1;
					
					
				}
			}
		}
		for(i=0;i<size;i++)
		{
			
			System.out.println(avg[i]+students[i]);
//			System.out.println();
		}
		
		System.out.println("\n");
//		
//		int row,x,y;
//		/*for(i=0;i<grpno;i++)
//		{
//			for(x=0;x<3;x++)
//			{
//				students[i][x]
//			}
//		}*/
//		int ctr,m,n=0;
//		ctr=1;
//		for(i=0;i<len;i++)
//		{
//			if(i%grpno==0&&i!=0)
//			{
//				ctr=(-1)*ctr;
//				n=n+1;
//			}
//			if(ctr==1)
//			{
//				m=i%grpno;
//			}
//			else
//			{
//				m=grpno-(i%grpno)-1;
//			}
//			
//			grp[m][n]=students[i];
//			
//		}
//		for(i=0;i<grpno;i++)
//		{
//			for(j=0;j<3;j++)
//			{
//				System.out.println(grp[i][j]);
//			}
//			System.out.println("\n");
//		}
		
			
			
			
		
	}

}

