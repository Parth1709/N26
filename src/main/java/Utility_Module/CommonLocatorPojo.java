package Utility_Module;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;


public class CommonLocatorPojo {
    public List<PageName> Pages;

    public List<PageName> getPages() {
        return this.Pages;
    }
}


class PageName {
    public String Pagename;
    public List<Locators> Locators;

    public String getName() {
        return this.Pagename;
    }

    public List<Locators> getLocators() {
        return this.Locators;
    }
}


@JsonInclude(JsonInclude.Include.NON_NULL)
class Locators {
    @JsonIgnoreProperties(ignoreUnknown = true)
    public String Lname;
    @JsonIgnoreProperties(ignoreUnknown = true)
    public String android;
    @JsonIgnoreProperties(ignoreUnknown = true)
    public String ios = "ios";
    @JsonIgnoreProperties(ignoreUnknown = true)
    public String tab = "tab";
    @JsonIgnoreProperties(ignoreUnknown = true)
    public String ipad = "ipad";
    @JsonIgnoreProperties(ignoreUnknown = true)
    public String tv = "tv";
    @JsonIgnoreProperties(ignoreUnknown = true)
    public String web;
    @JsonIgnoreProperties(ignoreUnknown = true)
    public String chrome;
    @JsonIgnoreProperties(ignoreUnknown = true)
    public String firefox;
    @JsonIgnoreProperties(ignoreUnknown = true)
    public String safari;
    @JsonIgnoreProperties(ignoreUnknown = true)
    public String ie;
    @JsonIgnoreProperties(ignoreUnknown = true)
    public String edge;


    public String getName() {
        return this.Lname;
    }

    public String getAndroid() {
        return this.android;
    }

    public String getIos() {
        return this.ios;
    }

    public String getiPad() {
        return this.ipad;
    }

    public String getTab() {
        return this.tab;
    }

    public String getTv() {
        return this.tv;
    }

    public String getWeb() {
        return this.web;
    }

    public String getChrome() {
        return this.chrome;
    }

    public String getFirefox() {
        return this.firefox;
    }

    public String getSafari() {
        return this.safari;
    }

    public String getIe() {
        return this.ie;
    }

    public String getEdge() {
        return this.edge;
    }
}
