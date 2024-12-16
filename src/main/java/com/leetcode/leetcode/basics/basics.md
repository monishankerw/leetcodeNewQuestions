
1.package com.reversenumber;

public class ReverseNumber {
public static void main(String strs[]) {
int rev=0,num=12345;
while(num!=0) {

rev=rev*10+num%10;
num=num/10;
}
System.out.println(rev);
}
}


2. package com.palindromenumber;
   public class PalindromeNumber {
   public static void main(String strs[]) {

Scanner sc=new Scanner(System.in);
System.out.println("Enter The Number:");
int num=sc.nextInt();
int org_num=num;
int rev=0;
while(num!=0){
rev=rev*10+num%10;
num=num/10;
}
if(org_num==rev) {
System.out.println("Palindrome Number");
} else {
System.out.println("Not Palindrome Number");
}
}

3.package com.swapping;
public class Swapping {
public static void main(String strs[]) {
int a=10,b=20;
System.out.println("Before Swapping"+a+"  "+b);
int c=a;
a=b;
b=c;
System.out.println("After Swapping"+a+"  "+b);

}
}

4.package com.swapping;
public class SwappingWithOutThirdvariable {
public static void main(String strs[]) {
int a=10,b=20;
System.out.println("Before Swapping"+a+"  "+b);
a=a+b;
b=a-b;
a=a-b;
System.out.println("After Swapping"+a+"  "+b);

}
}

5. package com.fabonacciseries;
   public class FabSeries {
   public static void main(String strs[]) {
   int a=0,b=1,c;
   System.out.println(a+"  "+b);
   for(int i=1;i<6;i++) {
   c=a+b;
   System.out.println("  "+c);

a=b;
b=c;
}
}


6. package com.armstrongnumber;
   public class ArmStrong {
   public static void main(String strs[]) {
   Scanner sc=new Scanner(System.in);
   System.out.println("Enter The Number:");
   int num=sc.nextInt();
   int org_num=num,sum=0,r;
   while(num!=0) {
   r=num%10;
   sum=sum+r*r*r;
   num=num/10;
   }
   if(org_num==sum) {
   System.out.println("Armstrong Number");
   } else {
   System.out.println(" Not Armstrong Number");
   }
   }

7. package com.primenumber;
   public class PrimeNumber {
   public static void main(String strs[]) {
   Scanner sc=new Scanner(System.in);
   System.out.println("Enter The Number:");
   int num=sc.nextInt();
   int count=0;
   for(int i=2;i<=num/2;i++) {
   if(num%i==0)
   count++;
   {
   if( count==0){
   System.out.println("Prime Number");
   } else {
   System.out.println("Not Prime Number");
   }
   }
   STREAMAPI JAVA8FEATURES
   ->WHICH HELPS US TO MANIPULATE COLLECTION
   ->A STREAM IS A SEQUENCE OF OBJECTS THAT SUPPORTS VARIOUS METHODS.
   ->PRESENT IN java.util.package
   -> A STREAM IS NOT PRESENT IN JAVA.UTIL PACKAGE
   ....INTERMEDIATE OPERATION
   THREE METHODS:
   1.FILTER():->FILTER IS USED FOR FILTERING THE DATA. IT ALWAYS RETURNS THE BOOLEAN VALUE.
   2.MAP():->TRANSFER THE OBJECT VALUE.
   .....TERMINAL OPERATIONS
   1.COLLECT()->THE COLLECT METHOD IS USED TO RETURN THE RESULT OF THE INTERMEDIATE OPERATIONS PERFORMED ON THE STREAM.
   2.FOREACH()->THE FOREACH METHOD IS USED TO ITERATE THROUGH EVERY ELEMENTS OF THE STREAM.
   3.REDUCE()->THE REDUCE METHOD IS USED TO REDUCE THE ELEMENTS OF A STREAM TO A SINGLE VALUE.
   STREAM(): STREAM IS A SEQUENCE OF OBJECT WE CAN TRAVELS THROUGH SEQUENCE OF OBJECT THROUGH JAVA8.
   1.SEQUENTIAL STREAM: sequential stream is where you current stream execute in one core in one thread.
   2.PARALLEL STREAM:Parallel stream is applicable for multiple core sequential stream execute single core.

8. package com.evennuber;
   public class EvenNumber {
   public static void main(String strs[]) {
   List<Integer>number=Arrays.asList(1,2,3,4,5,6,7,8);
   System.out.println("Enter The Number is:"+number);
   List<Integer>num=number.stream().filter(n->n%2==0).collect(Collectors.toList());
   System.out.println("Enter The Even number Number is:"+num);
   }
   }

9. package com.primenuber;
   public class PrimeNumber {
   public static void main(String strs[]) {
   List<Integer>number=Arrays.asList(1,2,3,4,5,6,7,8);
   System.out.println("Enter The Number is:"+number);
   List<Integer>num=number.stream().filter(PrimeNumber::isprime).collect(Collectors.toList());
   System.out.println("Enter The Even number Number is:"+num);
   }
   public static boolean isprime(int num){
   for(int i=2;i<number/2;i++){
   if(number%2==0){
   return false;
   }
   }
   return true;
   }
   }
   }

9. package com.duplicatenumber;
   public class DuplicateNumber {
   public static void main(String strs[]) {
   List<Integer>number=Arrays.asList(1,2,2,4,3,5,,1,2,6,7,6,,6,8);
   System.out.println("Enter The Number is:"+number);
   List<Integer>num=number.stream().distinct().collect(Collectors.toList());
   System.out.println("Enter The Even number Number is:"+num);
   }
   }
   10.package com.decendingorder;
   public class DecendingNumber {
   public static void main(String strs[]) {
   List<Integer>number=Arrays.asList(21,2,23,4,25,26,17,8);

List<Integer>num=number.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
System.out.println(num);

}
}

package accendingorder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AccendngOrder {
public static void main(String[] args) {
List<Integer> num = Arrays.asList(2,4,1,3,6,7,5,9,8);
System.out.println("Orginal Number:"+num);
List<Integer> num1 = num.stream().sorted().collect(Collectors.toList());
System.out.println("Accending Order:"+num1);
}
}
11.package com.evennuber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class SumEvenNumber {
public static void main(String strs[]) {
List<Integer>number=Arrays.asList(1,2,3,4,5,6,7,8);

Comparable<Integer>num=number.stream().filter(n->n%2==0).reduce(0,(ans,i)->ans+i);
System.out.println("Enter The Even number Number is:"+num);
}
}

12. package com.squrenumber;
    public class SumEvenNumber {
    public static void main(String strs[]) {
    List<Integer>number=Arrays.asList(1,2,3,4,5,6,7,8);

Comparable<Integer>num=number.stream().map(n->n*n).collect(Collectors.toList());
System.out.println("Enter The Even number Number is:"+num);
}
}
13. package com.squrenumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SumEvenNumber {
public static void main(String strs[]) {
List<Integer>number=Arrays.asList(1,2,3,4,5,6,7,8);

List<Integer>num=number.stream().map(n->n*n).collect(Collectors.toList());
System.out.println("Enter The Even number Number is:"+num);
}
}
14.package com.starwith;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SumEvenNumber {
public static void main(String strs[]) {
List<String>str=Arrays.asList("Reflection","Collection","stream");

List<String> a = str.stream().filter(s->s.startsWith("s")).collect(Collectors.toList());
System.out.println("Enter The String is:"+a);
}
}

15.package com.startingwithnumber;
public class A{
public static void main(String strs[]) {
List<Integer>n=Arrays.asList(1233,255,453,442,5567,54322,76887,56);
n.stream().filter(s->s.startswith("1")).forEach(System.out::println));
}
}

package com.streamapi;

import java.util.Arrays;
import java.util.List;

public class NumberStartingWith2 {
public static void main(String[] args) {
List<Integer>num=Arrays.asList(20,14,25,26,27,29);
num.stream().map(s->s+"").filter(s->s.startsWith("2")).forEach(System.out::println);
}
}
17.package abc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class DuplicateElements {
public static void main(String args[]) {
List<Integer>a=new ArrayList<>(Arrays.asList(1,2,3,1,2,4,3,5,6,4,5,4,5));
System.out.println("Duplicate Elements:"+a);
Set<Integer>set=new LinkedHashSet<>();
set.addAll(a);
a.clear();
a.addAll(set);
System.out.println("WithoutDuplicate Elements:"+a);

}}

18.package duplicateelements;

public class RemoveDuplicateElement {  
public static void main(String[] args) {

        //Initialize array   
        int [] arr = new int [] {1, 2, 3, 4, 2, 7, 8, 8, 3};   
          
        System.out.println("Duplicate elements in given array: ");  
        //Searches for duplicate element  
        for(int i = 0; i < arr.length; i++) {  
            for(int j = i + 1; j < arr.length; j++) {  
                if(arr[i] == arr[j])  
                    System.out.println(arr[j]);  
            }  
        }  
    }  
}  
19
package com.duplicateelements;

public class DuplicateElements {
public static void main(String[] args) {
int arr[]= {1,2,2,3,4,4,5,6,6};

	int temp[]=new int[arr.length-3];
	int j=0;
	for(int i=0;i<arr.length-1;i++) {
		if(arr[i]!=arr[i+1]) {
			temp[j]=arr[i];
			j++;
		}
	}
	temp[j]=arr[arr.length-1];
	for(int x:temp) {
		System.out.print(" "+x+" ");
	}
}
}
20.
package com.freqofeachelements;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
public class FreqOfEachElements {
public static void main(String[] args) {
int arr[]= {10,10,20,30,20,5,10};
countfrq(arr);
}
private static void countfrq(int[] arr) {
Map<Integer,Integer>map=new HashMap<>();
for(int i=0;i<arr.length;i++) {
if(map.containsKey(arr[i])) {
map.put(arr[i], map.get(arr[i])+1);
} else {
map.put(arr[i], 1);
} }
for(Entry<Integer,Integer>entry:map.entrySet()) {
System.out.println(entry.getKey()+" "+entry.getValue());
}}}

21
.package com.maximum_minimumelements;

public class MaxMinElements {
public static void main(String[] args) {
int arr[]= {1,2,3,7,9,20};
maxmin(arr);
}

private static void maxmin(int[] arr) {
int max=arr[0];
int min=arr[0];
for(int i=0;i<arr.length;i++) {
if(arr[i]>max) {
max=arr[i];
}
if(arr[i]<min) {
min=arr[i];
}
}
System.out.println(min);
System.out.println(max);

}
}

22.
package com.sorting;

public class SortingNumber {
public static void main(String[] args) {
int arr[]= {43,6,1,4,2,7};
sorting(arr);
}

private static void sorting(int[] arr) {
for(int j=0;j<arr.length-1;j++) {
for(int i=0;i<arr.length-1;i++) {
if(arr[i]>arr[i+1]) {
int temp=arr[i];
arr[i]=arr[i+1];
arr[i+1]=temp;
}
}
}
for(int x:arr) {
System.out.println(x);
}
}
}

23.
package com.SecondLargestElements;

public class Se {
public static void main(String[] args) {
int arr[]= {2,6,3,4,5,1};
for(int j=0;j<arr.length-1;j++) {
for(int i=0;i<arr.length-1;i++) {
if(arr[i]>arr[i+1]) {
int temp=arr[i];
arr[i]=arr[i+1];
arr[i+1]=temp;
}
}
}
System.out.println(arr[arr.length-2]);
}


}

24.
package com.movenegativeoneside;

import java.util.Arrays;

public class MoveNegative {
public static void main(String[] args) {
int arr[]= {1,-2,3,-5,4,-7};
movenegative(arr);
}

private static void movenegative(int[] arr) {
int j=0;
for(int i=0;i<arr.length;i++) {
if(arr[i]>=0) {
swapp(arr,i,j);
j++;
}
}
System.out.println(Arrays.toString(arr));
}

private static void swapp(int[] arr, int i, int j) {
int temp=arr[i];
arr[i]=arr[j];
arr[j]=temp;

}
}

25.
package com.movezerooneside;

import java.util.Arrays;

public class MoveZero {
public static void main(String[] args) {
int x[]= {1,0,3,0,45,0};
movezero(x);
}

private static void movezero(int[] x) {
int j=0;
for(int i=0;i<x.length;i++) {
if(x[i]!=0) {
swap(x,i,j);
j++;
}
}
System.out.println(Arrays.toString(x));
}


private static void swap(int[] x, int i, int j) {
int temp=x[i];
x[i]=x[j];
x[j]=temp;
}
}
26.
package countpair;

public class CountPair {
public static void main(String[] args) {
int arr[]= {1,2,4,-1,-6,-2};
int sum=3;
countpair(arr,sum);
}

private static void countpair(int[] arr, int sum) {
int count=0;
for(int i=0;i<arr.length;i++)
for(int j=0;j<arr.length;j++)
if(arr[i]+arr[j]==sum)
count++;
System.out.println(count);

}
}

27.
package com.rotatearray;

public class Roatatearray {
public static void main(String[] args) {
int[]arr=new int[] {1,2,3,4,5};
int n=3,j;
for(int i=0;i<n;i++) {
int first=arr[0];
for(j=0;j<arr.length-1;j++) {
arr[j]=arr[j+1];
}

		arr[j]=first;
	}
	for(int i=0;i<arr.length;i++) {
		System.out.println(arr[i]+" ");
	}
}
}

28.

package com.intersection;

import java.util.HashSet;
public class Intersection {
public static void main(String[] args) {
int arr1[]= {1,2,3,4};
int arr2[]= {1,2};
intersection(arr1,arr2);
}
private static void intersection(int[] arr1, int[] arr2) {
HashSet<Integer> s = new HashSet<Integer>();
for(int i=0;i<arr1.length;i++) {
s.add(arr1[i]);
}
for(int i=0;i<arr2.length;i++) {
if(s.contains(arr2[i])) {
System.out.println(arr2[i]);
} } }}

30.
package com.singleturn;
public final class A {
public static A a1=null;
private A() {
}
public static A getInstance() {
if(a1==null) {
A a1=new A();
return a1; }
return a1;
}}
package com.singleturn;
public class B {
public static void main(String[] args) {
A a1=A.getInstance();
A a2=A.getInstance();
System.out.println(a1);
System.out.println(a2);
}}
com.singleturn.A@4617c264
com.singleturn.A@36baf30c

31.
package com.sumofarrays;
2
3 public class Sum {
4 public static void main(String[] args) {
5
int arr[]= {1,2,3,4,5};
6
sum(arr);
7 }
8
9 private static void sum(int[] arr) {
10
int sum=0;
11
for(int i=0;i<arr.length;i++) {
12
sum=sum+arr[i];
13 }
14 System.out.println(sum);
15 }
16
17 }
15

32.

package com.subsetofarray;
public class SubSet {
public static void main(String[] args) {
int arr1[]= {1,2,3,4,5};
int arr2[]= {12,3,4};
int m=arr1.length;
int n=arr2.length;
if(subset(arr1,arr2,m,n)) {
System.out.println("arr2[] is subset of arr1[]");
} else {
System.out.println("arr2[] is not subset of arr1[]");
}
}
private static boolean subset(int[] arr1, int[] arr2, int m, int n) {
for(int i=0;i<n;i++) {
for(int j=0;j<m;j++) {
if(arr2[i]==arr1[j])
break;
/* If the above inner loop was not broken at all then arr2[i] is not present in arr1[]
*/
16
if (j == m)
return false;
}
/* If we reach here then all elements of arr2[] are present in arr1[] */
}
return true;
}


33.
package com.subofarray;
// Java program to generate all possible subarrays/subArrays
// Complexity- O(n^3) */
class Test
{
static int arr[] = new int[]{1, 2, 3, 4};
// Prints all subarrays in arr[0..n-1]
public static void subArray( int n) {
// Pick starting point
for (int i=0; i <n; i++)
{
// Pick ending point
for (int j=i; j<n; j++)
{
17
// Print subarray between current starting
// and ending points
for (int k=i; k<=j; k++)
System.out.print(arr[k]+" ");
} } }
// Driver method to test the above function
public static void main(String[] args) {
System.out.println("All Non-empty Subarrays");
subArray(arr.length);
} }


34.ReverseArray.java
1 package com.reverseofarray;
2
3 import java.util.Arrays;
5
6 public class ReverseArray {
7 public static void main(String[] args) {
8 Integer[]arr= {1,2,3,4,5,6};
18
9 System.out.println("original Array"+Arrays.asList(arr));
10
reversearry(arr);
11 }
12
13 private static void reversearry(Integer[] arr) {
14 Collections.reverse(Arrays.asList(arr));
15 System.out.println("Reverse Array"+Arrays.asList(arr));
16
17 }
18 }


35.
package com.trappingrainwater;
public class Trappingrainwater {
public static void main(String[] args) {
int arr[] = {6,9,9};
int n=arr.length;
System.out.println(maxtrappingwater(arr,n));

}
private static int maxtrappingwater(int[] arr, int n) {
int res=0;
for(int i=0;i<n-1;i++) {
int left=arr[i];
for(int j=0;j<i;j++) {
left=Math.max(left, arr[j]);
}
int right=arr[i];
for(int j=i+1;j<n;j++) {
right=Math.max(right, arr[j]);
}
res+=Math.max(left, right)-arr[i];
}
return res;
}}


STRING PROGRAM
1.
public class ReverseString {
public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
System.out.println("Enter Your String:");
String str=sc.next();
String rev=" ";
for(int i=str.length()-1;i>=0;i--) {
rev=rev+str.charAt(i);
}
System.out.println("Reverse String:"+rev);
}
}

2.
public class PalindromeString{

public static void main(String[] args) {
String str="madam",org_str=str,rev="";
for(int i=str.length()-1;i>=0;i--) {

rev=rev+str.charAt(i);
}
if(org_str.equls(rev)) {//The equals() method compares two strings, and returns true if the strings are equal, and false if not.
System.out.println("Palindrome String");
} else {
System.out.println("Not Palindrome String");
}
}

3.
package reverseword;
public class ReverseString {

public static void main(String[] args) {
String[] str="I am JavaDeveloper".split(" ");//split means print different line of the world
String rev=" ";
for(int i=str.length-1;i>=0;i--){//Length is the term used for identifying the size of an object or distance from one point to the other
rev=rev+str[i]+" ";
}
System.out.println(rev.substring(0,rev.length()-1));//The length() method returns the length of a specified string
//SUBSTRING is a string manipulation function that manipulates all string data types (BIT, BLOB, and CHARACTER), and extracts characters from a string to create another string
}


}

4.package accendingorder;

import java.util.Arrays;

public class AccendingOrder {
public static void main(String[] args) {
String[] str= {"abc","zew","qwe","cde","rew"};
Arrays.sort(str);
System.out.println("AccendingOrder");
for(String str1:str) {
System.out.print(" "+str1);
}
}
}
AccendingOrder
abc cde qwe rew zew


5.package decendingorder;

import java.util.Arrays;
import java.util.Collections;

public class DecendingOrder {
public static void main(String[] args) {
String[] str= {"abc","def","rst","mno","krd","jgs"};
Arrays.sort(str,Collections.reverseOrder());
System.out.println("Decending Order:");
for(String str1:str) {
System.out.print(" "+str1);
}
}
}

6.
package mutablestring;
//mutable string are whose value keep changing

public class Employee {
private long id;
private String name;
public long getid() {
return id;
}
public void setid(long id) {//setter is used to initialize value using
this.id=id;
}
public String getname() {//getter variable is used to read the value
return name;
//stringbuffer,stringbuilder both are used mutable
//may or may not thread safe
}
public void setname(String name) {
this.name=name;
}
public static void main(String[] args) {
Employee e=new Employee();
e.setid(12);
e.setname("Moni");
System.out.println(e.getid()+":"+e.getname());

}
}

7.
package immutablestring;
//string are immutable,immutable simple means unmodified or unchangable
//wrapper class,string class,legacy class etc.
//new object are not formed
public final class  Employee {//make class final
private long id;//make variable private
Employee(long id){//initialize through constructor
this.id=id;
}
public long getid() {//used only getter not setter
return id;
}
public static void main(String[] args) {
Employee e=new Employee(12);
System.out.println(e.getid());
}
}

8.
package removewhitespace;

public class RemoveWhiteSpace {
public static void main(String[] args) {
String str="    JavaDeveloper";
System.out.println(str);
System.out.println(str.trim());
}
}
9.
package permutation;

import java.util.Scanner;

public class PermutationString {
public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
String s1="ABC";
String s2=" ";
permun(s1,s2);
}

private static void permun(String s1, String s2) {
if(s1.length()==0) {//The length() method returns the length of a specified string
System.out.print(s2+" ");
return;
}
for(int i=0;i<s1.length();i++) {
char ch=s1.charAt(i);//it return the charvalue of the particular index as mentained
String left_substr=s1.substring(0,i);//SUBSTRING is a string manipulation function that manipulates all string data types (BIT, BLOB, and CHARACTER), and extracts characters from a string to create another string
String rigtht_substr=s1.substring(i+1);
String rest=left_substr+rigtht_substr;
permun(rest,s2+ch);
}
}
}

10.
package upper_lowerordes;

public class A {
public static void main(String[] args) {
String s1="MoNiShaNkER";
System.out.println(s1.toLowerCase());
System.out.println(s1.toUpperCase());
}
}
monishanker
MONISHANKER
11.
package printDifferentLine;

public class A {
public static void main(String[] args) {
String s1="RAM SHYAM";
String[] s2=s1.split(" ");
System.out.println(s2[0]);
System.out.println(s2[1]);
}
}
RAM
SHYAM

12.
package countNoOfWord;

public class A {
public static void main(String[] args) {
String s1="I am Java Developer";
System.out.println(s1.length());
String[] s2=s1.split(" ");
System.out.println(s2[0].length());
System.out.println(s2[1].length());
System.out.println(s2[2].length());
System.out.println(s2[3].length());
}
}

o/p:19
1
2
4
9


13.
package countcharct;

public class FrequencyOccuranceOfEachChar {
public static void main(String[] args) {
String str="aaaaaaadfggffdaaasdfaa";
char ch='a';
System.out.println(count(str,ch));
}

private static int count(String str, char ch) {
int count=0;
for(int i=0;i<str.length();i++) {
if(str.charAt(i)==ch) {
count++;
}
}
return count;
}
}



14.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DuplicateString {
public static void main(String[] args) {
ArrayList<String> a = new ArrayList<String>(Arrays.asList("a","a","b","c","d","b"));
List<String> a1 = a.stream().distinct().collect(Collectors.toList());
System.out.println(a1);
}
}

15
package com.duplicateelements;

public class DuplicateElements {
public static void main(String[] args) {
String str="JavaDeveloper";
int r=0;
char[]x=str.toCharArray();
for(int i=0;i<str.length();i++) {
for(int j=i+1;j<str.length();j++) {
if(x[i]==x[j]) {
System.out.print(x[j]);
r++;
break;
}
}
}
}
}O/p: avee

16
package duplicateelements;

import java.util.HashMap;
import java.util.Map;

public class Duplicate_Elements{


public static void main(String[] args) {
String str = "javadeveloper";
Map<Character, Integer> map = new HashMap<Character, Integer>();
char[] arr = str.toCharArray();

	    for (char value: arr) {

	       if (Character.isAlphabetic(value)) {
	           if (map.containsKey(value)) {
	               map.put(value, map.get(value) + 1);

	           } else {
	               map.put(value, 1);
	           }
	       }
	    }

	    System.out.println(map);
}
}

17
.AnagramWords.java
package com.AnagramWords;

import java.util.Arrays;

public class AnagramWords {
public static void main(String[] args) {

char str1[]= {'l','i','s','t','e','n'};

char str2[]= {'s','i','l','e','n','t'};

if(Anagram(str1,str2))
System.out.println("The two strings are anagram of each
other");

else
System.out.println("The two strings are not anagram of each
other");
}
private static boolean Anagram(char[] str1, char[] str2) {

int n1=str1.length;

int n2=str2.length;

if(n1!=n2)

return false;
Arrays.sort(str1);
Arrays.sort(str2);

for(int i=0;i<n1;i++)

if(str1[i]!=str2[i])

return false;

return true;
}
}

18
package com.p1;
// Java program to print common characters
import java.io.*;
// Function to find similar characters
public class Simstrings
{
static final int MAX_CHAR = 26;

static void printCommon(String s1, String s2)
{
// two arrays of length 26 to store occurrence

// of a letters alphabetically for each string

int[] a1 = new int[MAX_CHAR];

int[] a2 = new int[MAX_CHAR];

int length1 = s1.length();

int length2 = s2.length();

for (int i = 0 ; i < length1 ; i++)

a1[s1.charAt(i) - 'a'] += 1;

for (int i = 0 ; i < length2 ; i++)

a2[s2.charAt(i) - 'a'] += 1;

// If a common index is non-zero, it means

// that the letter corresponding to that

// index is common to both strings

for (int i = 0 ; i < MAX_CHAR ; i++)
}
if (a1[i] != 0 && a2[i] != 0)
{

// Find the minimum of the occurrence

// of the character in both strings and print

// the letter that many number of times

for (int j = 0 ; j < Math.min(a1[i], a2[i]) ; j++)
System.out.print(((char)(i + 'a')));
}

}
Page 1Simstrings.java Friday, November 25, 2022, 7:41 AM
}
// Driver code

public static void main(String[] args) throws IOException
{
String s1 = "geeksforgeeks", s2 = "practiceforgeeks";

printCommon(s1, s2);
}
}


19
.package com.p1;
2
3 public class preservingSpace {
4
public static void main(String[] args) {
5 String str="Java Developer";
6 preservingSpace(str);
7 }
8
9
private static void preservingSpace(String str) {
10
//initialize two pointer as two corners
11
int n=str.length()-1;
12
int start=0,end=n-1;
13
14
char[] ch=str.toCharArray();
15
//move both pointers toword each other
16
while(start<end) {
17
//if character at start or end is space ignore it
18
if(ch[start]==' ') {
19
start++;
20
continue;
21 }
22
else if(ch[end]==' ') {
23
end--;
24
continue;
25 }
26
//if both are not space do swapp
27
else {
28
char temp=ch[start];
29
ch[start]=ch[end];
30
ch[end]=temp;
31
start++;
32
end--;
33 }
34 }
35
//The java string valueOf() method converts different types
of values into string. By the help of string valueOf() method, you
can convert int to string, long to string, boolean to string,
character to string, float to string, double to string, object to
string and char array to string.



20.
import java.util.Iterator;
6
7 public class stack {
8 public static void main(String[] args)
9 {
10 List<String> list = new LinkedList<>();
11 list.add("Geeks");
12 list.add("For");
13 list.add("Geeks");
14 list.add("GeeksforGeeks");
15 Iterator<String> iter = list.iterator();
16 //1.iterable is interface,present in java.lang.iterable package.
17 //by using Iterator cursor, we can retrive the elements only
in forword direction.
18 //we get Iterable cursor by iterator() method "Iterator
it=l.iterator();
19 //Iterator cursor can be used with only collection object .
20 //Iterator method are hasNext(),next(),remove()
21 //
22 while (iter.hasNext())
23 System.out.printf(iter.next() + " ");
24
25 System.out.println();
26 }
27 }


21

46.package com.p1;
2
3 import java.util.TreeSet;
4 //1.it is sort the data
5 //2.contains unique elements
6 //it is sort the data in the ascending order.
7 //Tree set internally create Tree map.
8 //not insertion order and not add duplicate value
9 //null values are not accepted by the Tree set.
10 public class Treeset {
11 public static void main(String[] args)
12 {
13 TreeSet<String> treeSet = new TreeSet<>();
14
15 treeSet.add("Geeks");
16 treeSet.add("For");
17 treeSet.add("Geeks");
18 treeSet.add("GeeksforGeeks");
19
20 for (String temp : treeSet)
21 System.out.printf(temp + " ");
22
23 System.out.println("\n");
24 }
25 }













