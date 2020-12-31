package com.shcherbinina.dto.services;

import com.shcherbinina.Utils.Constants;
import com.shcherbinina.controllers.ActionController;
import com.shcherbinina.dao.entity.Purchase;
import com.shcherbinina.dao.entity.Subscription;
import com.shcherbinina.dao.repository.IPurchaseRepository;
import com.shcherbinina.dao.repository.ISubscriptionRepository;
import com.shcherbinina.dto.entity.ActionDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActionService implements IActionService {
    private static final Logger logger = LoggerFactory.getLogger(
            ActionService.class);

    @Autowired
    private IPurchaseRepository purchaseRepository;

    @Autowired
    private ISubscriptionRepository subscriptionRepository;

    @Override
    public void addNewAction(ActionDto action) {
        if(Constants.PURCHASE.equals(action.getAction())) {
            Purchase purchase = Purchase.builder()
                    .messageId(action.getId())
                    .msisdn(action.getMsisdn())
                    .timestamp(action.getTimestamp())
                    .build();
            purchaseRepository.save(purchase);
            logger.error("ActionService: new purchase was added");
        } else {
            Subscription purchase = Subscription.builder()
                    .messageId(action.getId())
                    .msisdn(action.getMsisdn())
                    .timestamp(action.getTimestamp())
                    .build();
            subscriptionRepository.save(purchase);
            logger.error("ActionService: new subscription was added");
        }
    }
}
