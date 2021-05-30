package hrms.Project.Hrms.api.controllers;

import hrms.Project.Hrms.business.abstracts.JobSeekerService;
import hrms.Project.Hrms.core.utilities.results.DataResult;
import hrms.Project.Hrms.core.utilities.results.Result;
import hrms.Project.Hrms.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobSeekers")
public class JobSeekersController {

	private JobSeekerService jobSeekerService;

	@Autowired
	public JobSeekersController(JobSeekerService jobSeekerService) {
		this.jobSeekerService = jobSeekerService;
	}

	@GetMapping("/getall")
	public DataResult<List<JobSeeker>> getAll() {
		return this.jobSeekerService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody JobSeeker jobSeeker) {
		return this.jobSeekerService.add(jobSeeker);
	}
}
