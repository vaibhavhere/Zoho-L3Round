// Task was to make a TimeTbale Application with the constraints that there 4 core subjects, 3 non-core subjects. A week has 5 days and 5 slots each day.

// LOGIC:
// 4 core subjects- each core subjects repeats 4 times a week. Hence, 16 core subject slots.
// 3 non-core subjects- each non core subject repetas 3 times a week, Hence 9 non-core subjects slots.
// Total 16+9=25 sots. Consgtraint satisfied.
// Featurees Added:
// Generate Table Feature with constraints
// Swap days
// Swap subjects
// Print days 
// Print specific subject
// List subjects
// List teachers

import java.util.Scanner;

public class TimeTableApp {
    static String current="";
    static Scanner sc=new Scanner(System.in);
    static String[] studentOptions={"View Table","List Teachers","List subjects","Table of Specific Day","Table of Specific period"};
    static String[] adminOptions={"View table for each Teacher","Generate Table","Swap Days","Swap Subjects","Mark absent","Update details"};
    static String[][] coreTeachers={{"A","B"},{"C","D"},{"E","F"},{"G","H"}};
    static String[] nonCoreTeachers={"X","Y","Z"};
    static String[] coreSubjects={"Java","C++","OOPS","DSA"};
    static String[] nonCoreSubjects={"Physics","Chemistry","English"};
    static String[][] table=generateTable(coreSubjects, nonCoreSubjects);
    static Teacher[] coreTeacher=new Teacher[8];
    static Teacher[] nonCoreTeacher=new Teacher[3];

    public static void main(String[] args) {
        getInput();
    }


