package ETDATA;

public class Data {
    private String name;
    private String SN;
    private String wsid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSN() {
        return SN;
    }

    public void setSN(String SN) {
        this.SN = SN;
    }

    public String getWsid() {
        return wsid;
    }

    public void setWsid(String wsid) {
        this.wsid = wsid;
    }

    @Override
    public String toString() {
        return "Data{" +
                "name='" + name + '\'' +
                ", SN='" + SN + '\'' +
                ", wsid='" + wsid + '\'' +
                '}';
    }
}
