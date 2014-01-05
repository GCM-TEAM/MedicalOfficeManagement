package fr.gcm.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.gcm.dao.UserRepository;
import fr.gcm.model.User;

/**
 * 
 * @author KBELHANI
 *
 */

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository
{
	private SessionFactory sessionFactory;

	/**
	 * Constructeur : crée une nouvelle instance de : HibernateUserRepositoryIml
	 */
	public UserRepositoryImpl () {}
	
	/**
	 * Cette méthode permet de créer ou de met à jour un user
	 */
	@Override
	public void addUser(User user)
	{
		try
		{
			getCurrentSession().saveOrUpdate(user);
		}
		catch(DataAccessException e)
		{
			e.printStackTrace();
		}	
	}
	
	/**
	 * Retourner la liste des utilisateur
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {
		return getCurrentSession().createQuery("from User").list();
	}
	
	/**
	 * Récupérer la courante session
	 * @return session Hibernate
	 */
	private Session getCurrentSession ()
	{
		return sessionFactory.getCurrentSession();
	}

	/*
	 * getter & setter
	 */

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}

}