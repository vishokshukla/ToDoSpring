package com.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entities.ToDo;


@Controller
public class HomeCtrl {

	@Autowired
	ServletContext context;
	
	@RequestMapping("/home")
	public String home(Model m) {
		String page = "home";
		m.addAttribute("page", page);
		
		List<ToDo> todoList = (List<ToDo>) context.getAttribute("list");
		m.addAttribute("todos", todoList);
		return "home";
	}
	
	@RequestMapping("/add")
	public String addTodo(Model m) {
		ToDo t = new ToDo();
		m.addAttribute("page","add");
		m.addAttribute("todo",t);
		return "home";
	}
	
	@RequestMapping(value = "/saveTodo", method = RequestMethod.POST)
	public String saveTodo(@ModelAttribute("todo") ToDo t, Model m) {
		System.out.println(t);
		t.setTodoDate(new Date());
		List<ToDo> todoList = (List<ToDo>) context.getAttribute("list");
		todoList.add(t);
		m.addAttribute("msg", "Successfully Added!");
		return "home";
	}
}
