package com.nt.service;

import com.nt.entity.MarriageSeekerInfo;

public interface IMatrimonyMgmtService {
    public  String registerProfile(MarriageSeekerInfo entity);
    public  Iterable<MarriageSeekerInfo>  getAllProfiles();
}
