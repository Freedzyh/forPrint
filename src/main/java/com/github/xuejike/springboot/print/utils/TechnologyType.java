package com.github.xuejike.springboot.print.utils;

import java.util.List;

/**
 * Created by xuemingyu 2018/3/27
 */
public class TechnologyType {
    private Long id;
    private String processTechnogy;
    private List<ProcessMethod> processMethodList;

    public TechnologyType() {
    }

    public TechnologyType(Long id, String processTechnogy, List<ProcessMethod> processMethodList) {
        this.id = id;
        this.processTechnogy = processTechnogy;
        this.processMethodList = processMethodList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProcessTechnogy() {
        return processTechnogy;
    }

    public void setProcessTechnogy(String processTechnogy) {
        this.processTechnogy = processTechnogy;
    }

    public List<ProcessMethod> getProcessMethodList() {
        return processMethodList;
    }

    public void setProcessMethodList(List<ProcessMethod> processMethodList) {
        this.processMethodList = processMethodList;
    }

    public class ProcessMethod {
        private String processMethod;
        private String cabinet;

        public ProcessMethod() {
        }

        public ProcessMethod(String processMethod, String cabinet) {
            this.processMethod = processMethod;
            this.cabinet = cabinet;
        }

        public String getProcessMethod() {
            return processMethod;
        }

        public void setProcessMethod(String processMethod) {
            this.processMethod = processMethod;
        }

        public String getCabinet() {
            return cabinet;
        }

        public void setCabinet(String cabinet) {
            this.cabinet = cabinet;
        }
    }
}
