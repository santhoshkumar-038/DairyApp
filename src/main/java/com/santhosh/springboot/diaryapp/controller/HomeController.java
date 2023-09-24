package com.santhosh.springboot.diaryapp.controller;

import java.util.List;

import jakarta.servlet.http.HttpSession ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.santhosh.springboot.diaryapp.service.UserService;
import com.santhosh.springboot.diaryapp.entity.Entry;
import com.santhosh.springboot.diaryapp.entity.User;
import com.santhosh.springboot.diaryapp.service.EntryService;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	//session is used to store the information of user who logged in
	@Autowired
	HttpSession session;
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Autowired
	private EntryService entryService;
	
	public EntryService getEntryService() {
		return entryService;
	}

	public void setEntryService(EntryService entryService) {
		this.entryService = entryService;
	}

	
	@GetMapping("login")
	public String loginpage() {
		String viewname = "loginpage";
		return viewname;
	}
	
	@GetMapping("register")
	public String registerpage() {
		String model = new String("registrationPage");
		return model;
	}
	
	@PostMapping(value="saveuser")
	public String saveuser(@ModelAttribute("user") User user) {
		
		//Code to save the user details into database
		
		String model = new String("registersuccess");
		userService.saveUser(user);
		return model;
	}
	
	@PostMapping(value="/authenticate")
	public String authenticateUser(@ModelAttribute("user") User user, Model model) {
		
		String viewname = "loginpage";
		
		User user1 = userService.findByUsername(user.getUsername());
		//System.out.println(user1.getUsername());
		if(user1 != null && user.getPassword().equals(user1.getPassword())) {
			viewname = "userhomepage";
			//we use add object method to share data to userhomepage as key,value pair
			model.addAttribute("user", user1);
			
			//storing user details, it will be available till user log out
			session.setAttribute("user", user1);
			List<Entry> entries = null;
			try {
				//finding user by userid which is in entry table
				entries = entryService.findByUserid(user1.getId());
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			model.addAttribute("entrieslist", entries);
		}
		
		return viewname;
	}
	
	@GetMapping("addentry")
	public String addentry() {
		String viewname = "addentryform";
		return viewname;
	}
	
	@PostMapping("saveentry")
	public String saveentry(@ModelAttribute("entry") Entry entry, Model model) {
		String viewname = "userhomepage";
		entryService.saveEntry(entry);
		User user1 = (User) session.getAttribute("user");
		List<Entry> entries = null;
		try {
			//finding user by userid which is in entry table
			entries = entryService.findByUserid(user1.getId());
			System.out.println(entries);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("entrieslist", entries);
		return viewname;
	}
	
	@GetMapping("viewentry")
	public String viewentry(@RequestParam("id") int id, Model model) {
		String viewname = "displayentry";
		Entry entry = entryService.findById(id);
		model.addAttribute("entry", entry);
		System.out.println(entry.getEntrydate());
		System.out.println(entry.getDescription());
		return viewname;
	}
	
	@GetMapping("userhome")
	public String userHomePage(Model model) {
		String viewname = "userhomepage";
		User user1 = (User) session.getAttribute("user");
	    List<Entry> entries = null;
		try {
			//finding user by userid which is in entry table
			entries = entryService.findByUserid(user1.getId());
			System.out.println(entries);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("entrieslist", entries);
		return viewname;
	}
	
	@GetMapping("updateentry")
	public String updateentry(@RequestParam("id") int id, Model model) {
		String viewname = "displayupdateentry";
		Entry entry =  entryService.findById(id);//code idi kadu..check with our code...okka entry update cheyadaniki malli ah user add chesina anni entries retrieve chestunnaru meeru in both view and update entries
		model.addAttribute("entry", entry);
		User user1 = (User) session.getAttribute("user");
		if (user1 == null) {
			viewname = "loginpage";
		}
		return viewname;
	}
	
	@PostMapping("processentryupdate")
	public String processentryupdate(@ModelAttribute("entry") Entry entry, Model model) {
		String viewname = "userhomepage";
		entryService.updateEntry(entry);
		User user1 = (User) session.getAttribute("user");
		List<Entry> entries = null;
		try {
			//finding user by userid which is in entry table
			entries = entryService.findByUserid(user1.getId());
			//System.out.println(entries);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("entrieslist", entries);
		return viewname;
	}
	
	@GetMapping("deleteentry")
	public String deleteentry(@RequestParam("id") int id, Model model) {
		String viewname = "userhomepage";
		User user1 = (User) session.getAttribute("user");
		
		Entry entry = (Entry) entryService.findById(id);
		if (user1 == null) {
			viewname = "loginpage";
		}else {
			entryService.deleteEntry(entry);
		}
		List<Entry> entries = null;
		try {
			//finding user by userid which is in entry table
			entries = entryService.findByUserid(user1.getId());
			System.out.println(entries);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("entrieslist", entries);
		return viewname;
	}
	
	@GetMapping("signout")
	public String signout() {
		String viewname = "loginpage";
		session.invalidate();
		return viewname;
	}
}
