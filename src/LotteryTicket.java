import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//algorithm
//1.Input for no. of test case to be executed
//2.Input for number of tickets
//3.Input for ticket code (each int)
//4.process ticket codes
//5.If divisible by 5 then LUCKY else UNLUCKY
class MyLottery{
    private int testCases=0,ticketCount = 0;
    private int[] tickets;
    private String[] result;
    Scanner sc = new Scanner(System.in);
    MyLottery(){
        System.out.println("Enter no. of test case(s):");
        testCases = sc.nextInt();
        result = new String[testCases];
        //ask test case to user
        for (int t = 0; t < testCases; t++) {
            System.out.println("*TestCase:" + (t + 1));
            System.out.print("Enter total number of tickets:");
            ticketCount = sc.nextInt();
            tickets = new int[ticketCount];
            int sum = 0, num = 0;
            //get ticket code from user
            for (int i = 0; i < tickets.length; i++) {
                num = sc.nextInt();
                tickets[i] = num;
                //sum last digit of every ticket code
                sum = sum + getLastDigit(num);
            }
            //check tickets are lucky
            result[t] = (sum % 2 == 0 ? "LUCKY" : "UNLUCKY");
        }
    }
    int getLastDigit(int num){
        if(num<10)
            return num;
        else
            return num%10;
    }
    public void showResult(){
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
public class LotteryTicket {
    public static void main(String[] args) {
        MyLottery obj = new MyLottery();
        obj.showResult();
    }
}
