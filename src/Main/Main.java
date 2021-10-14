package Main;

public class Main {

    public static void main(String[] args) {
    //note: for most following functions there exists a "BigInteger" library in java, but I will implement my own basic versions
        int[] num1= {1,3,0,0,0,0,0,0,0},num2 = {7,7,0,0,0,0,0,0,0};
        int[] num3 = aufgabe_1(num1,num2);
        for(int i: num3)
            System.out.print(i+" ");
    }

    public static int[] aufgabe_1(int [] num1,int [] num2){
        //adds 2 "big num" types - TODO: implement Carry over number of digits
        int [] ret_num = new int[num1.length];
        int carry=0;
        for(int i=num1.length-1;i>=0;i--){
            ret_num[i]=num1[i]+num2[i]+carry;
            carry=0;
            if(ret_num[i]>9){
                carry=ret_num[i]/10;
                ret_num[i]=ret_num[i]%10;
            }
        }
        return ret_num;
    }
}
