package com.leysoft.jdbcsproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.leysoft.jdbcsproject.service.interf.ProductoServiceInt;
import com.leysoft.jdbcsproject.service.interf.TipoProductoServiceInt;

@Controller
@RequestMapping(value = "/tipo_producto")
public class TipoProductoController {
	
	@Autowired @Qualifier("tipoProductoServiceJDBC")
	private TipoProductoServiceInt tipoProductoService;
	
	@Autowired @Qualifier("productoServiceJDBC")
	private ProductoServiceInt productoService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String tipoProductoList(Model model) {
		model.addAttribute("object", tipoProductoService.findById(1));
		model.addAttribute("list_product", productoService.findAllById(1));
		model.addAttribute("list_objects", tipoProductoService.findAll());
		return "tipo_producto_list";
	}
}