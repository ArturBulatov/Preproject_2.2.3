package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.Service.UserService;
import web.models.User;

import java.util.List;

@Controller
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(value = "/")
	public String InitialPage(Model model) {
		List<User> messages = userService.getAll();
		model.addAttribute("messages", messages);
		return "index";
	}

	@GetMapping("/{id}")
	public String byId(@PathVariable("id") Long id, Model model) {
		model.addAttribute("user", userService.getOne(id));
		return "byid";
	}

	@GetMapping("/addUser")
	public String addUser(@ModelAttribute("user") User user) {
		return "addUser";
	}

	@PostMapping()
	public String create(@ModelAttribute("user") User user) {
		userService.add(user);
		return "redirect:/";
	}

	@GetMapping("delete/{id}")
	public  String delete(@PathVariable("id") Long id) {
		userService.delete(userService.getOne(id));
		return "redirect:/";
}
	@GetMapping("/edit/{id}")
	public String editUser(@PathVariable Long id, Model model) {
		model.addAttribute("user", userService.getOne(id));
		return "editUser";
	}

	@PostMapping("/editUser/{id}")
	public String edit(@ModelAttribute("user") User user,@PathVariable("id") Long id) {
		userService.update(id, user);
		return "redirect:/";
	}
}