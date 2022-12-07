package com.coralogix.calculator;

import com.coralogix.calculator.model.Result;
import com.coralogix.calculator.services.AddService;

import reactor.core.publisher.Mono;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("add")
public class AddController {

	@Autowired
	private AddService addService;

	@GetMapping
	public ResponseEntity<Mono<Result>> add(@RequestParam int a, @RequestParam int b) {
		return ResponseEntity.ok(Mono.just(addService.add(a, b)));
	}
}
