package com.corporacaocapsula.cobr.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.corporacaocapsula.cobr.model.StatusTitulo;
import com.corporacaocapsula.cobr.model.Titulo;
import com.corporacaocapsula.cobr.repository.Titulos;

@Controller
@RequestMapping("/titulos")
public class ControllerTitulo {

	@Autowired
	private Titulos titulos;

	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("CadastroTitulo");
		mv.addObject(new Titulo());
		// mv.addObject("todosStatusTitulo",StatusTitulo.values());
		return mv;

	}

	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Titulo titulo, Errors errors, RedirectAttributes attributes) {

		if (errors.hasErrors()) {

			return "CadastroTitulo";
		}
		titulos.save(titulo);

		attributes.addFlashAttribute("mensagem", "Título salvo com sucesso!!!");
		return "redirect:/titulos/novo";

	}

	@RequestMapping
	public ModelAndView pesquisar() {

		List<Titulo> todosTitulos = titulos.findAll();
		ModelAndView mv = new ModelAndView("PesquisaTitulos");
		mv.addObject("titulos", todosTitulos);
		return mv;
	}

	@ModelAttribute("todosStatusTitulo")
	public List<StatusTitulo> todosStatusTitulo() {

		return Arrays.asList(StatusTitulo.values());
	}

	@RequestMapping("{codigo}")
	public ModelAndView editar(@PathVariable("codigo") Titulo titulo) {

		ModelAndView mv = new ModelAndView("CadastroTitulo");
		mv.addObject(titulo);
		return mv;
	}
	
	@RequestMapping(value="{codigo}",method=RequestMethod.DELETE)
	public String excluir(@PathVariable Long codigo, RedirectAttributes attributes){
		
		titulos.delete(codigo);
		attributes.addFlashAttribute("mensagem", "Título excluído com sucesso!!!");
		return "redirect:/titulos";
		
	}
	

}
