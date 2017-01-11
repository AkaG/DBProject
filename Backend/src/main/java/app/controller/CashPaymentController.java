package app.controller;

import app.model.CashPayment;
import app.repository.AppRepository;
import app.repository.CashPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jakub on 11.01.17.
 */
@RestController
@RequestMapping(value = "/cashpayment")
public class CashPaymentController extends AppRestController<CashPayment, Long> {
    @Autowired
    public CashPaymentController(CashPaymentRepository repository) {
        super(repository);
    }
}
