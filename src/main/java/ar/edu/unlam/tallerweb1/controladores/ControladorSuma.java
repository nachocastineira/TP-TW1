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
	
	
	@RequestMapping(path = "error/{primerValor}/{segundoValor}", method = RequestMethod.GET)
	public ModelAndView irAError(@PathVariable Integer primerValor , @PathVariable Integer segundoValor ) {
		
		ModelMap miModelo = new ModelMap();
		
		return new ModelAndView("error", miModelo);
	}
	
	
	
	@RequestMapping(path = "suma/{primerValor}/{segundoValor}" , method = RequestMethod.GET)
	public ModelAndView calcularSuma(@PathVariable Integer primerValor , @PathVariable Integer segundoValor ) {
		
		Integer resultado = primerValor + segundoValor;
		
		ModelMap miModelo = new ModelMap();
		
		switch(resultado) {
		
		}
		
		
		miModelo.put("primerValor", primerValor);
		
		miModelo.put("segundoValor", segundoValor);
		
		miModelo.put("resultado", resultado);
		
		if(resultado!=(primerValor+segundoValor))
		{
			return new ModelAndView("redirect:/error");
		}
		
		
		return new ModelAndView("suma", miModelo);
	}

	
	
}
