package com.soul.demo;

import java.util.Arrays;
import java.util.Date;

public class CodeDemo {
	
	public static void main (String [] args){
		
		System.out.println("自增减效果：");
		doSinceIncrease();
		System.out.println("位移运算：");
		doDisplacement();
		System.out.println("String 方法：");
		doTest();
		doTestArray();
		doLotteryDraw();
		doTestData();
	}

	/**
	 * 自增减效果
	 * ++n、n++
	 */
	public static void doSinceIncrease(){
		int n = 3;
		int m = 3;
		System.out.println("n is " + n +"\t m is " + m);
		System.out.println("n++ is " + n++ +"\t ++m is " + ++m);
	}
	/**
	 * 位移运算
	 * << 简单理解乘以2的index次方
	 * >> 简单理解除以2的index次方
	 * >>> 带符号如下注释
	 * 
	 */
	public static void doDisplacement(){
		 /* 
         * 5 
         * 正数 原码、反码、补码一致
         * 首位位符号位 0 : + ，1 : -
         * 00000000 00000000 00000000 00001000 
         * 
		 * 
         * -5 
         * 负数
         *  	反码除去第一个符号位不变其他位取反
         *  	补码除去符号位不变、其他位取反最后加1
         * 10000000 00000000 00000000 00001000  --原码 
         * 11111111 11111111 11111111 11110111  --反码 
         * 11111111 11111111 11111111 11111000  --补码 
         *  
         * >>
         * 11111111 11111111 11111111 11111100  补码  >>原补码右移一位  首位补符号位
         * 10000000 00000000 00000000 00000100  原码 (-4)
         * 11111111 11111111 11111111 11111011  反码
         * 
         * >>>
         * 01111111 11111111 11111111 11111100  补码  >>>原补码右移一位 首位直接补0
         * 01111111 11111111 11111111 11111100  原码 (2147483644)
         * 01111111 11111111 11111111 11111100  反码
		 * 
         * 总结： 
         * 1.>> 需考虑符号位 
         * 2.>>> 不考虑符号位，缺少的位数补0 
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
		//两个数组应用同一个数组变量、改变其中一个 另外一个也会跟着改变
		first = other;
		//拷贝数据
		second = Arrays.copyOf(other, other.length);
		other[2] = 5;
		System.out.println("first = other is : \n" + Arrays.toString(first));
		System.out.println("second Arrays.copyOf other is : \n" + Arrays.toString(second));
		System.out.println("other is : \n" + Arrays.toString(other));
		//增加数据长度
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
