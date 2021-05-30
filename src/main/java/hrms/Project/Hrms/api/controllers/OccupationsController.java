package hrms.Project.Hrms.api.controllers;

import hrms.Project.Hrms.business.abstracts.OccupationService;
import hrms.Project.Hrms.core.utilities.results.DataResult;
import hrms.Project.Hrms.core.utilities.results.Result;
import hrms.Project.Hrms.entities.concretes.Occupation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/occupations")
public class OccupationsController {

	private OccupationService occupationService;

	@Autowired
	public OccupationsController(OccupationService occupationService) {
		this.occupationService = occupationService;
	}

	@GetMapping("/getall")
	public DataResult<List<Occupation>> getAll() {
		return this.occupationService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody Occupation occupation) {
		return this.occupationService.add(occupation);
	}
}
