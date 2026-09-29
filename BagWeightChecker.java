import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class BagWeightChecker
{   static int SubPerDay;
    static int week;
    static double weight;
    static double StudentWeight;
    static String response="Blank";
    static String DayToday;
    static String[][] TimeTableArray;
    static String[] TodayTimeTableArray;
    static String[] BooksTakenToday;
    static int day;
    static String textFileContent;
    public static void main(String[] args)
    {
            askDayOfTheWeek();
if (DayToday=="Monday" || DayToday=="monday")
{

}
    }
    public static void askDayOfTheWeek() {
        int i = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("What's the day of the week?");
        DayToday = sc.nextLine();
        DayToday = DayToday.toLowerCase();
        switch (DayToday) {
            case "monday":
                day = 0;
                break;
            case "tuesday":
                day = 1;
                break;
            case "wednesday":
                day = 2;
                break;
            case "thursday":
                day = 3;
                break;
            case "friday":
                day = 4;
                break;
            case "saturday":
                day = 5;
                break;
            default:
                System.out.println("Please enter the day of the week correctly.");
                break;
        }
    }
    public static boolean checkFile() {
        File timetable = new File("timetable.txt");
        if (timetable.exist() == true) {
            continue;
        } else if (timetable.exist() == false) {
            fileHandling();
        } else {
            break;
        }
    }
    public static void fileHandling() {

        try {
            File timetable = new File("timetable.txt");
            FileWriter writer = new FileWriter("timetable.txt");
              for (int j = 0; j <= week - 1; j++) {
                for (int i = 0; i <= SubPerDay - 1; i++)
                {
                    writer.write(TimeTableArray[i][j]);
                    writer.write("\n");
                }
                writer.write("\n");
                writer.write("\n");
            }
                writer.close();
        }
        catch (IOException e)
        {
            System.out.println("Something went wrong");
        }
    }

    public static void AddWeeklyScheduleCalendar()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("How many lectures do you have each day?");
        SubPerDay=sc.nextInt();
        System.out.print("Do you go to school on Saturday as well?");
        String answer=sc.nextLine();
        int week=0;
        if(answer=="yes" || answer=="Yes")
        {
            week=6;
        }
        else{
            week=5;
        }
        String[][] TimeTableArray = new String[SubPerDay][week];
        for(int i=1;i<=week;i++)
        {System.out.println("Enter the Subjects for day "+i);
            for(int j=1;j<=SubPerDay;j++)
            {
              String TempSubVar= sc.nextLine();
              System.out.println(TempSubVar);
              TimeTableArray[j-1][i-1]=TempSubVar;
            }
        }

        System.out.println("Your time table for this week is: ");
         for(int i=0;i<=week-1;i++)
         {System.out.println();
             System.out.println("Day "+(i+1));
             for(int j=0;j<=SubPerDay-1;j++)
             {
                 System.out.println(TimeTableArray[j][i]);
             }
         }

    }


    public static void TodayTimeTable()
    {
        String[] TodayTimeTableArray = new String[SubPerDay];
        System.out.println("Ok, so here's what you've got for today:");
        for(int j=0;j<=(SubPerDay-1);j++)
        {
            System.out.println(TimeTableArray[j][day]);
            TodayTimeTableArray[j]=TimeTableArray[j][day];
        }


    }
    public static void AskWeight() {
        Scanner sc = new Scanner(System.in);
        System.out.println("The safe limit for backpack weight is correctly decided through the person's body weight." +
                "Kindly enter your current weight in kilograms to proceed");
        StudentWeight = sc.nextDouble();
    }


    public static void ScheduleAndBookCheck()
    {Scanner sc=new Scanner(System.in);
        int books=0;int t=0;
        for(int i=0;i<=SubPerDay-1;i++) {
            System.out.println("Enter the weight of your backpack");
            weight = sc.nextDouble();
            if (weight > (StudentWeight * 0.15)) {
                System.out.println("Enter the number of books you've taken");
                books = sc.nextInt();
                if(books<SubPerDay)
                {
                    while(response=="Blank")
                    {
                        System.out.print("Using the above timetable please recheck if you've packed all the necessary books." +
                                "Type 'yes' if you have.");
                        response = sc.nextLine();
                    }

                }
                System.out.print("Enter the books you've taken");
                int NumberOfBooksTaken=sc.nextInt();
                String[] BooksTakenToday = new String[books];
                  for(int i=0;i<=NumberOfBooksTaken-1;i++) {
                      BooksTakenToday[i] = sc.nextLine();
                  }
                for (int i = 0; i <= books-1; i++) {
                    for (int j = 0; j <= SubPerDay - 1; j++) {
                        if (BooksTakenToday[i] == TodayTimeTableArray[j]) {
                            t = 1;
                            break;
                        }

                    }
                    if (t == 0) {
                        System.out.println(BooksTakenToday[i] + " -you could try removing this book.");
                    }
                }
                System.out.println("After removing the suggested books, please enter the new weight of the backpack");
                double NewWeight=sc.nextDouble();
                while(NewWeight>(StudentWeight*0.15))
                {
                    System.out.println("Oops we're still crossing the safety limit. Try removing some more books");
                }
                System.out.println("Yay looks like you're all set to go!");
            }
        }

        }
    }
    public static void RandomWishDisplay()
    {
        Random ra=new Random();
        int WishNumber=ra.nextInt(4);
        switch (WishNumber)
        {
            case 0: System.out.println("Wishing you lots of confidence and a little bit of luck today.");
            break;
            case 1: System.out.println("Sending a little sunshine for your schoolday!");
            break;
            case 2: System.out.println("Have a fantastic day- you've got all it takes.");
            break;
            case 3: System.out.println("Today's going to bring confidence, laughter and awesome lectures.");
            break;
        }
    }
}


