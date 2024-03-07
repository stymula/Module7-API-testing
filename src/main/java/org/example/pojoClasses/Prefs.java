package org.example.pojoClasses;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Prefs{
    public String permissionLevel;
    public boolean hideVotes;
    public String voting;
    public String comments;
    public boolean selfJoin;
    public boolean cardCovers;
    public boolean isTemplate;
    public String cardAging;
    public boolean calendarFeedEnabled;
    public String background;
    public String backgroundImage;
    public ArrayList<BackgroundImageScaled> backgroundImageScaled;
    public boolean backgroundTile;
    public String backgroundBrightness;
    public String backgroundBottomColor;
    public String backgroundTopColor;
    public boolean canBePublic;
    public boolean canBeEnterprise;
    public boolean canBeOrg;
    public boolean canBePrivate;
    public boolean canInvite;
}
