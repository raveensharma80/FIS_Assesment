package org.example;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

import com.google.common.io.CharStreams;
import org.apache.commons.lang3.ArrayUtils;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        // Reverse a string
        String s = "reverseteste";
        //Method1
        //System.out.println("Reverse of s ="+new StringBuffer(s).reverse());
        //Method2
        char[] ch = s.toCharArray();
        String out = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            out = out + ch[i];
        }
        System.out.println("reversed=" + out);
        //Method3
        System.out.println("With recursion=" + recursivereverse(s));

        // reverse a number
        //System.out.println("Reverse num = "+reverseNumber(6789));
        //Repeat test
        //repeatTest("betterbutter");
        //replace white chars
        //replacewhite();
        //find duplicate chars with map
        //findDupMap();
        //reverse the words of a string
        //reverseWord();
        //separate zeros
        //separateZero();
        // moveZeroesToRight();
        //sort An array ascending or descending
        //sortArray();
        //reverse a string by reserving spaces
        //reverseStringReserveSpace();
        //swaptStringWithoutTemp()
        //System.out.println("Reversed = "+ reverString("Test string"));
         stringtest();
        //System.out.println(checkprime(103));
        //System.out.println(returnNprime(20));
        //test2();
        //fibonacci(50);
        //removeElementFromArray();
        //finduniquewithStream();
        //System.out.println(findFact(-89));
        //System.out.println(reverseNum(10));
        //digitSum();
        //separateChars();
        //removeDuplicatefromArray();
       // removeDuplicateWordFromString();
        //reverseStringWithSpaceReserved();
        //secondHighest();
        //test8();
        reversearray();

    }

    //Reverse an array
    static void reversearray() {
        int[] in = new int[]{1,2,46,7,22,55};
        int length = in.length;
        for(int i = 0; i < length/2; i++)
        {
            int temp =in[i];
            in[i] = in[length-1-i];
            in[length-1-i]=temp;
        }
        System.out.println(Arrays.toString(in));
    }


    static String recursivereverse(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        return recursivereverse(input.substring(1)) + input.charAt(0);
    }

    static int reverseNumber(int number) {

        int reverse = 0;
        int digit = 0;
        while (number != 0) {
            digit = number % 10;
            reverse = reverse * 10 + digit;
            number /= 10;

        }
        return reverse;
    }

    // how many times each char present at which position in a string
    static void repeatTest(String input) {
        // e.g. betterbutter
        String unique = "";
        String repeat = "";
        int index = -1;
        int count = 0;
        char[] inchar = input.toCharArray();
        for (char c : inchar) {
            if (unique.indexOf(c) < 0) {
                unique = unique + c;
                repeat = repeat + c;
                index = input.indexOf(c);
                System.out.println(c + " Present at index = " + index);
                while (index >= 0) {
                    index = input.indexOf(c, index + 1);
                    repeat = repeat + c;
                    if (index > -1) {
                        System.out.println(c + " Present at index = " + index);
                    }
                }
                System.out.println(c + " Repeates " + (repeat.length() - 1) + " times ");
            }

            repeat = "";
        }

        System.out.println("unique string =" + unique);
    }

    static void replacewhite() {
        Scanner sc = new Scanner(System.in);
        String st = sc.nextLine();
        st = st.replaceAll("\\s+", "");
        System.out.println("removed -->" + st);
        sc.close();
    }

    static void findDupMap() {
        Scanner sc = new Scanner(System.in);
        String st = sc.nextLine(); // e.g "this is better butter"
        char[] ch = st.toCharArray();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : ch) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else map.put(c, 1);
        }

        Set<Character> keyset = map.keySet();
        for (Character key : keyset) {
            System.out.println(key + " : " + map.get(key));
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }

    static void reverseWord() {
        Scanner sc = new Scanner(System.in);
        String st = sc.nextLine();
        String strev = "";
        String[] stArray = st.split("\\s+");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < stArray.length; i++) {
            strev = strev + " " + (new StringBuffer(stArray[i])).reverse();
        }
        System.out.println(strev);
        sc.close();

    }

    static void separateZero() {
        int[] input = {12, 0, 7, 0, 8, 0, 3};
        int counter = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] != 0) {
                input[counter] = input[i];
                counter++;
            }

        }
        while (counter < input.length) {
            input[counter] = 0;
            counter++;
        }
        System.out.println(Arrays.toString(input));
    }

    static void moveZeroesToRight() {
        int[] input = {12, 0, 7, 0, 8, 0, 3};
        int counter = input.length - 1;

        for (int i = input.length - 1; i >= 0; i--) {
            if (input[i] != 0) {
                input[counter] = input[i];
                counter--;
            }
        }
        while (counter >= 0) {
            input[counter] = 0;
            counter--;
        }
        System.out.println(Arrays.toString(input));
    }

    static void sortArray() {
        int[] input = {62, -45, 14, 8, -52, 45};
        int targetIndex = 0;

        for (int i = 0; i < input.length; i++) {
            targetIndex = i;
            for (int j = i + 1; j < input.length - 1; j++) {
                if (input[j] < input[i]) {
                    targetIndex = j;
                }
            }
            int temp = input[targetIndex];
            input[targetIndex] = input[i];
            input[i] = temp;

        }
        System.out.println(Arrays.toString(input));
    }

    static void reverseStringReserveSpace1() {
        String st = "i am not a string";
        char[] input = st.toCharArray();
        char[] output = new char[st.length()];

        for (int i = 0; i < input.length; i++) {
            if (input[i] == ' ') {
                output[i] = ' ';
            }
        }
        int j = input.length - 1;
        for (int k = 0; k < input.length; k++) {
            if (input[k] != ' ')
            {
                if (output[j] == ' ') {
                    j--;
                }
                output[j] = input[k];
                j--;
            }

        }
        System.out.println(String.valueOf(input));
        System.out.println(String.valueOf(output));

    }

    static void swaptStringWithoutTemp() {

        String st1 = "first";
        String st2 = "second";
        System.out.println("Before --" + st1 + " " + st2);
        st1 = st1 + st2;
        st2 = st1.substring(0, (st1.length() - st2.length()));
        st1 = st1.substring(st2.length());
        System.out.println("After --" + st1 + " " + st2);
    }

    static String reverString(String input) {
        String out = new String((new StringBuilder(input)).reverse());
        return out;
    }

    static void stringtest() {
        String s1 = "test";
        String s2 = "test";
        System.out.println("test1 " + (s1 == s2));  //true

        String t1 = "testing";
        String t2 = new String("testing");
        System.out.println("test2 " + (t1 == t2)); //false

        String k1 = new String("host");
        String k2 = new String("host");
        System.out.println("test3 " + (k1 == k2)); //false
        System.out.println("test4 " + (k1.equals(k2))); //true

        StringBuilder y1 = new StringBuilder("uml");
        StringBuilder y2 = new StringBuilder("uml");
        System.out.println("test5 " + (y1 == y2)); //false

    }

       static void test3() {
        String input = "betterbutter";
        char[] inchar = input.toCharArray();
        Map<Character, Integer> m = new HashMap<Character, Integer>();
        for (char c : inchar) {
            if (m.get(c) == null) {
                m.put(c, 1);
            } else {
                m.put(c, m.get(c) + 1);
            }
        }
        System.out.println(m);
        for (Map.Entry<Character, Integer> entry : m.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println("***********************************************");
        Set<Character> s = m.keySet();
        for (Character c : s) {
            System.out.println(c + " : " + m.get(c));
        }
        System.out.println("------------------------------");
        Iterator i = m.entrySet().iterator();
        while (i.hasNext()) {
            System.out.println("next entry ->" + i.next());
        }
    }

    static void test4() {
        String c = "this is test";
        char[] carr = c.toCharArray();
        String rev = "";
        for (int i = carr.length - 1; i >= 0; i--) {
            rev = rev + carr[i];
        }
        System.out.println(rev);
    }

    public static boolean checkprime(int num) {
        //Integer[] check = new Integer[]{Integer.valueOf(20)};
        boolean prime = true;
        if (num <= 1) {
            prime = false;
        }
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                prime = false;
            }
        }

        return prime;
    }

    public static List<Integer> returnNprime(int requiredNoOfPrime) {
        int number = 0;
        ArrayList<Integer> primelist = new ArrayList<Integer>();
        while (primelist.size() < requiredNoOfPrime) {
            number++;
            if (checkprime(number) == true) {
                primelist.add(number);
            }
        }

        return primelist;
    }

    public static void fibonacci(int num) {
        int first = 0;
        int second = 1;
        int next = 0;
        List<Integer> fiblist = new ArrayList<Integer>();
        fiblist.add(0, 0);
        fiblist.add(1, 1);
        while (next < num) {
            next = first + second;
            fiblist.add(next);
            first = second;
            second = next;
        }
        System.out.println(fiblist);
    }
    public static void secondHighest()
    {
        int in[] = new int[]{12,245,231,56,340,120,190};
        int first = in[0];
        int second = 0;

        for(int i = 1; i < in.length; i++)
        {
            if(in[i] > first)
            {
                second = first;
                first = in[i];
            } else if (in[i] > second) {
                second = in[i];

            }
        }
        System.out.println("First highest = "+first+"Second highest = "+second);

    }
    public static void removeElementFromArray() {
        String[] stArray = new String[]{"first", "second", "third", "fourth", "fifth", "first", "second", "tenth"};
        String[] arrayAfterRemoval = ArrayUtils.remove(stArray, 0);
        System.out.println(Arrays.toString(arrayAfterRemoval));
        String s = "testu on the skaay lobbay";
        System.out.println(s.replaceAll("[aeiou]", ""));
        System.out.println(s.replaceAll("[a-z]", ""));
        System.out.println(s.replaceAll("a", "z"));
        String[] newstring = s.split("\\s");
        System.out.println(Arrays.toString(newstring));

    }

    public static void finduniquewithStream() {

        Integer[] num = new Integer[]{0, 1, 3, 5, 3, 1, 7, 8, 5};
        List<Integer> UniqueNumbers = Arrays.stream(num).distinct().collect(Collectors.toList());
        List<Integer> sorted = Arrays.stream(num).sorted().collect(Collectors.toList());
        // Numbers.stream().distinct().collect(Collectors.toList());
        // List<Integer> UniqueNumbers = Numbers.stream().sorted().collect(Collectors.toList());

        //System.out.println(UniqueNumbers);
        System.out.println(sorted);
    }

    public static int findFact(int num)
    {
        int fact =1;
        if(num<=1)
        {return num;}
        for(int i = num;i>=1;i--)
        {
            fact = fact*i;
        }
        return fact;
    }

    public static int reverseNum(int num)
    {
        //e.g. 432
        if(Integer.toString(num).charAt(0)==0)
        {num = Integer.valueOf(Integer.toString(num).substring(1));}
        int reverse = 0;
        while(num>0)
        {
            int i = num%10;
            reverse = reverse*10+i;
            num=num/10;
        }

        return reverse;
    }
    public static void digitSum()
    {
        //e.g. 432
        Scanner sc = new Scanner(System.in);
        String num1=sc.next();
        int num2 =0;
//        while (sc.next()!="") {
//            num1 = sc.next();

            if (num1.charAt(0) == '0') {
                num2 = Integer.valueOf(num1.substring(1));
            } else num2 = Integer.valueOf(num1);
            int sum = 0;
            while (num2 > 0) {
                int i = num2 % 10;
                sum = sum + i;
                num2 = num2 / 10;
            }
            System.out.println(sum);

    }

   public static void separateChars()
   {
       String input = "abc #$# 23 asc TI1Ng Tong";
       //Pattern p = Pattern.compile("[a-zA-Z0-9]+"); // Any alphanumeric
       Pattern p = Pattern.compile("[^a-zA-Z0-9]"); // Any non-alphanumeric i.e. spacial chars
       //Pattern p = Pattern.compile("\\d+"); //"\\s+" (space) , "\\S+" (Non-Space)
                  //"\\d+" (digit) , "\\D+" (non-digit  , "\\w+" (alphanumeric words )
                 //"\\W+" -  Non-alphanumeric words includes space
       Matcher m = p.matcher(input);
       while (m.find())
       {
           System.out.println(m.start()+"..."+m.group());
       }
   }
   public static void removeDuplicatefromArray()
   {
       //Integer[] ar = new Integer[]{1,1,0,5,8,2,7,2};
       int[] ar = new int[]{1,1,0,5,8,2,7,2};

//       Set<Integer> s = new TreeSet<Integer>();
//       for(int i : ar)
//       {if (s.contains(i)!=true) s.add(i);}
//       System.out.println(s);
       System.out.println(Arrays.stream(ar).distinct().boxed().collect(Collectors.toList()));
       System.out.println(IntStream.of(ar).distinct().boxed().collect(Collectors.toList()));
        // System.out.println(k);
   }

   public static void removeDuplicateWordFromString()
   {
       String input = "this is duplicate duplicate string this";
       String[] inArr = input.split("\\s+");
       System.out.println(Arrays.stream(inArr).distinct().collect(Collectors.toList()));
   }
   public static void timecheck()
   {
       LocalTime l = LocalTime.now();
       l.getHour();

       LocalDateTime dt = LocalDateTime.now();
       dt.getDayOfMonth();
   }
   public static void test8()
   {
     List<Integer> l1 = Arrays.asList(1,2,3);

     ListIterator<Integer> i = l1.listIterator();

     ArrayList<Integer> l2 = new ArrayList<>();

     int prev = 0;
     while (i.hasNext())
     {
       System.out.println(i.nextIndex());
       System.out.println(i.next());
       System.out.println(i.previous());
     }
     System.out.println(l2);
       while (i.hasPrevious())
       {
           System.out.println(i.previous());
       }
       System.out.println(l2);
   }

}
















