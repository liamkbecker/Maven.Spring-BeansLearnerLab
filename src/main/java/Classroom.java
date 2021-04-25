public class Classroom {

    private Students students;
    private Instructors instructors;

    public Classroom(Students students, Instructors instructors){
        this.students = students;
        this.instructors = instructors;
    }

    public void hostLecture(Teacher teacher, double numberOfHours){
        teacher.lecture(this.students, numberOfHours);
    }

}
