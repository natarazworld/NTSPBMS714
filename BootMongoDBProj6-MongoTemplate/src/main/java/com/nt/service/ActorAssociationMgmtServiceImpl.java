package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.mongodb.client.result.UpdateResult;
import com.nt.document.Actor;

@Service("actorService")
public class ActorAssociationMgmtServiceImpl implements IActorAssociationMgmtService {
	 @Autowired
	 private  MongoTemplate  template;

	@Override
	public String registerActor(Actor actor) {
	    
		//Actor actor1=template.save(actor,"Artist");  // creats the collection with the given name Artist
		//Actor actor1=template.save(actor);  // creats the collection with the Document class name "Actor"
		Actor actor1=template.insert(actor);  // creats the collection with the Document class name "Actor"
		return  "Document is saved with the id value:"+actor1.getActorId();
	}
	
	@Override
	public String registerActorsGroup(List<Actor> list) {
		  
		return list.size()+"no.of actors are saved"+template.insertAll(list);
	}
	
	@Override
	public List<Actor> getAllActors() {
		return template.findAll(Actor.class);
	}
	
	@Override
	public List<Actor> getActorsByCategory(String category) {
		  Query query=new Query();
		  query.addCriteria(Criteria.where("category").is(category));
		  List<Actor>  list=template.find(query,Actor.class);
		return list;
	}
	
	@Override
	public Actor getActorByActorId(Integer id) {
		return template.findById(id,Actor.class);
	}
	
	@Override
	public String updateActorByActorId(Integer id, String newAddrs, Long newMobileNo) {
	    //prepare query object for retrieving doc
		Query query=new Query();
		query.addCriteria(Criteria.where("actorId").is(id));
		//prepare update object for modifying the doc
		Update  update=new Update();
		update.set("actorAddrs", newAddrs);
		update.set("mobileNo",newMobileNo);
		// find doc and modify the doc
		Actor actor=template.findAndModify(query, update, Actor.class);
		return actor==null?"Actor not found for updation":"Actor found and updated";
	}
	
	@Override
	public String updateActorsRenumerationByCategoryAndAge(String category, Float age, Double renumeration) {
		//prepare Query object
		Query query=new Query().addCriteria(Criteria.where("category").is(category).andOperator(Criteria.where("age").gte(age)));
		//prepare Update object
		Update update=new Update().set("renumeration", renumeration);
		//invoke updateMulti method
		UpdateResult  result=template.updateMulti(query, update, Actor.class);
		return result.getModifiedCount()+"  Actors are  modified";
	}
	
	@Override
	public String saveOrUpdateActorByRenumeration(double start, double end, String newAddrs, Float newAge,
			Long  newMobileNo) {
		//prepare Query object
		 Query query=new Query().addCriteria(Criteria.where("renumeration").gte(start).andOperator(Criteria.where("renumeration").lte(end)));
		 //prepare Update object
		 Update update=new Update().set("actorAddrs", newAddrs).set("age",newAge).set("mobileNo", newMobileNo);
		 //inovoke upSert(-,-,-) method
		 UpdateResult result=template.upsert(query, update, Actor.class );
		return result.getModifiedCount()+" are modified and  inserted doc id is"+result.getUpsertedId();
		
	}
	
	@Override
	public String removeDocByAge(Float age) {
		Query query=new Query().addCriteria(Criteria.where("age").is(age));
		Actor actor=template.findAndRemove(query, Actor.class);
		return actor.getActorId()+" doc  is removed";
	}
	
	

}
