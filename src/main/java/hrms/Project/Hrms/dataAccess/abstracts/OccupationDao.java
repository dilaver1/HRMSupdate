package hrms.Project.Hrms.dataAccess.abstracts;

import hrms.Project.Hrms.entities.concretes.Occupation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OccupationDao extends JpaRepository<Occupation, Integer> {

	Occupation findByName(String name);
}