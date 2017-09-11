package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Suma;

@Controller
public class ControladorSuma {

	/*
	 * Escucha la url y redirige a la url /mi-suma , es lo mismo que si se invoca
	 * la url /mi-suma directamente */
	@RequestMapping(path = "/" , method = RequestMethod.POST)
	public ModelAndView comienzo() {
		
		return new ModelAndView("redirect:/mi-suma");
	}
	
	/*
	 * Este metodo escucha la URL localhost:8080/proyecto-limpio-spring/mi-suma*/
	@RequestMapping(path = "/mi-suma", method = RequestMethod.POST)
	public ModelAndView irALaSuma() {
		
		ModelMap miModelo = new ModelMap();
		
		Suma miSuma = new Suma();
		
		miModelo.put("suma", miSuma);
		
		return new ModelAndView("mi-suma",miModelo);
	}
	
	/*
	 * Escucha la url validar-suma por metodo post*/
	@RequestMapping(path="/obtener-resultado-erroneo", method = RequestMethod.POST)
	public ModelAndView validarSuma(@ModelAttribute("miSuma") Suma miSuma) {
		
		miSuma.verificaNumerosCorrectos();
		
		if(miSuma.getNumerosCorrectos() != null) {
			return new ModelAndView("redirect:/error");
		}
		
		ModelMap suma = new ModelMap();
		
		Integer primerNumero = Integer.parseInt(miSuma.getPrimerValor());
		Integer segundoNumero = Integer.parseInt(miSuma.getSegundoValor());
				
		suma.put("primerNumero", primerNumero);
		suma.put("segundoNumero", segundoNumero);
		suma.put("resultado", primerNumero + segundoNumero);
		
		return new ModelAndView("resultado" , "suma" , suma);
	}
	
	/*
	 * Escucha la url por metodo get y redirige a una vista*/
	@RequestMapping(path = "/resultado" , method = RequestMethod.GET)
	public ModelAndView irAlResultadoErroneo() {
		
		return new ModelAndView("redirect:/mi-suma");
	}
	
	
	/*
	 * Redirige a la vista mi-suma cuando es erroneo el resultado*/
	@RequestMapping(path="/obtener-resultado-erroneo")
	public ModelAndView irALaObtencionDelResultadoErroneo() {
		
		return new ModelAndView("redirect:/mi-suma");
	}
	
	
	/*
	 * Cuando no se realiza la operacion se dirige a una nueva vista con el error*/
	@RequestMapping(path = "/error" , method = RequestMethod.GET)
	public ModelAndView irAlErrorDeLaOperacion() {
		
		return new ModelAndView("error");
	}
}
