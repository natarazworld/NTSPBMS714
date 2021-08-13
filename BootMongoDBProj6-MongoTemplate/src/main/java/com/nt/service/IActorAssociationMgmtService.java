package com.nt.service;

import java.util.List;

import com.nt.document.Actor;

public interface IActorAssociationMgmtService {
    public   String  registerActor(Actor actor);
    public  String   registerActorsGroup(List<Actor> list);
    public   List<Actor> getAllActors();
    public  List<Actor>  getActorsByCategory(String category);
}
