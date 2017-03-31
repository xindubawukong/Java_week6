package dataChooser;

import java.io.*;
import java.util.*;

public class DataChooser {
	Data[] a=new Data[100000];
	int n;
	void init(String filename)throws FileNotFoundException{
		File f=new File(filename);
		Scanner fin=new Scanner(f);
		n=0;
		while (fin.hasNextLine()){
			a[n]=new Data();
			a[n].data=fin.nextLine();
			String[] b=a[n].data.split(" ",10);
			for (int i=0,cnt=0;i<10;i++)
				if (b[i].length()>0){
					cnt++;
					if (cnt==5){
						a[n].value=Integer.parseInt(b[i]);
						break;
					}
				}
			n++;
		}
		fin.close();
	}
	void doit(){
		DataSorter sorter=new DataSorter();
		sorter.sort(a, 0, n-1);
	}
	void outit(String filename) throws FileNotFoundException{
		PrintStream fout=new PrintStream(filename);
		for (int i=0;i<n;i++) fout.println(a[i].data);
		System.out.println(a[0].value);
		fout.close();
	}
}
class Data{
	String data;
	int value;
	boolean cmp(Data b){
		return value<b.value;
	}
}
class DataSorter{
	void sort(Data[] a,int l,int r){
		int i=l,j=r;
		Data x=a[(l+r)>>1];
		while (i<=j){
			while (a[i].cmp(x)) i++;
			while (x.cmp(a[j])) j--;
			if (i<=j){
				Data t=a[i];
				a[i]=a[j];
				a[j]=t;
				i++;j--;
			}
		}
		if (i<r) sort(a,i,r);
		if (j>l) sort(a,l,j);
	}
}