package MODELO;
// Generated 24 abr. 2022 13:28:18 by Hibernate Tools 5.4.32.Final

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class CartasCompradas.
 * @see MODELO.CartasCompradas
 * @author Hibernate Tools
 */
public class CartasCompradasHome {

	private static final Logger logger = Logger.getLogger(CartasCompradasHome.class.getName());

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(CartasCompradas transientInstance) {
		logger.log(Level.INFO, "persisting CartasCompradas instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			logger.log(Level.INFO, "persist successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "persist failed", re);
			throw re;
		}
	}

	public void attachDirty(CartasCompradas instance) {
		logger.log(Level.INFO, "attaching dirty CartasCompradas instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			logger.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}

	public void attachClean(CartasCompradas instance) {
		logger.log(Level.INFO, "attaching clean CartasCompradas instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			logger.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}

	public void delete(CartasCompradas persistentInstance) {
		logger.log(Level.INFO, "deleting CartasCompradas instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			logger.log(Level.INFO, "delete successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "delete failed", re);
			throw re;
		}
	}

	public CartasCompradas merge(CartasCompradas detachedInstance) {
		logger.log(Level.INFO, "merging CartasCompradas instance");
		try {
			CartasCompradas result = (CartasCompradas) sessionFactory.getCurrentSession().merge(detachedInstance);
			logger.log(Level.INFO, "merge successful");
			return result;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "merge failed", re);
			throw re;
		}
	}

	public CartasCompradas findById(java.lang.String id) {
		logger.log(Level.INFO, "getting CartasCompradas instance with id: " + id);
		try {
			CartasCompradas instance = (CartasCompradas) sessionFactory.getCurrentSession()
					.get("MODELO.CartasCompradas", id);
			if (instance == null) {
				logger.log(Level.INFO, "get successful, no instance found");
			} else {
				logger.log(Level.INFO, "get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "get failed", re);
			throw re;
		}
	}

	public List findByExample(CartasCompradas instance) {
		logger.log(Level.INFO, "finding CartasCompradas instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("MODELO.CartasCompradas")
					.add(Example.create(instance)).list();
			logger.log(Level.INFO, "find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "find by example failed", re);
			throw re;
		}
	}
}
