package se.iths.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    private String subjectName;

    @ManyToOne
    private Teacher teacher;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })

    @JoinTable(name = "student_subject",
        joinColumns = @JoinColumn(name = "subject_id"),
        inverseJoinColumns = @JoinColumn(name = "student_id"))

    private List<Student> students = new ArrayList<>();

    public Teacher getTeacher() {
        return teacher;
    }



    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
        teacher.getSubjects().add(this);
    }

    public void addStudent(Student student) {
        students.add(student);
        student.getSubjects().add(this);
    }

    public Subject(String subjectName) {
        this.subjectName = subjectName;
    }

    public Subject() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }


    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
