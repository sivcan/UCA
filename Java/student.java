/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */

class student {
	int roll_no;
	String name;
	int marks;

	student() {
		roll_no = 0;
		name = " ";
		marks = 0;
	}

	student(int x, String c, int m) {
		roll_no = x;
		name = c;
		marks = m;
	}

	void get(int x, String c, int m) {
		roll_no = x;
		name = c;
		marks = m;
	}

	void show() {
		System.out.println(roll_no + " " + name + " " + marks);
	}
}
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		student s = new student();
		s.show();
		student k = new student(1,"Sivcan",40);
		k.show();
		k.get(2,"Smily",45);
		k.show();
	}
}
