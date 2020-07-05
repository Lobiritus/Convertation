/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertation;

import java.util.Scanner;

/**
 *
 * @author Lobiritus
 */
public class Convertation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

            char[] numb = new char []{'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
            int decimalNumber=0;
            int pow = 0; // степень
            int baseNumber;
            int userNumberBase;
            System.out.print("Введите исходное число: ");
            Scanner scan = new Scanner(System.in);
            String userNumber = (scan.nextLine()).toLowerCase();
            char[] chars = userNumber.toCharArray(); // преобразуем строку в char  и загоняем посимвольно  в массив
            System.out.print("Введите основание исходного числа от 2 до 36: ");
            baseNumber = scan.nextInt();                          
            System.out.print("Введите основание системы в которую вы хотите перевести от 2 до 36: ");
            userNumberBase = scan.nextInt();
            
            if(!(baseNumber>=2 && baseNumber<=36 && userNumberBase >=2 && userNumberBase <=36))
            {
                System.out.println("Неверная система счисления введите число от 2 до 36. ");
                return;
            }
            for (int i=0; i<userNumber.length();i++)
            {
                for(int j =0 ; j<36; j++)
                {
                    if(chars[i] == numb[j])
                    {
                        if(j>(baseNumber-1))
                        {
                            System.out.println("Число не соответсвует системе счисления.");
                            return;
                        }
                    }
                }
            }          
            for ( int i = userNumber.length() - 1 ; i>=0; i--) // Перевод в 10 систему счисления
            { 
                for(int j = 0; j<=36;j++)// цикл по массиву
                {
                    if(chars[i]== numb[j])
                    {
                        decimalNumber += (int)(j*Math.pow(baseNumber, pow));
                        pow++;
                        break;
                    }
                }
            }
            
            // перевод числа в нужную степень путем взятия остатка
            String result = "";
            while (decimalNumber!=0)
            {
                result = Character.toString(numb[decimalNumber % userNumberBase])+result;
                decimalNumber = decimalNumber / userNumberBase;
            }
            System.out.println("Результат перевода: " + result.toUpperCase());
        
    }
    
}
