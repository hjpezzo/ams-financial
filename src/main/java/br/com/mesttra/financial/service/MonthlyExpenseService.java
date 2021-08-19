package br.com.mesttra.financial.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.mesttra.financial.entity.MonthlyExpense;
import br.com.mesttra.financial.repository.MonthlyExpenseRepository;

@Service
public class MonthlyExpenseService {

	MonthlyExpenseRepository monthlyExpenseRepository;
	
    public MonthlyExpenseService(MonthlyExpenseRepository monthlyExpenseRepository) {
		this.monthlyExpenseRepository = monthlyExpenseRepository;
	}

	public MonthlyExpense addExpense(MonthlyExpense monthlyExpense) {
        return  monthlyExpenseRepository.save(monthlyExpense);
    }

	public List<MonthlyExpense> listExpenses() {
        return  monthlyExpenseRepository.findAll();
    }
	
	public Optional<MonthlyExpense> getExpense(Long expenseId) {
		return monthlyExpenseRepository.findById(expenseId);
	}

	public String removeExpense(Long expenseId) {
		monthlyExpenseRepository.deleteById(expenseId);
		return "Removido com sucesso";
	}

	@Transactional
	public MonthlyExpense changeExpenseDueDate(Long expenseId, LocalDate newDate) {

		MonthlyExpense monthlyExpense = monthlyExpenseRepository.getById(expenseId);
		monthlyExpense.setDueDate(newDate);
		monthlyExpenseRepository.save(monthlyExpense);

		return monthlyExpense;
	}


}
