package org.jenkinsci.plugins.cppcheck;

import com.thalesgroup.hudson.plugins.cppcheck.model.CppcheckFile;
import org.kohsuke.stapler.export.Exported;
import org.kohsuke.stapler.export.ExportedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Gregory Boissinot
 */
@ExportedBean
public class CppcheckReport implements Serializable {

    private String version;

    private transient List<CppcheckFile> allErrors = new ArrayList<CppcheckFile>();
    private transient Set<String> versions = new HashSet<String>();

    private List<CppcheckFile> errorSeverityList = new ArrayList<CppcheckFile>();
    private List<CppcheckFile> warningSeverityList = new ArrayList<CppcheckFile>();
    private List<CppcheckFile> styleSeverityList = new ArrayList<CppcheckFile>();
    private List<CppcheckFile> performanceSeverityList = new ArrayList<CppcheckFile>();
    private List<CppcheckFile> informationSeverityList = new ArrayList<CppcheckFile>();
    private List<CppcheckFile> noCategorySeverityList = new ArrayList<CppcheckFile>();

    public String getVersion() {
        return version;
    }

    public Set<String> getVersions() {
        return versions;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<CppcheckFile> getAllErrors() {
        return allErrors;
    }

    public void setAllErrors(List<CppcheckFile> allErrors) {
        this.allErrors = allErrors;
    }

    public List<CppcheckFile> getErrorSeverityList() {
        return errorSeverityList;
    }

    public void setErrorSeverityList(List<CppcheckFile> errorSeverityList) {
        this.errorSeverityList = errorSeverityList;
    }

    public List<CppcheckFile> getWarningSeverityList() {
        return warningSeverityList;
    }

    public void setWarningSeverityList(List<CppcheckFile> warningSeverityList) {
        this.warningSeverityList = warningSeverityList;
    }

    public List<CppcheckFile> getStyleSeverityList() {
        return styleSeverityList;
    }

    public void setStyleSeverityList(List<CppcheckFile> styleSeverityList) {
        this.styleSeverityList = styleSeverityList;
    }

    public List<CppcheckFile> getPerformanceSeverityList() {
        return performanceSeverityList;
    }

    public void setPerformanceSeverityList(List<CppcheckFile> performanceSeverityList) {
        this.performanceSeverityList = performanceSeverityList;
    }

    public List<CppcheckFile> getInformationSeverityList() {
        return informationSeverityList;
    }

    public void setInformationSeverityList(List<CppcheckFile> informationSeverityList) {
        this.informationSeverityList = informationSeverityList;
    }

    public List<CppcheckFile> getNoCategorySeverityList() {
        return noCategorySeverityList;
    }

    public void setNoCategorySeverityList(List<CppcheckFile> noCategorySeverityList) {
        this.noCategorySeverityList = noCategorySeverityList;
    }

    @Exported
    @SuppressWarnings("unused")
    public int getNumberTotal() {
        return (allErrors == null) ? 0 : allErrors.size();
    }

    @Exported
    @SuppressWarnings("unused")
    public int getNumberErrorSeverity() {
        return (errorSeverityList == null) ? 0 : errorSeverityList.size();
    }

    @Exported
    @SuppressWarnings("unused")
    public int getNumberWarningSeverity() {
        return (warningSeverityList == null) ? 0 : warningSeverityList.size();
    }

    @Exported
    @SuppressWarnings("unused")
    public int getNumberStyleSeverity() {
        return (styleSeverityList == null) ? 0 : styleSeverityList.size();
    }

    @Exported
    @SuppressWarnings("unused")
    public int getNumberPerformanceSeverity() {
        return (performanceSeverityList == null) ? 0 : performanceSeverityList.size();
    }

    @Exported
    @SuppressWarnings("unused")
    public int getNumberInformationSeverity() {
        return (informationSeverityList == null) ? 0 : informationSeverityList.size();
    }

    @Exported
    @SuppressWarnings("unused")
    public int getNumberNoCategorySeverity() {
        return (noCategorySeverityList == null) ? 0 : errorSeverityList.size();
    }


    @SuppressWarnings("unused")
    private Object readResolve() {
        this.allErrors = new ArrayList<CppcheckFile>();
        this.allErrors.addAll(errorSeverityList);
        this.allErrors.addAll(warningSeverityList);
        this.allErrors.addAll(styleSeverityList);
        this.allErrors.addAll(performanceSeverityList);
        this.allErrors.addAll(informationSeverityList);
        this.allErrors.addAll(noCategorySeverityList);
        return this;
    }
}
