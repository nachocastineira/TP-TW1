package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Suma;

@Controller
public class ControladorSuma {
	
	
	@RequestMapping(path = "/error", method = RequestMethod.GET)
	public ModelAndView irAError() {
		return new ModelAndView("error");
	}
	
	

	@RequestMapping(path = "/suma/{primerValor}/{segundoValor}/{resultado}" , method = RequestMethod.GET)
	public ModelAndView calcularSuma(@PathVariable Integer primerValor , @PathVariable Integer segundoValor , @PathVariable Integer resultado) {
		
		ModelMap miModelo = new ModelMap();
		
		miModelo.put("primerValor", primerValor);
		
		miModelo.put("segundoValor", segundoValor);
		
		miModelo.put("resultado", primerValor + segundoValor);
		
		if(resultado!=(primerValor+segundoValor))
		{
			return new ModelAndView("redirect:/error");
		}
		
		
		return new ModelAndView("suma", miModelo);
	}

	
	
}
