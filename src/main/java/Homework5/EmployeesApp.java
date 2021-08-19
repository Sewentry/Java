package Homework5;

public class EmployeesApp {
    public static void main(String[] args) {
    Employees[] staffArray = new Employees[5];
    staffArray[0] = new Employees("Ivanov Ivan", "Engineer", "Ivanov@corp.ru",8985, 25000, 30);
    staffArray[1] = new Employees("Ivanov Igor","Head Engineer","IvanovI@corp.ru",8901,35000,28);
    staffArray[2] = new Employees("Sidorov Alex", "programmer", "Sidorov@corp.ru", 8902, 30000,23);
    staffArray[3] = new Employees("Petrov Pasha", "leader", "Petrov@corp.ru",8900,49000,42);
    staffArray[4] = new Employees("Kuvshinova Svetlana", "HR", "Kuvshinova@corp.ru", 8999, 27000, 38);
        System.out.println(staffArray[1].getAge());
    for (int i=0; i<5; i++){
        if(staffArray[i].getAge()>40){
            staffArray[i].info();
        }
    }
    }
}
