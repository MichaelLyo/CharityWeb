package DBtest;

import junit.framework.TestCase;
import manage.HibernateUtils;
import model.User;
import org.hibernate.Session;

/**
 * Created by LSL on 2017/11/12
 */
public class UserTest extends TestCase
{
	/*
	 * 增加User
	 */
	public void testSave()
	{

		Session session = null;
		try {
			session = HibernateUtils.getSession();
			session.beginTransaction();

			User user = new User();
			//id should be unique
			user.setId(1001);
			user.setPassword("666");
			user.setUserName("sjw");

			session.save(user);
			session.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			HibernateUtils.closeSession(session);
		}
	}



	/**
	 * 删除
	 */
	public void testDel(){
		Session session = null;
		try {
			session = HibernateUtils.getSession();
			session.beginTransaction();

			User user=(User)session.load(User.class, 1000);

			session.delete(user);
			session.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			HibernateUtils.closeSession(session);
		}
	}

	/**
	 * 修改
	 */
	public void testUpdate(){
		Session session = null;
		try {
			session = HibernateUtils.getSession();
			session.beginTransaction();

			User user=(User)session.load(User.class, 1000);

			user.setUserName("LSL");
			session.update(user);
			session.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			HibernateUtils.closeSession(session);
		}
	}

	/**
	 * 查询
	 */
	public void testLoad(){
		Session session = null;
		try {
			session = HibernateUtils.getSession();
			session.beginTransaction();

			User user=(User)session.load(User.class, 1000);

			System.out.println(user.getId());
			System.out.println(user.getUserName());

			session.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			HibernateUtils.closeSession(session);
		}
	}
}
