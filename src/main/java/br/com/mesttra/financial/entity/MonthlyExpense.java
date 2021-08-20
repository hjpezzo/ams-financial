package br.com.mesttra.financial.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.mesttra.financial.enums.ExpenseType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Data
public class MonthlyExpense {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(value = "ID", name = "id", dataType = "Long", example = "0")
	private Long id;

	@Enumerated(EnumType.STRING)
	@ApiModelProperty(value = "Tipo de Despesa", name = "expenseType", dataType = "Enum: ex. SALARY", example = "SALARY")
	private ExpenseType expenseType;

	@ApiModelProperty(value = "Valor da Despesa", name = "amount", dataType = "double", example = "10.00")
	private Double amount;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@ApiModelProperty(value = "Data da Despesa", name = "dueDate", dataType = "LocalDate", example = "2021-08-19")
	private LocalDate dueDate;

}
