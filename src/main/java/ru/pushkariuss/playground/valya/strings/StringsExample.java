package com.valya.strings;

public class StringsExample {

    public static void main(String[] args) {
        // write your code here
        //1
        String a = "Tra ta $#542 3472864!!@!#32536523 ta";
        System.out.println(a);
        //2
        Pet pet = new Pet("cat","Tikhon");
        System.out.println(pet);
        //3
        String str = new String("usr/etc/log.txt");
        System.out.println(str.substring(str.lastIndexOf('/'),str.length()));
        //4
        System.out.println(str.substring(0,str.lastIndexOf('/')));
        //5
        System.out.println(str.substring(str.lastIndexOf('.'),str.length()));
        //6
        String str2 = "     hhs hshsy hhshs  ";
        System.out.println(str2.trim());
        //7
        String str3 = "/home/sweet/home/house.to";
        System.out.println(str3.substring(0,str3.length()-2)+"from");
        System.out.println(str3.replaceAll("to","from"));

        //9
        System.out.println(str3.replaceAll("house.to","barn.to"));
        System.out.println(str3.substring(0,str3.lastIndexOf('/')+1)+"barn.to");

//Figure

    }
}
