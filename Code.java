package com.jsp.comparingobjs;

public class Mobile implements Comparable {
	String brand;
	double price;
	int RAM;
	@Override
	public String toString() {
		return "Mobile [brand=" + brand + ", price=" + price + ", RAM=" + RAM + "]";
	}
	public Mobile(String brand, double price, int rAM) {
		super();
		this.brand = brand;
		this.price = price;
		RAM = rAM
	}
	@Override
	public int compareTo(Object o) {
		return (int) (this.price - ((Mobile)o).price);
		
	}
}

//sort by price
package com.jsp.comparingobjs;

import java.util.Comparator;

public class SortByPriceComparator implements Comparator
{

	@Override
	public int compare(Object o1, Object o2) {
		Mobile m1 = (Mobile)o1;
		Mobile m2 = (Mobile)o2;
		return (int) (m2.price - m1.price);
	}
}

//sort by brand

package com.jsp.comparingobjs;

import java.util.Comparator;

public class SortByBrandComparator implements Comparator
{

	@Override
	public int compare(Object o1, Object o2) {
		Mobile m1 = (Mobile)o1;
		Mobile m2 = (Mobile)o2;
		return m1.brand.compareTo(m2.brand);
	}
	
}

//Mobile Driver
package com.jsp.comparingobjs;

import java.util.Arrays;
import java.util.Scanner;

public class MobileDriver {
	static Scanner os = new Scanner(System.in);

	public static void main(String[] args) {

		Mobile[] arr = { new Mobile("Redmi", 10000, 6), new Mobile("Poco", 11000, 6), new Mobile("Oppo", 9000, 4),
				new Mobile("RealMe", 8000, 4), new Mobile("One Plus", 20000, 8) };
		for (Mobile obj : arr) {
			System.out.println(obj);
		}
		boolean flag = true;
		while (flag) {
			System.out.println("1.price:low to high");
			System.out.println("2.pice : High to low");
			System.out.println("3.Brand name");
			System.out.println("4.Exit");
			int choice = os.nextInt();
			switch (choice) {
			case 1:
				Arrays.sort(arr);
				for (Mobile obj : arr) {
					System.out.println(obj);
				}
				break;

			case 2:
				Arrays.sort(arr, new SortByPriceComparator());
				for (Mobile obj : arr) {
					System.out.println(obj);
				}
				break;
			case 3:
				Arrays.sort(arr, new SortByBrandComparator());
				for (Mobile obj : arr) {
					System.out.println(obj);
				}
				break;
			case 4:
				// exit
				System.out.println("Are You sure?1.for exit\nany other number to continue");
				int exit = os.nextInt();
				if(exit == 1)
				{
					System.out.println("Thank you");
					flag = false;
				}
				
				break

			default:
				System.out.println("invalid input");
				break;
			}

		}
}

