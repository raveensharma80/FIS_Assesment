package org.example;

public class Student {
    public static String school;
    public String name;
    public int rolno;

    public  Student(String name, int rolno){
        this.name = name;
        this.rolno = rolno;
    }
    public void m1(){
        System.out.println("this is m1 of Student");
    }

}

 class Test{

    public static void main(String[] args)
    {
        Student s1 = new Student("Mohan",10);
    }
}
