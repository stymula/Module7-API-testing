package org.example.pojoClasses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardResponse{
    public String id;
    public String name;
    public String desc;
    public String descData;
    public boolean closed;
    public String idMemberCreator;
    public String idOrganization;
    public boolean pinned;
    public String url;
    public String shortUrl;
    public Prefs prefs;
    public LabelNames labelNames;
    public Limits limits;
    public boolean starred;
    public String memberships;
    public String shortLink;
    public boolean subscribed;
    public String powerUps;
    public String dateLastActivity;
    public String dateLastView;
    public String idTags;
    public String datePluginDisable;
    public String creationMethod;
    public int ixUpdate;
    public String templateGallery;
    public boolean enterpriseOwned;
}
