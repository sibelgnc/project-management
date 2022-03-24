package com.project.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import java.util.Date;

import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.model.Note;
import com.project.model.NoteForm;
import com.project.model.Project;
import com.project.model.User;
import com.project.service.NoteService;
import com.project.service.ProjectService;
import com.project.service.UserService;


@Controller
@RequestMapping("/projectManagement")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;
    @Autowired
    private NoteService noteService;

    @RequestMapping(value = {"/add"}, method = RequestMethod.GET)
    public String getProjectAdd(ModelMap model) {
        model.addAttribute("additionProject", new Project());
        return "projectAdd";
    }

    @RequestMapping(value = "/projectAddition", method = RequestMethod.POST)
    public String saveProject(@Valid @ModelAttribute("additionProject") Project project, BindingResult result, ModelMap model) {
		/*System.out.println("project name:"+project.getProjectName());
		System.out.println("project date:"+project.getIssuedOn());*/

        projectService.addProjectToUser(project, new User());

        return "redirect:/projectManagement/add";


    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listProjects(ModelMap model) {
        //User user=userService.findUserByName("elidor");
        //List<Project>projects=projectService.findProjectByUser(user);
        Set<Project> projects = userService.findUserProject("elidor");
        model.addAttribute("projects", projects);
        System.out.println("project size:" + projects.size());
        return "projectList";
    }

    @RequestMapping(value = {"/delete-{id}-project"}, method = RequestMethod.GET)
    public String deleteProject(@PathVariable String id) {
        projectService.deleteProjectById(Integer.parseInt(id));
        return "redirect:/projectManagement/list";
    }


    @RequestMapping(value = "/edit-{id}-project", method = RequestMethod.GET)
    public String editProject(@PathVariable String id, ModelMap model) {
        Project project = projectService.findProjectById(Integer.parseInt(id));
        System.out.println("projact name:" + project.getProjectName());
        model.addAttribute("updatedProject", project);

        return "projectUpdate";
    }

    @RequestMapping(value = "/notes-{id}-project", method = RequestMethod.GET)
    public String projectNoteList(@PathVariable String id, ModelMap model) {
        Project project = projectService.findProjectById(Integer.parseInt(id));
        Note not = new Note();
        not.setProjectNotes(project);

        model.addAttribute("additionNote", not);


        model.addAttribute("notes", project.getNotes());


        return "projectNoteList";
    }
	
	/*@RequestMapping(value = "/notes-{id}-project" , method = RequestMethod.GET)
	public String projectNoteList(@PathVariable String id, ModelMap model) 
	{
		Project project=projectService.findProjectById(Integer.parseInt(id));
		Note not=new Note();
		not.setProjectNotes(project);

		model.addAttribute("noteList",not);
		NoteForm noteForm=new NoteForm();
		List<Note> no =  new ArrayList<Note>();;
		noteForm.setNotes(no);
	    no.addAll(project.getNotes());
		
		model.addAttribute("noteForm",noteForm);


		return "listDeneme";
	}*/


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateProject(@Valid @ModelAttribute("updatedProject") Project project, BindingResult result,
                                ModelMap model) {
        System.out.println("projact name:" + project.getProjectName());
        System.out.println("proje id:" + project.getId());
        projectService.updateProject(project);

        return "redirect:/projectManagement/list";
    }

    @RequestMapping(value = "/noteAdd", method = RequestMethod.POST)
    public String addNoteProject(@Valid @ModelAttribute("additionNote") Note note, BindingResult result,
                                 ModelMap model) throws ParseException {
        Project project = projectService.findProjectByName(note.getProjectNotes().getProjectName());

        Note not = new Note();
        not.setProjectNotes(project);
        project.getNotes().add(note);
        note.setProjectNotes(project);
        //Date date = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse(LocalDate.now().toString());

        note.setNoteDate(date);

        noteService.saveNote(note);

        model.addAttribute("additionNote", not);
        model.addAttribute("notes", project.getNotes());
        return "projectNoteList";
    }

	/*@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(
	            dateFormat, true));
	}*/
	/*@InitBinder("additionNote")
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(true);
		binder.registerCustomEditor(Date.class, "dateNote",new CustomDateEditor(dateFormat, true));
	}*/

    @ModelAttribute("noteForm")
    public NoteForm getNoteForm() {

        return new NoteForm();
    }

    @RequestMapping("/listDeneme")
    public @ResponseBody
    String someAction(@ModelAttribute("noteForm") NoteForm notes, Map<String, Object> map, HttpServletRequest request) {
        System.out.println("noteForm[0] :" + notes.getNotes().get(0).getContent());


        return "listDeneme";
    }
}
