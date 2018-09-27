package kohgylw.people_list_online.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import kohgylw.people_list_online.mapper.PeoplesMapper;
import kohgylw.people_list_online.modal.Peoples;
import kohgylw.people_list_online.service.PeopleService;

@Service
public class PeopleServiceImpl implements PeopleService {
	
	private static final String SUCCESS="SUCCESS";
	private static final String ERROR="ERROR";
	
	@Autowired
	private PeoplesMapper pm;
	
	@Autowired
	private Gson g;

	@Override
	public String doInsertPeople(String iname, String isex, Integer iage) {
		// TODO 自动生成的方法存根
		Peoples ps=new Peoples();
		ps.setPeoplesId(UUID.randomUUID().toString());
		ps.setPeoplesName(iname);
		ps.setPeoplesAge(iage);
		ps.setPeoplesSex(isex);
		try {
			return pm.insert(ps)>0?SUCCESS:ERROR;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public PeoplesMapper getPm() {
		return pm;
	}

	public void setPm(PeoplesMapper pm) {
		this.pm = pm;
	}

	@Override
	public List<Peoples> getAllPeoples() {
		// TODO 自动生成的方法存根
		return pm.selectAll();
	}

	@Override
	public String doRemovePeople(String peoplesId) {
		// TODO 自动生成的方法存根
		try {
			return pm.deleteByPrimaryKey(peoplesId)>0?SUCCESS:ERROR;
		} catch (Exception e) {
			// TODO: handle exception
			return ERROR;
		}
	}

	@Override
	public String getAllPeopleByJson() {
		// TODO 自动生成的方法存根
		return g.toJson(getAllPeoples());
	}

	public Gson getG() {
		return g;
	}

	public void setG(Gson g) {
		this.g = g;
	}

}
