package com.sethi.aayush.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sethi.aayush.hibernate.demo.entity.Course;
import com.sethi.aayush.hibernate.demo.entity.Instructor;
import com.sethi.aayush.hibernate.demo.entity.InstructorDetail;
import com.sethi.aayush.hibernate.demo.entity.Review;
import com.sethi.aayush.hibernate.demo.entity.Student;

public class CreateInstructorWithCoursesAndReviewDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create a session
		Session session = sessionFactory.getCurrentSession();

		try {

			Instructor tempInstructor = new Instructor("Aayush", "Sethi", "sethi.aayu@gmail.com");

			InstructorDetail tempDetail = new InstructorDetail("Youtube_Aayush_sethi", "programming");

			tempInstructor.setInstructorDetail(tempDetail);

			Course courseJava = new Course("Java");
			Course courseAspNet = new Course("ASP.NET");
			Review javaReviewOne = new Review("It is Java Course- One");
			Review javaReviewTwo = new Review("It is Java Course- Two");
			//courseJava.addReview(javaReviewTwo);
			//courseJava.addReview(javaReviewOne);
			//tempInstructor.addCourse(courseJava);
			//tempInstructor.addCourse(courseAspNet);
			
			Student student1 = new Student("Ankit", "Taneja", "ankit.taneja@gmail.com");
			Student student2 = new Student("Rahul", "Gupta", "rahul.gupta@gmail.com");
			
			courseJava.addStudent(student1);
			courseJava.addStudent(student2);
			// start a transaction
			session.beginTransaction();
			session.save(student1);
			session.save(student2);
			session.save(courseJava);
			//session.save(courseAspNet);

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}

	}

}
