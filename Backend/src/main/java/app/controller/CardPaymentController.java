package app.controller;

import app.model.CardPayment;
import app.repository.AppRepository;
import app.repository.CardPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jakub on 11.01.17.
 */
@RestController
@RequestMapping(value = "/cardpayment")
public class CardPaymentController extends AppRestController<CardPayment, Long> {
    @Autowired
    public CardPaymentController(CardPaymentRepository repository) {
        super(repository);
    }
}
