package com.nt.service;

import java.util.List;

import com.nt.document.Actor;

public interface IActorAssociationMgmtService {
    public   String  registerActor(Actor actor);
    public  String   registerActorsGroup(List<Actor> list);
    public   List<Actor> getAllActors();
    public  List<Actor>  getActorsByCategory(String category);
    public  Actor    getActorByActorId(Integer id);
    public  String    updateActorByActorId(Integer id, String newAddrs,Long newMobileNo);
    public   String   updateActorsRenumerationByCategoryAndAge(String category, Float age,  Double renumeration);
    public  String    saveOrUpdateActorByRenumeration(double start, double end, String newAddrs , Float newAge,Long newMobileNo);
    public  String  removeDocByAge(Float age);
}
