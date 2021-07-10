package services;

import entities.Contract;
import entities.Installment;

import java.util.Calendar;
import java.util.Date;
import java.util.spi.CalendarDataProvider;
import java.util.spi.CalendarNameProvider;

public class ContractService {

    private OnlinePaymentService paymentService;

    public ContractService(OnlinePaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void processContract(Contract contract, int months){
        double basicQuota = contract.getTotalValue() / months;
        for(int i = 1; i <= 3; i++){
            double updatedQuota = basicQuota * paymentService.interest(basicQuota,i);
            double fullQuota = updatedQuota + paymentService.paymentFee(updatedQuota);
            Date dueDate = addMonths(contract.getDate(), i);

            contract.getInstallments().add(new Installment(dueDate, fullQuota));
        }
    }
    private Date addMonths(Date date, int N){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, N);
        return calendar.getTime();
    }
}

