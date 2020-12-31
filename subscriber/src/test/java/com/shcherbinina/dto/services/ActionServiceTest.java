package com.shcherbinina.dto.services;

import com.shcherbinina.Utils.Constants;
import com.shcherbinina.dao.entity.Purchase;
import com.shcherbinina.dao.entity.Subscription;
import com.shcherbinina.dao.repository.IPurchaseRepository;
import com.shcherbinina.dao.repository.ISubscriptionRepository;
import com.shcherbinina.dto.entity.ActionDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActionServiceTest {
    @Autowired
    private ActionService actionService;
    @MockBean
    private IPurchaseRepository purchaseRepository;
    @MockBean
    private ISubscriptionRepository subscriptionRepository;

    @Test
    public void addNewActionPurchaseTest() {
        ActionDto actionPurchase = ActionDto.builder()
                .id(1)
                .action("PURCHASE")
                .msisdn(123456789)
                .timestamp(1589464122)
                .build();
        actionService.addNewAction(actionPurchase);

        Assert.assertEquals(Constants.PURCHASE, actionPurchase.getAction());
        Mockito.verify(purchaseRepository, Mockito.times(1)).save(ArgumentMatchers.any(Purchase.class));
    }

    @Test
    public void addNewActionSubscriptionTest() {
        ActionDto actionSubscription = ActionDto.builder()
                .id(1)
                .action("SUBSCRIPTION")
                .msisdn(123456780)
                .timestamp(1589464122)
                .build();

        actionService.addNewAction(actionSubscription);
        Assert.assertEquals(Constants.SUBSCRIPTION, actionSubscription.getAction());
        Mockito.verify(subscriptionRepository, Mockito.times(1)).save(ArgumentMatchers.any(Subscription.class));
    }
}