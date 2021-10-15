package Main;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
    //note: for most following functions there exists a "BigInteger" library in java, but I will implement my own basic versions

        int[] num1= {1,3,0,0,0,0,0,0,0},num2 = {8,7,0,0,0,0,0,0,0};
        int[] num3 = aufgabe_1(num1,num2);
        for(int i: num3)
            System.out.print(i+" ");
        System.out.println();
        int[] num4={8,3,0,0,0,0,0,0,0},num5={5,4,0,0,0,0,0,0,0};
        int[] num6=aufgabe_2(num4,num5);
        for(int i: num6)
            System.out.print(i+" ");
        System.out.println();
        int[] num7={2,3,6,0,0,0,0,0,0};
        int[] num8=aufgabe_3(num7,50);
        for(int i: num8)
            System.out.print(i+" ");
        System.out.println();
        int[] num9=aufgabe_4(num7,2);
        for(int i: num9)
            System.out.print(i+" ");
    }

    public static int[] aufgabe_1(int [] num1,int [] num2){
        //adds 2 "big num" types, returns array as result
        //Input: int [], int []
        //Output: int []
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
        if(carry!=0){
            int [] ret_num2 = new int[num1.length+1];
            ret_num2[0]=carry;
            for(int i=0;i<num1.length;i++)
                ret_num2[i+1]=ret_num[i];
            return ret_num2;
        }
        return ret_num;
    }

    public static int[] aufgabe_2(int[] num1,int[] num2){
        //subtracts 2 "big num" types, returns array as result - TODO: resolve num2>num1
        //Input: int [], int []
        //Output: int []
        int [] ret_num = new int[num1.length];
        int borrow=0;
        for(int i=num1.length-1;i>=0;i--){
            ret_num[i]=num1[i]-num2[i]-borrow;
            borrow=0;
            if(ret_num[i]<0){
                ret_num[i]+=10;
                borrow=1;
            }
        }
        while(ret_num[0]==0)
            ret_num=Arrays.copyOfRange(ret_num, 1, ret_num.length);
        return ret_num;
    }
    public static int[] add_to_start_of_array(int [] array,int elem){
        //adds an element to the start of an array and returns new array
        //Input: int [], int
        //Output: int []
        int[] ret_array=Arrays.copyOf(array,array.length+1);
        ret_array[0]=elem;
        System.arraycopy(array,0,ret_array,1,array.length);
        return ret_array;
    }

    public static int[] aufgabe_3(int[] num1,int num2){
        //multiplies a "big num" type to a regular int
        //Input: int [], int
        //Output: int []
        int [] ret_num = new int[num1.length];
        int carry=0;
        for(int i=num1.length-1;i>=0;i--){
            ret_num[i]=num1[i]*num2+carry;
            carry=0;
            if(ret_num[i]>9){
                carry=ret_num[i]/10;
                ret_num[i]=ret_num[i]%10;
            }
        }
        while(carry!=0){
            ret_num=add_to_start_of_array(ret_num,carry%10);
            carry/=10;
        }
        return ret_num;
    }

    public static int[] aufgabe_4(int[] num1,int num2){
        //divides a "big num" type by a regular int (integer value)
        int [] ret_num = new int[num1.length];
        int carry=0;
        for(int i=0;i<num1.length;i++){
            ret_num[i]=(carry*10+num1[i])/num2;
            carry=(carry*10+num1[i])%num2;
        }
        while(ret_num[0]==0)
            ret_num=Arrays.copyOfRange(ret_num, 1, ret_num.length);
        return ret_num;
    }
}
