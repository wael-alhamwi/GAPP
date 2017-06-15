package springmvc.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import springmvc.model.Application;
import springmvc.model.Department;
import springmvc.model.FileClass;
import springmvc.model.Program;
import springmvc.model.Student;
import springmvc.model.User;
import springmvc.model.dao.ApplicationDao;
import springmvc.model.dao.DepartmentDao;
import springmvc.model.dao.FileDao;
import springmvc.model.dao.ProgramDao;
import springmvc.model.dao.StudentDao;

@Controller
@SessionAttributes({ "departments", "programs", "requirements", "application" })
public class StudentController {

	@Autowired
	private ApplicationDao appDao;

	@Autowired
	private FileDao fileDao;
	
	@Autowired
	private DepartmentDao depDao;
	
	@Autowired
	private ProgramDao progDao;
	
	@Autowired
	private StudentDao stdDao;

	@Autowired
	private ServletContext context;

	// List all applications
	@RequestMapping("/student/list.html")
	public String departments(@RequestParam Integer id, ModelMap models) {
		models.put("stdUserID", id);
		models.put("apps", appDao.getApplications());
		return "student/list";
	}

	// Show application details
	@RequestMapping("/student/details.html")
	public String userDetails(@RequestParam Integer id, ModelMap models) {
		// get application by id
		models.put("std", appDao.getApp(id).getStdAppOwner());
		models.put("app", appDao.getApp(id));
		return "student/details";
	}

	// Upload file GET
	@RequestMapping(value = "/student/upload.html", method = RequestMethod.GET)
	public String fileUpload(@RequestParam Integer id, HttpSession session) {
		session.setAttribute("id", id);
		return "student/upload";
	}

	// Upload file POST
	@RequestMapping(value = "/student/upload.html", method = RequestMethod.POST)
	public String Upload(@RequestParam MultipartFile file, HttpSession session)
			throws IllegalStateException, IOException {

		Integer appID = (Integer) session.getAttribute("id");
		if (!file.isEmpty()) {
			// Get application and user ID
			Application appOwner = appDao.getApp(appID);
			User userOwner = appOwner.getStdAppOwner().getStdUser();
			String fileName = file.getOriginalFilename();
			String fileType = file.getContentType();
			Long fileSize = file.getSize();
			Date fileDate = new Date();

			System.out.println("Saving " + fileName + " to DISK");
			// Save file under /WEB-INF/files
			file.transferTo(new File(getFileDirectory(), fileName));

			System.out.println("DONE ... Saving file to DISK");
			// Save file info into DB

			System.out.println("Saving file to Database");
			FileClass saveFile = new FileClass();
			saveFile.setFileName(fileName);
			saveFile.setType(fileType);
			saveFile.setDate(fileDate);
			saveFile.setFileAppOwner(appOwner);
			saveFile.setFileUserOwner(userOwner);
			saveFile.setSize(fileSize);
			FileClass savedFile = fileDao.saveFile(saveFile);
			appOwner.setFile(savedFile);
			System.out.println("Done.... Saving file to Database");

			return "redirect:details.html?id=" + appID;

		} else {
			return "redirect:upload.html?id=" + appID;
		}
	}

	// Get file path
	private File getFileDirectory() {
		String path = context.getRealPath("/WEB-INF/files");
		return new File(path);
	}

	// Download file
	@RequestMapping(value = "/student/download.html")
	public String Download(HttpServletResponse response, @RequestParam Integer id) throws IOException {

		System.out.println("BEFORE IF ID= " + id);

		if (id != null) {
			String fileType = fileDao.getFile(id).getType();
			String fileName = fileDao.getFile(id).getFileName();

			System.out.println("TYPE: " + fileType + " NAME: " + fileName);

			response.setContentType(fileType);
			response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
			FileInputStream in = new FileInputStream(new File(getFileDirectory(), fileName));

			OutputStream out = response.getOutputStream();

			byte buffer[] = new byte[2048];
			int bytesRead;
			while ((bytesRead = in.read(buffer)) > 0)
				out.write(buffer, 0, bytesRead);

			in.close();
		}
		return null;
	}

	// Remove file
	@RequestMapping("/student/remove.html")
	public String remove(@RequestParam Integer id, ModelMap models) throws FileNotFoundException {
		Integer appID = fileDao.getFile(id).getFileAppOwner().getId();

		// Remove file from disk
		File file = new File(getFileDirectory(), fileDao.getFile(id).getFileName());
		file.delete();
		System.out.println("File DELETED FROM DISK");

		// Remove file from DB
		fileDao.removeFile(fileDao.getFile(id));
		System.out.println("File DELETED FROM DATABASE");

		return "redirect:../student/details.html?id=" + appID;
	}

