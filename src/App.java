/*
   Författare: Aoyon Mir
   Programmet är ett fightingspel där användaren eller datorn börjar utifrån en slumptal.
   Efter det attackerar den som börjar igen med en slumptal tills en vinnare framkommer genom att hälsopoängen blir 0.
   Sedan kommer programmet tillbaks till starten då man får välja om man ska spela spelet igen eller avluta det.
 */
/*
   @author Aoyon Mir
   @version 1.0
   @since 2024
 */

 import java.util.Scanner;
 import java.util.Random;
 
 public class App {
     public static void main(String[] args) throws Exception {
         
         Scanner tangentbord = new Scanner(System.in);
         
         // int val tar emot värde från tangenbordet och sedan används värdet för att välja vilket väg i programmet som ska följas.
         int val=1;
         while(true){
 
             System.out.println("Ange tal: \n1. Starta spelomgång\n2. Avsluta spel");
             val = tangentbord.nextInt();
 
             if(val==2)
             {
                 System.out.println("Spelet är avlutat");
                 break;
             }
 
             if(val<0||val>2){
                 System.out.println("Du har angett fel tal");
                 continue;
             }
 
             // String användaren och String datorn är de som fightar.
             tangentbord.nextLine();
             System.out.println("\nAnge användarnamn: ");
             String användaren = tangentbord.nextLine();
             System.out.println("\nAnge datornamn: ");
             String datorn = tangentbord.nextLine();
 
             // int[] hp är en array för användarens och datorns hp.
             int[] hp = {10,10};
 
             // Random slumptal och int start används till att göra slumptalsgeneratorn.
             // attack1 och attack2 är attackerna för användaren och datorn.
             while(hp[0]>=0 && hp[1]>=0){
                 Random slumptal = new Random();
                 int start = slumptal.nextInt(2);
                 if(start==0){
                     int attack1 = slumptal.nextInt(5)+1;
                     int attack2 = slumptal.nextInt(5)+1;
                     hp[1]=hp[1]-attack1;
                     hp[0]=hp[0]-attack2;
                     System.out.println("\n"+användaren+" attackerar tryck ENTER: ");
                     tangentbord.nextLine();
                     Thread.sleep(1000);
                     System.out.println(attack1+"\nhp: "+hp[1]);
                     Thread.sleep(1000);
                     System.out.println("\n"+datorn+" attackerar tryck ENTER: ");
                     tangentbord.nextLine();
                     Thread.sleep(1000);
                     System.out.println(attack2+"\nhp: "+hp[0]);
                     Thread.sleep(1000);
                     if(hp[1]<=0){
                         System.out.println("\n"+användaren+" vinner\n");
                     }
                     else if(hp[0]<=0){
                         System.out.println("\n"+datorn+" vinner\n");
                     }
                 }
                 else{
                     int attack1 = slumptal.nextInt(5)+1;
                     int attack2 = slumptal.nextInt(5)+1;
                     hp[0]=hp[0]-attack1;
                     hp[1]=hp[1]-attack2;
                     System.out.println("\n"+datorn+" attackera tryck ENTER: ");
                     tangentbord.nextLine();
                     Thread.sleep(1000);
                     System.out.println(attack1+"\nhp: "+hp[0]);
                     Thread.sleep(1000);
                     System.out.println("\n"+användaren+" attackerar tryck ENTER: ");
                     tangentbord.nextLine();
                     Thread.sleep(1000);
                     System.out.println(attack2+"\nhp: "+hp[1]);
                     Thread.sleep(1000);
                     if(hp[1]<=0){
                         System.out.println("\n"+användaren+" vinner\n");
                     }
                     else if(hp[0]<=0){
                         System.out.println("\n"+datorn+" vinner\n");
                     }
                 }
             }
         }
     }
 }