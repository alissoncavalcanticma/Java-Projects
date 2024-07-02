package entities;

public class Employee implements Comparable<Employee> {
    private String name;
    private Double salary;

    public Employee(String name, Double salary){
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    //TIP Método de comparação originado na interface Comparable<Employee>
    //O retorno será positivo caso o primeiro seja maior, ou do contrário será negativo.
    //Para valores idênticos retornará zero
    @Override
    public int compareTo(Employee other) {

        //Para comparação contrária, pode se usar o sinal negativo na frente do campo:
        // return -name.compareTo(other.getName());

        return name.compareTo(other.getName());
    }
}
