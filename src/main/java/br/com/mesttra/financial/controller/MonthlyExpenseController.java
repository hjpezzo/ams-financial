package br.com.mesttra.financial.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.mesttra.financial.dto.DueDateDTO;
import br.com.mesttra.financial.entity.MonthlyExpense;
import br.com.mesttra.financial.service.MonthlyExpenseService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/expenses")
public class MonthlyExpenseController {

	MonthlyExpenseService monthlyExpenseService;

    public MonthlyExpenseController(MonthlyExpenseService monthlyExpenseService) {
        this.monthlyExpenseService = monthlyExpenseService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value="Adicionar despesa", notes="Esse método adiciona uma nova despesa")
    @ApiResponses(value = {
    		@ApiResponse(code = 201, message="Despesa criada"),
    		@ApiResponse(code = 500, message="Internal error")
    })
    public MonthlyExpense addExpense(@RequestBody MonthlyExpense monthlyExpense) {
        return monthlyExpenseService.addExpense(monthlyExpense);
    }

    @PutMapping
    public MonthlyExpense updateExpense(@RequestBody MonthlyExpense monthlyExpense) {
        return monthlyExpenseService.updateExpense(monthlyExpense);
    }

    @GetMapping
    public List<MonthlyExpense> listExpenses() {
    	return monthlyExpenseService.listExpenses();
    }
    
    @GetMapping(path = "/{id}")
    public Optional<MonthlyExpense> getExpense(@PathVariable Long id) {
    	return monthlyExpenseService.getExpense(id);
    }
   
    @DeleteMapping(path = "/{id}")
    public String removeExpense(@PathVariable Long id) {
    	return monthlyExpenseService.removeExpense(id);
    }
    
    @PatchMapping(path = "/{id}")
    public MonthlyExpense changePlayerAvailability(@PathVariable Long id, @RequestBody DueDateDTO dueDateDTO) {
    	return monthlyExpenseService.changeExpenseDueDate(id, dueDateDTO.getDueDate());
    }

}
