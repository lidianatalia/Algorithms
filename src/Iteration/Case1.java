/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iteration;

import java.util.Scanner;

/**
 *
 * @author lidia
 */
public class Case1 {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.print("N = ");
        int n = new Scanner (System.in).nextInt();
        System.out.println(Solution (n));
    }
    
    public static int Solution (int N){
        String binary = rec(N);
        String values = checkGaps (binary);
        int result = 0;
        String[] res = values.split(",");
        //System.out.println(values);
        for (int i = 0; i< res.length; i++){
            if (!res[i].equals("")){
                if (Integer.parseInt(res[i]) > result){
                    result = Integer.parseInt(res[i]);
                }
            }
        }
        return result;
    }
    
    public static String rec (int N){
        if (N <=1){
            return String.valueOf(N);
        }
        else {
            if (N%2 == 1){
                return rec (N/2) + "1";
            }else {
                return rec (N/2) + "0";
            }
        }
    }
    
    public static String checkGaps (String binary){
        String gaps = "";
        int flg = 0;
        boolean chk = false;
        int i = 0;
            while (i < binary.length() && chk == false){
                int j =i+1; 
                while (j < binary.length() && chk == false){
                    if ((binary.charAt(j)=='0') && (j!= binary.length()-1)){
                        flg += 1;
                    }
                    else if ((j != i+1) && (binary.charAt(j) =='1')){
                        gaps = Integer.toString(flg);
                        chk = true;
                        binary = binary.substring(j,binary.length());
                    }
                    else if ((j== binary.length()-1) && (binary.charAt(j)=='0')){
                        chk = true;
                        return "";
                    }
                    else {
                        return gaps +"," + checkGaps (binary.substring(j,binary.length()));
                    }
                    j++;
                }
                i++;
                
            }
            if (binary.length()<=1)
                return gaps;
            
            else return gaps + "," + checkGaps(binary);
    }
}
