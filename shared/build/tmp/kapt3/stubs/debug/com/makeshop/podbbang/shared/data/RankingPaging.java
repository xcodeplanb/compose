package com.makeshop.podbbang.shared.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001:\u0002$%B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\tH\u00c6\u0003J7\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tH\u00c6\u0001J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u00d6\u0003J\t\u0010\u001d\u001a\u00020\u0018H\u00d6\u0001J\t\u0010\u001e\u001a\u00020\u0003H\u00d6\u0001J\u0019\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0018H\u00d6\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006&"}, d2 = {"Lcom/makeshop/podbbang/shared/data/RankingPaging;", "Landroid/os/Parcelable;", "createdAt", "", "data", "", "Lcom/makeshop/podbbang/shared/data/RankingPaging$RankEntity;", "next", "summary", "Lcom/makeshop/podbbang/shared/data/RankingPaging$Summary;", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/makeshop/podbbang/shared/data/RankingPaging$Summary;)V", "getCreatedAt", "()Ljava/lang/String;", "getData", "()Ljava/util/List;", "getNext", "getSummary", "()Lcom/makeshop/podbbang/shared/data/RankingPaging$Summary;", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "RankEntity", "Summary", "shared_debug"})
@kotlinx.parcelize.Parcelize()
public final class RankingPaging implements android.os.Parcelable {
    @com.google.gson.annotations.SerializedName(value = "createdAt")
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String createdAt = null;
    @com.google.gson.annotations.SerializedName(value = "data")
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.makeshop.podbbang.shared.data.RankingPaging.RankEntity> data = null;
    @com.google.gson.annotations.SerializedName(value = "next")
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String next = null;
    @com.google.gson.annotations.SerializedName(value = "summary")
    @org.jetbrains.annotations.NotNull()
    private final com.makeshop.podbbang.shared.data.RankingPaging.Summary summary = null;
    
    public RankingPaging(@org.jetbrains.annotations.NotNull()
    java.lang.String createdAt, @org.jetbrains.annotations.NotNull()
    java.util.List<com.makeshop.podbbang.shared.data.RankingPaging.RankEntity> data, @org.jetbrains.annotations.NotNull()
    java.lang.String next, @org.jetbrains.annotations.NotNull()
    com.makeshop.podbbang.shared.data.RankingPaging.Summary summary) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCreatedAt() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.makeshop.podbbang.shared.data.RankingPaging.RankEntity> getData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.makeshop.podbbang.shared.data.RankingPaging.Summary getSummary() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.makeshop.podbbang.shared.data.RankingPaging.RankEntity> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.makeshop.podbbang.shared.data.RankingPaging.Summary component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.makeshop.podbbang.shared.data.RankingPaging copy(@org.jetbrains.annotations.NotNull()
    java.lang.String createdAt, @org.jetbrains.annotations.NotNull()
    java.util.List<com.makeshop.podbbang.shared.data.RankingPaging.RankEntity> data, @org.jetbrains.annotations.NotNull()
    java.lang.String next, @org.jetbrains.annotations.NotNull()
    com.makeshop.podbbang.shared.data.RankingPaging.Summary summary) {
        return null;
    }
    