    static void printTeachers(){
        int i=0,index=1;
        System.out.println("\nTeachers:");
        for(i=0;i<coreTeachers.length;i++,index++){
            System.out.printf("%d. %-10s -",index,coreSubjects[i]);
            for(int j=0;j<coreTeachers[i].length;j++){
                System.out.print(coreTeachers[i][j]);
                if(j<coreTeachers[i].length-1){
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
        for(i=0;i<nonCoreTeachers.length;i++,index++){
            System.out.printf("%d. %-10s -%s\n",index,nonCoreSubjects[i],nonCoreTeachers[i]);          
        }
    }

    static void printSubjects(){
        int i=0,index=1;
        System.out.println("\nSubjects:");
        for(i=0;i<coreSubjects.length;i++,index++){
            System.out.println(index+". "+coreSubjects[i]);
        }
        for(i=0;i<nonCoreSubjects.length;i++,index++){
            System.out.println(index+". "+nonCoreSubjects[i]);
        }
    }

    static void getInput(){
        System.out.println("1. Login as Student");
        System.out.println("2. Login as Admin");
        System.out.println("3. Exit");

        int choice=sc.nextInt();
        if(choice==1){
            current="student";
            displayOptions(studentOptions);
            studentChoice();
        }
        else if(choice==2){
            current="admin";
            displayOptions(studentOptions,adminOptions);
            adminChoice();
        }
        else if(choice==3){
        }
    }

    static void displayOptions(String[]... options){
        int i,j,index=1;
        System.out.println("\nOptions:");
        for(i=0;i<options.length;i++){
            for(j=0;j<options[i].length;j++,index++){
                System.out.println(index+". "+options[i][j]);
            }
        }
        System.out.println(index+". Back");
    }

    static void adminChoice(){
        int choice=sc.nextInt();
        switch(choice){
            case 1:
            printTable(table,null,null);
            if(current.equals("admin")){
                displayOptions(studentOptions,adminOptions);
                adminChoice();
            }
            else{
                displayOptions(studentOptions);
                studentChoice();
            }
            break;
            case 2:
            // printTeachers();
            if(current.equals("admin")){
                displayOptions(studentOptions,adminOptions);
                adminChoice();
            }
            else{
                displayOptions(studentOptions);
                studentChoice();
            }
            break;
            case 3:
            printSubjects();
            if(current.equals("admin")){
                displayOptions(studentOptions,adminOptions);
                adminChoice();
            }
            else{
                displayOptions(studentOptions);
                studentChoice();
            }
            break;
            case 4:
            System.out.print("Enter Day:");
            String day=sc.next();
            printTable(table,day,null);
            if(current.equals("admin")){
                displayOptions(studentOptions,adminOptions);
                adminChoice();
            }
            else{
                displayOptions(studentOptions);
                studentChoice();
            }
            break;
            case 5:
            System.out.print("Enter period name:");
            String name=sc.next();
            printTable(table,null,name);
            if(current.equals("admin")){
                displayOptions(studentOptions,adminOptions);
                adminChoice();
            }
            else{
                displayOptions(studentOptions);
                studentChoice();
            }
            break;
            case 6:
            getInput();
            break;
            case 7:
            table=generateTable(coreSubjects, nonCoreSubjects);
            if(current.equals("admin")){
                displayOptions(studentOptions,adminOptions);
                adminChoice();
            }
            else{
                displayOptions(studentOptions);
                studentChoice();
            }
            break;
            case 8:
            swapDays();
            if(current.equals("admin")){
                displayOptions(studentOptions,adminOptions);
                adminChoice();
            }
            else{
                displayOptions(studentOptions);
                studentChoice();
            }
            break;
            case 9:
            swapSubjects();
            if(current.equals("admin")){
                displayOptions(studentOptions,adminOptions);
                adminChoice();
            }
            else{
                displayOptions(studentOptions);
                studentChoice();
            }
            break;
            case 10:
            System.out.println("Feature yet to be rolled out :)");
            if(current.equals("admin")){
                displayOptions(studentOptions,adminOptions);
                adminChoice();
            }
            else{
                displayOptions(studentOptions);
                studentChoice();
            }
            break;
            case 11:
            System.out.println("Feature yet to be rolled out :)");
            swapSubjects();
            if(current.equals("admin")){
                displayOptions(studentOptions,adminOptions);
                adminChoice();
            }
            else{
                displayOptions(studentOptions);
                studentChoice();
            }
            break;
            case 12:
            getInput();
        }
    }

static void swapDays(){
    System.out.print("Swap:");
    int s=dayToInt(sc.next());
    System.out.print("With:");
    int w=dayToInt(sc.next());
    String[] temp=table[s];
    table[s]=table[w];
    table[w]=temp;
}

static void swapSubjects(){
    System.out.print("Swap:");
    int s=dayToInt(sc.next());
    int c1=sc.nextInt()-1;
    System.out.print("With:");
    int w=dayToInt(sc.next());
    int c2=sc.nextInt()-1;
    String temp=table[s][c1];
    table[s][c1]=table[w][c2];
    table[w][c2]=temp;
}

static int dayToInt(String s){
    switch(s){
        case "Monday":
        return 0;
        case "Tuesday":
        return 1;
        case "Wednesday":
        return 2;
        case "Thursday":
        return 3;
        case "Friday":
        return 4;
    }
    return -1;
}

static String intToDay(int i){
    switch(i){
        case 0:
        return "Monday";
        case 1:
        return "Tuesday";
        case 2:
        return "Wednesday";
        case 3:
        return "Thursday";
        case 4:
        return "Friday";
    }
    return "";
}

    static void studentChoice(){
        int choice=sc.nextInt();
        switch(choice){
            case 1:
            printTable(table,null,null);
            if(current.equals("admin")){
                displayOptions(studentOptions,adminOptions);
                adminChoice();
            }
            else{
                displayOptions(studentOptions);
                studentChoice();
            }
            break;
            case 2:
            // printTeachers();
            if(current.equals("admin")){
                displayOptions(studentOptions,adminOptions);
                adminChoice();
            }
            else{
                displayOptions(studentOptions);
                studentChoice();
            }
            break;
            case 3:
            printSubjects();
            if(current.equals("admin")){
                displayOptions(studentOptions,adminOptions);
                adminChoice();
            }
            else{
                displayOptions(studentOptions);
                studentChoice();
            }
            break;
            case 4:
            System.out.print("Enter Day:");
            String day=sc.next();
            printTable(table,day,null);
            if(current.equals("admin")){
                displayOptions(studentOptions,adminOptions);
                adminChoice();
            }
            else{
                displayOptions(studentOptions);
                studentChoice();
            }
            break;
            case 5:
            System.out.print("Enter period name:");
            String name=sc.next();
            printTable(table,null,name);
            if(current.equals("admin")){
                displayOptions(studentOptions,adminOptions);
                adminChoice();
            }
            else{
                displayOptions(studentOptions);
                studentChoice();
            }
            break;
            case 6:
            getInput();
            break;
        }

    }


    static String[][] generateTable(String[] coreSubjects,String[] nonCoreSubjects){
        int i,j,core=0,nonCore=0;
        String[][] table=new String[5][5];
        for(i=0;i<5;i++){
            for(j=0;j<5;j++){
                if(j%2==0 || (i==4 && j==1)){
                    table[i][j]=coreSubjects[core];
                    core++;
                    if(core>=coreSubjects.length)core=0;
                }
                else{
                    table[i][j]=nonCoreSubjects[nonCore];
                    nonCore++;
                    if(nonCore>=nonCoreSubjects.length)nonCore=0;
                }
            }
        }
        return table;
    }

    static void printTable(String[][] table,String day,String name){
        for(int i=0;i<6;i++){
            if(i>0) System.out.printf("%-10s",i);
            else System.out.printf("%-10s","");
        }
        System.out.println();
        for(int i=0;i<5;i++){
            if(day!=null){
                if(i==dayToInt(day)){
                    System.out.printf("%-10s",intToDay(i));
                    for(int j=0;j<5;j++){
                        System.out.printf("%-10s",table[i][j]);
                    }
                    System.out.println();
                }
            }
            else if(name!=null){
                    System.out.printf("%-10s",intToDay(i));
                    for(int j=0;j<5;j++){
                        if(table[i][j].equals(name))
                        System.out.printf("%-10s",table[i][j]);
                        else
                        System.out.printf("%-10s","");
                    }
                    System.out.println();
            }
            else{
                System.out.printf("%-10s",intToDay(i));
                    for(int j=0;j<5;j++){
                        System.out.printf("%-10s",table[i][j]);
                    }
                    System.out.println();
            }
        }
    }
}
