package basic.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import basic.entity.Student;
import basic.repository.StudentRepository;

@RestController
public class K8SApiController {

	private final StudentRepository studentRepository;

	public K8SApiController(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@GetMapping(value = "/api/status")
	public String k8sApiTest() {
		return "Status - Hello World!!";
	}

	@GetMapping(value = "/api/students")
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}
}