    @java.lang.Override()
    public int describeContents() {
        return 0;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
    
    @java.lang.Override()
    public void writeToParcel(@org.jetbrains.annotations.NotNull()
    android.os.Parcel parcel, int flags) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b4\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 N2\u00020\u0001:\u0002MNB\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002Bq\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0002\u0010\u0013J\t\u00104\u001a\u00020\u0004H\u00c6\u0003J\u0010\u00105\u001a\u0004\u0018\u00010\u0010H\u00c6\u0003\u00a2\u0006\u0002\u0010 J\u0010\u00106\u001a\u0004\u0018\u00010\u0010H\u00c6\u0003\u00a2\u0006\u0002\u0010 J\u000b\u00107\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\t\u00109\u001a\u00020\u0004H\u00c6\u0003J\t\u0010:\u001a\u00020\u0004H\u00c6\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\t\u0010<\u001a\u00020\u0004H\u00c6\u0003J\t\u0010=\u001a\u00020\fH\u00c6\u0003J\t\u0010>\u001a\u00020\fH\u00c6\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u0092\u0001\u0010@\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u00c6\u0001\u00a2\u0006\u0002\u0010AJ\t\u0010B\u001a\u00020\fH\u00d6\u0001J\u0013\u0010C\u001a\u00020\u00102\b\u0010D\u001a\u0004\u0018\u00010EH\u00d6\u0003J\t\u0010F\u001a\u00020\fH\u00d6\u0001J\t\u0010G\u001a\u00020\u0004H\u00d6\u0001J\u0019\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020\fH\u00d6\u0001R \u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001bR\u001e\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010\u001bR\"\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010#\u001a\u0004\b\u0011\u0010 \"\u0004\b!\u0010\"R\"\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010#\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\u001e\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\'\"\u0004\b(\u0010)R \u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0019\"\u0004\b+\u0010\u001bR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\'\"\u0004\b-\u0010)R\u001e\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0019\"\u0004\b/\u0010\u001bR \u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0019\"\u0004\b1\u0010\u001bR \u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0019\"\u0004\b3\u0010\u001b\u00a8\u0006O"}, d2 = {"Lcom/makeshop/podbbang/shared/data/RankingPaging$RankEntity;", "Landroid/os/Parcelable;", "()V", "id", "", "type", "title", "image", "category", "Lcom/makeshop/podbbang/shared/data/RankingPaging$RankEntity$CategoryEntity;", "copyright", "subscribeCount", "", "rank", "rankChange", "onAir", "", "isAdultOnly", "updatedAt", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/makeshop/podbbang/shared/data/RankingPaging$RankEntity$CategoryEntity;Ljava/lang/String;IILjava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)V", "getCategory", "()Lcom/makeshop/podbbang/shared/data/RankingPaging$RankEntity$CategoryEntity;", "setCategory", "(Lcom/makeshop/podbbang/shared/data/RankingPaging$RankEntity$CategoryEntity;)V", "getCopyright", "()Ljava/lang/String;", "setCopyright", "(Ljava/lang/String;)V", "getId", "setId", "getImage", "setImage", "()Ljava/lang/Boolean;", "setAdultOnly", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getOnAir", "setOnAir", "getRank", "()I", "setRank", "(I)V", "getRankChange", "setRankChange", "getSubscribeCount", "setSubscribeCount", "getTitle", "setTitle", "getType", "setType", "getUpdatedAt", "setUpdatedAt", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/makeshop/podbbang/shared/data/RankingPaging$RankEntity$CategoryEntity;Ljava/lang/String;IILjava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/makeshop/podbbang/shared/data/RankingPaging$RankEntity;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "CategoryEntity", "Companion", "shared_debug"})
    @kotlinx.parcelize.Parcelize()
    public static final class RankEntity implements android.os.Parcelable {
        @com.google.gson.annotations.SerializedName(value = "id")
        @org.jetbrains.annotations.NotNull()
        private java.lang.String id;
        @com.google.gson.annotations.SerializedName(value = "type")
        @org.jetbrains.annotations.Nullable()
        private java.lang.String type;
        @com.google.gson.annotations.SerializedName(value = "title")
        @org.jetbrains.annotations.NotNull()
        private java.lang.String title;
        @com.google.gson.annotations.SerializedName(value = "image")
        @org.jetbrains.annotations.NotNull()
        private java.lang.String image;
        @com.google.gson.annotations.SerializedName(value = "category")
        @org.jetbrains.annotations.Nullable()
        private com.makeshop.podbbang.shared.data.RankingPaging.RankEntity.CategoryEntity category;
        @com.google.gson.annotations.SerializedName(value = "copyright")
        @org.jetbrains.annotations.NotNull()
        private java.lang.String copyright;
        @com.google.gson.annotations.SerializedName(value = "subscribeCount")
        private int subscribeCount;
        @com.google.gson.annotations.SerializedName(value = "rank")
        private int rank;
        @com.google.gson.annotations.SerializedName(value = "rankChange")
        @org.jetbrains.annotations.Nullable()
        private java.lang.String rankChange;
        @com.google.gson.annotations.SerializedName(value = "onAir")
        @org.jetbrains.annotations.Nullable()
        private java.lang.Boolean onAir;
        @com.google.gson.annotations.SerializedName(value = "isAdultOnly")
        @org.jetbrains.annotations.Nullable()
        private java.lang.Boolean isAdultOnly;
        @com.google.gson.annotations.SerializedName(value = "updatedAt")
        @org.jetbrains.annotations.Nullable()
        private java.lang.String updatedAt;
        @org.jetbrains.annotations.NotNull()
        public static final com.makeshop.podbbang.shared.data.RankingPaging.RankEntity.Companion Companion = null;
        
        public RankEntity(@org.jetbrains.annotations.NotNull()
        java.lang.String id, @org.jetbrains.annotations.Nullable()
        java.lang.String type, @org.jetbrains.annotations.NotNull()
        java.lang.String title, @org.jetbrains.annotations.NotNull()
        java.lang.String image, @org.jetbrains.annotations.Nullable()
        com.makeshop.podbbang.shared.data.RankingPaging.RankEntity.CategoryEntity category, @org.jetbrains.annotations.NotNull()
        java.lang.String copyright, int subscribeCount, int rank, @org.jetbrains.annotations.Nullable()
        java.lang.String rankChange, @org.jetbrains.annotations.Nullable()
        java.lang.Boolean onAir, @org.jetbrains.annotations.Nullable()
        java.lang.Boolean isAdultOnly, @org.jetbrains.annotations.Nullable()
        java.lang.String updatedAt) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getId() {
            return null;
        }
        
        public final void setId(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getType() {
            return null;
        }
        
        public final void setType(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getTitle() {
            return null;
        }
        
        public final void setTitle(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getImage() {
            return null;
        }
        
        public final void setImage(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.makeshop.podbbang.shared.data.RankingPaging.RankEntity.CategoryEntity getCategory() {
            return null;
        }
        
        public final void setCategory(@org.jetbrains.annotations.Nullable()
        com.makeshop.podbbang.shared.data.RankingPaging.RankEntity.CategoryEntity p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getCopyright() {
            return null;
        }
        
        public final void setCopyright(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        public final int getSubscribeCount() {
            return 0;
        }
        
        public final void setSubscribeCount(int p0) {
        }
        
        public final int getRank() {
            return 0;
        }
        
        public final void setRank(int p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getRankChange() {
            return null;
        }
        
        public final void setRankChange(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Boolean getOnAir() {
            return null;
        }
        
        public final void setOnAir(@org.jetbrains.annotations.Nullable()
        java.lang.Boolean p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Boolean isAdultOnly() {
            return null;
        }
        
        public final void setAdultOnly(@org.jetbrains.annotations.Nullable()
        java.lang.Boolean p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getUpdatedAt() {
            return null;
        }
        
        public final void setUpdatedAt(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
        
        public RankEntity() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Boolean component10() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Boolean component11() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component12() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component4() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.makeshop.podbbang.shared.data.RankingPaging.RankEntity.CategoryEntity component5() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component6() {
            return null;
        }
        
        public final int component7() {
            return 0;
        }
        
        public final int component8() {
            return 0;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component9() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.makeshop.podbbang.shared.data.RankingPaging.RankEntity copy(@org.jetbrains.annotations.NotNull()
        java.lang.String id, @org.jetbrains.annotations.Nullable()
        java.lang.String type, @org.jetbrains.annotations.NotNull()
        java.lang.String title, @org.jetbrains.annotations.NotNull()
        java.lang.String image, @org.jetbrains.annotations.Nullable()
        com.makeshop.podbbang.shared.data.RankingPaging.RankEntity.CategoryEntity category, @org.jetbrains.annotations.NotNull()
        java.lang.String copyright, int subscribeCount, int rank, @org.jetbrains.annotations.Nullable()
        java.lang.String rankChange, @org.jetbrains.annotations.Nullable()
        java.lang.Boolean onAir, @org.jetbrains.annotations.Nullable()
        java.lang.Boolean isAdultOnly, @org.jetbrains.annotations.Nullable()
        java.lang.String updatedAt) {
            return null;
        }
        
        @java.lang.Override()
        public int describeContents() {
            return 0;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
        
        @java.lang.Override()
        public void writeToParcel(@org.jetbrains.annotations.NotNull()
        android.os.Parcel parcel, int flags) {
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\t\u0010\f\u001a\u00020\rH\u00d6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\rH\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0003H\u00d6\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rH\u00d6\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0019"}, d2 = {"Lcom/makeshop/podbbang/shared/data/RankingPaging$RankEntity$CategoryEntity;", "Landroid/os/Parcelable;", "id", "", "name", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "shared_debug"})
        @kotlinx.parcelize.Parcelize()
        public static final class CategoryEntity implements android.os.Parcelable {
            @com.google.gson.annotations.SerializedName(value = "id")
            @org.jetbrains.annotations.NotNull()
            private final java.lang.String id = null;
            @com.google.gson.annotations.SerializedName(value = "name")
            @org.jetbrains.annotations.NotNull()
            private final java.lang.String name = null;
            
            public CategoryEntity(@org.jetbrains.annotations.NotNull()
            java.lang.String id, @org.jetbrains.annotations.NotNull()
            java.lang.String name) {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getId() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getName() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String component2() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.makeshop.podbbang.shared.data.RankingPaging.RankEntity.CategoryEntity copy(@org.jetbrains.annotations.NotNull()
            java.lang.String id, @org.jetbrains.annotations.NotNull()
            java.lang.String name) {
                return null;
            }
            
            @java.lang.Override()
            public int describeContents() {
                return 0;
            }
            
            @java.lang.Override()
            public boolean equals(@org.jetbrains.annotations.Nullable()
            java.lang.Object other) {
                return false;
            }
            
            @java.lang.Override()
            public int hashCode() {
                return 0;
            }
            
            @java.lang.Override()
            @org.jetbrains.annotations.NotNull()
            public java.lang.String toString() {
                return null;
            }
            
            @java.lang.Override()
            public void writeToParcel(@org.jetbrains.annotations.NotNull()
            android.os.Parcel parcel, int flags) {
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/makeshop/podbbang/shared/data/RankingPaging$RankEntity$Companion;", "", "()V", "shared_debug"})
        public static final class Companion {
            
            private Companion() {
                super();
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\t\u0010\t\u001a\u00020\u0003H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u00d6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0003H\u00d6\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0016"}, d2 = {"Lcom/makeshop/podbbang/shared/data/RankingPaging$Summary;", "Landroid/os/Parcelable;", "totalCount", "", "(I)V", "getTotalCount", "()I", "component1", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "shared_debug"})
    @kotlinx.parcelize.Parcelize()
    public static final class Summary implements android.os.Parcelable {
        @com.google.gson.annotations.SerializedName(value = "totalCount")
        private final int totalCount = 0;
        
        public Summary(int totalCount) {
            super();
        }
        
        public final int getTotalCount() {
            return 0;
        }
        
        public final int component1() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.makeshop.podbbang.shared.data.RankingPaging.Summary copy(int totalCount) {
            return null;
        }
        
        @java.lang.Override()
        public int describeContents() {
            return 0;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
        
        @java.lang.Override()
        public void writeToParcel(@org.jetbrains.annotations.NotNull()
        android.os.Parcel parcel, int flags) {
        }
    }
}