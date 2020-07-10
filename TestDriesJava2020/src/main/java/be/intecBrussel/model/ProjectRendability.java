package be.intecBrussel.model;

public class ProjectRendability {
    int projectID;
    int projectPrice;
    int totalHours;
    int totalCost;
    int rendability;

    @Override
    public String toString() {
        return "ProjectRendability{" +
                "projectID=" + projectID +
                ", projectPrice=" + projectPrice +
                ", totalHours=" + totalHours +
                ", totalCost=" + totalCost +
                ", rendability=" + rendability +
                '}';
    }

    public void addhours(int hours){
        totalHours += hours;
    }

    public void addCost(int cost){
        totalCost += cost;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public int getProjectPrice() {
        return projectPrice;
    }

    public void setProjectPrice(int projectPrice) {
        this.projectPrice = projectPrice;
    }

    public int getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(int totalHours) {
        this.totalHours = totalHours;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public int getRendability() {
        return rendability;
    }

    public void setRendability(int rendability) {
        this.rendability = rendability;
    }
}
