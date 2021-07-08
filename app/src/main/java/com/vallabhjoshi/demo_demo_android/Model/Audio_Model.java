package com.vallabhjoshi.demo_demo_android.Model;

public class Audio_Model {

    String Name;
    String url;
    String count;
    String mCategoryNames;

    public Audio_Model(String name, String url, String count) {
        Name = name;
        this.url = url;
        this.count = count;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
