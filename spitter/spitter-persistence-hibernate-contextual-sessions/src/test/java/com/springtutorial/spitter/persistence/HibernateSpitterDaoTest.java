package com.springtutorial.spitter.persistence;

import static org.junit.Assert.*;

import com.springtutorial.spitter.domain.Spitter;
import com.springtutorial.spitter.domain.Spittle;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:test-dataSource-context.xml",
        "classpath:test-transaction-context.xml"
})

@TransactionConfiguration(transactionManager = "txMgr", defaultRollback = true)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class})
@Transactional
public class HibernateSpitterDaoTest {

    @Autowired
    private SpitterDao dao;
    private Spitter spitter;

    @Before
    public void addDefaultSpitter() {
        spitter = insertASpitter("test", "test", "test", "test", false);
    }


    @Test
    public void shouldBeAbleToFindInsertedSpitter() {
        Spitter spitterIn = insertASpitter("username", "password", "fullname", "email", false);

        Spitter spitterOut = dao.getSpitterById(spitterIn.getId());

        assertEquals(spitterIn, spitterOut);
    }

    @Test
    public void shouldBeAbleToDeleteInsertedSpitter() {
        Spittle spittleIn = insertSpittle(spitter, "Hello", new Date());
        long id = spittleIn.getId();

        assertEquals(spittleIn, dao.getSpittleById(id));
        dao.deleteSpittle(id);
        assertEquals(null, dao.getSpittleById(id));
    }


    private Spitter insertASpitter(String username, String password, String fullname, String email, boolean updateByEmail) {
        Spitter spitter = new Spitter();
        spitter.setUsername(username);
        spitter.setPassword(password);
        spitter.setFullName(fullname);
        spitter.setEmail(email);
        spitter.setUpdateByEmail(updateByEmail);
        assertNull(spitter.getId());
        dao.addSpitter(spitter);
        assertNotNull(spitter.getId());
        return spitter;
    }

    private Spittle insertSpittle(Spitter spitter, String text, Date when) {
        Spittle spittle = new Spittle();
        spittle.setSpitter(spitter);
        spittle.setText(text);
        spittle.setWhen(when);
        assertNull(spittle.getId());
        dao.saveSpittle(spittle);
        assertNotNull(spittle.getId());
        return spittle;
    }

}
