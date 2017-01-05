package app.repository;

import app.model.CashPayment;
import org.springframework.stereotype.Repository;

@Repository
public interface CashPaymentRepository extends AppRepository<CashPayment, Long> {

}