	// Add application
	@RequestMapping(value = "/student/add.html", method = RequestMethod.GET)
	public String add(@RequestParam Integer id, ModelMap models) {
		models.put("application", new Application());
		models.put("departments", depDao.getDepartments());
		models.put("Student", stdDao.getStudentUsingUID(id));
		System.out.println("STUDENT ID: == "+ stdDao.getStudentUsingUID(id).getId());
		return "student/add";
	}
	
	// Update application
		@RequestMapping(value = "/student/update.html", method = RequestMethod.GET)
		public void update(@RequestParam Integer depID, HttpServletResponse response) throws IOException {
			
			String ProgramsList = "<h3 class=\"form-signin-heading\">Select program</h3><select id=\"ProgsList\" class=\"form-control\" onchange=\"initializeForm()\"><option value=\"null\" selected>Select option</option>";
			String endOfSelect = "</select>";
			List<Program> progs = depDao.getDep(depID).getPrograms();
			for (Program prog : progs) {
				ProgramsList += ("<option value=\""+prog.getId()+"\">"+prog.getTitle()+"</option>");
			}
			ProgramsList += endOfSelect;
			response.getWriter().println(ProgramsList);
		}

	@RequestMapping(value = "/student/add.html", method = RequestMethod.POST)
	public String save(@RequestParam String term,@RequestParam String status, @RequestParam Integer progAppOwner, @RequestParam Integer deptAppOwner, @RequestParam Integer stdAppOwner ) {

		Date date = new Date();
		Student std = stdDao.getStudent(stdAppOwner);
		Department dep = depDao.getDep(deptAppOwner);
		Program prog = progDao.getProgram(progAppOwner);
		
		Application newApplication = new Application();
		newApplication.setDeptAppOwner(dep);
		newApplication.setProgAppOwner(prog);
		newApplication.setStatus(status);
		newApplication.setStdAppOwner(std);
		newApplication.setSubmitDate(date);
		newApplication.setTerm(term);
	
		//System.out.println("Student: "+stdAppOwner+"|TERM: "+term +"|STATUS: "+ status +"|DATE: "+ date +"|Department: "+ deptAppOwner+"|Program: "+progAppOwner);		
		System.out.println(newApplication.getStatus()+" "+newApplication.getDeptAppOwner().getName()+newApplication.getProgAppOwner().getTitle());
		
		// Save application into Database
		newApplication = appDao.saveApplication(newApplication);
		System.out.println("Application saved");
		return "redirect:../user/student.html?id="+std.getStdUser().getId();
	}
		// Edit application
		@RequestMapping(value = "/student/edit.html", method = RequestMethod.GET)
		public String edit(@RequestParam Integer id, ModelMap models) {
			models.put("app", appDao.getApp(id));
			return "student/edit";
		}
		
		@RequestMapping(value = "/student/edit.html", method = RequestMethod.POST)
		public String SaveEdit(@RequestParam Integer appID, @RequestParam String term,@RequestParam String status, @RequestParam Integer progAppOwner, @RequestParam Integer deptAppOwner, @RequestParam Integer stdAppOwner ) {

			Date date = new Date();
			Student std = stdDao.getStudent(stdAppOwner);
			Department dep = depDao.getDep(deptAppOwner);
			Program prog = progDao.getProgram(progAppOwner);

			Application newApplication = appDao.getApp(appID);
			newApplication.setDeptAppOwner(dep);
			newApplication.setProgAppOwner(prog);
			newApplication.setStatus(status);
			newApplication.setStdAppOwner(std);
			newApplication.setSubmitDate(date);
			newApplication.setTerm(term);
		
			//System.out.println("Student: "+stdAppOwner+"|TERM: "+term +"|STATUS: "+ status +"|DATE: "+ date +"|Department: "+ deptAppOwner+"|Program: "+progAppOwner);		
			System.out.println(newApplication.getStatus()+" "+newApplication.getDeptAppOwner().getName()+newApplication.getProgAppOwner().getTitle()+"|"+newApplication.getTerm());
			
			// Update Changes application into Database
			newApplication = appDao.saveApplication(newApplication);
					
			System.out.println("Application Edited");
			return "redirect:../student/list.html?id="+std.getStdUser().getId();
		}
}
