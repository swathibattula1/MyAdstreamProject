package com.testapi;

public class ContentType
{
    private String id;

    private String projects;

    private String visible;

    private String value;

    private String dictionaryId;

    private String key;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getProjects ()
{
    return projects;
}

    public void setProjects (String projects)
    {
        this.projects = projects;
    }

    public String getVisible ()
    {
        return visible;
    }

    public void setVisible (String visible)
    {
        this.visible = visible;
    }

    public String getValue ()
    {
        return value;
    }

    public void setValue (String value)
    {
        this.value = value;
    }

    public String getDictionaryId ()
    {
        return dictionaryId;
    }

    public void setDictionaryId (String dictionaryId)
    {
        this.dictionaryId = dictionaryId;
    }

    public String getKey ()
    {
        return key;
    }

    public void setKey (String key)
    {
        this.key = key;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", projects = "+projects+", visible = "+visible+", value = "+value+", dictionaryId = "+dictionaryId+", key = "+key+"]";
    }
}


