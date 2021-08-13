package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

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

}
