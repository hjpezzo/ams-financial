package br.com.mesttra.financial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mesttra.financial.entity.MonthlyExpense;

@Repository
public interface MonthlyExpenseRepository extends JpaRepository<MonthlyExpense, Long> {

}
