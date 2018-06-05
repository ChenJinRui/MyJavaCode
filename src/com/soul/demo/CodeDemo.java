package com.soul.demo;

import java.util.Arrays;
import java.util.Date;

public class CodeDemo {
	
	public static void main (String [] args){
		
		System.out.println("������Ч����");
		doSinceIncrease();
		System.out.println("λ�����㣺");
		doDisplacement();
		System.out.println("String ������");
		doTest();
		doTestArray();
		doLotteryDraw();
		doTestData();
	}

	/**
	 * ������Ч��
	 * ++n��n++
	 */
	public static void doSinceIncrease(){
		int n = 3;
		int m = 3;
		System.out.println("n is " + n +"\t m is " + m);
		System.out.println("n++ is " + n++ +"\t ++m is " + ++m);
	}
	/**
	 * λ������
	 * << ��������2��index�η�
	 * >> ��������2��index�η�
	 * >>> ����������ע��
	 * 
	 */
	public static void doDisplacement(){
		 /* 
         * 5 
         * ���� ԭ�롢���롢����һ��
         * ��λλ����λ 0 : + ��1 : -
         * 00000000 00000000 00000000 00001000 
         * 
		 * 
         * -5 
         * ����
         *  	�����ȥ��һ������λ��������λȡ��
         *  	�����ȥ����λ���䡢����λȡ������1
         * 10000000 00000000 00000000 00001000  --ԭ�� 
         * 11111111 11111111 11111111 11110111  --���� 
         * 11111111 11111111 11111111 11111000  --���� 
         *  
         * >>
         * 11111111 11111111 11111111 11111100  ����  >>ԭ��������һλ  ��λ������λ
         * 10000000 00000000 00000000 00000100  ԭ�� (-4)
         * 11111111 11111111 11111111 11111011  ����
         * 
         * >>>
         * 01111111 11111111 11111111 11111100  ����  >>>ԭ��������һλ ��λֱ�Ӳ�0
         * 01111111 11111111 11111111 11111100  ԭ�� (2147483644)
         * 01111111 11111111 11111111 11111100  ����
		 * 
         * �ܽ᣺ 
         * 1.>> �迼�Ƿ���λ 
         * 2.>>> �����Ƿ���λ��ȱ�ٵ�λ����0 
         *  
         */
		int n = -8;
		int index = 1;
		int i = n << index;
		int p = n >> index;
		int q = n >>> index ;
		System.out.println("n is " + n + "\t n << " + "index" + index + " is " + i);
		System.out.println("n is " + n + "\t n >> " + "index" + index + " is " + p);
		System.out.println("n is " + n + "\t n >>> " + "index" + index + " is " + q);
	}
	
	public static void doTest(){
		String str = "doTest";
		
		char first = str.charAt(0);
		char last = str.charAt(str.length()-1);
		System.out.println("first: "+first+"\tlast: "+last);
	}
	
	public static void doTestArray(){
		int [] first ;
		int [] second ;
		int [] other = {1,2,3,4,5,6,7};
		//��������Ӧ��ͬһ������������ı�����һ�� ����һ��Ҳ����Ÿı�
		first = other;
		//��������
		second = Arrays.copyOf(other, other.length);
		other[2] = 5;
		System.out.println("first = other is : \n" + Arrays.toString(first));
		System.out.println("second Arrays.copyOf other is : \n" + Arrays.toString(second));
		System.out.println("other is : \n" + Arrays.toString(other));
		//�������ݳ���
		other = Arrays.copyOf(other, other.length+4);
		System.out.println("other Arrays.copyOf other.length+4 is : \n" + Arrays.toString(other));
	}
	
	public static void doLotteryDraw(){
		int n = 35 ;
		int k = 7;
		int [] pool = new int [n];
		int [] results = new int [k];
		for(int i = 0 ; i < pool.length ; i ++){
			pool [i] = i;
		}
		
		for(int i = 0 ; i < k ; i++){
			int key = (int) (Math.random() * n) ;
			results[i] = pool[key];
			pool[key] = pool[n-1];
			n--;
		}
		System.out.println(Arrays.toString(results));
			
		System.out.println(Arrays.toString(results));
		int m = results[3];
	
		int p = Arrays.binarySearch(results, m);
		int q = Arrays.binarySearch(results, 4,results.length,m);
		System.out.println("m:" + m + "\tbinarySearch m:"+p+ "\tbinarySearch m:"+q);
		
		Arrays.fill(results, 1);
		System.out.println("fill:" + Arrays.toString(results));
		
		String [] from = {"a","b","c","d","e","f"};
		
		String [] to = new String [from.length] ;
		
		System.arraycopy(from, 0, to, 1, from.length-2);
		
		System.out.println("System.arraycopy :" + Arrays.toString(to));
	}
	
	public static void doTestData(){
		Date date = new Date();
		System.out.println(date);
		String s  = date.toString();
		System.out.println(s);
	}
}
