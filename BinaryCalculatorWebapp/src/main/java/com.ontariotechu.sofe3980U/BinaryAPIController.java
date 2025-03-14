package com.ontariotechu.sofe3980U;

import com.ontariotechu.sofe3980U.Binary;
import com.ontariotechu.sofe3980U.BinaryAPIResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
public class BinaryAPIController {

	// Validate binary string input
	private boolean isValidBinary(String operand) {
		return operand.matches("[01]+");
	}

	@GetMapping("/add")
	public String addString(@RequestParam(name = "operand1", required = false, defaultValue = "") String operand1,
							@RequestParam(name = "operand2", required = false, defaultValue = "") String operand2) {
		if (!isValidBinary(operand1) || !isValidBinary(operand2)) {
			throw new IllegalArgumentException("Invalid binary input");
		}

		Binary number1 = new Binary(operand1);
		Binary number2 = new Binary(operand2);
		return Binary.add(number1, number2).getValue();
	}

	@GetMapping("/add_json")
	public BinaryAPIResult addJSON(@RequestParam(name = "operand1", required = false, defaultValue = "") String operand1,
								   @RequestParam(name = "operand2", required = false, defaultValue = "") String operand2) {
		if (!isValidBinary(operand1) || !isValidBinary(operand2)) {
			throw new IllegalArgumentException("Invalid binary input");
		}

		Binary number1 = new Binary(operand1);
		Binary number2 = new Binary(operand2);
		return new BinaryAPIResult(number1, "add", number2, Binary.add(number1, number2));
	}

	@GetMapping("/or")
	public String orString(@RequestParam(name = "operand1", required = false, defaultValue = "") String operand1,
						   @RequestParam(name = "operand2", required = false, defaultValue = "") String operand2) {
		if (!isValidBinary(operand1) || !isValidBinary(operand2)) {
			throw new IllegalArgumentException("Invalid binary input");
		}

		Binary number1 = new Binary(operand1);
		Binary number2 = new Binary(operand2);
		return Binary.or(number1, number2).getValue();
	}

	@GetMapping("/or_json")
	public BinaryAPIResult orJSON(@RequestParam(name = "operand1", required = false, defaultValue = "") String operand1,
								  @RequestParam(name = "operand2", required = false, defaultValue = "") String operand2) {
		if (!isValidBinary(operand1) || !isValidBinary(operand2)) {
			throw new IllegalArgumentException("Invalid binary input");
		}

		Binary number1 = new Binary(operand1);
		Binary number2 = new Binary(operand2);
		return new BinaryAPIResult(number1, "or", number2, Binary.or(number1, number2));
	}

	@GetMapping("/and")
	public String andString(@RequestParam(name = "operand1", required = false, defaultValue = "") String operand1,
							@RequestParam(name = "operand2", required = false, defaultValue = "") String operand2) {
		if (!isValidBinary(operand1) || !isValidBinary(operand2)) {
			throw new IllegalArgumentException("Invalid binary input");
		}

		Binary number1 = new Binary(operand1);
		Binary number2 = new Binary(operand2);
		return Binary.and(number1, number2).getValue();
	}

	@GetMapping("/and_json")
	public BinaryAPIResult andJSON(@RequestParam(name = "operand1", required = false, defaultValue = "") String operand1,
								   @RequestParam(name = "operand2", required = false, defaultValue = "") String operand2) {
		if (!isValidBinary(operand1) || !isValidBinary(operand2)) {
			throw new IllegalArgumentException("Invalid binary input");
		}

		Binary number1 = new Binary(operand1);
		Binary number2 = new Binary(operand2);
		return new BinaryAPIResult(number1, "and", number2, Binary.and(number1, number2));
	}

	@GetMapping("/multiply")
	public String multiplyString(@RequestParam(name = "operand1", required = false, defaultValue = "") String operand1,
								 @RequestParam(name = "operand2", required = false, defaultValue = "") String operand2) {
		if (!isValidBinary(operand1) || !isValidBinary(operand2)) {
			throw new IllegalArgumentException("Invalid binary input");
		}

		Binary number1 = new Binary(operand1);
		Binary number2 = new Binary(operand2);
		return Binary.multiply(number1, number2).getValue();
	}

	@GetMapping("/multiply_json")
	public BinaryAPIResult multiplyJSON(@RequestParam(name = "operand1", required = false, defaultValue = "") String operand1,
										@RequestParam(name = "operand2", required = false, defaultValue = "") String operand2) {
		if (!isValidBinary(operand1) || !isValidBinary(operand2)) {
			throw new IllegalArgumentException("Invalid binary input");
		}

		Binary number1 = new Binary(operand1);
		Binary number2 = new Binary(operand2);
		return new BinaryAPIResult(number1, "multiply", number2, Binary.multiply(number1, number2));
	}
}
