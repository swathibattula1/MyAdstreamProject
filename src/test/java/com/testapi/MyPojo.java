package com.testapi;

public class MyPojo {



        private String templateId;

        private StageDetails stageDetails;

        public String getTemplateId ()
        {
            return templateId;
        }

        public void setTemplateId (String templateId)
        {
            this.templateId = templateId;
        }

        public StageDetails getStageDetails ()
        {
            return stageDetails;
        }

        public void setStageDetails (StageDetails stageDetails)
        {
            this.stageDetails = stageDetails;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [templateId = "+templateId+", stageDetails = "+stageDetails+"]";
        }
    }

