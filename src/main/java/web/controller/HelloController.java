package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.dao.UserDao;
import web.models.User;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

	private final UserDao userDao;

	@Autowired
	public HelloController(UserDao userDao) {
		this.userDao = userDao;
	}

	@GetMapping(value = "/")
	public String InitialPage(Model model) {
//		User messages = userDao.getOne("Ben");
		List<User> messages = userDao.getAll();
		model.addAttribute("messages", messages);
		return "index";
	}

	@GetMapping("/{id}")
	public String byId(@PathVariable("id") Long id, Model model) {
		model.addAttribute("user", userDao.getOne(id));
		return "byid";
	}

	@GetMapping("/addUser")
	public String addUser(@ModelAttribute("user") User user) {
		return "addUser";
	}

	@PostMapping()
	public String create(@ModelAttribute("user") User user) {
		userDao.add(user);
		return "redirect:/";
	}

//	@GetMapping("/delete/{id}")
//	public  String delete(@PathVariable("id") Long id) {
//		userDao.delete(userDao.getOne(id));
//		System.out.println("deleting");
//		return "redirect:/";
//	}
//	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
//	public ModelAndView deleteUserById(@PathVariable("id") Long id) {
//		userDao.delete(userDao.getOne(id));
////		boolean isDeleted = userDao.deleteUserById(id);
////		System.out.println("User deletion respone: " + isDeleted);
//		ModelAndView mv = new ModelAndView("redirect:/");
//		return mv;
	@GetMapping("delete/{id}")
	public  String delete(@PathVariable("id") Long id) {
		System.out.println(id);
		System.out.println(userDao.getOne(id));
		userDao.delete(userDao.getOne(id));
		System.out.println("deleting");
		return "redirect:/";
}
	@GetMapping("/edit/{id}")
	public String editUser(@PathVariable Long id, Model model) {
//		User user = userDao.getOne(id);
		model.addAttribute("user", userDao.getOne(id));
		return "editUser";
	}

	@PostMapping("/editUser/{id}")
	public String edit(@ModelAttribute("user") User user,@PathVariable("id") Long id) {
		userDao.update(id, user);
		return "redirect:/";
	}
}