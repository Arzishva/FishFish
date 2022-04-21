package data;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class DataModelFeedHistory {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("feed_dose")
    @Expose
    private Integer feedDose;
    @SerializedName("feed_history_time")
    @Expose
    private String feedHistoryTime;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("pond")
    @Expose
    private Pond pond;
    @SerializedName("feed_type")
    @Expose
    private FeedType feedType;

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getFeedDose() {
        return feedDose;
    }

    public void setFeedDose(Integer feedDose) {
        this.feedDose = feedDose;
    }

    public String getFeedHistoryTime() {
        return feedHistoryTime;
    }

    public void setFeedHistoryTime(String feedHistoryTime) {
        this.feedHistoryTime = feedHistoryTime;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Pond getPond() {
        return pond;
    }

    public void setPond(Pond pond) {
        this.pond = pond;
    }

    public FeedType getFeedType() {
        return feedType;
    }

    public void setFeedType(FeedType feedType) {
        this.feedType = feedType;
    }
}
