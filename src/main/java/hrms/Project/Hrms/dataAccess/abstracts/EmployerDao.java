package hrms.Project.Hrms.dataAccess.abstracts;

import hrms.Project.Hrms.entities.concretes.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerDao extends JpaRepository<Employer, Integer> {

	Employer findByEmail(String email);
}
