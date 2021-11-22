package se.iths.service;

import se.iths.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional

public class StudentService {
    @PersistenceContext
    EntityManager entityManager;

    public void createStudent(Student student){
        entityManager.persist(student);
    }

    public void updateStudent(Student student){
        entityManager.merge(student);
    }

    public Student updateLastName (Long id, String lastName) {
        Student foundStudent = entityManager.find(Student.class, id);
            foundStudent.setFirstName(lastName);
            return foundStudent;
    }


    public Student findStudentById(Long id){
        return entityManager.find(Student.class, id);
    }

    public void deleteStudent(Long id) {
        Student foundStudent = entityManager.find(Student.class, id);
        entityManager.remove(foundStudent);
    }

    public List<Student> findStudentByLastName(String lastName){
        return entityManager.createQuery("SELECT s from Student s WHERE s.lastName LIKE :lastName")
                .setParameter("lastName", lastName)
                .getResultList();
    }

    public List<Student> getAllStudents(){
        return entityManager.createQuery("SELECT s from Student s", Student.class ).getResultList();
    }


}
