package com.blogspot.jpdevelopment.spring.transaction;

import static junit.framework.Assert.assertEquals;

import com.blogspot.jpdevelopment.spring.transaction.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TransactionConfig.class)
//@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class TransactionalServiceTest {

    @Autowired
    OuterBean outerBean;

    @Test
    public void testPerformAction() throws Exception {
        User user = new User();
        this.outerBean.testRequiresNew(user);

        assertEquals(1, user.getId());
    }
}