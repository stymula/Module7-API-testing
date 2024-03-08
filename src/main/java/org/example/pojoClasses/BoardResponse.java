package org.example.pojoClasses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardResponse{
    private String id;
    private String name;
    private String desc;
    private String descData;
    private boolean closed;
    private String idMemberCreator;
    private String idOrganization;
    private String idEnterprise;
    private boolean pinned;
    private String url;
    private String shortUrl;
    private Prefs prefs;
    private LabelNames labelNames;
    private Limits limits;
    private boolean starred;
    private String memberships;
    private String shortLink;
    private boolean subscribed;
    private String powerUps;
    private String dateLastActivity;
    private String dateLastView;
    private String idTags;
    private String datePluginDisable;
    private String creationMethod;
    private int ixUpdate;
    private String templateGallery;
    private boolean enterpriseOwned;
}
