package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorSuma {

	@RequestMapping(path = "/mi-suma", method = RequestMethod.POST)
	public ModelAndView irALaSuma() {
		
		ModelMap miSuma = new ModelMap();
		
		String suma = "El resultado de sumar 3 y 6 da 9";
		
		miSuma.put("suma", miSuma);
		
		return new ModelAndView("mi-suma",miSuma);
	}
}
