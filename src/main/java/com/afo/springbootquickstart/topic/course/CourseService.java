package com.afo.springbootquickstart.topic.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	/*private List<Course> courses = new ArrayList<>(Arrays.asList(
			new Course("spring", "spring frameWork", "Spring framework description"),
			new Course("java", "java core", "java core  description"),
			new Course("javascript", "javascript core", "javascript core  description")				
			));*/
	public List<Course> getAllCourses(String topicId) {
		//return topics;
		List<Course> courses = new ArrayList<>();
		//courseRepository.findAll().forEach(courses::add);
		courseRepository.findByTopicId(topicId).forEach(courses::add);
		return courses;
	}
	
	public Course getCourse(String id) {
		//return topics.stream().filter(x -> x.getId().equals(id)).findFirst().get();
		return courseRepository.findOne(id);
	}

	public void addCourse(Course course) {
     //topics.add(topic);
		courseRepository.save(course);
	}

	public void updateCourse(Course course) {
//		for(int i = 0; i < topics.size(); i++) {
//			Topic t = topics.get(i);
//			if(t.getId().equals(id)) {
//				topics.set(i, topic);
//				return;
//			}
//		}
		courseRepository.save(course);
	}

	public void deleteCourse(String id) {
		// TODO Auto-generated method stub
		//topics.removeIf(x -> x.getId().equals(id));
		courseRepository.delete(id);
	}
	
	
	
	

}
