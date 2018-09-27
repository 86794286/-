package kohgylw.people_list_online.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import kohgylw.people_list_online.mapper.PeoplesMapper;
import kohgylw.people_list_online.service.PeopleService;

/**
 * 
 * <h2>测试类：单元测试的核心组件</h2>
 * <p>测试类中可以使用测试方法并使用IOC容器……</p>
 * @author 青阳龙野(kohgylw)
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)//告诉测试框架：使用Spring运行环境进行测试
@ContextConfiguration("classpath:spring.xml")//告诉测试框架：使用哪个配置文件生成IOC容器……
public class ServiceTest {
	//在测试类中，请尽情使用IOC功能……
	
	@Autowired
	private PeopleService ps;
	
	@Autowired
	private PeoplesMapper pm;
	
	//这是一个测试方法，可以直接运行（选中方法，右键运行Junit测试……）
	@Test
	public void testGetAllPeopleByAjax() {
		System.out.println(ps.getAllPeopleByJson());
	}
	
	//对于不想“污染”数据库的测试操作，我们可以使用“事物管理”。
	@Test
	@Transactional//使用事物管理进行回滚
	@Rollback//该测试方法在执行结束后，自动回滚，必须配合@Transactional注解一起使用。
	@Repeat(100)//压力测试：重复执行100遍
	public void testRemovePeople() {
		System.out.println(ps.doRemovePeople("51337943-bcce-4263-a271-3f5c507ebf2a"));
	}

	public PeopleService getPs() {
		return ps;
	}

	public void setPs(PeopleService ps) {
		this.ps = ps;
	}

	public PeoplesMapper getPm() {
		return pm;
	}

	public void setPm(PeoplesMapper pm) {
		this.pm = pm;
	}

}
