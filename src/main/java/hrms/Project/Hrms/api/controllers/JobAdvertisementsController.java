package hrms.Project.Hrms.api.controllers;

import hrms.Project.Hrms.business.abstracts.JobAdvertisementService;
import hrms.Project.Hrms.core.utilities.results.DataResult;
import hrms.Project.Hrms.core.utilities.results.Result;
import hrms.Project.Hrms.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/jobAdvertisement")
public class JobAdvertisementsController {

	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		this.jobAdvertisementService = jobAdvertisementService;
	}

	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll() {
		return this.jobAdvertisementService.getAll();
	}

	@GetMapping("/findByIsActiveTrue")
	public DataResult<List<JobAdvertisement>> findByIsActiveTrue() {
		return this.jobAdvertisementService.findByIsActiveTrue();
	}

	@GetMapping("/findByEmployerId")
	public DataResult<List<JobAdvertisement>> findByEmployerId(int id) {
		return this.jobAdvertisementService.findByEmployerId(id);
	}

	@GetMapping("/findByEmployer_CompanyName")
	public DataResult<List<JobAdvertisement>> findByEmployer_CompanyName(@RequestParam String companyName) {
		return this.jobAdvertisementService.findByEmployer_CompanyName(companyName);
	}

	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}

	@PostMapping("/findByUpdatedAtAndIsActiveTrue")
	public DataResult<List<JobAdvertisement>> findByUpdatedAtAndIsActiveTrue(@RequestBody LocalDate localDate) {
		return this.jobAdvertisementService.findByUpdatedAtAndIsActiveTrue(localDate);
	}

	@PutMapping("/updateStatusJobAdvertisement")
	public DataResult<JobAdvertisement> updateStatusJobAdvertisement(@RequestParam int id,
			@RequestParam boolean status) {
		return this.jobAdvertisementService.updateStatusJobAdvertisement(id, status);
	}
}
