package rest_with_spring_boot_and_java.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest_with_spring_boot_and_java.exceptions.UnsupportedMathOperationException;

@RestController
@RequestMapping("/math")
public class MathController {

    private Double convertToDouble(String stringNumber) throws IllegalArgumentException {
        if(stringNumber == null || stringNumber.isEmpty())
            throw new UnsupportedMathOperationException("Please, set a numeric value.");
        return Double.parseDouble(stringNumber);
    }

    private boolean isNumeric(String stringNumber) {
        if (stringNumber == null || stringNumber.isEmpty()) return true;

        return !stringNumber.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    @RequestMapping("/sum/{numOne}/{numTwo}")
    public Double sum(
            @PathVariable("numOne") String numOne,
            @PathVariable("numTwo") String numTwo
    ) {
        if(isNumeric(numOne) || isNumeric(numTwo))
            throw new UnsupportedMathOperationException("Please, set a numeric value.");
        return convertToDouble(numOne) + convertToDouble(numTwo);
    }

    @RequestMapping("/subtract/{numOne}/{numTwo}")
    public Double subtract(
            @PathVariable("numOne") String numOne,
            @PathVariable("numTwo") String numTwo
    ) {
        if(isNumeric(numOne) || isNumeric(numTwo))
            throw new UnsupportedMathOperationException("Please, set a numeric value.");
        return convertToDouble(numOne) - convertToDouble(numTwo);
    }

    @RequestMapping("/multiply/{numOne}/{numTwo}")
    public Double multiply(
            @PathVariable("numOne") String numOne,
            @PathVariable("numTwo") String numTwo
    ) {
        if(isNumeric(numOne) || isNumeric(numTwo))
            throw new UnsupportedMathOperationException("Please, set a numeric value.");
        return convertToDouble(numOne) * convertToDouble(numTwo);
    }

    @RequestMapping("/divisor/{numOne}/{numTwo}")
    public Double divisor(
            @PathVariable("numOne") String numOne,
            @PathVariable("numTwo") String numTwo
    ) {
        if(isNumeric(numOne) || isNumeric(numTwo))
            throw new UnsupportedMathOperationException("Please, set a numeric value.");
        return convertToDouble(numOne) / convertToDouble(numTwo);
    }

    @RequestMapping("/average/{numOne}/{numTwo}")
    public Double average(
            @PathVariable("numOne") String numOne,
            @PathVariable("numTwo") String numTwo
    ) {
        if(isNumeric(numOne) || isNumeric(numTwo))
            throw new UnsupportedMathOperationException("Please, set a numeric value.");
        return (convertToDouble(numOne) + convertToDouble(numTwo)) / 2;
    }

    @RequestMapping("/square-root/{number}")
    public Double squareRoot(@PathVariable("number") String number) {

        if (isNumeric(number))
            throw new UnsupportedMathOperationException("Please, set a numeric value.");

        double value = convertToDouble(number);

        if (value < 0)
            throw new UnsupportedMathOperationException("Please, set a positive numeric value.");

        return Math.sqrt(value);
    }


}
