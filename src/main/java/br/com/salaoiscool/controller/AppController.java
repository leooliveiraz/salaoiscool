package br.com.salaoiscool.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
	@GetMapping("/")
	public String helloWorld() {
		return "Olá! Estou aqui Baby!";
	}
}
