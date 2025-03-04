package com.makeshop.podbbang.shared.data;

/**
 * 메인 플레이어 내 에피소드 목록에서 사용
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001:\u0002&\'B1\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\t\u0010\u0017\u001a\u00020\nH\u00c6\u0003J;\u0010\u0018\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u00c6\u0001J\t\u0010\u0019\u001a\u00020\u001aH\u00d6\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u00d6\u0003J\t\u0010\u001f\u001a\u00020\u001aH\u00d6\u0001J\t\u0010 \u001a\u00020\nH\u00d6\u0001J\u0019\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001aH\u00d6\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006("}, d2 = {"Lcom/makeshop/podbbang/shared/data/EpisodePaging;", "Landroid/os/Parcelable;", "data", "", "Lcom/makeshop/podbbang/shared/data/EpisodeEntity;", "summary", "Lcom/makeshop/podbbang/shared/data/EpisodePaging$Summary;", "paging", "Lcom/makeshop/podbbang/shared/data/EpisodePaging$Paging;", "next", "", "(Ljava/util/List;Lcom/makeshop/podbbang/shared/data/EpisodePaging$Summary;Lcom/makeshop/podbbang/shared/data/EpisodePaging$Paging;Ljava/lang/String;)V", "getData", "()Ljava/util/List;", "getNext", "()Ljava/lang/String;", "getPaging", "()Lcom/makeshop/podbbang/shared/data/EpisodePaging$Paging;", "getSummary", "()Lcom/makeshop/podbbang/shared/data/EpisodePaging$Summary;", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Paging", "Summary", "shared_debug"})
@kotlinx.parcelize.Parcelize()
public final class EpisodePaging implements android.os.Parcelable {
    @com.google.gson.annotations.SerializedName(value = "data")
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.makeshop.podbbang.shared.data.EpisodeEntity> data = null;
    @com.google.gson.annotations.SerializedName(value = "summary")
    @org.jetbrains.annotations.Nullable()
    private final com.makeshop.podbbang.shared.data.EpisodePaging.Summary summary = null;
    @com.google.gson.annotations.SerializedName(value = "paging")
    @org.jetbrains.annotations.Nullable()
    private final com.makeshop.podbbang.shared.data.EpisodePaging.Paging paging = null;
    @com.google.gson.annotations.SerializedName(value = "next")
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String next = null;
    
    public EpisodePaging(@org.jetbrains.annotations.NotNull()
    java.util.List<com.makeshop.podbbang.shared.data.EpisodeEntity> data, @org.jetbrains.annotations.Nullable()
    com.makeshop.podbbang.shared.data.EpisodePaging.Summary summary, @org.jetbrains.annotations.Nullable()
    com.makeshop.podbbang.shared.data.EpisodePaging.Paging paging, @org.jetbrains.annotations.NotNull()
    java.lang.String next) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.makeshop.podbbang.shared.data.EpisodeEntity> getData() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.makeshop.podbbang.shared.data.EpisodePaging.Summary getSummary() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.makeshop.podbbang.shared.data.EpisodePaging.Paging getPaging() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.makeshop.podbbang.shared.data.EpisodeEntity> component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.makeshop.podbbang.shared.data.EpisodePaging.Summary component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.makeshop.podbbang.shared.data.EpisodePaging.Paging component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.makeshop.podbbang.shared.data.EpisodePaging copy(@org.jetbrains.annotations.NotNull()
    java.util.List<com.makeshop.podbbang.shared.data.EpisodeEntity> data, @org.jetbrains.annotations.Nullable()
    com.makeshop.podbbang.shared.data.EpisodePaging.Summary summary, @org.jetbrains.annotations.Nullable()
    com.makeshop.podbbang.shared.data.EpisodePaging.Paging paging, @org.jetbrains.annotations.NotNull()
    java.lang.String next) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\t\u0010\f\u001a\u00020\rH\u00d6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\rH\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0003H\u00d6\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rH\u00d6\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0019"}, d2 = {"Lcom/makeshop/podbbang/shared/data/EpisodePaging$Paging;", "Landroid/os/Parcelable;", "prev", "", "next", "(Ljava/lang/String;Ljava/lang/String;)V", "getNext", "()Ljava/lang/String;", "getPrev", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "shared_debug"})
    @kotlinx.parcelize.Parcelize()
    public static final class Paging implements android.os.Parcelable {
        @com.google.gson.annotations.SerializedName(value = "prev")
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String prev = null;
        @com.google.gson.annotations.SerializedName(value = "next")
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String next = null;
        
        public Paging(@org.jetbrains.annotations.Nullable()
        java.lang.String prev, @org.jetbrains.annotations.Nullable()
        java.lang.String next) {
            super();
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getPrev() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getNext() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.makeshop.podbbang.shared.data.EpisodePaging.Paging copy(@org.jetbrains.annotations.Nullable()
        java.lang.String prev, @org.jetbrains.annotations.Nullable()
        java.lang.String next) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\t\u0010\t\u001a\u00020\u0003H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u00d6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0003H\u00d6\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0016"}, d2 = {"Lcom/makeshop/podbbang/shared/data/EpisodePaging$Summary;", "Landroid/os/Parcelable;", "totalCount", "", "(I)V", "getTotalCount", "()I", "component1", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "shared_debug"})
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
        public final com.makeshop.podbbang.shared.data.EpisodePaging.Summary copy(int totalCount) {
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