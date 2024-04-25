public class Student implements Comparable<Student> {
    
    private Integer arrival;
    private Integer grade;

    public Student(int arrival, int grade){
        this.arrival = arrival;
        this.grade = grade;
    }

    public int getArrival(){
        return this.arrival;
    }

    public int getGrade(){
        return this.grade;
    }


    @Override
    public int compareTo(Student other) {

        int comparableAux = this.grade.compareTo(other.grade);

        if (comparableAux == 0){
            comparableAux = this.arrival.compareTo(other.arrival);
        }

        return comparableAux;
    }
}
