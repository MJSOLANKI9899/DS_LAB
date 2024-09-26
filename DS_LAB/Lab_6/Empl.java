public class Empl {
    public static void main(String[] args) {
        Employee_Detai a = new Employee_Detai(12, "prit", "h1", 100);
        a.display();
    }
}

class Employee_Detai {
    int Employee_ID;
    String Name;
    String Designation;
    int Salary;

    Employee_Detai(int Employee_ID, String Name, String Designation, int Salary) {
        this.Employee_ID = Employee_ID;
        this.Name = Name;
        this.Designation = Designation;
        this.Salary = Salary;
    }
    
    void display(){
        System.out.println(this.Employee_ID +" "+this.Name+" "+this.Designation+" "+this.Salary);
    }

}
