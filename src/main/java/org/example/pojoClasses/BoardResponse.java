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
}
