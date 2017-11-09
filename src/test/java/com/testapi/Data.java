package com.testapi;

public class Data
{
    private String initialBudget;

    private String agencyCurrency;

    private String title;

    private String isAIPE;

    private String[] agencyProducer;

    private String costType;

    private BudgetRegion budgetRegion;

    private String IsCurrencyChanged;

    private String description;

    private Organisation organisation;

    private String smoId;

    private ContentType contentType;

    private String projectId;

    private String campaign;

    private ProductionType productionType;

    public String getInitialBudget ()
    {
        return initialBudget;
    }

    public void setInitialBudget (String initialBudget)
    {
        this.initialBudget = initialBudget;
    }

    public String getAgencyCurrency ()
    {
        return agencyCurrency;
    }

    public void setAgencyCurrency (String agencyCurrency)
    {
        this.agencyCurrency = agencyCurrency;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getIsAIPE ()
    {
        return isAIPE;
    }

    public void setIsAIPE (String isAIPE)
    {
        this.isAIPE = isAIPE;
    }

    public String[] getAgencyProducer ()
    {
        return agencyProducer;
    }

    public void setAgencyProducer (String[] agencyProducer)
    {
        this.agencyProducer = agencyProducer;
    }

    public String getCostType ()
    {
        return costType;
    }

    public void setCostType (String costType)
    {
        this.costType = costType;
    }

    public BudgetRegion getBudgetRegion ()
    {
        return budgetRegion;
    }

    public void setBudgetRegion (BudgetRegion budgetRegion)
    {
        this.budgetRegion = budgetRegion;
    }

    public String getIsCurrencyChanged ()
    {
        return IsCurrencyChanged;
    }

    public void setIsCurrencyChanged (String IsCurrencyChanged)
    {
        this.IsCurrencyChanged = IsCurrencyChanged;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public Organisation getOrganisation ()
    {
        return organisation;
    }

    public void setOrganisation (Organisation organisation)
    {
        this.organisation = organisation;
    }

    public String getSmoId ()
{
    return smoId;
}

    public void setSmoId (String smoId)
    {
        this.smoId = smoId;
    }

    public ContentType getContentType ()
    {
        return contentType;
    }

    public void setContentType (ContentType contentType)
    {
        this.contentType = contentType;
    }

    public String getProjectId ()
    {
        return projectId;
    }

    public void setProjectId (String projectId)
    {
        this.projectId = projectId;
    }

    public String getCampaign ()
    {
        return campaign;
    }

    public void setCampaign (String campaign)
    {
        this.campaign = campaign;
    }

    public ProductionType getProductionType ()
    {
        return productionType;
    }

    public void setProductionType (ProductionType productionType)
    {
        this.productionType = productionType;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [initialBudget = "+initialBudget+", agencyCurrency = "+agencyCurrency+", title = "+title+", isAIPE = "+isAIPE+", agencyProducer = "+agencyProducer+", costType = "+costType+", budgetRegion = "+budgetRegion+", IsCurrencyChanged = "+IsCurrencyChanged+", description = "+description+", organisation = "+organisation+", smoId = "+smoId+", contentType = "+contentType+", projectId = "+projectId+", campaign = "+campaign+", productionType = "+productionType+"]";
    }
}
