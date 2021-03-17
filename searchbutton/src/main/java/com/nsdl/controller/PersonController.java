package com.nsdl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nsdl.entity.Person;
import com.nsdl.service.PersonService;

@Controller
@RequestMapping("/")
public class PersonController {

	@Autowired
	private PersonService personService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showSearchBox() {

		ModelAndView modelAndView = new ModelAndView("search");
		return modelAndView;

	}

	@RequestMapping(method = RequestMethod.GET, value = "/search")
	public ModelAndView fetchDetails(@RequestParam(value = "searchText", required = true) String searchText) {
		ModelAndView modelAndView = new ModelAndView("search");
		if (searchText == null || searchText.isEmpty()) {
			modelAndView.addObject("message", "No Match found for search: Null/Empty");
		} else {
			List<Person> plist = personService.fetchAllDetails(searchText);
			if (plist == null || plist.isEmpty()) {
				modelAndView.addObject("message", "No Match found for search: " + searchText);
			} else {
				modelAndView.addObject("plist", plist);
			}
		}

		return modelAndView;
	}
}