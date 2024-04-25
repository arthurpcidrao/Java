import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        int numCases = input.nextInt();
        input.nextLine();

        for (int i = 0; i < numCases; i++){
            int numStudents = input.nextInt();
            input.nextLine();

            String stringGrades = input.nextLine();
            String grades[] = stringGrades.split(" ");

            Heap<Student> heap = new Heap<>(numStudents);
            LinkedQueue<Student> queue = new LinkedQueue<>();

            int count = 0;

            for (int j = 0; j < numStudents; j++){
                Student student = new Student(j, Integer.parseInt(grades[j]));
                heap.add(student);
                queue.enqueue(student);
            }

            for (int j = 0; j < numStudents; j++){
                int heapNext = heap.next().getGrade();
                int queueNext = queue.dequeue().getGrade();

                System.out.print(heapNext);
                System.out.println(" "+queueNext);
                if (heapNext == queueNext){
                    count++;
                }
            }

            System.out.println(count);
        }

        input.close();
    }
}
