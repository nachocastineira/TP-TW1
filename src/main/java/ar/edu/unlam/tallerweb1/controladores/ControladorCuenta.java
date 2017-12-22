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
public class ControladorCuenta {
	
	
	@RequestMapping("/{operacion}/{primerValor}/{segundoValor}")
	public ModelAndView operacionCuenta(@PathVariable String operacion, @PathVariable Integer primerValor , @PathVariable Integer segundoValor ) {
		
		
		ModelMap miModelo = new ModelMap();
		
		Integer result;
		

// realizo un switch para las diferentes operaciones, si lo ingresado no es ninguna de esas se redirecciona a la vista error
		switch (operacion.toUpperCase()) {
		
		case "SUMA":
			result = primerValor + segundoValor;
			break;	
		case "RESTA":
			result = primerValor - segundoValor;
			break;
		case "MULTIPLICAR":
			result = primerValor * segundoValor;
			break;	
		default:
			return new ModelAndView("redirect:/error");
		}
		
		
		miModelo.put("operation", operacion.toLowerCase());
		
		miModelo.put("primerValor", primerValor);
		
		miModelo.put("segundoValor", segundoValor);
		
		miModelo.put("resultado", result);
		
			
		return new ModelAndView("resultado", miModelo);
	}
	
	
	@RequestMapping("/error")
	public ModelAndView operacionErronea() {
		
		ModelMap model = new ModelMap();
		
		return new ModelAndView("error", model);
	}
}
	

	
	

