import java.util.Scanner;

public class Student {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Student_Detail[] arr = new Student_Detail[5];
           
        for(int i = 0;i<5;i++){
            arr[i] = new Student_Detail();
            arr[i].Get_Student();
            System.out.print("---------------------------------");
        }
        for(int i = 0;i<5;i++){
            arr[i].Display();
            System.out.print("---------------------------------");
        }

    }
}
class Student_Detail {

    int Enrollment_No;
    String Name;
    int Semester;
    int CPI;
    
    Student_Detail(){
        this.Enrollment_No = Enrollment_No;
        this.Name = Name;
        this.Semester = Semester;
        this.CPI = CPI;
    }
    
    void Get_Student(){
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Enrollment no. : ");
            Enrollment_No = sc.nextInt();

            System.out.print("Enter Name : ");
            Name = sc.next();
            
            System.out.print("Enter Semester : ");
            Semester = sc.nextInt();
            
            System.out.print("Enter CPI : ");
            CPI = sc.nextInt();
        
    }
    void Display(){
       
            System.out.println(" : ");
           System.out.println(" Enrollment_No :" + Enrollment_No);
           System.out.println(" Name :" + Name);
           System.out.println(" Semester :" + Semester);
           System.out.println(" CPI :" +CPI);
           System.out.println();
        
    }
    
    
}
