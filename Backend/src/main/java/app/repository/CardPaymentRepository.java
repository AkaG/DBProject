package app.repository;

import app.model.CardPayment;
import org.springframework.stereotype.Repository;

@Repository
public interface CardPaymentRepository extends AppRepository<CardPayment, Long> {

}