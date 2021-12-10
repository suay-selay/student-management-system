package se.iths.utility;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

    @Singleton
    @Startup
    public class SampleDataGenerator {

        @PersistenceContext
        EntityManager entityManager;

        @PostConstruct
        public void generateData() {

            Student stu1 = new Student("Sofia", "Malmrod", "sm@gmail.com", "0712-345678");
            Student stu2 = new Student("Sona", "Rahimova", "sr@gmail.com", "0721-098765");
            Student stu3 = new Student("Mia", "Quirin", "mq@gmail.com", "0762-453891");
            Student stu4 = new Student("Anna", "Anderson", "aa@gmail.com", "0756-223344");
            Student stu5 = new Student("Maria", "Westman", "mw@gmail.com", "0798-123657");
            Student stu6 = new Student("Hina", "Osman", "ho@gmail.com", "0756-109283");


            Subject sub1 = new Subject("History");
            Subject sub2 = new Subject("Math");
            Subject sub3 = new Subject("Religion");

            Teacher tea1 = new Teacher("Ingrid", "Malmgren", "im@hotmail.com", "0721-567890");
            Teacher tea2 = new Teacher("Niklas", "Ingemar", "ni@hotmail.com", "0721-567888");


            sub1.addStudent(stu1);
            sub1.addStudent(stu2);
            sub1.setTeacher(tea1);

//            tea1.addSubject(sub1);
//            tea2.addSubject(sub2);
//            tea2.addSubject(sub3);

//            tea2.addSubject(sub2);
//            tea2.addSubject(sub1);
//            tea2.addSubject(sub3);

//            stu1.addSubject(sub1);
//            stu2.addSubject(sub1);
//            stu3.addSubject(sub1);
//
//           stu4.addSubject(sub2);
//            stu5.addSubject(sub2);
//            stu6.addSubject(sub2);
//
//            stu1.addSubject(sub3);
//            stu3.addSubject(sub3);
//            stu5.addSubject(sub3);


//            entityManager.persist(stu1);
//            entityManager.persist(stu2);
//            entityManager.persist(stu3);
//            entityManager.persist(stu4);
//            entityManager.persist(stu5);
//            entityManager.persist(stu6);
//
//            entityManager.persist(tea1);
//            entityManager.persist(tea2);

            entityManager.persist(sub1);
            entityManager.persist(sub2);
            entityManager.persist(sub3);

        }

}
