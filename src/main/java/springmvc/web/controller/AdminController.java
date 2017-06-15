package springmvc.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import springmvc.model.Additional_Requirements;
import springmvc.model.Department;
import springmvc.model.Program;
import springmvc.model.dao.AdditionalDao;
import springmvc.model.dao.DepartmentDao;
import springmvc.model.dao.ProgramDao;

@Controller
@SessionAttributes({ "department", "program", "requirement" })
public class AdminController {

	@Autowired
	private DepartmentDao deptDao;

	@Autowired
	private ProgramDao progDao;

	@Autowired
	private AdditionalDao addReqDao;

	@RequestMapping("/user/admin.html")
	public String index() {
		return "user/admin";
	}

	// List all departments
	@RequestMapping("/department/list.html")
	public String departments(ModelMap models) {
		models.put("depts", deptDao.getDepartments());

		return "department/list";
	}

	// department details
	@RequestMapping("/department/details.html")
	public String departmentDetails(@RequestParam Integer id, ModelMap models) {
		// Get department by id
		models.put("department", deptDao.getDep(id));
		System.out.println("Department NAME: " + deptDao.getDep(id).getName());

		// get department's programs
		models.put("deptProgs", deptDao.getDep(id).getPrograms());

		// get department's additional requirements
		models.put("deptAdReqs", deptDao.getDep(id).getRequirements());

		return "department/details";
	}

	// Add department
	@RequestMapping(value = "/department/add.html", method = RequestMethod.GET)
	public String add(ModelMap models) {
		models.put("department", new Department());
		return "department/add";
	}

	@RequestMapping(value = "/department/add.html", method = RequestMethod.POST)
	public String add(@ModelAttribute Department department) {

		// Save department into Database
		department = deptDao.saveDepartment(department);
		System.out.println("Department saved");
		return "redirect:list.html";

	}

	// Edit department
	@RequestMapping(value = "/department/edit.html", method = RequestMethod.GET)
	public String edit(@RequestParam Integer id, ModelMap models) {
		models.put("department", deptDao.getDep(id));
		return "department/edit";
	}

	@RequestMapping(value = "/department/edit.html", method = RequestMethod.POST)
	public String edit(@ModelAttribute Department department, SessionStatus status) {

		// Saving into database
		department = deptDao.saveDepartment(department);

		status.setComplete();

		return "redirect:list.html";
	}

	// Remove department
	@RequestMapping("/department/remove.html")
	public String removeDepartment(@RequestParam Integer id, ModelMap models) {
		// Remove department by id
		deptDao.removeDepartment(deptDao.getDep(id));

		// Update list of departments
		models.put("depts", deptDao.getDepartments());
		return "department/list";
	}

	// Add program
	@RequestMapping(value = "/program/add.html", method = RequestMethod.GET)
	public String addProg(@RequestParam Integer id, ModelMap models) {
		models.put("program", new Program());
		models.put("departmentID", id);
		return "program/add";
	}

	@RequestMapping(value = "/program/add.html", method = RequestMethod.POST)
	public String addProg(@ModelAttribute Program program) {

		// Save department into Database
		program = progDao.saveProgram(program);
		System.out.println("Program saved");
		return "redirect:../department/details.html?id=" + program.getProgramOwner();

	}

	// Edit program
	@RequestMapping(value = "/program/edit.html", method = RequestMethod.GET)
	public String editProg(@RequestParam Integer id, ModelMap models) {
		models.put("DepID", progDao.getProgram(id).getProgramOwner());
		models.put("program", progDao.getProgram(id));
		return "program/edit";
	}

	@RequestMapping(value = "/program/edit.html", method = RequestMethod.POST)
	public String editProg(@ModelAttribute Program program, SessionStatus status) {

		Integer depID = program.getProgramOwner().getId();

		// Saving into database
		program = progDao.saveProgram(program);

		status.setComplete();

		return "redirect:../department/details.html?id=" + depID;
	}

	// Remove program
	@RequestMapping("/program/remove.html")
	public String removeProg(@RequestParam Integer id, ModelMap models) {
		// program department
		Integer dID = progDao.getProgram(id).getProgramOwner().getId();

		// Remove program by id
		progDao.removeProgram(progDao.getProgram(id));

		// Update list of programs
		models.put("deptProgs", progDao.getPrograms());
		return "redirect:../department/details.html?id=" + dID;
	}

	// Add requirement
	@RequestMapping(value = "/additional/add.html", method = RequestMethod.GET)
	public String addReq(@RequestParam Integer id, ModelMap models) {
		models.put("depID", id);
		models.put("requirement", new Additional_Requirements());
		return "additional/add";
	}

	@RequestMapping(value = "/additional/add.html", method = RequestMethod.POST)
	public String addReq(@ModelAttribute Additional_Requirements requirement) {

		// requirement department
		Integer depID = requirement.getAdditionalReqOwner().getId();

		// Save requirement into Database
		requirement = addReqDao.saveRequirement(requirement);
		System.out.println("requirement saved");
		return "redirect:../department/details.html?id=" + depID;

	}

	// Edit requirement
	@RequestMapping(value = "/additional/edit.html", method = RequestMethod.GET)
	public String editReq(@RequestParam Integer id, ModelMap models) {
		models.put("DepID", addReqDao.getAdditionalReq(id).getAdditionalReqOwner());
		models.put("requirement", addReqDao.getAdditionalReq(id));
		return "additional/edit";
	}

	@RequestMapping(value = "/additional/edit.html", method = RequestMethod.POST)
	public String editReq(@ModelAttribute Additional_Requirements requirement, SessionStatus status) {

		// requirement department
		Integer depID = requirement.getAdditionalReqOwner().getId();

		// Saving into database
		requirement = addReqDao.saveRequirement(requirement);

		status.setComplete();

		return "redirect:../department/details.html?id=" + depID;
	}

	// Remove requirement
	@RequestMapping("/additional/remove.html")
	public String removeReq(@RequestParam Integer id, ModelMap models) {
		// requirement department
		Integer depID = addReqDao.getAdditionalReq(id).getAdditionalReqOwner().getId();

		// Remove requirement by id
		addReqDao.removeAdditionalReq(addReqDao.getAdditionalReq(id));

		// Update list of requirements
		models.put("deptAdReqs", addReqDao.getAdditionalReqs());
		return "redirect:../department/details.html?id=" + depID;
	}
}
