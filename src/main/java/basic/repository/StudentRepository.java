package basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import basic.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
