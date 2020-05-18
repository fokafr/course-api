package com.afo.springbootquickstart.topic.course;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.afo.springbootquickstart.topic.Topic;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;

	//@RequestMapping("/topics")
	@GetMapping("/topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id) {
		return courseService.getAllCourses(id);
	}

	@RequestMapping("/topics/{topicId}/courses/{course/{id}")
	public Course getCourse(@PathVariable String id) {
		return courseService.getCourse(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses/{course/{id}")
	public void addTopic(@RequestBody Course course, @PathVariable String topicId ) {
	 course.setTopic(new Topic(topicId, "", ""));	
     courseService.addCourse(course);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{course/{id}")
	public void updateTopic(@RequestBody Course course, @PathVariable String topicId ) {
		 course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(course);
}
	@RequestMapping(method = RequestMethod.DELETE, value ="/topics/{topicId}/courses/{course/{id}")
	public void deleteTopic(@PathVariable String id) {
		 courseService.deleteCourse(id);
	}
	
}
