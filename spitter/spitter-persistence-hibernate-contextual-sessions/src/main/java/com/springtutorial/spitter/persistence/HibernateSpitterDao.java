//<start id="java_contextualHibernateDao"/> 
package com.springtutorial.spitter.persistence;

import java.util.List;

import com.springtutorial.spitter.domain.Spitter;
import com.springtutorial.spitter.domain.Spittle;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateSpitterDao implements SpitterDao {
    private SessionFactory sessionFactory;

    @Autowired
    public HibernateSpitterDao(SessionFactory sessionFactory) {//<co id="co_injectSessionFactory"/>
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();//<co id="co_getCurrentSession"/>
    }

    public void addSpitter(Spitter spitter) {
        currentSession().save(spitter);//<co id="co_useSession"/>
    }

    public Spitter getSpitterById(long id) {
        return (Spitter) currentSession().get(Spitter.class, id);//<co id="co_useSession"/>
    }

    public void saveSpitter(Spitter spitter) {
        currentSession().update(spitter);//<co id="co_useSession"/>
    }
    //<end id="java_contextualHibernateDao"/>

    public List<Spittle> getRecentSpittle() {
        //  return currentSession().f  loadAll(Spittle.class); // this isn't right...just a placeholder for now
        return null;
    }

    public void saveSpittle(Spittle spittle) {
        currentSession().save(spittle);
    }

    public List<Spittle> getSpittlesForSpitter(
            Spitter spitter) {
        // TODO Auto-generated method stub
        return null;
    }

    public Spitter getSpitterByUsername(String username) {
        // TODO Auto-generated method stub
        return null;
    }

    public void deleteSpittle(long id) {
        currentSession().delete(getSpittleById(id));
    }

    public Spittle getSpittleById(long id) {
        return (Spittle) currentSession().get(Spittle.class, id);
    }

    public List<Spitter> findAllSpitters() {
        return currentSession().createCriteria(Spittle.class).list();
    }
}